package com.gmail.vacrosdk.modules.Prison.BetterTimers.Listeners;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.language.MessageCatchLanguage;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpot;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Managers.CatchManager;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.labymod.api.client.entity.player.ClientPlayer;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class CatchListener {

  private final FreakyvilleAddon addon;
  private final CatchManager catchManager;
  private Set<HotSpot> keySet;

  private String catchString;

  public CatchListener(FreakyvilleAddon addon, CatchManager catchManager) {
    this.addon = addon;
    this.catchManager = catchManager;
    keySet = catchManager.getKeySet();
  }

  @Subscribe
  public void onChatReceive(ChatReceiveEvent event) {
    if(!addon.isOnlineOnFreakyville()) {
      return;
    }
    if(moduleIsDisabled()) {
      return;
    }
    doCheck(event);
  }

  private void doCheck(ChatReceiveEvent event) {
    String message = event.chatMessage().getPlainText();
    //String message = event.chatMessage().getFormattedText();
    keySet.forEach(hotspot -> {
      if(message.contains(hotspot.getCatchMessage())) {
        String ClosesthotSpot = getClosesthotSpot();
        System.out.println("1: " + ClosesthotSpot);
        if(hotspot.getHotSpotName().contains("A Bandeomr")) {
          if (ClosesthotSpot.equalsIgnoreCase("A")) {
            if (hotspotIsCOrBVault(hotspot)) {
              hotspot.setRobbed(addon);
              handlePersonalCoolDown(hotspot, message);
              return;
            }
            catchManager.addToConfirmList(hotspot);

            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

            Runnable task = () -> {
              if (catchManager.confirmSetContains(hotspot)) {
                catchManager.removeFromSetContains(hotspot);
                hotspot.setFailed();
              }
            };
            executor.schedule(task, hotspot.getRobbingTimeFromStartToFinish() + 1, TimeUnit.SECONDS);
            executor.shutdown();
          }
        } else if (hotspot.getHotSpotName().contains("C Bandeomr")) {
          if (ClosesthotSpot.equalsIgnoreCase("C")) {
            if (hotspotIsCOrBVault(hotspot)) {
              hotspot.setRobbed(addon);
              handlePersonalCoolDown(hotspot, message);
              return;
            }
            catchManager.addToConfirmList(hotspot);

            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

            Runnable task = () -> {
              if (catchManager.confirmSetContains(hotspot)) {
                catchManager.removeFromSetContains(hotspot);
                hotspot.setFailed();
              }
            };
            executor.schedule(task, hotspot.getRobbingTimeFromStartToFinish() + 1, TimeUnit.SECONDS);
            executor.shutdown();
          }
        } else {
          if (hotspotIsCOrBVault(hotspot)) {
            hotspot.setRobbed(addon);
            handlePersonalCoolDown(hotspot, message);
            return;
          }
          catchManager.addToConfirmList(hotspot);

          ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

          Runnable task = () -> {
            if (catchManager.confirmSetContains(hotspot)) {
              catchManager.removeFromSetContains(hotspot);
              hotspot.setFailed();
            }
          };
          executor.schedule(task, hotspot.getRobbingTimeFromStartToFinish() + 1, TimeUnit.SECONDS);
          executor.shutdown();
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

  private void handlePersonalCoolDown(HotSpot hotSpot, String message) {
    ClientPlayer clientPlayer = addon.labyAPI().minecraft().getClientPlayer();
    if(clientPlayer == null) {
      return;
    }
    String name = clientPlayer.getName();
    if(hotSpot.getHotSpotName().equalsIgnoreCase("Koben Cooldown") || (hotSpot.getHotSpotName().equalsIgnoreCase("Fishing rod Cooldown")) || (hotSpot.getHotSpotName().equalsIgnoreCase("Fishing rod Cooldownd"))) {
      hotSpot.startPersonalCoolDown();
    }
    if(message.contains(name)) {
      hotSpot.startPersonalCoolDown();
    }
  }

  private boolean hotspotIsCOrBVault(HotSpot hotspot) {
    return
        hotspot.getCatchMessage().equalsIgnoreCase(MessageCatchLanguage.B_VV_CATCH) ||
        hotspot.getCatchMessage().equalsIgnoreCase(MessageCatchLanguage.C_VV_CATCH) ||
        hotspot.getCatchMessage().equalsIgnoreCase(MessageCatchLanguage.NEW_GANG_CATCH) ||
        hotspot.getCatchMessage().equalsIgnoreCase(MessageCatchLanguage.NEW_FISHING_ROD_CATCH) ||
        hotspot.getCatchMessage().equalsIgnoreCase(MessageCatchLanguage.B_KOBEN_CATCH) ||
        hotspot.getCatchMessage().equalsIgnoreCase(MessageCatchLanguage.A_DISABLE_VAULTS_CATCH);
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getBetterTimers().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

}
