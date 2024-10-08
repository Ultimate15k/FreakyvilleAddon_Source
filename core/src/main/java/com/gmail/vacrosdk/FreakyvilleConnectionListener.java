package com.gmail.vacrosdk;

import com.gmail.vacrosdk.utils.VersionChecker;
import java.net.http.WebSocket.Listener;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerDisconnectEvent;
import net.labymod.api.event.client.network.server.ServerJoinEvent;

public class FreakyvilleConnectionListener implements Listener {

  private final FreakyvilleAddon addon;

  public FreakyvilleConnectionListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }
  @Subscribe
  public void onFreakyvilleConnect(ServerJoinEvent event) {
    String ip = event.serverData().address().getHost().toLowerCase();
    VersionChecker versionChecker = new VersionChecker(addon);
    versionChecker.checkVersion();
    if(ip.contains("freakyville")) {
      addon.displayMessage("§8[§a§lFV-ADDON§8§l] §aYou connected to Freakyville!");
      addon.setOnlineOnFreakyville(true);
    }
  }

  @Subscribe
  public void onFreakyvilleDisconnect(ServerDisconnectEvent event) {
    String ip = event.serverData().address().getHost().toLowerCase();
    if(ip.contains("freakyville")) {
      addon.SetIsPlayerOnGuard(false);
      addon.setOnlineOnFreakyville(false);
    }
  }

}
