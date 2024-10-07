package com.gmail.vacrosdk.modules.Prison.EventNotifier.Event;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Sounds.NotificationSound;
import com.gmail.vacrosdk.utils.Utils;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public abstract class NotificationEvent {

  public final String catchMessage;
  public final FreakyvilleAddon addon;

  public NotificationEvent(String catchMessage, FreakyvilleAddon addon) {
    this.catchMessage = catchMessage;
    this.addon = addon;
  }

  public abstract void runSubEvent(ChatReceiveEvent event);

  public void runSound() {
    Boolean soundIsEnabled = addon.configuration().getSoundEnabled().get();
    if(soundIsEnabled) {
      NotificationSound notificationSound = addon.configuration().getNotifierSound().get();
      Float volume = addon.configuration().getVolume().get();

      Utils.playNotificationSound(notificationSound, volume, 100);
    }
  }

  @Subscribe
  public void onChatReceiveEvent(ChatReceiveEvent event) {
    if (!addon.isOnlineOnFreakyville()) {
      return;
    }
    if(moduleIsDisabled()) {
      return;
    }
    doEvent(event);
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getEventNotifier().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

  private void doEvent(ChatReceiveEvent event) {
    String plainText = event.chatMessage().getPlainText();
    String formattedText = event.chatMessage().getFormattedText();
    if(plainText.contains(catchMessage)) {
      runSubEvent(event);
    }else if(formattedText.contains(catchMessage)) {
      runSubEvent(event);
    }
  }
}
