package com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpots;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.TimerWidget;
import net.labymod.api.client.gui.icon.Icon;

public class BPlusGangAreaTimerTextHudWidget extends TimerWidget {

  public BPlusGangAreaTimerTextHudWidget(String id, FreakyvilleAddon addon, Icon icon) {
    super(id, addon, icon);
  }

  @Override
  public String getStringTimeLeft() {
    return HotSpots.BPLUS_GANGAREA.getHotSpot().getTimeLeft();
  }

  @Override
  public String getHotSpotName() {
    return HotSpots.BPLUS_GANGAREA.getHotSpot().getHotSpotName();
  }
}
