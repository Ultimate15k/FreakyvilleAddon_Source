package com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Listeners;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.network.NetworkPlayerInfo;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.playerinfo.PlayerInfoAddEvent;

public class JoinListener {

  private final FreakyvilleAddon addon;
  private final PlayerNotifierManager playerManager;

  public JoinListener(FreakyvilleAddon addon,
      PlayerNotifierManager playerManager) {
    this.addon = addon;
    this.playerManager = playerManager;
  }

  @Subscribe
  public void onGameTick(PlayerInfoAddEvent event) {
    if (!addon.isOnlineOnFreakyville()) {
      return;
    }
    if(moduleIsDisabled()) {
      return;
    }
    NetworkPlayerInfo playerInfo = event.playerInfo();
    String username = playerInfo.profile().getUsername();
    if(playerManager.contains(username.toLowerCase())) {
      Icon head = Icon.head(playerInfo.profile().getUniqueId());
      Utils.createNotification(username, "er joinet din server!", head);
    }

  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getPlayerNotifier().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getJoinNotifier().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

}
