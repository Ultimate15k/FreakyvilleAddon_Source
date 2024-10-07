package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ParentSwitch;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

public class QuestBSubSettings extends Config {

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 6)
  @ParentSwitch
  private final ConfigProperty<Boolean> BQuestEnabled = new ConfigProperty<>(true);

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 6, x = 1)
  private final ConfigProperty<Boolean> mrxEnabled = new ConfigProperty<>(true);

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 5, x = 7)
  private final ConfigProperty<Boolean> finnfiskerEnabled = new ConfigProperty<>(true);

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 6, x = 2)
  private final ConfigProperty<Boolean> pallevagtEnabled = new ConfigProperty<>(true);

  public ConfigProperty<Boolean> getBQuestEnabled() {
    return BQuestEnabled;
  }

  public ConfigProperty<Boolean> getMrXEnabled() {
    return mrxEnabled;
  }

  public ConfigProperty<Boolean> getFinnfiskerEnabled() {
    return finnfiskerEnabled;
  }

  public ConfigProperty<Boolean> getPallevagtEnabled() {
    return pallevagtEnabled;
  }

}
