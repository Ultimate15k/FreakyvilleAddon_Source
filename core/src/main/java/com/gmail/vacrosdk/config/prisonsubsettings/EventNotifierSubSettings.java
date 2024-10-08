package com.gmail.vacrosdk.config.prisonsubsettings;

import com.gmail.vacrosdk.modules.Prison.EventNotifier.Sounds.NotificationSound;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public class EventNotifierSubSettings extends Config {

  @ShowSettingInParent
  @SwitchSetting
  @SpriteSlot(y = 1, x = 4)
  private final ConfigProperty<Boolean> eventNotifier = new ConfigProperty<>(true);
  @SpriteSlot(y = 3, x = 4)
  private final EventNotifierSoundSubSettings eventNotifierSoundSubSettings = new EventNotifierSoundSubSettings();
  @SpriteSlot(y = 4, x = 1)
  private final EventNotifierEventsSubSettings eventNotifierEventsSubSettings = new EventNotifierEventsSubSettings();



  public ConfigProperty<Boolean> getSoundEnabled() {
    return eventNotifierSoundSubSettings.getSoundEnabled();
  }

  public ConfigProperty<NotificationSound> getNotifierSound() {
    return eventNotifierSoundSubSettings.getNotifierSound();
  }

  public ConfigProperty<Float> getVolume() {
    return eventNotifierSoundSubSettings.getVolume();
  }

  public ConfigProperty<Boolean> getEventNotifier() {
    return eventNotifier;
  }

  public ConfigProperty<Boolean> getaPlusVaultEvent() {
    return eventNotifierEventsSubSettings.getaPlusVaultEvent();
  }

  public ConfigProperty<Boolean> getaVaultEvent() {
    return eventNotifierEventsSubSettings.getaVaultEvent();
  }

  public ConfigProperty<Boolean> getBVaultEvent() {
    return eventNotifierEventsSubSettings.getbVaultEvent();
  }

  public ConfigProperty<Boolean> getCVaultEvent() {
    return eventNotifierEventsSubSettings.getcVaultEvent();
  }

  public ConfigProperty<Boolean> getaGangAreaEvent() {
    return eventNotifierEventsSubSettings.getaGangAreaEvent();
  }

  public ConfigProperty<Boolean> getaPlusGangAreaEvent() {
    return eventNotifierEventsSubSettings.getaPlusGangAreaEvent();
  }

  public ConfigProperty<Boolean> getRockerTorbenEvent() {
    return eventNotifierEventsSubSettings.getRockerTorbenEvent();
  }

  public ConfigProperty<Boolean> getGuardsDisabledVaultsEvent() {
    return eventNotifierEventsSubSettings.getGuardsDisabledVaultsEvent();
  }

  public ConfigProperty<Boolean> getStringCaughtEvent() {
    return eventNotifierEventsSubSettings.getStringCaughtEvent();
  }

  public ConfigProperty<Boolean> getBoLootEventEvent() {
    return eventNotifierEventsSubSettings.getBoLootEventEvent();
  }

  public ConfigProperty<Boolean> getHeadEvent() {
    return eventNotifierEventsSubSettings.getHeadEvent();
  }

  public ConfigProperty<Boolean> getGuardKillEvent() {
    return eventNotifierEventsSubSettings.getGuardKillEvent();
  }

  public ConfigProperty<Boolean> getBPlusVaultEvent() {
    return eventNotifierEventsSubSettings.getbPlusVaultEvent();
  }

  public ConfigProperty<Boolean> getBPlusGangAreaEvent() {
    return eventNotifierEventsSubSettings.getbPlusGangAreaEvent();
  }

  public ConfigProperty<Boolean> getBGangAreaEvent() {
    return eventNotifierEventsSubSettings.getBGangAreaEvent();
  }

  public ConfigProperty<Boolean> getBPvpChestEvent() {
    return eventNotifierEventsSubSettings.getPvpChestEvent();
  }

  public ConfigProperty<Boolean> getFlipLostEvent() {
    return eventNotifierEventsSubSettings.getFlipLostEvent();
  }

  public ConfigProperty<Boolean> getFlipNewOfferEvent() {
    return eventNotifierEventsSubSettings.getFlipNewOfferEvent();
  }

  public ConfigProperty<Boolean> getFlipWinEvent() {
    return eventNotifierEventsSubSettings.getFlipWinEvent();
  }


}
