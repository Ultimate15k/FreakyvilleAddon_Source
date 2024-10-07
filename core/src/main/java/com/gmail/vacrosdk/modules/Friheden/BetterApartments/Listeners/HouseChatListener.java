package com.gmail.vacrosdk.modules.Friheden.BetterApartments.Listeners;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.discord.WebHook;
import com.gmail.vacrosdk.discord.WebHook.EmbedObject;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.Area.HouseAreaManager;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.House;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.HouseIdentifier;
import com.gmail.vacrosdk.utils.Utils;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.logging.Logging;

public class HouseChatListener {

  private final FreakyvilleAddon addon;
  private final HouseAreaManager houseAreaManager;
  private final Pattern pattern = Pattern.compile("=*\\s*([a-zA-Z]+)(\\d+)\\s*}=");
  private final Pattern pattern2 = Pattern.compile("(Slags: )([A-Za-z]*)");

  public HouseChatListener(FreakyvilleAddon addon, HouseAreaManager houseAreaManager) {
    this.addon = addon;
    this.houseAreaManager = houseAreaManager;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if(betterApartmentsIsDisabled()) {
      return;
    }
    String message = event.chatMessage().getPlainText();
    if (message.contains("----={ ")) {
      handleMessage(event, message);
    } else if (message.contains("Slags: ")) {
      handleMessage2(event, message);
    }
  }

  private boolean betterApartmentsIsDisabled() {
    return addon.configuration().getApartmentsEnabled().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getFrihedenEnabled().get().equals(false);
  }

  private boolean betterApartmentsReqIsDisabled() {
    return addon.configuration().getReqEnabled().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getFrihedenEnabled().get().equals(false);
  }

  private boolean betterApartmentsDesIsDisabled() {
    return addon.configuration().getDesEnabled().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getFrihedenEnabled().get().equals(false);
  }

  private House house2;

  private void handleMessage(ChatReceiveEvent event, String message) {
    Matcher matcher = pattern.matcher(message);
    if (matcher.find()) {
      HouseIdentifier houseIdentifier = Utils.convertStringToIdentifier2(matcher.group(1));
      int houseNumber = Integer.parseInt(matcher.group(2));
      House house = new House(houseIdentifier, houseNumber);
      house2 = house;
      updateMessage(event, message, house);
    }
  }

  private void handleMessage2(ChatReceiveEvent event, String message) {
    Matcher matcher = pattern2.matcher(message);
    if (matcher.find()) {
      if(!betterApartmentsDesIsDisabled()) {
        event.setMessage(Component.text(message.replace(message, "§bLokation: §7" + houseAreaManager.getHouseArea(
            house2).getStringDescription())));
      } else {
        event.setCancelled(true);
      }
      if(!betterApartmentsReqIsDisabled()) {
        addon.displayMessage("§bKrav: §7" + houseAreaManager.getHouseArea(house2).getHouseRequirements());
      }
    }
  }

  private void updateMessage(ChatReceiveEvent event, String message, House house) {
    if(houseAreaDoesNotExist(house)) {
      event.setMessage(Component.text("§cDer opstod en fejl, som er blevet reporteret. \n"+ message));
      SendErrorWebhook(house);
      return;
    }
    doFinalMessage(event, message, house);
  }

  private void doFinalMessage(ChatReceiveEvent event, String message, House house) {
    event.setMessage(Component.text(message
        .replace(" }=----", ": " + houseAreaManager.getHouseArea(house).getStringName() + " )=-- ")
        .replace("----={ ", "--=( "), NamedTextColor.AQUA));
  }

  private boolean houseAreaDoesNotExist(House house) {
    return houseAreaManager.getHouseArea(house) == null;
  }

  private void SendErrorWebhook(House house) {
    WebHook webHook = new WebHook("https://discord.com/api/webhooks/1100819093835235439/aUdWS5bOwFMXF2AsmiP17xRmPAWczpELif2uY4yjoNZQ35TP-KJWBBKiioMj6Ec01Z--");
    EmbedObject embed = new EmbedObject();
    embed.setTitle("FrihedenAddon - Celle fejl");
    embed.setColor(Color.RED);
    embed.addField("Navn:", addon.labyAPI().minecraft().getClientPlayer().getName(), false);
    embed.addField("Version:", String.valueOf(addon.addonInfo().getVersion()), false);
    embed.addField("Identifier:", house.getIdentifier().getStringIdentifier(), false);
    embed.addField("Number:", String.valueOf(house.getHouseNumber()), false);
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    embed.setFooter(now.format(formatter), "");
    webHook.addEmbed(embed);

    try {
      webHook.execute();
    } catch (IOException var6) {
      Logging.getLogger().error("IOException occurred: " + var6.getMessage());
      for (StackTraceElement element : var6.getStackTrace()) {
        Logging.getLogger().error(element.toString());
      }
    }
  }
}
