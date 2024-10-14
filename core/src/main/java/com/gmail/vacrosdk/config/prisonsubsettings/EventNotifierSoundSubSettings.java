package com.gmail.vacrosdk.config.prisonsubsettings;

import com.gmail.vacrosdk.modules.Prison.EventNotifier.Sounds.NotificationSound;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.dropdown.DropdownWidget.DropdownSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;

public class EventNotifierSoundSubSettings extends Config {

  @SwitchSetting
  @SettingRequires("eventNotifier")
  @SpriteSlot(y = 2, x = 5)
  private final ConfigProperty<Boolean> soundEnabled = new ConfigProperty<>(false);

  @DropdownSetting
  @SettingRequires("soundEnabled")
  @SpriteSlot(y = 2, x = 6)
  private final ConfigProperty<NotificationSound> notifierSound = new ConfigProperty<>(NotificationSound.NOTE_PLING);

  @SliderSetting(min = 0, max = 100)
  @SettingRequires("soundEnabled")
  @SpriteSlot(y = 2, x = 7)
  private final ConfigProperty<Float> volume = new ConfigProperty<>(50F);


  public ConfigProperty<Boolean> getSoundEnabled() {
    return soundEnabled;
  }

  public ConfigProperty<NotificationSound> getNotifierSound() {
    return notifierSound;
  }

  public ConfigProperty<Float> getVolume() {
    return volume;
  }
}
