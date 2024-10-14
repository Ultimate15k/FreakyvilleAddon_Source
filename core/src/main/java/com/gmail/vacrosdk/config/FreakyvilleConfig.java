package com.gmail.vacrosdk.config;

import com.gmail.vacrosdk.modules.Prison.EventNotifier.Sounds.NotificationSound;
import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.annotation.SpriteTexture;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;
import net.labymod.api.util.Color;

@ConfigName("settings")
@SpriteTexture("settings/icons.png")
public class FreakyvilleConfig extends AddonConfig {

  @SwitchSetting
  @SpriteSlot()
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SettingSection("Prison")
  @SpriteSlot(x = 1)
  private PrisonConfig prisonConfig = new PrisonConfig();

  @SettingSection("Friheden")
  @SpriteSlot(x = 2)
  private FrihedenConfig frihedenConfig = new FrihedenConfig();

  @SettingSection("Misc")
  @SwitchSetting
  @SpriteSlot(x = 3)
  private final ConfigProperty<Boolean> discordDisabled = new ConfigProperty<>(true);

  @SwitchSetting
  @SpriteSlot(x = 4)
  private final ConfigProperty<Boolean> fileAccess = new ConfigProperty<>(true);

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }
  public ConfigProperty<Boolean> discordDisabled() {
    return discordDisabled;
  }
  public ConfigProperty<Boolean> getHasfileAccess() {
    return fileAccess;
  }
  public ConfigProperty<Boolean> getPrisonEnabled() {
    return prisonConfig.getPrisonEnabled();
  }
  public ConfigProperty<Boolean> getFrihedenEnabled() {
    return frihedenConfig.getFrihedenEnabled();
  }
  public ConfigProperty<Boolean> getRenterEnabled() {
    return frihedenConfig.getRenterEnabled();
  }
  public ConfigProperty<Boolean> getBetterCells() {
    return prisonConfig.getBetterCells();
  }
  public ConfigProperty<Boolean> getBetterCellsLocation() {
    return prisonConfig.getBetterCellsLocation();
  }
  //PlayerNotifier
  public ConfigProperty<Boolean> getPlayerNotifier() {
    return prisonConfig.getPlayerNotifier();
  }
  public ConfigProperty<Boolean> getJoinNotifier() {
    return prisonConfig.getJoinNotifier();
  }
  public ConfigProperty<Boolean> getLeaveNotifier() {
    return prisonConfig.getLeaveNotifier();
  }
  public ConfigProperty<Color> getPlayerNotifierColor() {
    return prisonConfig.getPlayerNotifierColor();
  }

  //BetterApartments
  public ConfigProperty<Boolean> getApartmentsEnabled() {
    return frihedenConfig.getApartmentsEnabled();
  }
  public ConfigProperty<Boolean> getReqEnabled() {
    return frihedenConfig.getReqEnabled();
  }
  public ConfigProperty<Boolean> getDesEnabled() {
    return frihedenConfig.getDesEnabled();
  }

  //BetterInvestments
  public ConfigProperty<Boolean> getBetterInvestmentsEnabled() {
    return frihedenConfig.getBetterInvestmentsEnabled();
  }
  public ConfigProperty<Boolean> getInvestmentsJoinTitleEnable() {
    return frihedenConfig.getJoinTitleEnable();
  }


  //BetterTimers
  public ConfigProperty<Boolean> getKitHeadTimer() {
    return prisonConfig.getKitHeadTimer();
  }
  public ConfigProperty<Boolean> getChestTimer() {
    return prisonConfig.getChestTimer();
  }
  public ConfigProperty<Boolean> getBetterTimers() {
    return prisonConfig.getBetterTimers();
  }
  public ConfigProperty<Boolean> getBetterTimersMessage() {
    return prisonConfig.getBetterTimersMessage();
  }
  public ConfigProperty<Integer> getTimerNotificationSlider() {
    return prisonConfig.getTimerNotificationSlider();
  }
  public ConfigProperty<Boolean> getTimerNotification() {
    return prisonConfig.getTimerNotification();
  }
  public ConfigProperty<Color> getKnownTimerColor() {
    return prisonConfig.getKnownTimerColor();
  }
  public ConfigProperty<Color> getUnknownTimerColor() {
    return prisonConfig.getUnknownTimerColor();
  }
  public ConfigProperty<Color> getMainTimerColor() {
    return prisonConfig.getMainTimerColor();
  }

  //BetterNameTags
  public ConfigProperty<Boolean> getNameTags() {
    return prisonConfig.getNameTags();
  }
  public ConfigProperty<Color> getNameTagColor() {
    return prisonConfig.getNameTagColor();
  }
  public ConfigProperty<Boolean> getBoldFont() {
    return prisonConfig.getBoldFont();
  }
  public ConfigProperty<Color> getNameTagMessageColor() {
    return prisonConfig.getNameTagMessageColor();
  }
  public ConfigProperty<Boolean> getItalicFont() {
    return prisonConfig.getItalicFont();
  }

  public ConfigProperty<Boolean> getMagicFont() {
    return prisonConfig.getMagicFont();
  }

  public ConfigProperty<Boolean> getStrikeFont() {
    return prisonConfig.getStrikeFont();
  }

  public ConfigProperty<Boolean> getUnderlineFont() {
    return prisonConfig.getUnderlineFont();
  }

  //EventNotifier
  public ConfigProperty<Boolean> getSoundEnabled() {
    return prisonConfig.getSoundEnabled();
  }

  public ConfigProperty<NotificationSound> getNotifierSound() {
    return prisonConfig.getNotifierSound();
  }


  //EventNotifier
  public ConfigProperty<Float> getVolume() {
    return prisonConfig.getVolume();
  }
  public ConfigProperty<Boolean> getEventNotifier() {
    return prisonConfig.getEventNotifier();
  }
  public ConfigProperty<Boolean> getaPlusVaultEvent() {
    return prisonConfig.getaPlusVaultEvent();
  }
  public ConfigProperty<Boolean> getaVaultEvent() {
    return prisonConfig.getaVaultEvent();
  }
  public ConfigProperty<Boolean> getBVaultEvent() {
    return prisonConfig.getBVaultEvent();
  }
  public ConfigProperty<Boolean> getCVaultEvent() {
    return prisonConfig.getCVaultEvent();
  }
  public ConfigProperty<Boolean> getaGangAreaEvent() {
    return prisonConfig.getaGangAreaEvent();
  }
  public ConfigProperty<Boolean> getaPlusGangAreaEvent() {
    return prisonConfig.getaPlusGangAreaEvent();
  }
  public ConfigProperty<Boolean> getRockerTorbenEvent() {
    return prisonConfig.getRockerTorbenEvent();
  }
  public ConfigProperty<Boolean> getGuardsDisabledVaultsEvent() {
    return prisonConfig.getGuardsDisabledVaultsEvent();
  }
  public ConfigProperty<Boolean> getStringCaughtEvent() {
    return prisonConfig.getStringCaughtEvent();
  }
  public ConfigProperty<Boolean> getBoLootEventEvent() {
    return prisonConfig.getBoLootEventEvent();
  }
  public ConfigProperty<Boolean> getHeadEvent() {
    return prisonConfig.getHeadEvent();
  }
  public ConfigProperty<Boolean> getGuardKillEvent() {
    return prisonConfig.getGuardKillEvent();
  }
  public ConfigProperty<Boolean> getBPlusVaultEvent() {
    return prisonConfig.getBPlusVaultEvent();
  }
  public ConfigProperty<Boolean> getBPlusGangAreaEvent() {
    return prisonConfig.getBPlusGangAreaEvent();
  }
  public ConfigProperty<Boolean> getBGangAreaEvent() {
    return prisonConfig.getBGangAreaEvent();
  }
  public ConfigProperty<Boolean> getBPvpChestEvent() {
    return prisonConfig.getBPvpChestEvent();
  }
  public ConfigProperty<Boolean> getFlipLostEvent() {
    return prisonConfig.getFlipLostEvent();
  }
  public ConfigProperty<Boolean> getFlipNewOfferEvent() {
    return prisonConfig.getFlipNewOfferEvent();
  }
  public ConfigProperty<Boolean> getFlipWinEvent() {
    return prisonConfig.getFlipWinEvent();
  }


  //Quests
  public ConfigProperty<Boolean> getQuestsEnabled() {
    return prisonConfig.getQuestsEnabled();
  }
  public ConfigProperty<Boolean> getDonvitoEnabled() {
    return prisonConfig.getDonvitoEnabled();
  }
  public ConfigProperty<Boolean> getGertvagtEnabled() {
    return prisonConfig.getGertvagtEnabled();
  }
  public ConfigProperty<Boolean> getFinnfiskerEnabled() {
    return prisonConfig.getFinnfiskerEnabled();
  }
  public ConfigProperty<Boolean> getPallevagtEnabled() {
    return prisonConfig.getPallevagtEnabled();
  }
  public ConfigProperty<Boolean> getMrXEnabled() {
    return prisonConfig.getMrXEnabled();
  }

  public ConfigProperty<Boolean> getAQuestEnabled() {
    return prisonConfig.getAQuestEnabled();
  }
  public ConfigProperty<Boolean> getBQuestEnabled() {
    return prisonConfig.getBQuestEnabled();
  }
}
