package com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.NotificationEvent;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class GuardsDisableVaultsEvent extends NotificationEvent {

  public GuardsDisableVaultsEvent(String catchMessage, FreakyvilleAddon addon) {
    super(catchMessage, addon);
  }

  @Override
  public void runSubEvent(ChatReceiveEvent event) {
    if(addon.configuration().getGuardsDisabledVaultsEvent().get()) {
      runSound();
      Utils.showTitle("§c§lA+/A Vagtvault slået fra");
    }
  }
}
