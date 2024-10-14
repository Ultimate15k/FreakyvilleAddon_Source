package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.util.Color;

public class BettertimersSubSettings extends Config {

  @ShowSettingInParent
  @SwitchSetting
  private final ConfigProperty<Boolean> betterTimers = new ConfigProperty<>(true);

  @SpriteSlot(y = 1)
  private final BetterTimersColorSettings betterTimersColorSettings = new BetterTimersColorSettings();

  @SpriteSlot(x = 7)
  private final BetterTimersNotificationSettings betterTimersNotificationSettings = new BetterTimersNotificationSettings();

  @SwitchSetting
  @SpriteSlot(y = 1, x = 5)
  private final ConfigProperty<Boolean> KitHeadTimer = new ConfigProperty<>(false);

  @SwitchSetting
  @SpriteSlot(y = 3, x = 4)
  private final ConfigProperty<Boolean> ChestTimer = new ConfigProperty<>(false);

  public ConfigProperty<Boolean> getBetterTimers() {
    return betterTimers;
  }

  public ConfigProperty<Boolean> getKitHeadTimer() {
    return KitHeadTimer;
  }

  public ConfigProperty<Boolean> getChestTimer() {
    return ChestTimer;
  }

  public ConfigProperty<Boolean> getBetterTimersMessage() {
    return betterTimersNotificationSettings.getBetterTimersMessage();
  }

  public ConfigProperty<Integer> getTimerNotificationSlider() {
    return betterTimersNotificationSettings.getTimerNotificationSlider();
  }

  public ConfigProperty<Boolean> getTimerNotification() {
    return betterTimersNotificationSettings.getTimerNotification();
  }

  public ConfigProperty<Color> getKnownTimerColor() {
    return betterTimersColorSettings.getKnownTimerColor();
  }

  public ConfigProperty<Color> getUnknownTimerColor() {
    return betterTimersColorSettings.getUnknownTimerColor();
  }

  public ConfigProperty<Color> getMainTimerColor() {
    return betterTimersColorSettings.getMainTimerColor();
  }


}
