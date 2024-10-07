package com.gmail.vacrosdk.config.frihedensubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ParentSwitch;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public class BetterInvestmentsSubSettings extends Config {

  @ParentSwitch
  @SwitchSetting
  private ConfigProperty<Boolean> enabled = new ConfigProperty<>(false);
  @SwitchSetting
  @SpriteSlot(x = 6, y = 6)
  private final ConfigProperty<Boolean> joinTitle = new ConfigProperty<>(false);

  public ConfigProperty<Boolean> getBetterInvestmentsEnabled() {
    return enabled;
  }
  public ConfigProperty<Boolean> getJoinTitleEnable() {
    return joinTitle;
  }

}