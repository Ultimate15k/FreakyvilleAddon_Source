package com.gmail.vacrosdk.modules.Prison.BetterTimers.Listeners;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpot;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Managers.CatchManager;
import java.util.Set;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;
import net.labymod.api.client.entity.player.ClientPlayer;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class ConfirmListener {

  private final FreakyvilleAddon addon;
  private final CatchManager catchManager;
  private Set<HotSpot> confirmSet;

  public ConfirmListener(FreakyvilleAddon addon,
      CatchManager catchManager) {
    this.addon = addon;
    this.catchManager = catchManager;
    confirmSet = catchManager.getConfirmSet();
  }

  @Subscribe
  public void onChatReceive(ChatReceiveEvent event) {
    if(!addon.isOnlineOnFreakyville()) {
      return;
    }
    if(!moduleIsEnabled()) {
      return;
    }
    if(confirmSet.isEmpty()) {
      return;
    }
    confirmSet = catchManager.getConfirmSet();
    String message = event.chatMessage().getPlainText();
    confirmSet.forEach(hotSpot -> {
      if(message.contains(hotSpot.getConfirmMessage())) {
        handlePersonalCoolDown(hotSpot, message);
        hotSpot.setRobbed(addon);
        catchManager.removeFromSetContains(hotSpot);
        if(BetterTimersMessagesIsEnabled() && !playerIsOnGuard(addon)) {
          TextColor textColor = TextColor.color(addon.configuration().getMainTimerColor().get().get());
          addon.displayMessage(Component.text("BetterTimers detected: " + hotSpot.getHotSpotName() + " has confirmed").color(textColor));
        }
      }
    });
  }

  private boolean playerIsOnGuard(FreakyvilleAddon addon) {
    return addon.configuration().getVagtSwitch().get();
  }

  private void handlePersonalCoolDown(HotSpot hotSpot, String message) {
    ClientPlayer clientPlayer = addon.labyAPI().minecraft().getClientPlayer();
    if(clientPlayer == null) {
      return;
    }
    String name = clientPlayer.getName();
    if(message.contains(name)) {
      hotSpot.startPersonalCoolDown();
    }
  }

  private boolean BetterTimersMessagesIsEnabled() {
    return addon.configuration().getBetterTimersMessage().get().equals(true);
  }

  private boolean moduleIsEnabled() {
    return addon.configuration().getBetterTimers().get().equals(true) || addon.configuration().enabled().get().equals(true)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

}
