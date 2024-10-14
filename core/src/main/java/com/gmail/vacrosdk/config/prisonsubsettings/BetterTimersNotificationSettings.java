package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

public class BetterTimersNotificationSettings extends Config {

  @SettingRequires("betterTimers")
  @SwitchSetting
  @SpriteSlot(x = 7)
  private final ConfigProperty<Boolean> betterTimersMessage = new ConfigProperty<>(true);

  @SettingRequires("betterTimers")
  @SwitchSetting()
  @SpriteSlot(x = 5)
  private final ConfigProperty<Boolean> timerNotification = new ConfigProperty<>(true);

  @SettingRequires("timerNotification")
  @SliderSetting(min=1, max=5)
  @SpriteSlot(x = 6)
  private final ConfigProperty<Integer> timerNotificationSlider = new ConfigProperty<>(2);

  public ConfigProperty<Boolean> getBetterTimersMessage() {
    return betterTimersMessage;
  }

  public ConfigProperty<Boolean> getTimerNotification() {
    return timerNotification;
  }

  public ConfigProperty<Integer> getTimerNotificationSlider() {
    return timerNotificationSlider;
  }

}
