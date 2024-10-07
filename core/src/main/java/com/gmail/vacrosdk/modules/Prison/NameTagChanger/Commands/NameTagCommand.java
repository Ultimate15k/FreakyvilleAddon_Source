package com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.subcommands.NameTagAddCommand;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.subcommands.NameTagClearCommand;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.subcommands.NameTagListCommand;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.subcommands.NameTagRemoveCommand;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.NameTagPlayerManager;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class NameTagCommand extends Command {

  private final FreakyvilleAddon addon;

  public NameTagCommand(String prefix, FreakyvilleAddon addon, NameTagPlayerManager nameTagPlayerManager) {
    super(prefix);
    this.addon = addon;
    this.withSubCommand(new NameTagAddCommand("add", nameTagPlayerManager, addon));
    this.withSubCommand(new NameTagClearCommand("clear", nameTagPlayerManager, addon));
    this.withSubCommand(new NameTagRemoveCommand("remove", nameTagPlayerManager, addon));
    this.withSubCommand(new NameTagListCommand("players", nameTagPlayerManager, addon));
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!addon.isOnlineOnFreakyville()) {
      return false;
    }
    if(moduleIsDisabled()) {
      return true;
    }
    if(prefix.equalsIgnoreCase("nt")) {
      if(arguments.length == 0) {
        TextColor color = TextColor.color(addon.configuration().getNameTagMessageColor().get().get());
        addon.displayMessage(Component.text("/nt <add/remove/players/clear> <playerName>").color(color));
      }
    }
    return true;
  }
  private boolean moduleIsDisabled() {
    return addon.configuration().getNameTags().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
