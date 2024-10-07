package com.gmail.vacrosdk.plugin.KitsTimers.Listener;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.logging.Logging;

import static com.gmail.vacrosdk.utils.TimerFunctions.updatePlayerData;

public class KitUpdaterListener {

  private final FreakyvilleAddon addon;

  public KitUpdaterListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!isModuleDisabled()) {
      String text = event.chatMessage().getPlainText();
      if (text.contains("Received kit head")) {
        if(!text.contains("mig")) {
          String playerName = addon.labyAPI().getName();
          updatePlayerData(playerName, "kithead_date_time", 0);
          Logging.getLogger().info("Player data saved for: " + playerName);
        }
      }
    }
  }


  private boolean isModuleDisabled() {
    return addon.configuration().getKitHeadTimer().get().equals(false) ||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getPrisonEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }

}
