package com.gmail.vacrosdk.modules.Prison.BetterTimers.Chests.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.entity.player.ClientPlayer;
import static com.gmail.vacrosdk.utils.TimerFunctions.*;

public class ChestCommand extends Command {

  private final FreakyvilleAddon addon;

  public ChestCommand(FreakyvilleAddon addon) {
    super("kister");
    this.addon = addon;
  }

  @Override
  public boolean execute(String strings, String[] arguments) {
    if (isModuleDisabled()) {
      return false;
    }

    addon.displayMessage("§3★§f✩§3★ §3§lKister ★§f✩§3★");
//    String closestHotSpot = getClosestCoordSet();
    String playerName = addon.labyAPI().getName();

    if (!playerFileExists(playerName)) {
      addon.displayMessage("§6Ingen data");
      return true;
    }

    String[] chestNames = {"chest_TankStation", "chest_MrX", "chest_Tree", "chest_SortPortal", "chest_Minen", "chest_Fitness"};

    for (String chest : chestNames) {
      String displayName = chest.replaceFirst("chest_", "");
      String time = calculateTime(playerName, chest);
      if (time != null && !time.equalsIgnoreCase("Ingen Data")) {
        addon.displayMessage("§a" + displayName + ": §6" + time);
      } else {
        addon.displayMessage("§a" + displayName + ": §6Ingen data");
      }
    }

    return true;
  }

  private String getClosestCoordSet() {
    Utils utils = new Utils(addon);
    ClientPlayer player = addon.labyAPI().minecraft().getClientPlayer();

    double playerX = player.getPosX();
    double playerY = player.getPosY();
    double playerZ = player.getPosZ();

    utils.SendDebugMessage("Player coordinates: X=" + playerX + ", Y=" + playerY + ", Z=" + playerZ);

    double[] distances = {
        calculateDistance(-27.500, 64.0, -496.500),
        calculateDistance(76.500, 64.0, -440.500),
        calculateDistance(79.500, 65.0, -538.500),
        calculateDistance(-1680.500, 114.0, 84.500),
        calculateDistance(20.500, 66.0, -668.500),
        calculateDistance(8.500, 66.0, -665.500)
    };

    String[] locations = {
        "chest_TankStation",
        "chest_MrX",
        "chest_Tree",
        "chest_SortPortal",
        "chest_Minen",
        "chest_Fitness"
    };

    double minDistance = Double.MAX_VALUE;
    String closestLocation = "Ingen";

    for (int i = 0; i < distances.length; i++) {
      utils.SendDebugMessage(locations[i] + ": " + distances[i]);
      if (distances[i] < minDistance) {
        minDistance = distances[i];
        closestLocation = locations[i];
      }
    }

    utils.SendDebugMessage("Returning " + closestLocation);
    return closestLocation;
  }

  private double calculateDistance(double x, double y, double z) {
    ClientPlayer player = addon.labyAPI().minecraft().getClientPlayer();
    double playerX = player.getPosX();
    double playerY = player.getPosY();
    double playerZ = player.getPosZ();

    return Math.sqrt(Math.pow(playerX - x, 2) + Math.pow(playerY - y, 2) + Math.pow(playerZ - z, 2));
  }

  private boolean isModuleDisabled() {
    return !addon.configuration().getChestTimer().get() ||
        !addon.configuration().enabled().get() ||
        !addon.configuration().getPrisonEnabled().get()||
        !addon.configuration().getHasfileAccess().get();
  }
}