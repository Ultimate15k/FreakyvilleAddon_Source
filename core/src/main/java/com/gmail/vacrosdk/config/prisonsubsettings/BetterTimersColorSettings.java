package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.color.ColorPickerWidget.ColorPickerSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;
import net.labymod.api.util.Color;

public class BetterTimersColorSettings extends Config {

  @SettingRequires("betterTimers")
  @ColorPickerSetting(chroma = true)
  @SpriteSlot(y = 1)
  private final ConfigProperty<Color> mainTimerColor = new ConfigProperty<>(Color.ofRGB(9, 58, 142, 70));

  @SettingRequires("betterTimers")
  @ColorPickerSetting(chroma = true)
  @SpriteSlot(y = 1)
  private final ConfigProperty<Color> knownTimerColor = new ConfigProperty<>(Color.ofRGB(9, 58, 142, 70));

  @SettingRequires("betterTimers")
  @ColorPickerSetting(chroma = true)
  @SpriteSlot(y = 1)
  private final ConfigProperty<Color> unknownTimerColor = new ConfigProperty<>(Color.ofRGB(9, 58, 142, 70));

  public ConfigProperty<Color> getMainTimerColor() {
    return mainTimerColor;
  }

  public ConfigProperty<Color> getKnownTimerColor() {
    return knownTimerColor;
  }

  public ConfigProperty<Color> getUnknownTimerColor() {
    return unknownTimerColor;
  }
}
