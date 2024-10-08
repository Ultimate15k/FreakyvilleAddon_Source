package com.gmail.vacrosdk.modules.Friheden.BetterInvestments;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.Title;
import net.labymod.api.client.component.Component;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerJoinEvent;

import static com.gmail.vacrosdk.utils.TimerFunctions.*;

public class ServerJoin {

  private final FreakyvilleAddon addon;

  public ServerJoin(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onServerJoin(ServerJoinEvent server) {
    if (!isModuleDisabled()) {
      if (server.serverData().actualAddress().getHost().contains("freakyville")) {
        String playerName = addon.labyAPI().getName();
        boolean hasFile = playerExists(playerName,"investments_time");
        if (hasFile) {
          boolean isOver24Hours = isDateOver24HoursAgo(playerName,"investments");
          if (isOver24Hours) {
            Title.builder()
                .title(Component.text("§4§lDine investeringer"))
                .subTitle(Component.text("§4§lkan tages!!"))
                .fadeIn(5)
                .stay(60)
                .fadeOut(5)
                .build()
                .show();
          }
        }
      }
    }
  }

  private boolean isModuleDisabled() {
    return addon.configuration().getBetterInvestmentsEnabled().get().equals(false) ||
        addon.configuration().getInvestmentsJoinTitleEnable().get().equals(false)||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getFrihedenEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }

}
