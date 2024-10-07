package com.gmail.vacrosdk.plugin;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.NameTagPlayerManager;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import java.util.HashMap;
import java.util.Map;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;

public class CampCommand extends Command {

  private final Map<String, Boolean> shouldStartCamping = new HashMap<>();
  private final PlayerNotifierManager playerNotifierManager;
  private final NameTagPlayerManager nameTagPlayerManager;

  private final FreakyvilleAddon addon;

  public CampCommand(String prefix,
      PlayerNotifierManager playerNotifierManager,
      NameTagPlayerManager nameTagPlayerManager, FreakyvilleAddon addon) {
    super(prefix);
    this.playerNotifierManager = playerNotifierManager;
    this.nameTagPlayerManager = nameTagPlayerManager;
    this.addon = addon;
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    if(!addon.isOnlineOnFreakyville()) {
      return false;
    }

    if (arguments.length == 0) {
      this.displayMessage(Component.text("§a/camp <playerName>"));
      return true;
    }
    if (arguments[0].equalsIgnoreCase("clear")) {
      doClear();
      return true;
    }
    String playerName = arguments[0].toLowerCase();
    if (!shouldStartCamping.containsKey(playerName) || shouldStartCamping.get(playerName)) {
      this.labyAPI.commandService().fireCommand("pn", new String[]{"add", playerName});
      this.labyAPI.commandService().fireCommand("nt", new String[]{"add", playerName});
      shouldStartCamping.put(playerName, false);
      return true;
    }
    this.labyAPI.commandService().fireCommand("pn", new String[]{"remove", playerName});
    this.labyAPI.commandService().fireCommand("nt", new String[]{"remove", playerName});
    shouldStartCamping.put(playerName, true);

    return true;
  }

  private void doClear() {
    playerNotifierManager.clear();
    nameTagPlayerManager.clear();
  }


}
