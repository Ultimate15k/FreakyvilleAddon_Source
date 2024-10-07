package com.gmail.vacrosdk.plugin.Stats;

import net.labymod.api.util.logging.Logging;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class StatsFunctions {

  private static final String folderPath = "FreakyvilleAddon/stats";

  public static void addDateToFile(String playerName, String type) {
    try {
      // Check if the folder exists, create it if not
      File folder = new File(folderPath);
      if (!folder.exists()) {
        folder.mkdirs(); // Creates directory and necessary parent directories
      }

      String fileName = folderPath + "/" + playerName + ".csv";
      File file = new File(fileName);
      boolean fileExists = file.exists();

      int lineCount = 0;
      if (fileExists) {
        lineCount = countLines(fileName);
      }

      // If file exists and has more than 10 lines, delete the top line (excluding header)
      if (fileExists && lineCount > 10) {
        deleteSecondLine(playerName);
      }

      FileWriter csvWriter = new FileWriter(fileName, true);
      if (!fileExists || lineCount == 0) {
        // If file doesn't exist or is empty, write default header data
        csvWriter.append("clock,date,type\n");
      }

      SimpleDateFormat clockFormat = new SimpleDateFormat("HH:mm:ss");
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
      String currentTime = clockFormat.format(new Date());
      String currentDate = dateFormat.format(new Date());
      csvWriter.append(currentTime);
      csvWriter.append(",").append(currentDate);
      csvWriter.append(",").append(type);
      csvWriter.append("\n");
      csvWriter.flush();
      csvWriter.close();
      System.out.println("Date added to file: " + fileName);
    } catch (IOException e) {
      System.out.println("An error occurred while adding date to file: " + e.getMessage());
    }
  }

  private static int countLines(String fileName) throws IOException {
    int lineCount = 0;
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    while (reader.readLine() != null) lineCount++;
    reader.close();
    return lineCount;
  }

  public static List<String> getDatesForType(String playerName, String type) {
    List<String> dates = new ArrayList<>();
    try {
      String fileName = folderPath + "/" + playerName + ".csv";
      BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
      String row;
      SimpleDateFormat dateTimeFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
      while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        if (data.length >= 3 && data[2].trim().equals(type)) {
          String dateTimeString = data[0].trim() + " " + data[1].trim();
          Date dateTime = dateTimeFormat.parse(dateTimeString);
          dates.add(dateTimeFormat.format(dateTime));
        }
      }
      csvReader.close();
    } catch (IOException | java.text.ParseException e) {
      System.out.println("An error occurred while reading file: " + e.getMessage());
    }
    return dates;
  }

  public static void deleteSecondLine(String playerName) {
    // Construct the file path
    String filePath = folderPath + "/" + playerName + ".csv";

    // Create a temporary file to write the modified content
    Path tempFile = Paths.get(folderPath, "temp.csv");

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
        BufferedWriter writer = Files.newBufferedWriter(tempFile)) {

      // Skip the first line
      String line = reader.readLine();
      writer.write(line);
      writer.newLine();

      // Skip the second line (delete it)
      reader.readLine();

      // Copy the remaining lines
      while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.newLine();
      }

    } catch (IOException e) {
      Logging.getLogger().error("Error while deleting second line from file: " + filePath + " - " + e.getMessage());
      for (StackTraceElement element : e.getStackTrace()) {
        Logging.getLogger().error(element.toString());
      }
    }

    // Replace the original file with the temporary file
    try {
      Files.move(tempFile, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      Logging.getLogger().error("Error replacing original file with temp file: " + filePath + " - " + e.getMessage());
      for (StackTraceElement element : e.getStackTrace()) {
        Logging.getLogger().error(element.toString());
      }
    }
  }



}
