package com.gmail.vacrosdk.modules.Prison.BetterTimers.Listeners;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.language.MessageCatchLanguage;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpot;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Managers.CatchManager;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.labymod.api.client.entity.player.ClientPlayer;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;

public class UpdateListener {

  private final FreakyvilleAddon addon;
  private final Set<HotSpot> keySet;

  Pattern hoursPattern = Pattern.compile("(\\d+) time");
  Pattern minutesPattern = Pattern.compile("(\\d+) minut");
  Pattern secondsPattern = Pattern.compile("(\\d+) sekund");
  public UpdateListener(FreakyvilleAddon addon, CatchManager catchManager) {
    this.addon = addon;
    keySet = catchManager.getKeySet();
  }

  @Subscribe
  public void onChatReceive(ChatReceiveEvent event) {
    if(!addon.isOnlineOnFreakyville()) {
      return;
    }
    if(!moduleIsEnabled()) {
      return;
    }

    doCheck(event);
  }

  private void doCheck(ChatReceiveEvent event) {
    String message = event.chatMessage().getPlainText();
    keySet.forEach(hotSpot -> {
      if(updateMessageIsNull(hotSpot)) {
        return;
      }
      if(hotSpotIsAGangArea(hotSpot)) {
        return;
      }
      if(hotSpot.getHotSpotName().equalsIgnoreCase("B+ Bank")) {
        if (message.contains(hotSpot.getUpdateMessage())) {
          String ClosesthotSpot = getClosestCoordSet();
          if(ClosesthotSpot.equalsIgnoreCase("bplus")) {
            handleTimer(hotSpot, message);
          }
        }
      } else if (hotSpot.getHotSpotName().equalsIgnoreCase("A+ Bank")) {
        if (message.contains(hotSpot.getUpdateMessage())) {
          String ClosesthotSpot = getClosestCoordSet();
          if(ClosesthotSpot.equalsIgnoreCase("aplus")) {
            handleTimer(hotSpot, message);
          }
        }
      }
      if (message.contains(hotSpot.getUpdateMessage())) {
        if(hotSpot.getHotSpotName().equalsIgnoreCase("B+ Bank") || (hotSpot.getHotSpotName().equalsIgnoreCase("A+ Bank"))) {
          return;
        }
        handleTimer(hotSpot, message);
      }

    });
  }

  private void handleTimer(HotSpot hotSpot, String message) {
    if(shouldSetPersonalTimer(hotSpot)) {
      setPersonalTimer(hotSpot, message);
    }else{
      setGlobalTimer(hotSpot, message);
    }

  }

  public String getClosestCoordSet() {
    ClientPlayer p = addon.labyAPI().minecraft().getClientPlayer();

    double playerX = p.position().getX();
    double playerY = p.position().getY();
    double playerZ = p.position().getZ();

    double distanceSquaredToCoord1 = calculateDistanceSquared(playerX, playerY, playerZ, 627.455, 74.0, 215.458); //Aplus
    double distanceSquaredToCoord2 = calculateDistanceSquared(playerX, playerY, playerZ, 17.560, 66.0, -419.374); //Bplus

    double minDistanceSquared = Math.min(distanceSquaredToCoord1, distanceSquaredToCoord2);

    if (minDistanceSquared == distanceSquaredToCoord1) {
      return "aplus";
    } else {
      return "bplus";
    }
  }

  private double calculateDistanceSquared(double x1, double y1, double z1, double x2, double y2, double z2) {
    double deltaX = x2 - x1;
    double deltaY = y2 - y1;
    double deltaZ = z2 - z1;
    return deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
  }



  private void setGlobalTimer(HotSpot hotSpot, String message) {
    int hours = getTime(message, hoursPattern);
    int minutes = getTime(message, minutesPattern);
    int seconds = getTime(message, secondsPattern);
    hotSpot.setTimeLeftManually(hours, minutes, seconds);
  }

  private void setPersonalTimer(HotSpot hotSpot, String message) {
    int hours = getTime(message, hoursPattern);
    int minutes = getTime(message, minutesPattern);
    int seconds = getTime(message, secondsPattern);
    hotSpot.setPersonalTimeLeftManually(hours, minutes, seconds);
  }

  private int getTime(String message, Pattern pattern) {
    int amount = 0;
    Matcher matcher = pattern.matcher(message);
    if(matcher.find()) {
      amount = Integer.parseInt(matcher.group(1));
    }
    return amount;
  }

  private boolean shouldSetPersonalTimer(HotSpot hotSpot) {
    if(hotSpot.getClockSetWhenAbleToBeRobbedPersonal() == null) {
      return false;
    }
    return hotSpot.getClockSetWhenAbleToBeRobbedPersonal().isAfter(LocalDateTime.now());
  }

  private boolean hotSpotIsAGangArea(HotSpot hotSpot) {
    return hotSpot.getUpdateMessage().equalsIgnoreCase(MessageCatchLanguage.GANGAREA_UPDATE);
  }

  private boolean updateMessageIsNull(HotSpot hotSpot) {
    return hotSpot.getUpdateMessage() == null;
  }

  private boolean moduleIsEnabled() {
    return addon.configuration().getBetterTimers().get().equals(true) || addon.configuration().enabled().get().equals(true)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }

}
