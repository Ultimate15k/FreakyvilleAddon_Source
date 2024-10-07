package com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands.PlayerNotifierAddCommand;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands.PlayerNotifierClearCommand;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands.PlayerNotifierListCommand;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands.PlayerNotifierRemoveCommand;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class PlayerNotifierCommand extends Command {

  private final FreakyvilleAddon addon;

  public PlayerNotifierCommand(String prefix, FreakyvilleAddon addon,
      PlayerNotifierManager playerManager) {
    super(prefix);
    this.addon = addon;
    this.withSubCommand(new PlayerNotifierAddCommand("add", playerManager, addon));
    this.withSubCommand(new PlayerNotifierClearCommand("clear", playerManager, addon));
    this.withSubCommand(new PlayerNotifierRemoveCommand("remove", playerManager, addon));
    this.withSubCommand(new PlayerNotifierListCommand("players", playerManager, addon));
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!addon.isOnlineOnFreakyville()) {
      return false;
    }
    if (moduleIsDisabled()) {
      return true;
    }
    if (prefix.equalsIgnoreCase("pn")) {
      if (arguments.length == 0) {
        TextColor textColor = TextColor.color(addon.configuration().getPlayerNotifierColor().get().get());
        addon.displayMessage(Component.text("/pn <add/remove/players/clear> <playerName>").color(textColor));
      }
    }
    return true;
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getPlayerNotifier().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
