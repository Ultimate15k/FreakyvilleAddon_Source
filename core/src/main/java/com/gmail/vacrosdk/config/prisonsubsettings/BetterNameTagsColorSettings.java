package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.color.ColorPickerWidget.ColorPickerSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;
import net.labymod.api.util.Color;

public class BetterNameTagsColorSettings extends Config {

  @SettingRequires("nameTags")
  @ColorPickerSetting(chroma = true)
  @SpriteSlot(y = 1)
  private final ConfigProperty<Color> nameTagColor = new ConfigProperty<>(Color.ofRGB(9, 58, 142, 70));

  @SettingRequires("nameTags")
  @ColorPickerSetting(chroma = true)
  @SpriteSlot(y = 1)
  private final ConfigProperty<Color> nameTagMessageColor = new ConfigProperty<>(Color.ofRGB(9, 58, 142, 70));

  public ConfigProperty<Color> getNameTagColor() {
    return nameTagColor;
  }

  public ConfigProperty<Color> getNameTagMessageColor() {
    return nameTagMessageColor;
  }
}
