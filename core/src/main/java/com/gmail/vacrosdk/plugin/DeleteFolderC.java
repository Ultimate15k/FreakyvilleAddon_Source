package com.gmail.vacrosdk.plugin;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.util.logging.Logging;

public class DeleteFolderC extends Command {

  private static final Logging LOGGER = Logging.getLogger();
  public static boolean NeedDeleteConfirm = false;
  private final FreakyvilleAddon addon;

  public DeleteFolderC(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] strings) {
    addon.displayMessage("§aEr du sikker på, at du vil slette alle data vedr FreakyvilleAddon?");
    addon.displayMessage("§aSkriv §b/confirm §afor at bekræfte, eller vent §e15 sekunder §afor at annullere.");
    NeedDeleteConfirm = true;

    new Thread(() -> {
      try {
        Thread.sleep(15000); // Sleep for 15 seconds (15,000 milliseconds)
        if (NeedDeleteConfirm) {
          addon.displayMessage("§cTid udløbet. Skriv commanden igen.");
        }
        NeedDeleteConfirm = false;
      } catch (InterruptedException e) {
        LOGGER.error("Thread interrupted while waiting for delete confirmation: " + e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
          LOGGER.error(element.toString());
        }
      }
    }).start();

    return true;
  }

}
