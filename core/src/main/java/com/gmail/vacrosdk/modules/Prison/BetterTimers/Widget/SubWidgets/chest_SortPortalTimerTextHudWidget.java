package com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.TimerWidget;
import net.labymod.api.client.gui.icon.Icon;

import static com.gmail.vacrosdk.utils.TimerFunctions.calculateTime;
import static com.gmail.vacrosdk.utils.TimerFunctions.playerExists;

public class chest_SortPortalTimerTextHudWidget extends TimerWidget {

  public chest_SortPortalTimerTextHudWidget(String id, FreakyvilleAddon addon, Icon icon) {
    super(id, addon, icon);
  }

  @Override
  public String getStringTimeLeft() {
    String playerName = this.labyAPI.getName();
    if (!playerExists(playerName,"chest_SortPortal")) {
      return null;
    }
    String time = calculateTime(playerName, "chest_SortPortal");
    if (time == null) {
      return null;
    }
    return time.replace("time", "T")
        .replace("minutter", "M")
        .replace("sekunder", "S");
  }

  @Override
  public String getHotSpotName() {
    return "Chest - Sort Portal";
  }
}
