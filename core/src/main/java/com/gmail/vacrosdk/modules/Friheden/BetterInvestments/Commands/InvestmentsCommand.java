package com.gmail.vacrosdk.modules.Friheden.BetterInvestments.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.util.I18n;

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
      boolean exists = playerExists(playerName, "investments_time");

      if (exists && arguments.length == 0) {

        if (!Objects.requireNonNull(getPlayerData(playerName, "investments_time")).equalsIgnoreCase("Ingen data")) {

          addon.displayMessage(I18n.translate("Friheden.Investments.invest.header", playerName));
          addon.displayMessage(I18n.translate("Friheden.Investments.invest.collect_time_label"));
          addon.displayMessage("§6" + getPlayerData(playerName, "investments_time"));
          addon.displayMessage(I18n.translate("Friheden.Investments.invest.time_since_last"));

          if (isDateOver24HoursAgo(playerName, "investments")) {
            addon.displayMessage(I18n.translate("Friheden.Investments.invest.can_collect"));
          }

          addon.displayMessage("§6" + calculateInvestmentsTime(playerName, "investments"));

        } else {
          showPossiblePlayers();
        }

      } else if (!exists && arguments.length == 0) {
        showPossiblePlayers();

      } else if (arguments.length == 1) {

        boolean existsPart2 = playerExists(arguments[0], "investments_time");

        if (existsPart2) {
          if (!Objects.requireNonNull(getPlayerData(arguments[0], "investments_time")).equalsIgnoreCase("Ingen data")) {

            addon.displayMessage(I18n.translate("Friheden.Investments.invest.header", arguments[0]));
            addon.displayMessage(I18n.translate("Friheden.Investments.invest.collect_time_label"));
            addon.displayMessage("§6" + getPlayerData(arguments[0], "investments_time"));
            addon.displayMessage(I18n.translate("Friheden.Investments.invest.time_since_last"));

            if (isDateOver24HoursAgo(arguments[0], "investments")) {
              addon.displayMessage(I18n.translate("Friheden.Investments.invest.can_collect"));
            }

            addon.displayMessage("§6" + calculateInvestmentsTime(arguments[0], "investments"));

          } else {
            addon.displayMessage(I18n.translate("Friheden.Investments.invest.no_investments", arguments[0]));
          }

        } else {
          addon.displayMessage(I18n.translate("Friheden.Investments.invest.no_investments", arguments[0]));
        }
      }

      return true;
    }
    return false;
  }

  private void showPossiblePlayers() {
    addon.displayMessage(I18n.translate("Friheden.Investments.invest.possible_players_header"));

    String[] playerNames = getAllPlayerNames();
    for (String name : playerNames) {
      String Data = getPlayerData(name, "investments_time");

      if (Data != null && !Data.equalsIgnoreCase("Ingen data")) {

        if (!isDateOver24HoursAgo(name, "investments")) {
          addon.displayMessage("§6" + name);
        } else {
          addon.displayMessage(I18n.translate("Friheden.Investments.invest.player_can_collect", name));
        }
      }
    }
  }

  private boolean isModuleDisabled() {
    return addon.configuration().getBetterInvestmentsEnabled().get().equals(false)
        || addon.configuration().enabled().get().equals(false)
        || addon.configuration().getFrihedenEnabled().get().equals(false)
        || addon.configuration().getHasfileAccess().get().equals(false);
  }
}
