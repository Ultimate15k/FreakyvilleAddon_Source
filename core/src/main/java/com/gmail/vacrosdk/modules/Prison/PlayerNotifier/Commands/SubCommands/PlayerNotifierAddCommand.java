package com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class PlayerNotifierAddCommand extends SubCommand {

  private final PlayerNotifierManager playerManager;
  private final FreakyvilleAddon addon;

  public PlayerNotifierAddCommand(String prefix, PlayerNotifierManager playerManager,
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
    TextColor textColor = TextColor.color(addon.configuration().getPlayerNotifierColor().get().get());
    if (arguments.length == 0) {
      addon.displayMessage(
          Component.text("/pn add <playerName>").color(textColor));
      return true;
    }
    String[] newArguments = {arguments[0]};
    doAdd(newArguments, textColor);

    return true;
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getPlayerNotifier().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private void doAdd(String[] arguments, TextColor textColor) {
    if (!(arguments.length == 1)) {
      this.displayMessage(Component.text("/pn <playerName>").color(textColor));
      return;
    }
    playerManager.add(arguments[0], textColor);
  }
}
