package com.gmail.vacrosdk.modules.Prison.BetterTimers.Chests.Listener;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.client.entity.player.ClientPlayer;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

import static com.gmail.vacrosdk.utils.TimerFunctions.updatePlayerData;

public class ChestListener {

  private final FreakyvilleAddon addon;

  public ChestListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!isModuleDisabled()) {
      String text = event.chatMessage().getFormattedText();
      if(text.contains("§a§lGodt gået! Du åbnede kisten, skynd dig væk!")) {
        Utils utils = new Utils(addon);
        String playerName = addon.labyAPI().getName();
        String ClosesthotSpot = getClosestCoordSet();
        if(!ClosesthotSpot.equalsIgnoreCase("ingen")) {
          updatePlayerData(playerName,ClosesthotSpot, 0);
          utils.SendDebugMessage("Chest data saved for: " + ClosesthotSpot);
        }
      }
    }
  }

  public String getClosestCoordSet() {
    Utils utils = new Utils(addon);
    ClientPlayer p = addon.labyAPI().minecraft().getClientPlayer();

    double playerX = p.position().getX();
    double playerY = p.position().getY();
    double playerZ = p.position().getZ();

    utils.SendDebugMessage("Player coordinates: X=" + playerX + ", Y=" + playerY + ", Z=" + playerZ);

    double chest_TankStation = calculateDistanceSquared(playerX, playerY, playerZ, -27.500, 64.0, -496.500);
    double chest_MrX = calculateDistanceSquared(playerX, playerY, playerZ, 76.500, 64.0, -440.500);
    double chest_Tree = calculateDistanceSquared(playerX, playerY, playerZ, 79.500, 65.0, -538.500);
    double chest_SortPortal = calculateDistanceSquared(playerX, playerY, playerZ, -1680.500, 114.0, 84.500);
    double chest_Minen = calculateDistanceSquared(playerX, playerY, playerZ, 20.500, 66.0, -668.500);
    double chest_Fitness = calculateDistanceSquared(playerX, playerY, playerZ, 8.500, 66.0, -665.500);

    utils.SendDebugMessage("Distances:");
    utils.SendDebugMessage("chest_TankStation: " + chest_TankStation);
    utils.SendDebugMessage("chest_MrX: " + chest_MrX);
    utils.SendDebugMessage("chest_Tree: " + chest_Tree);
    utils.SendDebugMessage("chest_SortPortal: " + chest_SortPortal);
    utils.SendDebugMessage("chest_Minen: " + chest_Minen);
    utils.SendDebugMessage("chest_Fitness: " + chest_Fitness);

    double minDistanceSquared = Math.min(chest_TankStation, Math.min(chest_MrX, Math.min(chest_Tree, Math.min(chest_SortPortal, Math.min(chest_Minen, chest_Fitness)))));

    if (minDistanceSquared == chest_TankStation) {
      utils.SendDebugMessage("Returning chest_TankStation");
      return "chest_TankStation";
    } else if (minDistanceSquared == chest_MrX) {
      utils.SendDebugMessage("Returning chest_MrX");
      return "chest_MrX";
    } else if (minDistanceSquared == chest_Tree) {
      utils.SendDebugMessage("Returning chest_Tree");
      return "chest_Tree";
    } else if (minDistanceSquared == chest_SortPortal) {
      utils.SendDebugMessage("Returning chest_SortPortal");
      return "chest_SortPortal";
    } else if (minDistanceSquared == chest_Minen) {
      utils.SendDebugMessage("Returning chest_Minen");
      return "chest_Minen";
    } else if (minDistanceSquared == chest_Fitness) {
      utils.SendDebugMessage("Returning chest_Fitness");
      return "chest_Fitness";
    } else {
      utils.SendDebugMessage("No closest chest found, returning Ingen");
      return "Ingen";
    }
  }


  private double calculateDistanceSquared(double x1, double y1, double z1, double x2, double y2, double z2) {
    double deltaX = x2 - x1;
    double deltaY = y2 - y1;
    double deltaZ = z2 - z1;
    return deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
  }

  private boolean isModuleDisabled() {
    return addon.configuration().getChestTimer().get().equals(false) ||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getPrisonEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }

}
