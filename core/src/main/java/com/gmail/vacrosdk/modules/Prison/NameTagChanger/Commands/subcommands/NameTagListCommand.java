package com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.subcommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.NameTagPlayerManager;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class NameTagListCommand extends SubCommand {

  private final NameTagPlayerManager playerManager;
  private final FreakyvilleAddon addon;

  public NameTagListCommand(String prefix, NameTagPlayerManager playerManager,
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
    doList();

    return true;
  }

  private void doList() {
    TextColor color = TextColor.color(addon.configuration().getNameTagMessageColor().get().get());
    if (playerManager.isEmpty()) {
      addon.displayMessage(
          Component.translatable("NT.no_players")
              .color(color)
      );
      return;
    }
    playerManager.print(color);
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getNameTags().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
