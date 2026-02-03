package com.gmail.vacrosdk.modules.Prison.BetterTimers.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpots;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class PersonalTimersCommand extends Command {

  private final FreakyvilleAddon addon;

  public PersonalTimersCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if(moduleIsDisabled() || playerIsOnGuard(addon)) {
      return false;
    }
    TextColor textColor = TextColor.color(addon.configuration().getMainTimerColor().get().get());
    addon.displayMessage(Component.translatable("Prison.BetterTimers.personal_header").color(textColor));
    HotSpots.APLUS_BANK.getHotSpot().printPersonal(addon);
    HotSpots.A_VAULT.getHotSpot().printPersonal(addon);
    HotSpots.B_VAULT.getHotSpot().printPersonal(addon);
    HotSpots.CM_VAULT.getHotSpot().printPersonal(addon);
    HotSpots.C_VAULT.getHotSpot().printPersonal(addon);

    HotSpots.APLUS_GANGAREA.getHotSpot().printPersonal(addon);
    HotSpots.A_GANGAREA.getHotSpot().printPersonal(addon);

    HotSpots.BPLUS_GANGAREA.getHotSpot().printPersonal(addon);
    HotSpots.B_GANG_AREA.getHotSpot().printPersonal(addon);
    HotSpots.B_PVP_CHEST.getHotSpot().printPersonal(addon);
    HotSpots.BPLUS_VAULT.getHotSpot().printPersonal(addon);
    HotSpots.C_GANG_AREA.getHotSpot().printPersonal(addon);
    HotSpots.NEW_GANG.getHotSpot().printGlobal(addon);
    HotSpots.NEW_FISHING_ROD.getHotSpot().printPersonal(addon);
    HotSpots.B_KOBEN.getHotSpot().printPersonal(addon);

    if(!(HotSpots.A_ROCKER_TORBEN.getHotSpot().getClockSetWhenAbleToBeRobbedPersonal() == null)) {
      HotSpots.A_ROCKER_TORBEN.getHotSpot().printGlobal(addon);
    }
    return true;
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getBetterTimers().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean playerIsOnGuard(FreakyvilleAddon addon) {
    return addon.IsPlayerOnGuard();
  }


}
