package com.gmail.vacrosdk.modules.Prison.Quest.SubCommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.time.DayOfWeek;
import java.time.LocalDate;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;

public class QuestB extends SubCommand {

  private final FreakyvilleAddon addon;

  public QuestB(FreakyvilleAddon addon) {
    super("b");
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] arguments) {
    if (!QuestIsDisabled()) {
      if (prefix.equalsIgnoreCase("B")) {
        if (arguments.length == 0) {
          DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
          if (dayOfWeek == DayOfWeek.MONDAY) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - B] ★§f✩§9★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§9§l[Mr. X] - §fAflever 4 stacks sugar:");
              addon.displayMessage("§9Du får: §fDiamand Polet & chance for 1-3 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§9§l[Finn Fisker] - §fRøv Vagt-Vaulten (B):");
              addon.displayMessage("§9Du får: §f25k + Ok chance for 1 rare head");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§9§l[PalleVagt] - §fAflever 4 stacks seeds:");
              addon.displayMessage("§9Du får: §f1 Diamond Polet");
            }
          } else if (dayOfWeek == DayOfWeek.TUESDAY) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - B] ★§f✩§a★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§a§l[Mr. X] - §fAflever 6 stacks wheat:");
              addon.displayMessage(
                  "§aDu får: §fDiamant Polet, 25% chance for PC & chance for 1-2 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage(
                  "§a§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 32 logs + 5 blazerods:");
              addon.displayMessage("§aDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§a§l[PalleVagt] - §fAflever 5 stacks iron ingots:");
              addon.displayMessage(
                  "§aDu får: §f3 Diamond Polet + 10 Brød + 25% Chance for Computer");
            }
          } else if (dayOfWeek == DayOfWeek.WEDNESDAY) {
            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - B] ★§f✩§b★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§b§l[Mr. X] - §fAflever 4 stacks wheat:");
              addon.displayMessage("§bDu får: §fFiskestang & chance for 1-3 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§b§l[Finn Fisker] - §f15 Raw fish + 15 clown fish:");
              addon.displayMessage("§bDu får: §f5 Blaze Rod + Lille chance for String");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§b§l[PalleVagt] - §fAflever 4 stacks wheat:");
              addon.displayMessage("§bDu får: §f10 Blazerods + 1 Legend Key + 2 Diamond Poletter");
            }
          } else if (dayOfWeek == DayOfWeek.THURSDAY) {
            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - B] ★§f✩§e★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§e§l[Mr. X] - §fBræk 3 kister op i B+:");
              addon.displayMessage("§eDu får: §f25k & Lille chance for head");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage(
                  "§e§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 64 logs + 7 blazerods:");
              addon.displayMessage("§eDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage(
                  "§e§l[PalleVagt] - §fAflever 4 stacks Oak log + 4 stacks Leaves:");
              addon.displayMessage("§eDu får: §f2 Legend Keys + 5 Blazerods");
            }
          } else if (dayOfWeek == DayOfWeek.FRIDAY) {
            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - B] ★§f✩§c★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§c§l[Mr. X] - §fAflever 32 kaktus & 4 stacks jern:");
              addon.displayMessage(
                  "§cDu får: §f2 Guld Polet, 25% chance for PC & chance for 1-3 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§c§l[Finn Fisker] - §fBræk 3 kister op i B:");
              addon.displayMessage("§cDu får: §f25k + Lille chance for head");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§c§l[PalleVagt] - §fAflever 16 Kaktus + 2 stacks sugar:");
              addon.displayMessage("§cDu får: §f5k + 2 Guld Poletter + 25% Chance for Computer");
            }
          } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - B] ★§f✩§6★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§6§l[Mr. X] - §fRøv B+ BO:");
              addon.displayMessage("§6Du får: §f25k & lille chance for head");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage(
                  "§6§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 48 logs + 6 blazerods:");
              addon.displayMessage("§6Du får: §f1 Fishing rod med 10% chance for unbreaking");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage(
                  "§6§l[PalleVagt] - §fAflever 2 stacks Iron Ore + 4 stacks Lapis:");
              addon.displayMessage("§6Du får: §f1 Sæt Titan Tools + 1 Diamond");
            }
          } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - B] ★§f✩§d★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§d§l[Mr. X] - §fRøv BO:");
              addon.displayMessage("§dDu får: §f25k & lille chance for head");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§d§l[Finn Fisker] - §fAflever 15 Raw fish + 15 clown fish:");
              addon.displayMessage("§dDu får: §f5 Blaze Rod + Lille chance for String");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§d§l[PalleVagt] - §fAflever 1 Sæt Diamond Gear:");
              addon.displayMessage("§dDu får: §f50k");
            }
          } else {
            addon.displayMessage("§cDer skete en fejl! opret en ticket på discorden");
            addon.displayMessage("§cDag:" + dayOfWeek);
          }
        } else if (arguments.length == 1) {
          if (arguments[0].equalsIgnoreCase("mandag")) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - B] ★§f✩§9★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§9§l[Mr. X] - §fAflever 4 stacks suger:");
              addon.displayMessage("§9Du får: §fDiamand Polet & chance for 1-3 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§9§l[Finn Fisker] - §fRøv Vagt-Vaulten (B):");
              addon.displayMessage("§9Du får: §f25k + Ok chance for 1 rare head");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§9§l[PalleVagt] - §fAflever 4 stacks seeds:");
              addon.displayMessage("§9Du får: §f1 Diamond Polet");
            }
          } else if (arguments[0].equalsIgnoreCase("tirsdag")) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - B] ★§f✩§a★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§a§l[Mr. X] - §fAflever 6 stacks wheat:");
              addon.displayMessage(
                  "§aDu får: §fDiamant Polet, 25% chance for PC & chance for 1-2 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage(
                  "§a§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 32 logs + 5 blazerods:");
              addon.displayMessage("§aDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§a§l[PalleVagt] - §fAflever 5 stacks iron ingots:");
              addon.displayMessage(
                  "§aDu får: §f3 Diamond Polet + 10 Brød + 25% Chance for Computer");
            }
          } else if (arguments[0].equalsIgnoreCase("onsdag")) {
            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - B] ★§f✩§b★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§b§l[Mr. X] - §fAflever 4 stacks wheat:");
              addon.displayMessage("§bDu får: §fFiskestang & chance for 1-3 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§b§l[Finn Fisker] - §f15 Raw fish + 15 clown fish:");
              addon.displayMessage("§bDu får: §f5 Blaze Rod + Lille chance for String");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§b§l[PalleVagt] - §fAflever 4 stacks wheat:");
              addon.displayMessage("§bDu får: §f10 Blazerods + 1 Legend Key + 2 Diamond Poletter");
            }
          } else if (arguments[0].equalsIgnoreCase("torsdag")) {
            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - B] ★§f✩§e★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§e§l[Mr. X] - §fBræk 3 kister op i B+:");
              addon.displayMessage("§eDu får: §f25k & Lille chance for head");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage(
                  "§e§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 64 logs + 7 blazerods:");
              addon.displayMessage("§eDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage(
                  "§e§l[PalleVagt] - §fAflever 4 stacks Oak log + 4 stacks Leaves:");
              addon.displayMessage("§eDu får: §f2 Legend Keys + 5 Blazerods");
            }
          } else if (arguments[0].equalsIgnoreCase("fredag")) {
            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - B] ★§f✩§c★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§c§l[Mr. X] - §fAflever 32 kaktus & 4 stacks jern:");
              addon.displayMessage(
                  "§cDu får: §f2 Guld Polet, 25% chance for PC & chance for 1-3 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§c§l[Finn Fisker] - §fBræk 3 kister op i B:");
              addon.displayMessage("§cDu får: §f25k + Lille chance for head");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§c§l[PalleVagt] - §fAflever 16 Kaktus + 2 stacks sugar:");
              addon.displayMessage("§cDu får: §f5k + 2 Guld Poletter + 25% Chance for Computer");
            }
          } else if (arguments[0].equalsIgnoreCase("lørdag")) {
            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - B] ★§f✩§6★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§6§l[Mr. X] - §fRøv B+ BO:");
              addon.displayMessage("§6Du får: §f25k & lille chance for head");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage(
                  "§6§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 48 logs + 6 blazerods:");
              addon.displayMessage("§6Du får: §f1 Fishing rod med 10% chance for unbreaking");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage(
                  "§6§l[PalleVagt] - §fAflever 2 stacks Iron Ore + 4 stacks Lapis:");
              addon.displayMessage("§6Du får: §f1 Sæt Titan Tools + 1 Diamond");
            }
          } else if (arguments[0].equalsIgnoreCase("søndag")) {
            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - B] ★§f✩§d★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§d§l[Mr. X] - §fRøv BO:");
              addon.displayMessage("§dDu får: §f25k & lille chance for head");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§d§l[Finn Fisker] - §fAflever 15 Raw fish + 15 clown fish:");
              addon.displayMessage("§dDu får: §f5 Blaze Rod + Lille chance for String");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§d§l[PalleVagt] - §fAflever 1 Sæt Diamond Gear:");
              addon.displayMessage("§dDu får: §f50k");
            }
          } else if (arguments[0].equalsIgnoreCase("alle") || (arguments[0].equalsIgnoreCase("all"))) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - B] ★§f✩§9★");
            addon.displayMessage("§9§l[Mr. X] - §fAflever 4 stacks suger:");
            addon.displayMessage("§9Du får: §fDiamand Polet & chance for 1-3 dbs");
            addon.displayMessage("§9§l[Finn Fisker] - §fRøv Vagt-Vaulten (B):");
            addon.displayMessage("§9Du får: §f25k + Ok chance for 1 rare head");
            addon.displayMessage("§9§l[PalleVagt] - §fAflever 4 stacks seeds:");
            addon.displayMessage("§9Du får: §f1 Diamond Polet");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - B] ★§f✩§a★");
            addon.displayMessage("§a§l[Mr. X] - §fAflever 6 stacks wheat:");
            addon.displayMessage(
                "§aDu får: §fDiamant Polet, 25% chance for PC & chance for 1-2 dbs");
            addon.displayMessage(
                "§a§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 32 logs + 5 blazerods:");
            addon.displayMessage("§aDu får: §f1 Fishing rod med 10% chance for unbreaking");
            addon.displayMessage("§a§l[PalleVagt] - §fAflever 5 stacks iron ingots:");
            addon.displayMessage("§aDu får: §f3 Diamond Polet + 10 Brød + 25% Chance for Computer");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - B] ★§f✩§b★");
            addon.displayMessage("§b§l[Mr. X] - §fAflever 4 stacks wheat:");
            addon.displayMessage("§bDu får: §fFiskestang & chance for 1-3 dbs");
            addon.displayMessage("§b§l[Finn Fisker] - §f15 Raw fish + 15 clown fish:");
            addon.displayMessage("§bDu får: §f5 Blaze Rod + Lille chance for String");
            addon.displayMessage("§b§l[PalleVagt] - §fAflever 4 stacks wheat:");
            addon.displayMessage("§bDu får: §f10 Blazerods + 1 Legend Key + 2 Diamond Poletter");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - B] ★§f✩§e★");
            addon.displayMessage("§e§l[Mr. X] - §fBræk 3 kister op i B+:");
            addon.displayMessage("§eDu får: §f25k & Lille chance for head");
            addon.displayMessage(
                "§e§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 64 logs + 7 blazerods:");
            addon.displayMessage("§eDu får: §f1 Fishing rod med 10% chance for unbreaking");
            addon.displayMessage("§e§l[PalleVagt] - §fAflever 4 stacks Oak log + 4 stacks Leaves:");
            addon.displayMessage("§eDu får: §f2 Legend Keys + 5 Blazerods");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - B] ★§f✩§c★");
            addon.displayMessage("§c§l[Mr. X] - §fAflever 32 kaktus & 4 stacks jern:");
            addon.displayMessage(
                "§cDu får: §f2 Guld Polet, 25% chance for PC & chance for 1-3 dbs");
            addon.displayMessage("§c§l[Finn Fisker] - §fBræk 3 kister op i B:");
            addon.displayMessage("§cDu får: §f25k + Lille chance for head");
            addon.displayMessage("§c§l[PalleVagt] - §fAflever 16 Kaktus + 2 stacks sugar:");
            addon.displayMessage("§cDu får: §f5k + 2 Guld Poletter + 25% Chance for Computer");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - B] ★§f✩§6★");
            addon.displayMessage("§6§l[Mr. X] - §fRøv B+ BO:");
            addon.displayMessage("§6Du får: §f25k & lille chance for head");
            addon.displayMessage(
                "§6§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 48 logs + 6 blazerods:");
            addon.displayMessage("§6Du får: §f1 Fishing rod med 10% chance for unbreaking");
            addon.displayMessage("§6§l[PalleVagt] - §fAflever 2 stacks Iron Ore + 4 stacks Lapis:");
            addon.displayMessage("§6Du får: §f1 Sæt Titan Tools + 1 Diamond");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - B] ★§f✩§d★");
            addon.displayMessage("§d§l[Mr. X] - §fRøv BO:");
            addon.displayMessage("§dDu får: §f25k & lille chance for head");
            addon.displayMessage("§d§l[Finn Fisker] - §fAflever 15 Raw fish + 15 clown fish:");
            addon.displayMessage("§dDu får: §f5 Blaze Rod + Lille chance for String");
            addon.displayMessage("§d§l[PalleVagt] - §fAflever 1 Sæt Diamond Gear:");
            addon.displayMessage("§dDu får: §f50k");
          }
        } else {
          addon.displayMessage(Component.text("/quests a/b (dag/alle)", NamedTextColor.RED));
        }
        return true;
      }
    }
      return false;
  }

  private boolean QuestIsDisabled() {
    return addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean MrXIsDisabled() {
    return addon.configuration().getMrXEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean FinnFiskerIsDisabled() {
    return addon.configuration().getFinnfiskerEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean PalleVagtIsDisabled() {
    return addon.configuration().getPallevagtEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}