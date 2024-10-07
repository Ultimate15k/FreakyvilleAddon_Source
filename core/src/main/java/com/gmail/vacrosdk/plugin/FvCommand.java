package com.gmail.vacrosdk.plugin;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;

public class FvCommand extends Command {

  private final FreakyvilleAddon addon;

  public FvCommand(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] strings) {
    if(moduleIsDisabled()) {
      return false;
    }
    addon.displayMessage("§a★§f✩§a★ §a§lCommands ★§f✩§a★");
    addon.displayMessage("§a§lCamp (Person) - §fPersonen får et farvet navn og du får en notifikation når personen leaver/joiner den server du er på");
    addon.displayMessage("§a§lCei - §fGiver information om celler");
    addon.displayMessage("§a§lTimers - §fViser tider på de forskelige ting");
    addon.displayMessage("§a§lpTimers - §fViser personlig tider på de forskelige ting");
    addon.displayMessage("§a§lNt (Person) - §fPersonen får et farvet navn");
    addon.displayMessage("§a§lPn (Person) - §fDu får en notifikation når personen leaver/joiner den server du er på");
    addon.displayMessage("§a§lQuest a/b (dag/alle) - §fViser de forskelige quests");
    return true;
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().enabled().get().equals(false);
  }
}
