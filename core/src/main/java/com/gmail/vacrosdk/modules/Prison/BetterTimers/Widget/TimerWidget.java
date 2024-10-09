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

  public TimerWidget(String id, FreakyvilleAddon addon, Icon icon) {
    super(id, TextHudWidgetConfig.class);
    this.addon = addon;

    // Automatically bind the widget to the addon's category
    this.bindCategory(addon.getWidgetCategory());

    // Set the widget icon
    this.setIcon(icon);
  }

  @Override
  public void onUpdate() {
    super.onUpdate();

    String timeLeft = getStringTimeLeft();

    if (timeLeft == null || timeLeft.equals("Kan tages")) {
      if (this.text == null) {
        this.text = this.createLine(getHotSpotName(), "");
      }
      this.text.setState(State.HIDDEN);
      return;
    }

    // Hide if the player is a guard
    if (addon.IsPlayerOnGuard()) {
      this.text.setState(State.HIDDEN);
      return;
    }

    this.text.update(timeLeft);
    this.text.setState(State.VISIBLE);
  }

  @Override
  public void load(TextHudWidgetConfig config) {
    super.load(config);

    String timeLeft = getStringTimeLeft();
    if (timeLeft == null) {
      timeLeft = "Ukendt";
    }

    // Initialize and set the state of the text
    this.text = this.createLine(getHotSpotName(), timeLeft);
    this.text.setState(State.VISIBLE);
  }

  // Abstract methods that each specific widget must implement
  public abstract String getStringTimeLeft();
  public abstract String getHotSpotName();
}
