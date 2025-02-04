package com.gmail.vacrosdk.plugin.Stats;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.logging.Logging;

import static com.gmail.vacrosdk.utils.TimerFunctions.*;

public class StatsListener {

  private final FreakyvilleAddon addon;

  public StatsListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!isModuleDisabled()) {
      String text = event.chatMessage().getFormattedText();
      checkAndSavePlayerData(text, "$bDu vandt et head i Kit Head!", "stats_heads_kit");
      checkAndSavePlayerData(text, "$bDer droppede sgu et head", "stats_heads_vv");
    }
  }

  private void checkAndSavePlayerData(String text, String messagePattern, String statKey) {
    if (text.contains(messagePattern)) {
      String playerName = addon.labyAPI().getName();
      updatePlayerData(playerName, statKey, 0);
      Logging.getLogger().info("Player data saved for: " + playerName);
    }
  }


  private boolean isModuleDisabled() {
    return addon.configuration().getKitHeadTimer().get().equals(false) ||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getPrisonEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }
}
