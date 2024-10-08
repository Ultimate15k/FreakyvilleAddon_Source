package com.gmail.vacrosdk.config.frihedensubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public class ApartmentsSubSettings extends Config {

  @ShowSettingInParent
  @SwitchSetting
  private ConfigProperty<Boolean> enabled = new ConfigProperty<>(false);
  @SwitchSetting
  @SpriteSlot(x = 6, y = 6)
  private final ConfigProperty<Boolean> ReqEnabled = new ConfigProperty<>(true);
  @SwitchSetting
  @SpriteSlot(y = 2)
  private final ConfigProperty<Boolean> DesEnabled = new ConfigProperty<>(true);

  public ConfigProperty<Boolean> getApartmentsEnabled() {
    return enabled;
  }
  public ConfigProperty<Boolean> getReqEnabled() {
    return ReqEnabled;
  }
  public ConfigProperty<Boolean> getDesEnabled() {
    return DesEnabled;
  }

}