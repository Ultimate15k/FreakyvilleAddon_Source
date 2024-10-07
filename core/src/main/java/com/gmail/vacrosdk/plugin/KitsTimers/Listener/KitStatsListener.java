package com.gmail.vacrosdk.plugin.KitsTimers.Listener;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.logging.Logging;

import static com.gmail.vacrosdk.utils.TimerFunctions.*;

public class KitStatsListener {

  private final FreakyvilleAddon addon;

  public KitStatsListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!isModuleDisabled()) {
      String text = event.chatMessage().getFormattedText();
      if(text.contains("$bDu vandt et head i Kit Head!")) {
        String playerName = addon.labyAPI().getName();
        updatePlayerData(playerName,"stats_heads_kit", 0);
        Logging.getLogger().info("Player data saved for: " + playerName);
      } else if(text.contains("$bDer droppede sgu et head")){
        String playerName = addon.labyAPI().getName();
        updatePlayerData(playerName,"stats_heads_vv", 0);
        Logging.getLogger().info("Player data saved for: " + playerName);
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
