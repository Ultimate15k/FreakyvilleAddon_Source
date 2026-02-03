package com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class HotSpot {
  private final String hotSpotName;
  private final String chatMessageCatch;
  private final String chatMessageCancel;
  private final String chatMessageUpdate;

  private final int hotSpotCoolDown;

  private LocalDateTime clockSetWhenAbleToBeRobbed;
  private LocalDateTime clockSetWhenAbleToBeRobbedPersonal;

  private final int coolDownWhenFailed;
  private final int robbingTimeFromStartToFinish;

  private final int personalCoolDownTime;

  public HotSpot(String name,
      String chatMessageCatch,
      String chatMessageCancel,
      String chatMessageUpdate,
      int timerInMinutes,
      int coolDownWhenFailedInMinutes,
      int robbingTimeFromStartToFinishInSeconds,
      int personalCoolDownInMinutes) {
    this.hotSpotName = name;
    this.chatMessageCatch = chatMessageCatch;
    this.chatMessageCancel = chatMessageCancel;
    this.chatMessageUpdate = chatMessageUpdate;
    this.hotSpotCoolDown = timerInMinutes;
    this.coolDownWhenFailed = coolDownWhenFailedInMinutes;
    this.robbingTimeFromStartToFinish = robbingTimeFromStartToFinishInSeconds;
    this.personalCoolDownTime = personalCoolDownInMinutes;
  }

  public String getCatchMessage() {
    return chatMessageCatch;
  }

  public String getConfirmMessage() {
    return chatMessageCancel;
  }

  public int getRobbingTimeFromStartToFinish() {
    return robbingTimeFromStartToFinish;
  }

  public void setRobbed(FreakyvilleAddon addon) {
    clockSetWhenAbleToBeRobbed = LocalDateTime.now().plusMinutes(hotSpotCoolDown);

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    Runnable task = () -> {
      if(addonIsEnabled(addon) && prisonIsEnabled(addon) && timerNotificationsAreEnabled(addon) && !playerIsOnGuard(addon)) {
        TextColor textColor = TextColor.color(addon.configuration().getMainTimerColor().get().get());
        addon.displayMessage(Component.translatable("Prison.BetterTimers.reminder", Component.text(hotSpotName), Component.text(getNotificationTime(addon))).color(textColor)
        );

      }
    };
    executor.schedule(task, calculateTime(addon), TimeUnit.MINUTES);
    executor.shutdown();
  }

  private boolean playerIsOnGuard(FreakyvilleAddon addon) {
    return addon.IsPlayerOnGuard();
  }

  private Boolean timerNotificationsAreEnabled(FreakyvilleAddon addon) {
    return addon.configuration().getTimerNotification().get();
  }

  private Boolean addonIsEnabled(FreakyvilleAddon addon) {
    return addon.configuration().enabled().get();
  }

  private Boolean prisonIsEnabled(FreakyvilleAddon addon) {
    return addon.configuration().getPrisonEnabled().get();
  }

  private int calculateTime(FreakyvilleAddon addon) {
    return getHotSpotCoolDown() - getNotificationTime(addon);
  }

  private Integer getNotificationTime(FreakyvilleAddon addon) {
    return addon.configuration().getTimerNotificationSlider().get();
  }

  public void setFailed() {
    clockSetWhenAbleToBeRobbed = LocalDateTime.now().plusMinutes(coolDownWhenFailed);
  }

  public void printGlobal(FreakyvilleAddon addon) {
    if(getTimeLeft() == null) {
      TextColor textColor = TextColor.color(addon.configuration().getUnknownTimerColor().get().get());
      addon.displayMessage(Component.translatable("Prison.BetterTimers.unknown", Component.text(hotSpotName)).color(textColor));
      return;
    }
    TextColor textColor = TextColor.color(addon.configuration().getKnownTimerColor().get().get());
    addon.displayMessage(
        Component.translatable(
            "Prison.BetterTimers.global",
            Component.text(hotSpotName),
            Component.text(getTimeLeft())
        ).color(textColor)
    );
  }

  public String printGlobal2() {
    if(getTimeLeft() == null) {
      return "Ukendt";
    }
    return getTimeLeft();
  }

  public void printPersonal(FreakyvilleAddon addon) {
    if(clockSetWhenAbleToBeRobbedPersonal == null) {
      TextColor textColor = TextColor.color(addon.configuration().getUnknownTimerColor().get().get());
      addon.displayMessage(
          Component.translatable(
              "Prison.BetterTimers.not_taken",
              Component.text(hotSpotName)
          ).color(textColor)
      );

      return;
    }
    TextColor textColor = TextColor.color(addon.configuration().getKnownTimerColor().get().get());
    addon.displayMessage(
        Component.translatable(
            "Prison.BetterTimers.personal",
            Component.text(hotSpotName),
            Component.text(Objects.requireNonNull(getPersonalTimeLeft()))
        ).color(textColor)
    );

  }

  public String getTimeLeft() {

    if(clockSetWhenAbleToBeRobbed == null) {
      return null;
    }
    Duration duration = Duration.between(LocalDateTime.now(), clockSetWhenAbleToBeRobbed);

    long minutes = duration.toMinutes();
    long seconds = duration.getSeconds();
    long subtractMinutes = minutes*60;

    seconds -= subtractMinutes;

    if(duration.isNegative()) {
      return "Kan tages";
    }

    return minutes + "m, " + seconds + "s";
  }

  private String getPersonalTimeLeft() {
    if(clockSetWhenAbleToBeRobbedPersonal == null) {
      return null;
    }

    LocalDateTime now = LocalDateTime.now();
    Duration duration = Duration.between(now, clockSetWhenAbleToBeRobbedPersonal);

    if (duration.isNegative()) {
      return "Kan tages";
    }

    long hours = duration.toHours();
    duration = duration.minusHours(hours);

    long minutes = duration.toMinutes();
    duration = duration.minusMinutes(minutes);

    long seconds = duration.getSeconds();

    String message = "";
    if (hours > 0) {
      message += hours + "t, ";
    }
    if (hours > 0 || minutes > 0) {
      message += minutes + "m, ";
    }
    message += seconds + "s";

    return message;
  }

  public String getHotSpotName() {
    return hotSpotName;
  }

  public String getUpdateMessage() {
    return chatMessageUpdate;
  }

  public void setTimeLeftManually(int hours, int minutes, int seconds) {
    clockSetWhenAbleToBeRobbed = LocalDateTime.now()
        .plusHours(hours)
        .plusMinutes(minutes)
        .plusSeconds(seconds);
  }

  public int getHotSpotCoolDown() {
    return hotSpotCoolDown;
  }

  public void startPersonalCoolDown() {
    clockSetWhenAbleToBeRobbedPersonal = LocalDateTime.now().plusMinutes(personalCoolDownTime);
  }

  public LocalDateTime getClockSetWhenAbleToBeRobbedPersonal() {
    return clockSetWhenAbleToBeRobbedPersonal;
  }

  public LocalDateTime getClockSetWhenAbleToBeRobbed() {
    return clockSetWhenAbleToBeRobbed;
  }

  public void setPersonalTimeLeftManually(int hours, int minutes, int seconds) {
    clockSetWhenAbleToBeRobbedPersonal = LocalDateTime.now()
        .plusHours(hours)
        .plusMinutes(minutes)
        .plusSeconds(seconds);
  }


}
