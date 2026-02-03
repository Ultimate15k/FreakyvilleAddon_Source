package com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.NotificationEvent;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

/**
 * This is not a language file.
 * Instead, this represents a thing on the server the addon is made for
 */

public class HeadEvent extends NotificationEvent {

  public HeadEvent(String catchMessage, FreakyvilleAddon addon) {
    super(catchMessage, addon);
  }

  @Override
  public void runSubEvent(ChatReceiveEvent event) {
    if(addon.configuration().getHeadEvent().get()) {
      runSound();
      Utils.showTitle("§d§lHEAD - HEAD - HEAD");
    }
  }
}
