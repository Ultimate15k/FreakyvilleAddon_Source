package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

public class BetterNameTagsFontSettings extends Config {

  @SettingRequires("nameTags")
  @SwitchSetting
  @SpriteSlot(y = 1)
  private final ConfigProperty<Boolean> boldFont = new ConfigProperty<>(false);

  @SettingRequires("nameTags")
  @SwitchSetting
  @SpriteSlot(y = 4, x = 4)
  private final ConfigProperty<Boolean> underline = new ConfigProperty<>(false);

  @SettingRequires("nameTags")
  @SwitchSetting
  @SpriteSlot(y = 4, x = 7)
  private final ConfigProperty<Boolean> magic = new ConfigProperty<>(false);

  @SettingRequires("nameTags")
  @SwitchSetting
  @SpriteSlot(y = 4, x = 6)
  private final ConfigProperty<Boolean> strike = new ConfigProperty<>(false);

  @SettingRequires("nameTags")
  @SwitchSetting
  @SpriteSlot(y = 4, x = 5)
  private final ConfigProperty<Boolean> italic = new ConfigProperty<>(false);


  public ConfigProperty<Boolean> getBoldFont() {
    return boldFont;
  }

  public ConfigProperty<Boolean> getUnderline() {
    return underline;
  }

  public ConfigProperty<Boolean> getMagic() {
    return magic;
  }

  public ConfigProperty<Boolean> getStrike() {
    return strike;
  }

  public ConfigProperty<Boolean> getItalic() {
    return italic;
  }
}
