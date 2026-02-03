package com.gmail.vacrosdk.modules.Prison.BetterTimers.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpots;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class GlobalTimersCommand extends Command {

  private final FreakyvilleAddon addon;

  public GlobalTimersCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (moduleIsDisabled() || playerIsOnGuard(addon)) return false;

    TextColor textColor = TextColor.color(addon.configuration().getMainTimerColor().get().get());
    addon.displayMessage(Component.translatable("Prison.BetterTimers.global_header").color(textColor));
    HotSpots.A_VAULT.getHotSpot().printGlobal(addon);
    HotSpots.APLUS_BANK.getHotSpot().printGlobal(addon);
    HotSpots.A_GANGAREA.getHotSpot().printGlobal(addon);
    HotSpots.APLUS_GANGAREA.getHotSpot().printGlobal(addon);

    HotSpots.B_VAULT.getHotSpot().printGlobal(addon);
    HotSpots.BPLUS_VAULT.getHotSpot().printGlobal(addon);
    HotSpots.B_GANG_AREA.getHotSpot().printGlobal(addon);
    HotSpots.BPLUS_GANGAREA.getHotSpot().printGlobal(addon);
    HotSpots.B_PVP_CHEST.getHotSpot().printGlobal(addon);

    HotSpots.CM_VAULT.getHotSpot().printGlobal(addon);
    HotSpots.C_VAULT.getHotSpot().printGlobal(addon);
    HotSpots.C_GANG_AREA.getHotSpot().printGlobal(addon);

    HotSpots.NEW_GANG.getHotSpot().printGlobal(addon);

    printOthers();
    return true;
  }

  private void printOthers() {
    if(!(HotSpots.A_ROCKER_TORBEN.getHotSpot().getClockSetWhenAbleToBeRobbed() == null)) {
      HotSpots.A_ROCKER_TORBEN.getHotSpot().printGlobal(addon);
    }
    if(!(HotSpots.A_DISABLE_VAULTS.getHotSpot().getClockSetWhenAbleToBeRobbed() == null)) {
      HotSpots.A_DISABLE_VAULTS.getHotSpot().printGlobal(addon);
    }
  }

  private boolean playerIsOnGuard(FreakyvilleAddon addon) {
    return addon.IsPlayerOnGuard();
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getBetterTimers().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getPrisonEnabled().get().equals(false);
  }

}
