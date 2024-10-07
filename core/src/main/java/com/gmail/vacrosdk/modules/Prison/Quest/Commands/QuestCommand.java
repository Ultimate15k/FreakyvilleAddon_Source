package com.gmail.vacrosdk.modules.Prison.Quest.Commands;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.Quest.SubCommands.QuestA;
import com.gmail.vacrosdk.modules.Prison.Quest.SubCommands.QuestB;
import java.time.DayOfWeek;
import java.time.LocalDate;
import net.labymod.api.client.chat.command.Command;

public class QuestCommand extends Command {

  private final FreakyvilleAddon addon;

  public QuestCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);

    this.withSubCommand(new QuestA(addon));
    this.withSubCommand(new QuestB(addon));
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] arguments) {
    if (!QuestIsDisabled()) {
      if (!(arguments.length == 1)) {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        if (dayOfWeek == DayOfWeek.MONDAY) {
          if(AQuestIsDisabled()) {
            addon.displayMessage("§9★§f✩§9★ §9§l[MANDAG - A] ★§f✩§9★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§9§l[Gertvagt] - §fAflever 10 stacks brød:");
              addon.displayMessage("§9Du får: §fChance for Vaskepolet + 80k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§9§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§9Du får: §f50k + 3-9 Diamonds");
            }
          }
          if(BQuestIsDisabled()) {
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
          }
        } else if (dayOfWeek == DayOfWeek.TUESDAY) {
          if(AQuestIsDisabled()) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - A] ★§f✩§a★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§a§l[Gertvagt] - §fAflever 2 stacks emeralder:");
              addon.displayMessage("§aDu får: §fChance for Vaskepolet + Leg key + 2 Dia polet");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§a§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§aDu får: §fLille Chance for Rare Dør");
            }
          }
          if(BQuestIsDisabled()) {
            addon.displayMessage("§a★§f✩§a★ §a§l[TIRSDAG - B] ★§f✩§a★");
            if (MrXIsDisabled()) {
              addon.displayMessage("§a§l[Mr. X] - §fAflever 6 stacks wheat:");
              addon.displayMessage(
                  "§aDu får: §fDiamant Polet, 25% chance for PC & chance for 1-2 dbs");
            }
            if (FinnFiskerIsDisabled()) {
              addon.displayMessage("§a§l[Finn Fisker] - §fAflever 4 stacks Iron Ingots + 32 logs + 5 blazerods:");
              addon.displayMessage("§aDu får: §f1 Fishing rod med 10% chance for unbreaking");
            }
            if (PalleVagtIsDisabled()) {
              addon.displayMessage("§a§l[PalleVagt] - §fAflever 5 stacks iron ingots:");
              addon.displayMessage(
                  "§aDu får: §f3 Diamond Polet + 10 Brød + 25% Chance for Computer");
            }
          }
        } else if (dayOfWeek == DayOfWeek.WEDNESDAY) {
          if(AQuestIsDisabled()) {
            addon.displayMessage("§b★§f✩§b★ §b§l[ONSDAG - A] ★§f✩§b★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§b§l[Gertvagt] - §fAflever 3 sæts diagear:");
              addon.displayMessage("§bDu får: §fChance for Vaskepolet + 10 stacks brød + 50 blaze");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§b§l[Donvito] - §fOvertag A Bandeområde:");
              addon.displayMessage("§bDu får: §fLille Chance for Head");
            }
          }
          if(BQuestIsDisabled()) {
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
          }
        } else if (dayOfWeek == DayOfWeek.THURSDAY) {
          if(AQuestIsDisabled()) {
            addon.displayMessage("§e★§f✩§e★ §e§l[TORSDAG - A] ★§f✩§e★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§e§l[Gertvagt] - §fAflever 5 stacks kaktus:");
              addon.displayMessage("§eDu får: §fChance for Vaskepolet + 1 Dia polet + 40k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§e§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§eDu får: §f50k + Lille Chance for rare Stair");
            }
          }
          if(BQuestIsDisabled()) {
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
          }
        } else if (dayOfWeek == DayOfWeek.FRIDAY) {
          if(AQuestIsDisabled()) {
            addon.displayMessage("§c★§f✩§c★ §c§l[FREDAG - A] ★§f✩§c★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§c§l[Gertvagt] - §fAflever 5 stacks sugar:");
              addon.displayMessage("§cDu får: §fChance for Vaskepolet + 2 Guld polet + 30k");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§c§l[Donvito] - §fRøv Vven:");
              addon.displayMessage("§cDu får: §fFin Chance for Rare Head");
            }
          }
          if(BQuestIsDisabled()) {
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
          }
        } else if (dayOfWeek == DayOfWeek.SATURDAY) {
          if(AQuestIsDisabled()) {
            addon.displayMessage("§6★§f✩§6★ §6§l[LØRDAG - A] ★§f✩§6★");
            if (GertvagtIsDisabled()) {
              addon.displayMessage("§6§l[Gertvagt] - §fAflever 5 stacks neather wart:");
              addon.displayMessage("§6Du får: §fChance for Vaskepolet + Leg key");
            }
            if (DonvitoIsDisabled()) {
              addon.displayMessage("§6§l[Donvito] - §f50 Respekt:");
              addon.displayMessage("§6Du får: §f50k + Ok chance for head");
            }
          }
          if(BQuestIsDisabled()) {
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
          }
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
          if(AQuestIsDisabled()) {
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
          }
          if(BQuestIsDisabled()) {
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
          }
        } else {
          addon.displayMessage("§cDer skete en fejl! opret en ticket på discorden");
          addon.displayMessage("§cDag:" + dayOfWeek);
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

  private boolean GertvagtIsDisabled() {
    return addon.configuration().getGertvagtEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean DonvitoIsDisabled() {
    return addon.configuration().getDonvitoEnabled().get().equals(true) || addon.configuration().getQuestsEnabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private boolean BQuestIsDisabled() {
    return addon.configuration().getBQuestEnabled().get().equals(true);
  }

  private boolean AQuestIsDisabled() {
    return addon.configuration().getAQuestEnabled().get().equals(true);
  }
}
