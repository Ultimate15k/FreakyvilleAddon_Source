package com.gmail.vacrosdk.plugin;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.utils.VersionChecker;
import net.labymod.api.client.chat.command.Command;

public class VersionCommand extends Command {

  private final FreakyvilleAddon addon;

  public VersionCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if(moduleIsDisabled()) {
      return false;
    }
    addon.displayMessage("§aVersion: §7(" + addon.addonInfo().getVersion() + ")");
    VersionChecker version = new VersionChecker(addon);
    version.checkVersion();
    return true;
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().enabled().get().equals(false);
  }
}
