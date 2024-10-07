package com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.SubCommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class PlayerNotifierListCommand extends SubCommand {

  private final PlayerNotifierManager playerManager;
  private final FreakyvilleAddon addon;

  public PlayerNotifierListCommand(String prefix, PlayerNotifierManager playerManager,
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
    TextColor textColor = TextColor.color(addon.configuration().getPlayerNotifierColor().get().get());
    if (playerManager.isEmpty()) {
      this.displayMessage(Component.text("Du har ikke tilføjet nogle spillere.").color(textColor));
      return;
    }
    playerManager.print(textColor);
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getPlayerNotifier().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
