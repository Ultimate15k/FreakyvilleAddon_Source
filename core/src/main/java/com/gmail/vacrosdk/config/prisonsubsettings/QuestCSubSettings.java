package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

public class QuestCSubSettings extends Config {

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 2, x = 2)
  @ShowSettingInParent
  private final ConfigProperty<Boolean> CQuestEnabled = new ConfigProperty<>(true);

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 4, x = 7)
  private final ConfigProperty<Boolean> CfinnfiskerEnabled = new ConfigProperty<>(true);

  public ConfigProperty<Boolean> getCQuestEnabled() {
    return CQuestEnabled;
  }

  public ConfigProperty<Boolean> getCFinnfiskerEnabled() {
    return CfinnfiskerEnabled;
  }

}
