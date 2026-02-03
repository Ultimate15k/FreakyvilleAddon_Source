package com.gmail.vacrosdk.modules.Friheden;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.util.I18n;
import net.labymod.api.util.logging.Logging;

public class Renter extends Command {

  private final FreakyvilleAddon addon;

  public Renter(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }


  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (!CheckIsModuleDisabled()) {
      LocalTime currentTime = LocalTime.now();
      LocalTime nextTime = findNextTime(currentTime);
      long[] timeUntilNextTime = calculateTimeUntilNextTime(currentTime, nextTime);

      addon.displayMessage(I18n.translate("Friheden.Interest.frihedsbanken.header"));
      addon.displayMessage(I18n.translate("Friheden.Interest.frihedsbanken.next_payout", nextTime));
      addon.displayMessage(I18n.translate("Friheden.Interest.frihedsbanken.time_until_payout", timeUntilNextTime[0], timeUntilNextTime[1]));


      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    LocalTime currentTime = LocalTime.now();
    LocalTime nextTime = findNextTime(currentTime);
    long minutesUntilNextTime = calculateMinutesUntilNextTime(currentTime, nextTime);

    Logging.getLogger().info("Current time: " + currentTime);
    Logging.getLogger().info("Next time: " + nextTime);
    Logging.getLogger().info("Minutes until the next time: " + minutesUntilNextTime);
  }

  public static LocalTime findNextTime(LocalTime currentTime) {
    LocalTime[] times = {
        LocalTime.of(0, 0),
        LocalTime.of(0, 45),
        LocalTime.of(1, 30),
        LocalTime.of(2, 15),
        LocalTime.of(3, 0),
        LocalTime.of(3, 45),
        LocalTime.of(4, 30),
        LocalTime.of(5, 15),
        LocalTime.of(6, 0),
        LocalTime.of(6, 45),
        LocalTime.of(7, 30),
        LocalTime.of(8, 15),
        LocalTime.of(9, 0),
        LocalTime.of(9, 45),
        LocalTime.of(10, 30),
        LocalTime.of(11, 15),
        LocalTime.of(12, 0),
        LocalTime.of(12, 45),
        LocalTime.of(13, 30),
        LocalTime.of(14, 15),
        LocalTime.of(15, 0),
        LocalTime.of(15, 45),
        LocalTime.of(16, 30),
        LocalTime.of(17, 15),
        LocalTime.of(18, 0),
        LocalTime.of(18, 45),
        LocalTime.of(19, 30),
        LocalTime.of(20, 15),
        LocalTime.of(21, 0),
        LocalTime.of(21, 45),
        LocalTime.of(22, 30),
        LocalTime.of(23, 15)
    };

    LocalTime nextTime = times[0];
    for (LocalTime time : times) {
      if (time.isAfter(currentTime)) {
        nextTime = time;
        break;
      }
    }

    return nextTime;
  }

  public static long[] calculateTimeUntilNextTime(LocalTime currentTime, LocalTime nextTime) {
    LocalDate currentDate = LocalDate.now();
    LocalDateTime currentDateTime = currentDate.atTime(currentTime);

    LocalDate nextDate = currentDate;
    LocalDateTime nextDateTime = nextDate.atTime(nextTime);

    if (nextDateTime.isBefore(currentDateTime)) {
      nextDate = nextDate.plusDays(1);
      nextDateTime = nextDate.atTime(nextTime);
    }

    long minutes = currentDateTime.until(nextDateTime, ChronoUnit.MINUTES);
    long seconds = currentDateTime.until(nextDateTime, ChronoUnit.SECONDS) % 60;

    return new long[]{ minutes, seconds };
  }

  public static long calculateMinutesUntilNextTime(LocalTime currentTime, LocalTime nextTime) {
    return currentTime.until(nextTime, ChronoUnit.MINUTES);
  }

  private boolean CheckIsModuleDisabled() {
    return addon.configuration().getRenterEnabled().get().equals(false) || addon.configuration().enabled().get().equals(false) || addon.configuration().getFrihedenEnabled().get().equals(false);
  }
}
