package com.gmail.vacrosdk.plugin;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.util.logging.Logging;

public class DiscordCommand extends Command {

  private final FreakyvilleAddon addon;

  public DiscordCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if(CheckIsModuleDisabled()) {
      return false;
    }
//    float XCoords = addon.labyAPI().minecraft().getClientPlayer().getPosX();
//    float YCoords = addon.labyAPI().minecraft().getClientPlayer().getPosY();
//    float ZCoords = addon.labyAPI().minecraft().getClientPlayer().getPosZ();
//    Logging.getLogger().info(String.format("X: %.2f, Y: %.2f, Z: %.2f", XCoords, YCoords, ZCoords));
    addon.displayMessage("§9Discord: §fhttps://discord.gg/Eg4ARCsQbD");
    return true;
  }

  private Boolean CheckIsModuleDisabled() {
    return addon.configuration().discordDisabled().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
