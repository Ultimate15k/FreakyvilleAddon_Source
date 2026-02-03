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
        String ClosesthotSpot = getClosesthotSpot();
        System.out.println("2: " + ClosesthotSpot);
        if(hotSpot.getHotSpotName().contains("A Bandeomr")) {
          if (ClosesthotSpot.equalsIgnoreCase("A")) {
            handlePersonalCoolDown(hotSpot, message);
            hotSpot.setRobbed(addon);
            catchManager.removeFromSetContains(hotSpot);
            if (BetterTimersMessagesIsEnabled() && !playerIsOnGuard(addon)) {
              TextColor textColor = TextColor.color(addon.configuration().getMainTimerColor().get().get());
              addon.displayMessage(
                  Component.translatable(
                      "Prison.BetterTimers.confirmed",
                      Component.text(hotSpot.getHotSpotName())
                  ).color(textColor)
              );
            }
          }
        } else if(hotSpot.getHotSpotName().contains("C Bandeomr")) {
          if (ClosesthotSpot.equalsIgnoreCase("C")) {
            handlePersonalCoolDown(hotSpot, message);
            hotSpot.setRobbed(addon);
            catchManager.removeFromSetContains(hotSpot);
            if (BetterTimersMessagesIsEnabled() && !playerIsOnGuard(addon)) {
              TextColor textColor = TextColor.color(addon.configuration().getMainTimerColor().get().get());
              addon.displayMessage(
                  Component.translatable(
                      "Prison.BetterTimers.confirmed",
                      Component.text(hotSpot.getHotSpotName())
                  ).color(textColor)
              );            }
          }
        } else {
          handlePersonalCoolDown(hotSpot, message);
          hotSpot.setRobbed(addon);
          catchManager.removeFromSetContains(hotSpot);
          if (BetterTimersMessagesIsEnabled() && !playerIsOnGuard(addon)) {
            TextColor textColor = TextColor.color(addon.configuration().getMainTimerColor().get().get());
            addon.displayMessage(
                Component.translatable(
                    "Prison.BetterTimers.confirmed",
                    Component.text(hotSpot.getHotSpotName())
                ).color(textColor)
            );          }
        }
      }
    });
  }


    private static final double C_X = 4.500;
    private static final double C_Y = 73.0;
    private static final double C_Z = 93.500;

    private static final double A_X = 834.500;
    private static final double A_Y = 66.0;
    private static final double A_Z = -325.500;

    private static double calculateDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
      return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

  public String getClosesthotSpot() {
    ClientPlayer player = addon.labyAPI().minecraft().getClientPlayer();

    if (player == null) {
      throw new IllegalStateException("Player is not available.");
    }

    double playerX = player.position().getX();
    double playerY = player.position().getY();
    double playerZ = player.position().getZ();

    double distanceToC = calculateDistance(playerX, playerY, playerZ, C_X, C_Y, C_Z);
    double distanceToA = calculateDistance(playerX, playerY, playerZ, A_X, A_Y, A_Z);

    return (distanceToC < distanceToA) ? "C" : "A";
  }

  private boolean playerIsOnGuard(FreakyvilleAddon addon) {
    return addon.IsPlayerOnGuard();
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
