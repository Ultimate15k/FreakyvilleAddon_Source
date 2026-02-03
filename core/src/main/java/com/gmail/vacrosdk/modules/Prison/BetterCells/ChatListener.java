package com.gmail.vacrosdk.modules.Prison.BetterCells;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.discord.WebHook;
import com.gmail.vacrosdk.discord.WebHook.EmbedObject;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.I18n;
import net.labymod.api.util.logging.Logging;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.gmail.vacrosdk.utils.CSVFunctions.getCellDetails;

public class ChatListener {

  private final FreakyvilleAddon addon;
  private final Pattern pattern = Pattern.compile("------------=\\{ ([a-zA-Z]+)(\\d+) }=-----------");
  private final Pattern pattern2 = Pattern.compile("(Blok: )([A-Za-z]*)");
  private String typeCell;
  private String CellNumber;

  public ChatListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!addon.isOnlineOnFreakyville() || IsModuleDisabled()) {
      return;
    }

    String message = event.chatMessage().getPlainText();
    if (message.contains("------------={ ") && (message.contains(" }=------------"))) {
      handleMessage(event, message);
    } else if (message.startsWith("Blok: ") && !IsModuleDesDisabled()) {
      handleMessage2(event, message);
    }
  }

  private void handleMessage2(ChatReceiveEvent event, String message) {
    Matcher matcher = pattern2.matcher(message);
    if (matcher.find()) {
      event.setMessage(Component.text(
          I18n.translate("Friheden.BetterApartments.location", getCellDetails(typeCell, CellNumber, "Desc"))
      ));
    }
  }


  private void handleMessage(ChatReceiveEvent event, String message) {
    Matcher matcher = pattern.matcher(message);
    if (matcher.find()) {
      try {
        String identifier = getCellDetails(matcher.group(1), matcher.group(2), "CellNumber");
        if (identifier.contains("No matching cell found.")) {
          event.setMessage(Component.text(
              I18n.translate("labymod.error.message", message)
          ));
          Logging.getLogger().error(
              I18n.translate("labymod.error.message", message)
          );
//          SendErrorWebhook(matcher);
          return;
        }
        doFinalMessage(event, message, identifier);
        typeCell = matcher.group(1);
        CellNumber = matcher.group(2);
      } catch (Exception e) {
        Logging.getLogger().error("Exception occurred while handling message: " + e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
          Logging.getLogger().error(element.toString());
        }
      }
    }
  }


  private void doFinalMessage(ChatReceiveEvent event, String message, String identifier) {
    event.setMessage(Component.text(message
        .replace(" }=------------", ": " + identifier + " )=- ")
        .replace("------------={ ", "-=( "), NamedTextColor.AQUA));
  }

  private void SendErrorWebhook(Matcher matcher) {
    WebHook webHook = new WebHook("https://discord.com/api/webhooks/1289273173812183070/RM-1dC_Z-dPmYILD71hVQkSzvgJY0efleCtAJpFRZmEXMq2uTBuoW5v0L5Cm7ocHu84i");
    EmbedObject embed = new EmbedObject();
    embed.setTitle("FreakyvilleAddon - Celle fejl");
    embed.setColor(Color.RED);
    embed.addField("Navn:", Objects.requireNonNull(addon.labyAPI().minecraft().getClientPlayer()).getName(), false);
    embed.addField("Version:", String.valueOf(addon.addonInfo().getVersion()), false);
    embed.addField("Identifier:", matcher.group(1), false);
    embed.addField("Number:", matcher.group(2), false);
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    embed.setFooter(now.format(formatter), "");
    webHook.addEmbed(embed);

    try {
      webHook.execute();
    } catch (IOException e) {
      Logging.getLogger().error("Error sending webhook: " + e.getMessage());
      for (StackTraceElement element : e.getStackTrace()) {
        Logging.getLogger().error(element.toString());
      }
    }
  }


  private boolean IsModuleDisabled() {
    return addon.configuration().getBetterCells().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean IsModuleDesDisabled() {
    return addon.configuration().getBetterCellsLocation().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getPrisonEnabled().get().equals(false);
  }


}
