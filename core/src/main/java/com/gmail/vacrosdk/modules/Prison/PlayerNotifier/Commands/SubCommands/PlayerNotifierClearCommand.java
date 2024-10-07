package com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class PlayerNotifierClearCommand extends SubCommand {

  private final PlayerNotifierManager playerManager;
  private final FreakyvilleAddon addon;

  public PlayerNotifierClearCommand(String prefix, PlayerNotifierManager playerManager,
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
      return true;
    }
    if (arguments[0].equalsIgnoreCase("clear")) {
      doClear();
    }

    return true;
  }

  private void doClear() {
    if (playerManager.isEmpty()) {
      TextColor textColor = TextColor.color(addon.configuration().getPlayerNotifierColor().get().get());
      addon.displayMessage(Component.text("Der er ikke nogle spillere tilføjet til Player Notifier")
          .color(textColor));
      return;
    }
    playerManager.clear();
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getPlayerNotifier().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
