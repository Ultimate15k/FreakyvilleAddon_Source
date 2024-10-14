package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.util.Color;

public class BetterNameTagSubSettings extends Config {

  @ShowSettingInParent
  @SwitchSetting
  private final ConfigProperty<Boolean> nameTags = new ConfigProperty<>(true);
  @SpriteSlot(y = 1)
  private BetterNameTagsColorSettings betterNameTagsColorSettings = new BetterNameTagsColorSettings();
  @SpriteSlot(y = 1, x = 4)
  private BetterNameTagsFontSettings betterNameTagsFontSettings = new BetterNameTagsFontSettings();

  public ConfigProperty<Boolean> getNameTags() {
    return nameTags;
  }

  public ConfigProperty<Color> getNameTagColor() {
    return betterNameTagsColorSettings.getNameTagColor();
  }

  public ConfigProperty<Boolean> getBoldFont() {
    return betterNameTagsFontSettings.getBoldFont();
  }

  public ConfigProperty<Color> getNameTagMessageColor() {
    return betterNameTagsColorSettings.getNameTagMessageColor();
  }

  public ConfigProperty<Boolean> getItalic() {
    return betterNameTagsFontSettings.getItalic();
  }

  public ConfigProperty<Boolean> getMagic() {
    return betterNameTagsFontSettings.getMagic();
  }

  public ConfigProperty<Boolean> getStrike() {
    return betterNameTagsFontSettings.getStrike();
  }

  public ConfigProperty<Boolean> getUnderline() {
    return betterNameTagsFontSettings.getUnderline();
  }

}
