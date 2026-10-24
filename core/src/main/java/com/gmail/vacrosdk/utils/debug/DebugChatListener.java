package com.gmail.vacrosdk.utils.debug;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class DebugChatListener {

  private final FreakyvilleAddon addon;

  public DebugChatListener(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  @SuppressWarnings("unused")
  public void onChatMessageReceived(ChatReceiveEvent event) {
    String message = event.chatMessage().getFormattedText();
    String playername = addon.labyAPI().getName();
    if (DebugFunctions.isDebugMode()) {
      System.out.println(playername + ": " + message);
    }
  }

}
