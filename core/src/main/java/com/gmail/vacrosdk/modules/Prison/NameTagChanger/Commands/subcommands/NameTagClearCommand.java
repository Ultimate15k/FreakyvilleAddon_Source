package com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.subcommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.NameTagPlayerManager;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class NameTagClearCommand extends SubCommand {

  private final NameTagPlayerManager playerManager;
  private final FreakyvilleAddon addon;

  public NameTagClearCommand(String prefix, NameTagPlayerManager playerManager,
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
      TextColor color = TextColor.color(addon.configuration().getNameTagMessageColor().get().get());
      addon.displayMessage(
          Component.translatable("NT.no_players")
              .color(color)
      );
      return;
    }
    playerManager.clear();
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getNameTags().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
