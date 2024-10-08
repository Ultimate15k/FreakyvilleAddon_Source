package com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine.State;
import net.labymod.api.client.gui.icon.Icon;

public abstract class TimerWidget extends TextHudWidget<TextHudWidgetConfig> {

  private TextLine text;
  private final FreakyvilleAddon addon;

  private final Icon hudWidgetIcon;

  public TimerWidget(String id, FreakyvilleAddon addon, Icon icon) {
    super(id);
    this.addon = addon;
    this.hudWidgetIcon = icon;
  }

  @Override
  public void onUpdate() {
    super.onUpdate();
    if(getStringTimeLeft() == null || getStringTimeLeft().equals("Kan tages")) {
      if(this.text == null){
        this.text = this.createLine(getHotSpotName(), "");
        this.text.setState(State.HIDDEN);
        return;
      }
      this.text.setState(State.HIDDEN);
      return;
    }
    if(addon.IsPlayerOnGuard().equals(true)) {
      this.text.setState(State.HIDDEN);
      return;
    }
    this.text.update(getStringTimeLeft());
    this.text.setState(State.VISIBLE);
  }

  @Override
  public void load(TextHudWidgetConfig config) {
    super.load(config);

    String stringTimeLeft = getStringTimeLeft();
    if(stringTimeLeft == null) {
      stringTimeLeft = "Ukendt";
    }

    this.text = super.createLine(getHotSpotName(), stringTimeLeft);
    this.text.setState(State.VISIBLE);

    this.setIcon(this.hudWidgetIcon);
  }

  public abstract String getStringTimeLeft();

  public abstract String getHotSpotName();
}