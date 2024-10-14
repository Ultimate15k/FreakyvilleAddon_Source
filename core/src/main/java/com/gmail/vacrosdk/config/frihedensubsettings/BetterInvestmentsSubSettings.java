package com.gmail.vacrosdk.config.frihedensubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public class BetterInvestmentsSubSettings extends Config {

  @ShowSettingInParent
  @SwitchSetting
  @SpriteSlot(y = 4, x = 3)
  private ConfigProperty<Boolean> enabled = new ConfigProperty<>(false);

  @SwitchSetting
  @SpriteSlot(y = 5, x = 4)
  private final ConfigProperty<Boolean> joinTitle = new ConfigProperty<>(false);

  public ConfigProperty<Boolean> getBetterInvestmentsEnabled() {
    return enabled;
  }
  public ConfigProperty<Boolean> getJoinTitleEnable() {
    return joinTitle;
  }

}