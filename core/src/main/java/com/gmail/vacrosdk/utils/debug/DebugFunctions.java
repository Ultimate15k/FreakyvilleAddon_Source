package com.gmail.vacrosdk.utils.debug;

public class DebugFunctions {
  private static boolean debugMode = false; // Initial value is false

  // Method to toggle debug mode
  public static void toggleDebugMode() {
    debugMode = !debugMode;
  }

  // Method to check if debug mode is enabled
  public static boolean isDebugMode() {
    return debugMode;
  }
}
