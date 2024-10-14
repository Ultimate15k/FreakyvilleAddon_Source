package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public class QuestSubSettings extends Config {

  @ShowSettingInParent
  @SwitchSetting
  @SpriteSlot(y = 5)
  private final ConfigProperty<Boolean> questsEnabled = new ConfigProperty<>(true);
  @SpriteSlot(y = 2, x = 1)
  private final QuestASubSettings questasubSettings = new QuestASubSettings();
  @SpriteSlot(y = 2, x = 2)
  private final QuestBSubSettings questbsubSettings = new QuestBSubSettings();



  public ConfigProperty<Boolean> getQuestsEnabled() {
    return questsEnabled;
  }
  public ConfigProperty<Boolean> getDonvitoEnabled() {
    return questasubSettings.getDonvitoEnabled();
  }
  public ConfigProperty<Boolean> getGertvagtEnabled() {
    return questasubSettings.getGertvagtEnabled();
  }
  public ConfigProperty<Boolean> getFinnfiskerEnabled() {
    return questbsubSettings.getFinnfiskerEnabled();
  }
  public ConfigProperty<Boolean> getPallevagtEnabled() {
    return questbsubSettings.getPallevagtEnabled();
  }
  public ConfigProperty<Boolean> getMrXEnabled() {
    return questbsubSettings.getMrXEnabled();
  }

  public ConfigProperty<Boolean> getBQuestEnabled() {
    return questbsubSettings.getBQuestEnabled();
  }

  public ConfigProperty<Boolean> getAQuestEnabled() {
    return questasubSettings.getAQuestEnabled();
  }

}
