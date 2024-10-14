package com.gmail.vacrosdk.config;

import com.gmail.vacrosdk.config.prisonsubsettings.BetterNameTagSubSettings;
import com.gmail.vacrosdk.config.prisonsubsettings.BettercellsSubSettings;
import com.gmail.vacrosdk.config.prisonsubsettings.BettertimersSubSettings;
import com.gmail.vacrosdk.config.prisonsubsettings.EventNotifierSubSettings;
import com.gmail.vacrosdk.config.prisonsubsettings.PlayerNotifierSubSettings;
import com.gmail.vacrosdk.config.prisonsubsettings.QuestSubSettings;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Sounds.NotificationSound;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;
import net.labymod.api.util.Color;

public class PrisonConfig extends Config {

  @ShowSettingInParent
  @SwitchSetting
  private final ConfigProperty<Boolean> prisonEnabled = new ConfigProperty<>(true);

  @SettingSection("BetterCells")
  @SpriteSlot(x = 1)
  private BettercellsSubSettings bettercellsSubSettings = new BettercellsSubSettings();

  @SettingSection("PlayerNotifierSettings")
  @SpriteSlot(y = 2, x = 3)
  private PlayerNotifierSubSettings playerNotifierSubSettings = new PlayerNotifierSubSettings();

  @SettingSection("BetterTimers")
  @SpriteSlot(y = 3, x = 6)
  private BettertimersSubSettings bettertimersSubSettings = new BettertimersSubSettings();

  @SettingSection("BetterNameTags")
  @SpriteSlot(y = 1, x = 3)
  private BetterNameTagSubSettings nameTagsSubSettings = new BetterNameTagSubSettings();

  @SettingSection("EventNotifier")
  @SpriteSlot(x = 5)
  private EventNotifierSubSettings eventNotifierSubSettings = new EventNotifierSubSettings();

  @SettingSection("Quests")
  @SpriteSlot(y = 5)
  private QuestSubSettings questSubSettings = new QuestSubSettings();



  public ConfigProperty<Boolean> getPrisonEnabled() {
    return prisonEnabled;
  }

  public ConfigProperty<Boolean> getBetterCells() {
    return bettercellsSubSettings.getBetterCells();
  }

  public ConfigProperty<Boolean> getBetterCellsLocation() {
    return bettercellsSubSettings.getBetterCellsLocation();
  }

  //PlayerNotifier
  public ConfigProperty<Boolean> getPlayerNotifier() {
    return playerNotifierSubSettings.getPlayerNotifier();
  }
  public ConfigProperty<Boolean> getJoinNotifier() {
    return playerNotifierSubSettings.getJoinNotifier();
  }
  public ConfigProperty<Boolean> getLeaveNotifier() {
    return playerNotifierSubSettings.getLeaveNotifier();
  }
  public ConfigProperty<Color> getPlayerNotifierColor() {
    return playerNotifierSubSettings.getPlayerNotifierColor();
  }

  //BetterTimers
  public ConfigProperty<Boolean> getKitHeadTimer() {
    return bettertimersSubSettings.getKitHeadTimer();
  }
  public ConfigProperty<Boolean> getChestTimer() {
    return bettertimersSubSettings.getChestTimer();
  }
  public ConfigProperty<Boolean> getBetterTimers() {
    return bettertimersSubSettings.getBetterTimers();
  }
  public ConfigProperty<Boolean> getBetterTimersMessage() {
    return bettertimersSubSettings.getBetterTimersMessage();
  }
  public ConfigProperty<Integer> getTimerNotificationSlider() {
    return bettertimersSubSettings.getTimerNotificationSlider();
  }
  public ConfigProperty<Boolean> getTimerNotification() {
    return bettertimersSubSettings.getTimerNotification();
  }
  public ConfigProperty<Color> getKnownTimerColor() {
    return bettertimersSubSettings.getKnownTimerColor();
  }
  public ConfigProperty<Color> getUnknownTimerColor() {
    return bettertimersSubSettings.getUnknownTimerColor();
  }
  public ConfigProperty<Color> getMainTimerColor() {
    return bettertimersSubSettings.getMainTimerColor();
  }

  //BetterNameTags
  public ConfigProperty<Boolean> getNameTags() {
    return nameTagsSubSettings.getNameTags();
  }

  public ConfigProperty<Color> getNameTagColor() {
    return nameTagsSubSettings.getNameTagColor();
  }

  public ConfigProperty<Boolean> getBoldFont() {
    return nameTagsSubSettings.getBoldFont();
  }

  public ConfigProperty<Color> getNameTagMessageColor() {
    return nameTagsSubSettings.getNameTagMessageColor();
  }
  public ConfigProperty<Boolean> getItalicFont() {
    return nameTagsSubSettings.getItalic();
  }

  public ConfigProperty<Boolean> getMagicFont() {
    return nameTagsSubSettings.getMagic();
  }

  public ConfigProperty<Boolean> getStrikeFont() {
    return nameTagsSubSettings.getStrike();
  }

  public ConfigProperty<Boolean> getUnderlineFont() {
    return nameTagsSubSettings.getUnderline();
  }

  //EventNotifier
  public ConfigProperty<Boolean> getSoundEnabled() {
    return eventNotifierSubSettings.getSoundEnabled();
  }

  public ConfigProperty<NotificationSound> getNotifierSound() {
    return eventNotifierSubSettings.getNotifierSound();
  }

  public ConfigProperty<Float> getVolume() {
    return eventNotifierSubSettings.getVolume();
  }

  public ConfigProperty<Boolean> getEventNotifier() {
    return eventNotifierSubSettings.getEventNotifier();
  }

  public ConfigProperty<Boolean> getaPlusVaultEvent() {
    return eventNotifierSubSettings.getaPlusVaultEvent();
  }

  public ConfigProperty<Boolean> getaVaultEvent() {
    return eventNotifierSubSettings.getaVaultEvent();
  }

  public ConfigProperty<Boolean> getBVaultEvent() {
    return eventNotifierSubSettings.getBVaultEvent();
  }

  public ConfigProperty<Boolean> getCVaultEvent() {
    return eventNotifierSubSettings.getCVaultEvent();
  }

  public ConfigProperty<Boolean> getaGangAreaEvent() {
    return eventNotifierSubSettings.getaGangAreaEvent();
  }

  public ConfigProperty<Boolean> getaPlusGangAreaEvent() {
    return eventNotifierSubSettings.getaPlusGangAreaEvent();
  }

  public ConfigProperty<Boolean> getRockerTorbenEvent() {
    return eventNotifierSubSettings.getRockerTorbenEvent();
  }

  public ConfigProperty<Boolean> getGuardsDisabledVaultsEvent() {
    return eventNotifierSubSettings.getGuardsDisabledVaultsEvent();
  }

  public ConfigProperty<Boolean> getStringCaughtEvent() {
    return eventNotifierSubSettings.getStringCaughtEvent();
  }

  public ConfigProperty<Boolean> getBoLootEventEvent() {
    return eventNotifierSubSettings.getBoLootEventEvent();
  }

  public ConfigProperty<Boolean> getHeadEvent() {
    return eventNotifierSubSettings.getHeadEvent();
  }

  public ConfigProperty<Boolean> getGuardKillEvent() {
    return eventNotifierSubSettings.getGuardKillEvent();
  }

  public ConfigProperty<Boolean> getBPlusVaultEvent() {
    return eventNotifierSubSettings.getBPlusVaultEvent();
  }

  public ConfigProperty<Boolean> getBPlusGangAreaEvent() {
    return eventNotifierSubSettings.getBPlusGangAreaEvent();
  }

  public ConfigProperty<Boolean> getBGangAreaEvent() {
    return eventNotifierSubSettings.getBGangAreaEvent();
  }

  public ConfigProperty<Boolean> getBPvpChestEvent() {
    return eventNotifierSubSettings.getBPvpChestEvent();
  }

  public ConfigProperty<Boolean> getFlipLostEvent() {
    return eventNotifierSubSettings.getFlipLostEvent();
  }

  public ConfigProperty<Boolean> getFlipNewOfferEvent() {
    return eventNotifierSubSettings.getFlipNewOfferEvent();
  }

  public ConfigProperty<Boolean> getFlipWinEvent() {
    return eventNotifierSubSettings.getFlipWinEvent();
  }

  //Quests
  public ConfigProperty<Boolean> getQuestsEnabled() {
    return questSubSettings.getQuestsEnabled();
  }
  public ConfigProperty<Boolean> getDonvitoEnabled() {
    return questSubSettings.getDonvitoEnabled();
  }
  public ConfigProperty<Boolean> getGertvagtEnabled() {
    return questSubSettings.getGertvagtEnabled();
  }
  public ConfigProperty<Boolean> getFinnfiskerEnabled() {
    return questSubSettings.getFinnfiskerEnabled();
  }
  public ConfigProperty<Boolean> getPallevagtEnabled() {
    return questSubSettings.getPallevagtEnabled();
  }
  public ConfigProperty<Boolean> getMrXEnabled() {
    return questSubSettings.getMrXEnabled();
  }

  public ConfigProperty<Boolean> getAQuestEnabled() {
    return questSubSettings.getAQuestEnabled();
  }

  public ConfigProperty<Boolean> getBQuestEnabled() {
    return questSubSettings.getBQuestEnabled();
  }

}
