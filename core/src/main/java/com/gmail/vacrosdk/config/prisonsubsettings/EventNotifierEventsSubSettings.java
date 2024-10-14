package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.annotation.SpriteTexture;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

@SpriteTexture("settings/icons2.png")
public class EventNotifierEventsSubSettings extends Config {

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(x = 5)
  private final ConfigProperty<Boolean> guardsDisabledVaultsEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot()
  private final ConfigProperty<Boolean> aPlusVaultEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(x = 1)
  private final ConfigProperty<Boolean> aVaultEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(x = 2)
  private final ConfigProperty<Boolean> bPlusVaultEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(x = 3)
  private final ConfigProperty<Boolean> bVaultEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(x = 4)
  private final ConfigProperty<Boolean> cVaultEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 2)
  private final ConfigProperty<Boolean> bPlusGangAreaEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 3)
  private final ConfigProperty<Boolean> bGangAreaEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 1)
  private final ConfigProperty<Boolean> aGangAreaEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1)
  private final ConfigProperty<Boolean> aPlusGangAreaEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 5)
  private final ConfigProperty<Boolean> rockerTorbenEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 4)
  private final ConfigProperty<Boolean> pvpChestEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 6)
  private final ConfigProperty<Boolean> stringCaughtEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 4)
  private final ConfigProperty<Boolean> BoLootEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 1, x = 7)
  private final ConfigProperty<Boolean> headEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 2, x = 6)
  private final ConfigProperty<Boolean> guardKillEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 3)
  private final ConfigProperty<Boolean> FlipNewOfferEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 3, x = 1)
  private final ConfigProperty<Boolean> FlipWinningEvent = new ConfigProperty<>(false);

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 3, x = 2)
  private final ConfigProperty<Boolean> FlipLosingEvent = new ConfigProperty<>(false);

  public ConfigProperty<Boolean> getaPlusVaultEvent() {
    return aPlusVaultEvent;
  }

  public ConfigProperty<Boolean> getaVaultEvent() {
    return aVaultEvent;
  }

  public ConfigProperty<Boolean> getbPlusVaultEvent() {
    return bPlusVaultEvent;
  }

  public ConfigProperty<Boolean> getbVaultEvent() {
    return bVaultEvent;
  }

  public ConfigProperty<Boolean> getcVaultEvent() {
    return cVaultEvent;
  }

  public ConfigProperty<Boolean> getbPlusGangAreaEvent() {
    return bPlusGangAreaEvent;
  }

  public ConfigProperty<Boolean> getaGangAreaEvent() {
    return aGangAreaEvent;
  }

  public ConfigProperty<Boolean> getaPlusGangAreaEvent() {
    return aPlusGangAreaEvent;
  }

  public ConfigProperty<Boolean> getRockerTorbenEvent() {
    return rockerTorbenEvent;
  }

  public ConfigProperty<Boolean> getGuardsDisabledVaultsEvent() {
    return guardsDisabledVaultsEvent;
  }

  public ConfigProperty<Boolean> getPvpChestEvent() {
    return pvpChestEvent;
  }

  public ConfigProperty<Boolean> getStringCaughtEvent() {
    return stringCaughtEvent;
  }

  public ConfigProperty<Boolean> getBoLootEventEvent() {
    return BoLootEvent;
  }

  public ConfigProperty<Boolean> getHeadEvent() {
    return headEvent;
  }

  public ConfigProperty<Boolean> getGuardKillEvent() {
    return guardKillEvent;
  }

  public ConfigProperty<Boolean> getBGangAreaEvent() {
    return bGangAreaEvent;
  }
  public ConfigProperty<Boolean> getFlipLostEvent() {
    return FlipLosingEvent;
  }
  public ConfigProperty<Boolean> getFlipNewOfferEvent() {
    return FlipNewOfferEvent;
  }
  public ConfigProperty<Boolean> getFlipWinEvent() {
    return FlipWinningEvent;
  }
}
