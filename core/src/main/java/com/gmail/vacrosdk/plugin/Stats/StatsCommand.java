package com.gmail.vacrosdk.plugin.Stats;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;

import static com.gmail.vacrosdk.plugin.Stats.StatsFunctions.*;
import static com.gmail.vacrosdk.utils.TimerFunctions.*;

public class StatsCommand extends Command {

  private final FreakyvilleAddon addon;

  public StatsCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if(isModuleDisabled()) {
      return false;
    }
    if(arguments.length == 0) {
      String playerName = addon.labyAPI().getName();
      boolean exists = playerFileExists(playerName);
      if (exists){
        addon.displayMessage("§6§m------§aStats - [§6" + playerName + "§a]§6§m------");
        addon.displayMessage("§aHeads:");
        addon.displayMessage(" §7• §aVV: §6" + getPlayerData(playerName,"stats_heads_vv"));
        addon.displayMessage(" §7• §aKit Head: §6" + getPlayerData(playerName,"stats_heads_kit"));
      } else {
        addon.displayMessage("§cDu har ingen stats");
      }
    } else {
      boolean exists = playerFileExists(arguments[1]);
      if (exists){
        addon.displayMessage("§6§m------§aStats - [§6" + arguments[1] + "§a]§6§m------");
        addon.displayMessage("§aHeads:");
        addon.displayMessage(" §7• §aVV: §6" + getPlayerData(arguments[1],"stats_heads_vv"));
        addon.displayMessage(" §7• §aKit Head: §6" + getPlayerData(arguments[1],"stats_heads_kit"));
      } else {
        addon.displayMessage("§c" + arguments[1] + " har ingen stats");
      }
    }
    return true;
  }

  private boolean isModuleDisabled() {
    return addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getPrisonEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }

}
