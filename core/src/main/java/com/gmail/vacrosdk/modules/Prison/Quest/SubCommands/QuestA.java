package com.gmail.vacrosdk.modules.Prison.Quest.SubCommands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.time.DayOfWeek;
import java.time.LocalDate;
import net.labymod.api.client.chat.command.SubCommand;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;

public class QuestA extends SubCommand {

  private final FreakyvilleAddon addon;

  public QuestA(FreakyvilleAddon addon) {
    super("a");
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] arguments) {
    if (!QuestIsDisabled()) {
      if (prefix.equalsIgnoreCase("A")) {
        if (arguments.length == 0) {
          DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
          if (dayOfWeek == DayOfWeek.MONDAY) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - A] ★§f✩§9★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§9§l[Gertvagt] - §fAflever 10 stacks brød:");
              addon.displayMessage("§9Du får: §fChance for Vaskepolet + 80k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§9§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§9Du får: §f50k + 3-9 Diamonds");
            }
          } else if (dayOfWeek == DayOfWeek.TUESDAY) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - A] ★§f✩§a★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§a§l[Gertvagt] - §fAflever 2 stacks emeralder:");
              addon.displayMessage("§aDu får: §fChance for Vaskepolet + Leg key + 2 Dia polet");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§a§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§aDu får: §fLille Chance for Rare Dør");
            }
          } else if (dayOfWeek == DayOfWeek.WEDNESDAY) {
            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - A] ★§f✩§b★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§b§l[Gertvagt] - §fAflever 3 sæts diagear:");
              addon.displayMessage("§bDu får: §fChance for Vaskepolet + 10 stacks brød + 50 blaze");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§b§l[Donvito] - §fOvertag A Bandeområde:");
              addon.displayMessage("§bDu får: §fLille Chance for Head");
            }
          } else if (dayOfWeek == DayOfWeek.THURSDAY) {
            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - A] ★§f✩§e★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§e§l[Gertvagt] - §fAflever 5 stacks kaktus:");
              addon.displayMessage("§eDu får: §fChance for Vaskepolet + 1 Dia polet + 40k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§e§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§eDu får: §f50k + Lille Chance for rare Stair");
            }
          } else if (dayOfWeek == DayOfWeek.FRIDAY) {
            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - A] ★§f✩§c★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§c§l[Gertvagt] - §fAflever 5 stacks sugar:");
              addon.displayMessage("§cDu får: §fChance for Vaskepolet + 2 Guld polet + 30k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§c§l[Donvito] - §fRøv Vven:");
              addon.displayMessage("§cDu får: §fFin Chance for Rare Head");
            }
          } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - A] ★§f✩§6★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§6§l[Gertvagt] - §fAflever 5 stacks neather wart:");
              addon.displayMessage("§6Du får: §fChance for Vaskepolet + Leg key");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§6§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§6Du får: §f50k + Ok chance for head");
            }
          } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - A] ★§f✩§d★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage(
                  "§d§l[Gertvagt] - §fAflever 10 bones, 10 pufferfish, 2 stacks raw fish:");
              addon.displayMessage("§dDu får: §fChance for Vaskepolet + Glow key + Em key");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§d§l[Donvito] - §fOvertag Bandeområde i A+:");
              addon.displayMessage("§dDu får: §fLille Chance for Head");
            }
          } else {
            addon.displayMessage("§cDer skete en fejl! opret en ticket på discorden");
            addon.displayMessage("§cDag:" + dayOfWeek);
          }
        } else if (arguments.length == 1) {
          if (arguments[0].equalsIgnoreCase("mandag")) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - A] ★§f✩§9★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§9§l[Gertvagt] - §fAflever 10 stacks brød:");
              addon.displayMessage("§9Du får: §fChance for Vaskepolet + 80k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§9§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§9Du får: §f50k + 3-9 Diamonds");
            }
          } else if (arguments[0].equalsIgnoreCase("tirsdag")) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - A] ★§f✩§a★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§a§l[Gertvagt] - §fAflever 2 stacks emeralder:");
              addon.displayMessage("§aDu får: §fChance for Vaskepolet + Leg key + 2 Dia polet");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§a§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§aDu får: §fLille Chance for Rare Dør");
            }
          } else if (arguments[0].equalsIgnoreCase("onsdag")) {
            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - A] ★§f✩§b★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§b§l[Gertvagt] - §fAflever 3 sæts diagear:");
              addon.displayMessage("§bDu får: §fChance for Vaskepolet + 10 stacks brød + 50 blaze");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§b§l[Donvito] - §fOvertag A Bandeområde:");
              addon.displayMessage("§bDu får: §fLille Chance for Head");
            }
          } else if (arguments[0].equalsIgnoreCase("torsdag")) {
            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - A] ★§f✩§e★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§e§l[Gertvagt] - §fAflever 5 stacks kaktus:");
              addon.displayMessage("§eDu får: §fChance for Vaskepolet + 1 Dia polet + 40k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§e§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§eDu får: §f50k + Lille Chance for rare Stair");
            }
          } else if (arguments[0].equalsIgnoreCase("fredag")) {
            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - A] ★§f✩§c★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§c§l[Gertvagt] - §fAflever 5 stacks sugar:");
              addon.displayMessage("§cDu får: §fChance for Vaskepolet + 2 Guld polet + 30k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§c§l[Donvito] - §fRøv Vven:");
              addon.displayMessage("§cDu får: §fFin Chance for Rare Head");
            }
          } else if (arguments[0].equalsIgnoreCase("lørdag")) {
            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - A] ★§f✩§6★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§6§l[Gertvagt] - §fAflever 5 stacks neather wart:");
              addon.displayMessage("§6Du får: §fChance for Vaskepolet + Leg key");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§6§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§6Du får: §f50k + Ok chance for head");
            }
          } else if (arguments[0].equalsIgnoreCase("søndag")) {
            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - A] ★§f✩§d★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§d§l[Gertvagt] - §fAflever 10 bones, 10 pufferfish, 2 stacks raw fish:");
              addon.displayMessage("§dDu får: §fChance for Vaskepolet + Glow key + Em key");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§d§l[Donvito] - §fOvertag Bandeområde i A+:");
              addon.displayMessage("§dDu får: §fLille Chance for Head");
            }
          } else if (arguments[0].equalsIgnoreCase("alle") || (arguments[0].equalsIgnoreCase("all"))) {

            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - A] ★§f✩§9★");
            addon.displayMessage("§9§l[Gertvagt] - §fAflever 10 stacks brød:");
            addon.displayMessage("§9Du får: §fChance for Vaskepolet + 80k");
            addon.displayMessage("§9§l[Donvito] - §f50 Respekt:");
            addon.displayMessage("§9Du får: §f50k + 3-9 Diamonds");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - A] ★§f✩§a★");
            addon.displayMessage("§a§l[Gertvagt] - §fAflever 2 stacks emeralder:");
            addon.displayMessage("§aDu får: §fChance for Vaskepolet + Leg key + 2 Dia polet");
            addon.displayMessage("§a§l[Donvito] - §f50 Respekt:");
            addon.displayMessage("§aDu får: §fLille Chance for Rare Dør");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - A] ★§f✩§b★");
            addon.displayMessage("§b§l[Gertvagt] - §fAflever 3 sæts diagear:");
            addon.displayMessage("§bDu får: §fChance for Vaskepolet + 10 stacks brød + 50 blaze");
            addon.displayMessage("§b§l[Donvito] - §fOvertag A Bandeområde:");
            addon.displayMessage("§bDu får: §fLille Chance for Head");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - A] ★§f✩§e★");
            addon.displayMessage("§e§l[Gertvagt] - §fAflever 5 stacks kaktus:");
            addon.displayMessage("§eDu får: §fChance for Vaskepolet + 1 Dia polet + 40k");
            addon.displayMessage("§e§l[Donvito] - §f50 Respekt:");
            addon.displayMessage("§eDu får: §f50k + Lille Chance for rare Stair");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - A] ★§f✩§c★");
            addon.displayMessage("§c§l[Gertvagt] - §fAflever 5 stacks sugar:");
            addon.displayMessage("§cDu får: §fChance for Vaskepolet + 2 Guld polet + 30k");
            addon.displayMessage("§c§l[Donvito] - §fRøv Vven:");
            addon.displayMessage("§cDu får: §fFin Chance for Rare Head");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - A] ★§f✩§6★");
            addon.displayMessage("§6§l[Gertvagt] - §fAflever 5 stacks neather wart:");
            addon.displayMessage("§6Du får: §fChance for Vaskepolet + Leg key");
            addon.displayMessage("§6§l[Donvito] - §f50 Respekt:");
            addon.displayMessage("§6Du får: §f50k + Ok chance for head");

            addon.displayMessage("§0§m-----------------------------");

            addon.displayMessage("§d★§f✩§d★ §d§l[SØNDAG - A] ★§f✩§d★");
            addon.displayMessage("§d§l[Gertvagt] - §fAflever 10 bones, 10 pufferfish, 2 stacks raw fish:");
            addon.displayMessage("§dDu får: §fChance for Vaskepolet + Glow key + Em key");
            addon.displayMessage("§d§l[Donvito] - §fOvertag Bandeområde i A+:");
            addon.displayMessage("§dDu får: §fLille Chance for Head");
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

  private boolean GertvagtIsDisabled() {
    return addon.configuration().getGertvagtEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean DonvitoIsDisabled() {
    return addon.configuration().getDonvitoEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}

