package com.gmail.vacrosdk.plugin.KitsTimers;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.Title;
import net.labymod.api.client.component.Component;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerJoinEvent;

import static com.gmail.vacrosdk.utils.TimerFunctions.isDateAWeekAgo;
import static com.gmail.vacrosdk.utils.TimerFunctions.isDateOver24HoursAgo;
import static com.gmail.vacrosdk.utils.TimerFunctions.playerExists;

public class KitServerJoin {

  private final FreakyvilleAddon addon;

  public KitServerJoin(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onServerJoin(ServerJoinEvent server) {
    if (!isModuleDisabled()) {
      String playerName = addon.labyAPI().getName();
      boolean exists = playerExists(playerName,"kithead_date_time");
      if (exists) {
        isDateAWeekAgo(playerName);
        if (server.serverData().actualAddress().getHost().contains("freakyville")) {
          if (isDateOver24HoursAgo(playerName,"kithead_date_time")) {
            Title.builder()
                .title(Component.text("§4§lKit Head"))
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
    return addon.configuration().getKitHeadTimer().get().equals(false) ||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getPrisonEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }

}
