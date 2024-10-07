package com.gmail.vacrosdk.modules.Friheden.BetterInvestments.Listener;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

import static com.gmail.vacrosdk.utils.TimerFunctions.updatePlayerData;

public class InvestmentsUpdaterListener {

  private final FreakyvilleAddon addon;

  public InvestmentsUpdaterListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!isModuleDisabled()) {
      Utils utils = new Utils(addon);
      String text = event.chatMessage().getFormattedText();
      String playerName = addon.labyAPI().getName();
      //§a§l
      if (text.contains("Du indsamlede dit overskud")) {
        updatePlayerData(playerName, "investments", 0);
        utils.SendDebugMessage("Player data saved for: " + playerName);
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
