package com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.NotificationEvent;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

/**
 * This is not a language file.
 * Instead, this represents a thing on the server the addon is made for
 */

public class FlipManLostFlip extends NotificationEvent {

  public FlipManLostFlip(String catchMessage, FreakyvilleAddon addon) {
    super(catchMessage, addon);
  }

  @Override
  public void runSubEvent(ChatReceiveEvent event) {
    if(addon.configuration().getFlipLostEvent().get()) {
      runSound();
      Utils.showTitle("§4§lDu tabte!!!");
    }
  }
}
