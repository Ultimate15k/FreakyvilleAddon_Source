package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.color.ColorPickerWidget.ColorPickerSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ParentSwitch;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.util.Color;

public class PlayerNotifierSubSettings extends Config {

  @ParentSwitch
  @SwitchSetting
  @SpriteSlot(y = 2, x = 3)
  private final ConfigProperty<Boolean> playerNotifier = new ConfigProperty<>(true);

  @ColorPickerSetting
  @SpriteSlot(y = 1, x = 1)
  private final ConfigProperty<Color> playerNotifierColor = new ConfigProperty<>(Color.ofRGB(9, 58, 142, 70));

  @SwitchSetting
  @SpriteSlot(y = 1, x = 6)
  private final ConfigProperty<Boolean> joinNotifier = new ConfigProperty<>(true);

  @SwitchSetting
  @SpriteSlot(y = 1, x = 7)
  private final ConfigProperty<Boolean> leaveNotifier = new ConfigProperty<>(true);


  public ConfigProperty<Boolean> getPlayerNotifier() {
    return playerNotifier;
  }

  public ConfigProperty<Color> getPlayerNotifierColor() {
    return playerNotifierColor;
  }

  public ConfigProperty<Boolean> getJoinNotifier() {
    return joinNotifier;
  }

  public ConfigProperty<Boolean> getLeaveNotifier() {
    return leaveNotifier;
  }

}
