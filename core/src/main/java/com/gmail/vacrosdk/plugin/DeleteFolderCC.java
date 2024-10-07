package com.gmail.vacrosdk.plugin;

import com.gmail.vacrosdk.FreakyvilleAddon;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.util.logging.Logging;
import java.io.File;

public class DeleteFolderCC extends Command {

  private final FreakyvilleAddon addon;
  private static final String folderPath = "FreakyvilleAddon/";

  public DeleteFolderCC(String prefix, FreakyvilleAddon addon) {
    super(prefix);
    this.addon = addon;
  }

  @Override
  public boolean execute(String s, String[] strings) {
    boolean NeedDeleteConfirm = DeleteFolderC.NeedDeleteConfirm;
    if (NeedDeleteConfirm) {
      addon.displayMessage("§cDu har hermed slettet alt data vedr FreakyvilleAddon");
      deleteFolder(folderPath);
      DeleteFolderC.NeedDeleteConfirm = false;
    } else {
      return false;
    }
    return true;
  }

  private void deleteFolder(String folderPath) {
    try {
      File folder = new File(folderPath);
      if (folder.exists()) {
        File[] files = folder.listFiles();
        if (files != null) {
          for (File file : files) {
            if (file.isDirectory()) {
              deleteFolder(file.getAbsolutePath());
            } else {
              file.delete();
            }
          }
        }
        folder.delete();
        Logging.getLogger().info("Folder " + folderPath + " deleted successfully.");
      } else {
        Logging.getLogger().error("Folder " + folderPath + " does not exist.");
      }
    } catch (Exception e) {
      Logging.getLogger().error("Error occurred while deleting folder: " + e.getMessage());
    }
  }

}
