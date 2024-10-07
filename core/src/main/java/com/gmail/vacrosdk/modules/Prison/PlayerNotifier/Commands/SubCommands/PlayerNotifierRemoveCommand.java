package com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class PlayerNotifierRemoveCommand extends SubCommand {

  private final PlayerNotifierManager playerManager;
  private final FreakyvilleAddon addon;

  public PlayerNotifierRemoveCommand(String prefix, PlayerNotifierManager playerManager,
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
      TextColor textColor = TextColor.color(
          addon.configuration().getPlayerNotifierColor().get().get());
      addon.displayMessage(
          Component.text("/jn remove <playerName>").color(textColor));
      return true;
    }

    String[] newArguments = {arguments[0]};
    doRemove(newArguments);

    return true;
  }

  private void doRemove(String[] arguments) {
    TextColor textColor = TextColor.color(addon.configuration().getPlayerNotifierColor().get().get());
    if (!(arguments.length == 1)) {
      this.displayMessage(Component.text("/pn <playerName>").color(textColor));
      return;
    }
    playerManager.remove(arguments[0], textColor);
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getPlayerNotifier().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
