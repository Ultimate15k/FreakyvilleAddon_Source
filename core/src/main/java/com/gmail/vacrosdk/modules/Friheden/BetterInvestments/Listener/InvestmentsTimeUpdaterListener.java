package com.gmail.vacrosdk.modules.Friheden.BetterInvestments.Listener;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.utils.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

import static com.gmail.vacrosdk.utils.TimerFunctions.*;

public class InvestmentsTimeUpdaterListener {

  private final FreakyvilleAddon addon;

  private final Pattern pattern = Pattern.compile("Du kan først hente din udbetaling om (\\d+) timer & (\\d+) minutter, (\\d+) sekunder");

  public InvestmentsTimeUpdaterListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!isModuleDisabled()) {
      Utils utils = new Utils(addon);
      String text2 = event.chatMessage().getFormattedText();
      if (text2.contains("§cDu kan først hente din udbetaling om")) {
        String text = event.chatMessage().getPlainText();
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
          String playerName = addon.labyAPI().getName();
          String hours = matcher.group(1);
          String minutes = matcher.group(2);
          String seconds = matcher.group(3);
          if (hours.isEmpty()) {
            hours = "0";
          }
          if (minutes.isEmpty()) {
            minutes = "0";
          }
          if (seconds.isEmpty()) {
            seconds = "0";
          }
          utils.SendDebugMessage("Clock before: " + hours + " - " + minutes + " - " + seconds + " - ");
          String[] timeStrings = calculateAdjustedTime(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds));
          utils.SendDebugMessage("Date: " + timeStrings[0]);
          utils.SendDebugMessage("Clock: " + timeStrings[1]);
          utils.SendDebugMessage("Player data saved for: " + playerName);
          updateInvestmentsDateTime(playerName,timeStrings[0],timeStrings[1]);
        }
      }
    }
  }


  private boolean isModuleDisabled() {
    return addon.configuration().getBetterInvestmentsEnabled().get().equals(false) ||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getFrihedenEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }

}
