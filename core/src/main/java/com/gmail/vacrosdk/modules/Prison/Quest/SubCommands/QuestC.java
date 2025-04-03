package com.gmail.vacrosdk.modules.Prison.Quest.SubCommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.time.DayOfWeek;
import java.time.LocalDate;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;

public class QuestC extends SubCommand {

  private final FreakyvilleAddon addon;

  public QuestC(FreakyvilleAddon addon) {
    super("c");
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] arguments) {
    if (!QuestIsDisabled()) {
      if (prefix.equalsIgnoreCase("C")) {
        if (arguments.length == 0) {
          DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
          if (dayOfWeek == DayOfWeek.MONDAY) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - C] ★§f✩§9★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§9§l[Finn Fisker] - §fRøv Vagt-Vaulten (C):");
              addon.displayMessage("§9Du får: §f$2500 & Ok chance for 1 rare head");
            }
          } else if (dayOfWeek == DayOfWeek.TUESDAY) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - C] ★§f✩§a★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§a§l[Finn Fisker] - §fAflever 32 Iron Ingots + 32 Coal + 1 blazerods:");
              addon.displayMessage("§aDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
          } else if (dayOfWeek == DayOfWeek.WEDNESDAY) {
            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - C] ★§f✩§b★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§b§l[Finn Fisker] - §f15 Raw fish + 15 clown fish:");
              addon.displayMessage("§bDu får: §f2 Blaze Rod + Lille chance for String");
            }
          } else if (dayOfWeek == DayOfWeek.THURSDAY) {
            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - C] ★§f✩§e★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§e§l[Finn Fisker] - §fAflever 64 coal + 64 iron ingots og 2 blaze rods:");
              addon.displayMessage("§eDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
          } else if (dayOfWeek == DayOfWeek.FRIDAY) {
            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - C] ★§f✩§c★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§c§l[Finn Fisker] - §fBræk 3 kister op i C:");
              addon.displayMessage("§cDu får: §f2500 + Lille chance for head");
            }
          } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - C] ★§f✩§6★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§6§l[Finn Fisker] - §fAflever 256 Iron Ingots + 48 logs + 6 blazerods:");
              addon.displayMessage("§6Du får: §f1 Fishing rod med 10% chance for unbreaking");
            }
          } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - C] ★§f✩§d★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§d§l[Finn Fisker] - §fAflever 15 Raw fish + 15 clown fish:");
              addon.displayMessage("§dDu får: Lille chance for String");
            }
          } else {
            addon.displayMessage("§cDer skete en fejl! opret en ticket på discorden");
            addon.displayMessage("§cDag:" + dayOfWeek);
          }
        } else if (arguments.length == 1) {
          if (arguments[0].equalsIgnoreCase("mandag")) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - C] ★§f✩§9★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§9§l[Finn Fisker] - §fRøv Vagt-Vaulten (C):");
              addon.displayMessage("§9Du får: §f$2500 & Ok chance for 1 rare head");
            }
          } else if (arguments[0].equalsIgnoreCase("tirsdag")) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - C] ★§f✩§a★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§a§l[Finn Fisker] - §fAflever 32 Iron Ingots + 32 Coal + 1 blazerods:");
              addon.displayMessage("§aDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
          } else if (arguments[0].equalsIgnoreCase("onsdag")) {
            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - C] ★§f✩§b★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§b§l[Finn Fisker] - §f15 Raw fish + 15 clown fish:");
              addon.displayMessage("§bDu får: §f2 Blaze Rod + Lille chance for String");
            }
          } else if (arguments[0].equalsIgnoreCase("torsdag")) {
            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - C] ★§f✩§e★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§e§l[Finn Fisker] - §fAflever 64 coal + 64 iron ingots og 2 blaze rods:");
              addon.displayMessage("§eDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
          } else if (arguments[0].equalsIgnoreCase("fredag")) {
            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - C] ★§f✩§c★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§c§l[Finn Fisker] - §fBræk 3 kister op i C:");
              addon.displayMessage("§cDu får: §f2500 + Lille chance for head");
            }
          } else if (arguments[0].equalsIgnoreCase("lørdag")) {
            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - C] ★§f✩§6★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§6§l[Finn Fisker] - §fAflever 256 Iron Ingots + 48 logs + 6 blazerods:");
              addon.displayMessage("§6Du får: §f1 Fishing rod med 10% chance for unbreaking");
            }
          } else if (arguments[0].equalsIgnoreCase("søndag")) {
            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - C] ★§f✩§d★");
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§d§l[Finn Fisker] - §fAflever 15 Raw fish + 15 clown fish:");
              addon.displayMessage("§dDu får: Lille chance for String");
            }
          } else if (arguments[0].equalsIgnoreCase("alle") || (arguments[0].equalsIgnoreCase("all"))) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - C] ★§f✩§9★");
            addon.displayMessage("§9§l[Finn Fisker] - §fRøv Vagt-Vaulten (C):");
            addon.displayMessage("§9Du får: §f$2500 & Ok chance for 1 rare head");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - C] ★§f✩§a★");
            addon.displayMessage("§a§l[Finn Fisker] - §fAflever 32 Iron Ingots + 32 Coal + 1 blazerods:");
            addon.displayMessage("§aDu får: §f1 Fishing rod med 10% chance for unbreaking");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - C] ★§f✩§b★");
            addon.displayMessage("§b§l[Finn Fisker] - §f15 Raw fish + 15 clown fish:");
            addon.displayMessage("§bDu får: §f2 Blaze Rod + Lille chance for String");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - C] ★§f✩§e★");
            addon.displayMessage("§e§l[Finn Fisker] - §fAflever 64 coal + 64 iron ingots og 2 blaze rods:");
            addon.displayMessage("§eDu får: §f1 Fishing rod med 10% chance for unbreaking");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - C] ★§f✩§c★");
            addon.displayMessage("§c§l[Finn Fisker] - §fBræk 3 kister op i C:");
            addon.displayMessage("§cDu får: §f2500 + Lille chance for head");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - C] ★§f✩§6★");
            addon.displayMessage("§6§l[Finn Fisker] - §fAflever 256 Iron Ingots + 48 logs + 6 blazerods:");
            addon.displayMessage("§6Du får: §f1 Fishing rod med 10% chance for unbreaking");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - C] ★§f✩§d★");
            addon.displayMessage("§d§l[Finn Fisker] - §fAflever 15 Raw fish + 15 clown fish:");
            addon.displayMessage("§dDu får: Lille chance for String");
          }
        } else {
          addon.displayMessage(Component.text("/quests a/b/c (dag/alle)", NamedTextColor.RED));
        }
        return true;
      }
    }
      return false;
  }

  private boolean QuestIsDisabled() {
    return addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean FinnFiskerIsDisabled() {
    return addon.configuration().getCFinnfiskerEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}