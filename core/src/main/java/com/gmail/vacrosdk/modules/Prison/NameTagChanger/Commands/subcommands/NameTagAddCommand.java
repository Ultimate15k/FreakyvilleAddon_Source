package com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.subcommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.NameTagPlayerManager;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class NameTagAddCommand extends SubCommand {

  private final NameTagPlayerManager playerManager;
  private final FreakyvilleAddon addon;

  public NameTagAddCommand(String prefix, NameTagPlayerManager playerManager,
      FreakyvilleAddon addon) {
    super(prefix);
    this.playerManager = playerManager;
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (moduleIsDisabled()) {
      return true;
    }
    if (arguments.length == 0) {
      TextColor color = TextColor.color(addon.configuration().getNameTagMessageColor().get().get());
      addon.displayMessage(Component.text("/nt add <playerName>").color(color));
      return true;
    }
    String[] newArguments = {arguments[0]};
    doAdd(newArguments);

    return true;
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getNameTags().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private void doAdd(String[] arguments) {
    TextColor color = TextColor.color(addon.configuration().getNameTagMessageColor().get().get());
    if (!(arguments.length == 1)) {
      this.displayMessage(Component.text("/nt <playerName>").color(color));
      return;
    }
    playerManager.add(arguments[0], color);
  }
}
