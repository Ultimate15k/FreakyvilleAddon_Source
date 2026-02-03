package com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.NotificationEvent;
import com.gmail.vacrosdk.utils.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

/**
 * This is not a language file.
 * Instead, this represents a thing on the server the addon is made for
 */

public class GuardKillEvent extends NotificationEvent {

  Pattern pattern = Pattern.compile("dræbt af §e§l");

  public GuardKillEvent(String catchMessage, FreakyvilleAddon addon) {
    super(catchMessage, addon);
  }

  @Override
  public void runSubEvent(ChatReceiveEvent event) {
    if (addon.configuration().getGuardKillEvent().get()) {
      String formattedText = event.chatMessage().getFormattedText();
      Matcher matcher = pattern.matcher(formattedText);
      if (matcher.find()) {
        doTitle(formattedText);
        runSound();
      }
    }
  }

  private void doTitle(String text) {
    String replace = text.replace("§8§l| §b§lFV§7§l-§b§lPRISON §8§l|", "");
    String[] split = replace.split("dræbt");
    Utils.showTitle(split[0], "§7§ldræbt" + split[1]);
  }
}
