package com.gmail.vacrosdk.modules.Prison.vagt;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class VagtJoinListener {

  private final FreakyvilleAddon addon;

  public VagtJoinListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(ChatReceiveEvent event) {
    if (!addon.isOnlineOnFreakyville()) {
      return;
    }
    if (moduleIsDisabled()) {
      return;
    }
    doCheck(event);
  }

  private void doCheck(ChatReceiveEvent event) {
    String username = addon.labyAPI().getName();
    String message = event.chatMessage().getFormattedText();
    if (message.contains("§bDu har modtaget dine buffs :o")) {
      addon.SetIsPlayerOnGuard(true);
      Utils.createNotification("BetterTimers", "Modul er slået fra!", Icon.head(username));
    }
  }

  private boolean moduleIsDisabled() {
    return addon.IsPlayerOnGuard().equals(true) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
}
