package com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;

public class WidgetUpdater {

  private final FreakyvilleAddon addon;
  private int count = 0;

  public WidgetUpdater(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(GameTickEvent event) {
    count += 2;
    if (count == 40) {
      if (moduleIsDisabled()) {
        return;
      }
      doAction();
    }
    if(count > 40) {
      count = 0;
    }
  }

  private void doAction() {
    addon.labyAPI().hudWidgetRegistry().updateHudWidgets();
  }

  private boolean moduleIsDisabled() {
    return  addon.configuration().getBetterTimers().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

}
