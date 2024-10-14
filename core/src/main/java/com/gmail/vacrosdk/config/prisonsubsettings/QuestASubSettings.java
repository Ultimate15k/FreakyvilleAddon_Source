package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

public class QuestASubSettings extends Config {

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 2, x = 1)
  @ShowSettingInParent
  private final ConfigProperty<Boolean> AQuestEnabled = new ConfigProperty<>(true);

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 5, x = 1)
  private final ConfigProperty<Boolean> gertvagtEnabled = new ConfigProperty<>(true);

  @SwitchSetting
  @SettingRequires("questsEnabled")
  @SpriteSlot(y = 4, x = 6)
  private final ConfigProperty<Boolean> donvitoEnabled = new ConfigProperty<>(true);

  public ConfigProperty<Boolean> getGertvagtEnabled() {
    return gertvagtEnabled;
  }

  public ConfigProperty<Boolean> getDonvitoEnabled() {
    return donvitoEnabled;
  }

  public ConfigProperty<Boolean> getAQuestEnabled() {
    return AQuestEnabled;
  }

}
