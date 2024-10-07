package com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.NotificationEvent;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class FlipManNewOffer extends NotificationEvent {

  public FlipManNewOffer(String catchMessage, FreakyvilleAddon addon) {
    super(catchMessage, addon);
  }

  @Override
  public void runSubEvent(ChatReceiveEvent event) {
    if(addon.configuration().getFlipNewOfferEvent().get()) {
      String formattedText = event.chatMessage().getFormattedText();
      System.out.println("formattedText: " + formattedText);
      runSound();
      Utils.showTitle("§6§lNyt modbud!");
    }
  }
}
