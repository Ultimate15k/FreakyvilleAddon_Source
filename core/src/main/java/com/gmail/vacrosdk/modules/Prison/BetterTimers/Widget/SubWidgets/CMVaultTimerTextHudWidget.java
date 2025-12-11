package com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpots;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.TimerWidget;
import net.labymod.api.client.gui.icon.Icon;

public class CMVaultTimerTextHudWidget extends TimerWidget {

  public CMVaultTimerTextHudWidget(String id, Icon icon, FreakyvilleAddon addon) {
    super(id, addon, icon);
  }

  @Override
  public String getStringTimeLeft() {
    return HotSpots.CM_VAULT.getHotSpot().getTimeLeft();
  }

  @Override
  public String getHotSpotName() {
    return HotSpots.CM_VAULT.getHotSpot().getHotSpotName();
  }
}
