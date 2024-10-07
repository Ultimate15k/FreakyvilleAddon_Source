package com.gmail.vacrosdk.utils;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VersionChecker {

  private final FreakyvilleAddon addon;

  public VersionChecker(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  public static String getLatestVersion(String owner, String repo) {
    try {
      String apiUrl = "https://api.github.com/repos/" + owner + "/" + repo + "/releases/latest";
      URL url = new URL(apiUrl);

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Accept", "application/json");

      int responseCode = connection.getResponseCode();

      if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }

        in.close();

        String versionJson = response.toString();

        String latestVersionWithV = versionJson.split("\"tag_name\":\"")[1].split("\",")[0];
        return latestVersionWithV.substring(1);
      } else {
        System.out.println("Failed to get the latest version. Response Code: " + responseCode);
      }
    } catch (IOException e) {
      System.out.println("An error occurred: " + e.getMessage());
    }

    return null;
  }


  public void checkVersion() {
    String owner = "ultimate15k";
    String repo = "FreakyVilleAddon_Release";

    String latestVersion = getLatestVersion(owner, repo);
    String currentVersion = String.valueOf(addon.addonInfo().getVersion());

    if (latestVersion != null) {
      System.out.println("Latest addon version: " + latestVersion);
      System.out.println("Current addon version: " + currentVersion);

      if (latestVersion.equals(currentVersion)) {
        addon.displayMessage("§aDu har den nyeste version");
        System.out.println("Your application is up to date.");
        System.out.println("Latest addon version: " + latestVersion);
        System.out.println("Current addon version: " + currentVersion);
      } else if (compareVersions(currentVersion, latestVersion) < 0) {
        addon.displayMessage("§aEn ny version er tilgængelig");
        addon.displayMessage("§bDiscord: §fhttps://discord.gg/Eg4ARCsQbD");
        System.out.println("A new version is available. Please update!");
        System.out.println("Latest addon version: " + latestVersion);
        System.out.println("Current addon version: " + currentVersion);
      } else {
        addon.displayMessage("§6Din version er højere end udgivet!");
        System.out.println("Your version is higher than the released version.");
        System.out.println("Latest addon version: " + latestVersion);
        System.out.println("Current addon version: " + currentVersion);
      }

    } else {
      System.out.println("Failed to retrieve the addon version.");
      System.out.println("Current addon version: " + currentVersion);
    }
  }

  private int compareVersions(String version1, String version2) {
    // Assuming versions are in the format "v1.7.1" or similar
    version1 = version1.replace("v", "");
    version2 = version2.replace("v", "");

    String[] parts1 = version1.split("\\.");
    String[] parts2 = version2.split("\\.");

    for (int i = 0; i < Math.min(parts1.length, parts2.length); i++) {
      int partComparison = Integer.compare(Integer.parseInt(parts1[i]), Integer.parseInt(parts2[i]));
      if (partComparison != 0) {
        return partComparison;
      }
    }

    return Integer.compare(parts1.length, parts2.length);
  }
}
