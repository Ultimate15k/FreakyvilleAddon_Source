package com.gmail.vacrosdk.config.prisonsubsettings;

import net.labymod.api.Laby;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.screen.widget.widgets.input.ButtonWidget.ButtonSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.ShowSettingInParent;
import net.labymod.api.configuration.loader.annotation.SpriteSlot;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.notification.Notification;
import net.labymod.api.util.MethodOrder;

public class BettercellsSubSettings extends Config {

  @ShowSettingInParent
  @SwitchSetting
  private final ConfigProperty<Boolean> getBetterCells = new ConfigProperty<>(true);

  @SwitchSetting
  private final ConfigProperty<Boolean> getBetterCellsLocation = new ConfigProperty<>(true);

  @MethodOrder(after = "getBetterCellsLocation")
  @SpriteSlot(x = 6)
  @ButtonSetting
  public void print() {
    Notification.Builder builder = Notification.builder()
        .title(Component.text("INFO"))
        .text(Component.text("Geninlæser celler"));
    Laby.labyAPI().notificationController().push(builder.build());
  }

  public ConfigProperty<Boolean> getBetterCells() {
    return getBetterCells;
  }

  public ConfigProperty<Boolean> getBetterCellsLocation() {
    return getBetterCellsLocation;
  }


}
