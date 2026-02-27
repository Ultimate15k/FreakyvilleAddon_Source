package com.gmail.vacrosdk.utils;

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

public class CSVFunctions {

  private static final Logging LOGGER = Logging.getLogger();

  private static final String CSV_URL =
      "https://raw.githubusercontent.com/Ultimate15k/FreakyvilleAddon-Data/refs/heads/main/Cell_Data.csv";

  private static List<CSVRecord> csvRecords = new ArrayList<>();

  public static String preloadCSV() {
    OkHttpClient client = new OkHttpClient();
    LOGGER.info("Preloading CSV data from URL: " + CSV_URL);

    Request request = new Request.Builder()
        .url(CSV_URL)
        .build();

    try (Response response = client.newCall(request).execute()) {
      LOGGER.info("Received response for CSV preload from: " + CSV_URL);

      if (!response.isSuccessful()) {
        LOGGER.error("Unexpected code during CSV preload " + response);
        return "§cFejl: §fUkendt data - §7" + response;
      }

      assert response.body() != null;
      InputStream inputStream = response.body().byteStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

      CSVFormat format = CSVFormat.DEFAULT.builder()
          .setHeader()
          .setSkipHeaderRecord(true)
          .build();

      csvRecords = format.parse(reader).getRecords();

      LOGGER.info("CSV data preloaded successfully. Total records: " + csvRecords.size());
      return "§aGennemført: §fAntal celler: " + csvRecords.size();

    } catch (IOException e) {
      LOGGER.error("IOException during CSV preload: " + e.getMessage());
      return "§cFejl: §f" + e.getMessage();
    }
  }

  public static String getCellDetails(String identifier, String number, String type) {
    LOGGER.info("Looking up details for identifier: " + identifier + ", number: " + number);

    for (CSVRecord record : csvRecords) {
      String id = record.get("identifier");
      int firstCellNumber = Integer.parseInt(record.get("firstCellNumber"));
      int lastCellNumber = Integer.parseInt(record.get("lastCellNumber"));

      LOGGER.debug("Checking record: identifier=" + id
          + ", firstCellNumber=" + firstCellNumber
          + ", lastCellNumber=" + lastCellNumber);

      int cellNumber = Integer.parseInt(number); // (lille bonus: parse én gang)

      if (id.equalsIgnoreCase(identifier)
          && cellNumber >= firstCellNumber
          && cellNumber <= lastCellNumber) {

        LOGGER.info("Match found: Name=" + record.get("name")
            + ", Description=" + record.get("description"));

        if (type.equalsIgnoreCase("CellNumber")) {
          return record.get("name");
        } else if (type.equalsIgnoreCase("Desc")) {
          return record.get("description");
        } else {
          return "Name: " + record.get("name") + ", Description: " + record.get("description");
        }
      }
    }

    LOGGER.warn("No matching cell found for identifier: " + identifier + " and number: " + number);
    return "No matching cell found.";
  }
}