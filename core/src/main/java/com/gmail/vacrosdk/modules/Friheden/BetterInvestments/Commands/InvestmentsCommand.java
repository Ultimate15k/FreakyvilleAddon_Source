package com.gmail.vacrosdk.modules.Friheden.BetterInvestments.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;

import net.labymod.api.client.chat.command.Command;

import java.util.Objects;

import static com.gmail.vacrosdk.utils.TimerFunctions.*;

public class InvestmentsCommand extends Command {

  private final FreakyvilleAddon addon;

  public InvestmentsCommand(String prefix, FreakyvilleAddon addon) {
      super(prefix);

      this.addon = addon;
  }

  @Override
  public boolean execute(String strings, String[] arguments) {
    if (!isModuleDisabled()) {
      String playerName = addon.labyAPI().getName();
      boolean exists = playerExists(playerName,"investments_time");
      if (exists && arguments.length == 0) {
        if(!Objects.requireNonNull(getPlayerData(playerName, "investments_time")).equalsIgnoreCase("Ingen data")) {
          addon.displayMessage("§6§m----§aInvesterings Timer - [§6" + playerName + "§a]§6§m----");

          addon.displayMessage("§aKlokken du kan tage");
          addon.displayMessage("§6" + getPlayerData(playerName, "investments_time"));

          addon.displayMessage("§aTid siden sidste indsamling");

          if (isDateOver24HoursAgo(playerName, "investments")) {
            addon.displayMessage("§4Du kan tage dine investeringer");
          }
          addon.displayMessage("§6" + calculateInvestmentsTime(playerName, "investments"));
        } else {
          String[] playerNames = getAllPlayerNames();
          addon.displayMessage("§6§m----§aMulige personer:§6§m----");
          for (String name : playerNames) {
            String Data = getPlayerData(name,"investments_time");
            assert Data != null;
            if(!Data.equalsIgnoreCase("Ingen data")) {
              if (!isDateOver24HoursAgo(name, "investments")) {
                addon.displayMessage("§6" + name);
              } else {
                addon.displayMessage("§6" + name + " - §4Investeringer kan tages");
              }
            }
          }
        }
      } else if (!exists && arguments.length == 0) {
        String[] playerNames = getAllPlayerNames();
        addon.displayMessage("§6§m----§aMulige personer:§6§m----");
        for (String name : playerNames) {
          String Data = getPlayerData(name,"investments_time");
          assert Data != null;
          if(!Data.equalsIgnoreCase("Ingen data")) {
            if (!isDateOver24HoursAgo(name, "investments")) {
              addon.displayMessage("§6" + name);
            } else {
              addon.displayMessage("§6" + name + " - §4Investeringer kan tages");
            }
          }
        }
      } else if (arguments.length == 1) {
        boolean existsPart2 = playerExists(arguments[0],"investments_time");
        if (existsPart2) {
          if(!Objects.requireNonNull(getPlayerData(arguments[0], "investments_time")).equalsIgnoreCase("Ingen data")) {
            addon.displayMessage("§6§m----§aInvesterings Timer - [§6" + arguments[0] + "§a]§6§m----");
            addon.displayMessage("§aKlokken du kan tage");
            addon.displayMessage("§6" + getPlayerData(arguments[0], "investments_time"));
            addon.displayMessage("§aTid siden sidste indsamling");

            if (isDateOver24HoursAgo(arguments[0], "investments")) {
              addon.displayMessage("§4Du kan tage dine investeringer");
            }
            addon.displayMessage("§6" + calculateInvestmentsTime(arguments[0], "investments"));
          } else {
            addon.displayMessage("§6" + arguments[0] + " §char ikke nogen investeringer");
          }
        } else {
          addon.displayMessage("§6" + arguments[0] + " §char ikke nogen investeringer");
        }
      }
      return true;
    }
      return false;
  }

  private boolean isModuleDisabled() {
    return addon.configuration().getBetterInvestmentsEnabled().get().equals(false) ||
        addon.configuration().enabled().get().equals(false) ||
        addon.configuration().getFrihedenEnabled().get().equals(false)||
        addon.configuration().getHasfileAccess().get().equals(false);
  }
}
