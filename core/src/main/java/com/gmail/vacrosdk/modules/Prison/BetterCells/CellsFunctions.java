package com.gmail.vacrosdk.modules.Prison.BetterCells;

import net.labymod.api.util.logging.Logging;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CellsFunctions {

  private static final String CSV_URL = "https://raw.githubusercontent.com/Ultimate15k/FreakyvilleAddon-Data/refs/heads/main/Cell_Data.csv";
  private static List<CSVRecord> csvRecords = new ArrayList<>(); // Store CSV records in memory

  // Method to preload the CSV data into memory
  public static String preloadCSV() {
    OkHttpClient client = new OkHttpClient();
    Logging.getLogger().info("Preloading CSV data from URL: " + CSV_URL);

    Request request = new Request.Builder()
        .url(CSV_URL)
        .build();

    try (Response response = client.newCall(request).execute()) {
      Logging.getLogger().info("Received response for CSV preload from: " + CSV_URL);

      if (!response.isSuccessful()) {
        Logging.getLogger().error("Unexpected code during CSV preload " + response);
        return "§cFejl: §fUkendt data - §7" + response;
      }

      assert response.body() != null;
      InputStream inputStream = response.body().byteStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader).getRecords();

      Logging.getLogger().info("CSV data preloaded successfully. Total records: " + csvRecords.size());
      return "§aGennemført: §fAntal celler: " + csvRecords.size();
    } catch (IOException e) {
      Logging.getLogger().error("IOException during CSV preload: " + e.getMessage());
      return "§cFejl: §f" + e.getMessage();
    }
  }

  public static String getCellDetails(String identifier, String number, String type) {
    Logging.getLogger().info("Looking up details for identifier: " + identifier + ", number: " + number);

    for (CSVRecord record : csvRecords) {
      String id = record.get("identifier");
      int firstCellNumber = Integer.parseInt(record.get("firstCellNumber"));
      int lastCellNumber = Integer.parseInt(record.get("lastCellNumber"));

      Logging.getLogger().debug("Checking record: identifier=" + id + ", firstCellNumber=" + firstCellNumber + ", lastCellNumber=" + lastCellNumber);

      // Check if identifier matches and number is within range
      if (id.equalsIgnoreCase(identifier) && Integer.parseInt(number) >= firstCellNumber && Integer.parseInt(number) <= lastCellNumber) {
        Logging.getLogger().info("Match found: Name=" + record.get("name") + ", Description=" + record.get("description"));
        if (type.equalsIgnoreCase("CellNumber")) {
          return String.format(record.get("name"));
        } else if (type.equalsIgnoreCase("Desc")) {
          return String.format(record.get("description"));
        } else {
          return String.format("Name: %s, Description: %s", record.get("name"), record.get("description"));
        }
      }
    }

    Logging.getLogger().warn("No matching cell found for identifier: " + identifier + " and number: " + number);
    return "No matching cell found.";
  }
}
