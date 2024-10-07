package com.gmail.vacrosdk.plugin.KitsTimers.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;

import static com.gmail.vacrosdk.utils.TimerFunctions.formatPlayerTime;
import static com.gmail.vacrosdk.utils.TimerFunctions.getAllPlayerNames;
import static com.gmail.vacrosdk.utils.TimerFunctions.getPlayerData;
import static com.gmail.vacrosdk.utils.TimerFunctions.isDateOver24HoursAgo;
import static com.gmail.vacrosdk.utils.TimerFunctions.playerExists;

public class KitCommand extends Command {

  private final FreakyvilleAddon addon;

  public KitCommand(FreakyvilleAddon addon) {
    super("kits");

    this.addon = addon;
  }

  @Override
  public boolean execute(String strings, String[] arguments) {
    if (!isModuleDisabled()) {
      String playerName = addon.labyAPI().getName();
      boolean exists = playerExists(playerName,"kithead_date_time");
      System.out.println(arguments.length);
      if (exists && arguments.length == 0) {

        addon.displayMessage("§6§m------§aKit Timer - [§6" + playerName + "§a]§6§m------");
        if (isDateOver24HoursAgo(playerName,"kithead_date_time")) {
          addon.displayMessage("§aKit head:§6 kan tages");
        } else {
          String playerData = getPlayerData(playerName,"kithead_date_time");
          String formattedTime = formatPlayerTime(playerData);
          addon.displayMessage("§aKit head:§6 " + formattedTime);
        }
      } else if (!exists && arguments.length == 0) {
        String[] playerNames = getAllPlayerNames();
        addon.displayMessage("§6§m------§aMulige personer:§6§m------");
        for (String name : playerNames) {
          if(!isDateOver24HoursAgo(name,"kithead_date_time")) {
            String playerData = getPlayerData(name,"kithead_date_time");
            String formattedTime = formatPlayerTime(playerData);
            addon.displayMessage("§a[§6" + name + "§a] §7- §aKit head: §6" + formattedTime);
          } else {
            addon.displayMessage("§a[§6" + name + "§a] §7- §aKit head: §6kan tages");
          }
        }
      } else if (arguments.length == 1) {
        if (arguments[0].equalsIgnoreCase("liste")) {
          String[] playerNames = getAllPlayerNames();
          addon.displayMessage("§6§m------§aMulige personer:§6§m------");
          for (String name : playerNames) {
            if(!isDateOver24HoursAgo(name,"kithead_date_time")) {
              String playerData = getPlayerData(name,"kithead_date_time");
              String formattedTime = formatPlayerTime(playerData);
              addon.displayMessage("§a[§6" + name + "§a] §7- §aKit head: §6" + formattedTime);
            } else {
              addon.displayMessage("§a[§6" + name + "§a] §7- §aKit head: §6kan tages");
            }
          }
        } else {
          boolean existsPart2 = playerExists(arguments[0],"kithead_date_time");
          if (existsPart2) {
            addon.displayMessage("§6§m------§aKit Timer - [§6" + arguments[0] + "§a]§6§m------");
            System.out.println("....... " + isDateOver24HoursAgo(arguments[0],"kithead_date_time"));
            if (isDateOver24HoursAgo(arguments[0], "kithead_date_time")) {
              addon.displayMessage("§aKit head:§6 kan tages");
            } else {
              String playerData = getPlayerData(arguments[0], "kithead_date_time");
              String formattedTime = formatPlayerTime(playerData);
              addon.displayMessage("§aKit head:§6 " + formattedTime);
            }
          } else {
            addon.displayMessage("§cDenne person findes ikke!");
          }
        }
      }
    } else {
      addon.displayMessage("§cBrug:");
      addon.displayMessage("§c/kits [Person/Liste]:");
    }
    return true;
  }

  private boolean isModuleDisabled() {
    return addon.configuration().getKitHeadTimer().get().equals(false) ||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getPrisonEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }
}
