package com.gmail.vacrosdk.utils;

import static net.labymod.api.Laby.labyAPI;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.HouseIdentifier;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Sounds.NotificationSound;
import com.gmail.vacrosdk.utils.debug.DebugFunctions;
import net.labymod.api.Laby;
import net.labymod.api.client.chat.Title;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.notification.Notification;
import net.labymod.api.util.logging.Logging;

public class Utils {

  private final FreakyvilleAddon addon;

  public Utils(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  public static HouseIdentifier convertStringToIdentifier2(String stringIdentifier) {
    HouseIdentifier[] values = HouseIdentifier.values();
    HouseIdentifier Houseidentifier = null;
    for (HouseIdentifier value : values) {
      if (stringIdentifier.equalsIgnoreCase(value.getStringIdentifier())) {
        Houseidentifier = value;
      }
    }
    return Houseidentifier;
  }

  public void SendDebugMessage(String message) {
    String playername = addon.labyAPI().getName();
    if (DebugFunctions.isDebugMode()) {
      addon.displayMessage("§7§l[§6§lFV-Addon§7§l]:§f " + message);
      Logging.getLogger().debug(playername + ": " + message);
    }
  }

  public static void createNotification(String title, String text, Icon icon) {
    Notification.Builder builder = Notification.builder()
        .title(Component.text(title, NamedTextColor.GREEN))
        .text(Component.text(text, NamedTextColor.GREEN))
        .icon(icon);
//        .type(Type.ADVANCEMENT);
    labyAPI().notificationController().push(builder.build());
  }

  public static void playNotificationSound(NotificationSound sound, float volume, float pitch) {
    for (int i = 0; i < 5; i++) {
      Laby.labyAPI().minecraft().sounds().playSound(
          ResourceLocation.create("minecraft", sound.getSoundString()),
          volume,
          pitch);
    }
  }

  public static void playSound(NotificationSound sound, float volume, float pitch) {
    Laby.labyAPI().minecraft().sounds().playSound(
        ResourceLocation.create("minecraft", sound.getSoundString()),
        volume,
        pitch);

  }

  public static void showTitle(String title, String subtitle, int fadeInTicks, int stayTicks, int fadeOutTicks) {
    Laby.labyAPI().minecraft().showTitle(new Title(
        Component.text(""),
        Component.text(""),
        20,
        20,
        20));
    Laby.labyAPI().minecraft().clearTitle();
    Laby.labyAPI().minecraft().showTitle(new Title(
        Component.text(title),
        Component.text(subtitle),
        fadeInTicks,
        stayTicks,
        fadeOutTicks
    ));
  }

  public static void showTitle(String title, int fadeInTicks, int stayTicks, int fadeOutTicks) {
    showTitle(title, "", fadeInTicks, stayTicks, fadeOutTicks);
  }

  public static void showTitle(String title) {
    showTitle(title, "", 20, 60, 20);
  }

  public String getPlayerName() {
    return addon.labyAPI().getName();
  }

  public static void showTitle(String title, String subtitle) {
    showTitle(title, subtitle, 20, 60, 20);
  }
}
