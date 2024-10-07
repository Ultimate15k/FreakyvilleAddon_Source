package com.gmail.vacrosdk.utils.debug;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;

public class DebugCommand extends Command {

  private final FreakyvilleAddon addon;

  public DebugCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] strings) {
    DebugFunctions.toggleDebugMode();

    boolean debugMode = DebugFunctions.isDebugMode();
    addon.displayMessage("§7§l[§6§lAddon-Debug§7§l]:§f " + debugMode);

    return true;
  }
}
