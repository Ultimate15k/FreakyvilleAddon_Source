package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.TextFieldWidget.TextFieldSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

public class GuardSubSettings extends Config {

  @SwitchSetting
  @SpriteSlot(y = 2, x = 6)
  private final ConfigProperty<Boolean> vagtSwitch = new ConfigProperty<>(false);

  @SwitchSetting
  @SpriteSlot(y = 2, x = 4)
  private final ConfigProperty<Boolean> automaticSwitch = new ConfigProperty<>(true);

  @SettingRequires("automaticSwitch")
  @TextFieldSetting
  @SpriteSlot(x = 4)
  private final ConfigProperty<String> vagtName = new ConfigProperty<>("Indsæt vagtnavn");

  public ConfigProperty<Boolean> getVagtSwitch() {
    return vagtSwitch;
  }

  public ConfigProperty<String> getVagtName() {
    return vagtName;
  }

  public ConfigProperty<Boolean> getAutomaticSwitch() {
    return automaticSwitch;
  }

}
