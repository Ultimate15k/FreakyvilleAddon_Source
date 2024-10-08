package com.gmail.vacrosdk.config;

import com.gmail.vacrosdk.config.frihedensubsettings.ApartmentsSubSettings;
import com.gmail.vacrosdk.config.frihedensubsettings.BetterInvestmentsSubSettings;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;

public class FrihedenConfig extends Config {

  @ShowSettingInParent
  @SwitchSetting
  @SpriteSlot(y = 5, x = 3)
  private final ConfigProperty<Boolean> frihedenEnabled = new ConfigProperty<>(false);
  @SettingSection("betterapartments")
  @SpriteSlot(x = 4, y = 6)
  private ApartmentsSubSettings ApartmentsEnabled = new ApartmentsSubSettings();

  @SettingSection("betterRenter")
  @SwitchSetting
  @SpriteSlot(x = 5, y = 6)
  private final ConfigProperty<Boolean> renterEnabled = new ConfigProperty<>(false);

  @SettingSection("betterinvestments")
  @SpriteSlot(x = 3, y = 6)
  private BetterInvestmentsSubSettings InvestmentsEnabled = new BetterInvestmentsSubSettings();

  public ConfigProperty<Boolean> getFrihedenEnabled() {
    return frihedenEnabled;
  }

  public ConfigProperty<Boolean> getRenterEnabled() {
    return renterEnabled;
  }
  public ConfigProperty<Boolean> getApartmentsEnabled() {
    return ApartmentsEnabled.getApartmentsEnabled();
  }
  public ConfigProperty<Boolean> getReqEnabled() {
    return ApartmentsEnabled.getReqEnabled();
  }
  public ConfigProperty<Boolean> getDesEnabled() {
    return ApartmentsEnabled.getDesEnabled();
  }

  public ConfigProperty<Boolean> getBetterInvestmentsEnabled() {
    return InvestmentsEnabled.getBetterInvestmentsEnabled();
  }

  public ConfigProperty<Boolean> getJoinTitleEnable() {
    return InvestmentsEnabled.getJoinTitleEnable();
  }

}
