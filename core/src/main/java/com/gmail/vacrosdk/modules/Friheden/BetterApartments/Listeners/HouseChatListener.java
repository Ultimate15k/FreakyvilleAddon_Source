package com.gmail.vacrosdk.modules.Friheden.BetterApartments.Listeners;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.Area.HouseAreaManager;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.House;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.HouseIdentifier;
import com.gmail.vacrosdk.utils.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.I18n;

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
        event.setMessage(Component.text(message.replace(message, I18n.translate("Friheden.BetterApartments.location" + houseAreaManager.getHouseArea(house2).getStringDescription()))));
      } else {
        event.setCancelled(true);
      }
      if(!betterApartmentsReqIsDisabled()) {
        addon.displayMessage(I18n.translate("Friheden.BetterApartments.requirments" + houseAreaManager.getHouseArea(house2).getHouseRequirements()));
      }
    }
  }

  private void updateMessage(ChatReceiveEvent event, String message, House house) {
    if(houseAreaDoesNotExist(house)) {
      event.setMessage(Component.text(I18n.translate("Friheden.BetterApartments.error" + message)));
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
}
