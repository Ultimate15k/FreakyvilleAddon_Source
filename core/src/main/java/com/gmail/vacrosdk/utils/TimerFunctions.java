package com.gmail.vacrosdk.utils;

import net.labymod.api.util.logging.Logging;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TimerFunctions {

  private static final String folderPath = "FreakyvilleAddon/players/";
  //private static final String fileName = folderPath + "players.xml";

  public static void updatePlayerData(String playerName, String fieldType, int time) {
    try {
      String fileName = folderPath + playerName + ".xml";
      File xmlFile = new File(fileName);
      if (!xmlFile.exists()) {
        xmlFile.getParentFile().mkdirs();
        xmlFile.createNewFile();
        writeDefaultData(xmlFile,playerName);
      }
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(xmlFile);

      doc.getDocumentElement().normalize();

      NodeList playersList = doc.getElementsByTagName("players");
      boolean playerFound = false;

      for (int i = 0; i < playersList.getLength(); i++) {
        Node playerNode = playersList.item(i);

        if (playerNode.getNodeType() == Node.ELEMENT_NODE) {
          Element playerElement = (Element) playerNode;
          NodeList playerNameList = playerElement.getElementsByTagName("playerName");
          Element playerNameElement = (Element) playerNameList.item(0);
          String name = playerNameElement.getTextContent();

          if (name.equals(playerName)) {
            CheckPlayerFile(playerName);
            playerFound = true;
            writeDefaultDataV2(xmlFile,playerName);
            switch (fieldType) {
              case "kithead_reset" -> {
                Element fieldElement = (Element) playerElement.getElementsByTagName("kithead_date_time").item(0);
                fieldElement.setTextContent("Ingen data");

                Element fieldElement2 = (Element) playerElement.getElementsByTagName("kithead_start_date_time").item(0);
                fieldElement2.setTextContent("Ingen data");
              }
              case "investments" -> {
                // Update investments_date and investments_time
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
                LocalDateTime now = LocalDateTime.now();
                String currentDateAndTime = dtf.format(now);

                Element investmentsDateElement = (Element) playerElement.getElementsByTagName("investments_date").item(0);
                Element investmentsTimeElement = (Element) playerElement.getElementsByTagName("investments_time").item(0);

                investmentsDateElement.setTextContent(currentDateAndTime.substring(6, 16));
                investmentsTimeElement.setTextContent(currentDateAndTime.substring(0, 5));
              }
              case "kithead_date_time" -> {
                isDateAWeekAgo(playerName);
                // Update kithead_date_time
                String playerData = getPlayerData(playerName,"kithead_date_time");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
                LocalDateTime now = LocalDateTime.now();
                String currentDateAndTime = dtf.format(now);
                if(playerData.equals("Ingen data")) {
                  Element fieldElement2 = (Element) playerElement.getElementsByTagName("kithead_start_date_time").item(0);
                  fieldElement2.setTextContent(currentDateAndTime);
                }

                Element fieldElement = (Element) playerElement.getElementsByTagName("kithead_date_time").item(0);
                fieldElement.setTextContent(currentDateAndTime);
              }
              case "stats_heads_kit", "stats_heads_vv" -> {
                isDateAWeekAgo(playerName);
                Element fieldElement = (Element) playerElement.getElementsByTagName(fieldType).item(0);
                int currentValue = Integer.parseInt(fieldElement.getTextContent());
                fieldElement.setTextContent(String.valueOf(currentValue + 1));
              }
              case "chest_TankStation", "chest_MrX", "chest_Tree", "chest_SortPortal", "chest_Minen", "chest_Fitness" -> {
                if((time == 0)){
                  // Update chest
                  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
                  LocalDateTime now = LocalDateTime.now().plusHours(2);
                  String currentDateAndTime = dtf.format(now);

                  Element fieldElement = (Element) playerElement.getElementsByTagName(fieldType).item(0);
                  fieldElement.setTextContent(currentDateAndTime);
                } else {
                  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
                  LocalDateTime now = LocalDateTime.now().plusSeconds(time);
                  String currentDateAndTime = dtf.format(now);

                  Element fieldElement = (Element) playerElement.getElementsByTagName(fieldType).item(0);
                  fieldElement.setTextContent(currentDateAndTime);
                }
              }
            }
            break;
          }
        }
      }

      // If playerName is not found, create a new player entry
      if (!playerFound) {
        Element newPlayer = doc.createElement("players");

        Element playerNameElement = doc.createElement("playerName");
        playerNameElement.appendChild(doc.createTextNode(playerName));
        newPlayer.appendChild(playerNameElement);

        Element investmentsDateElement = doc.createElement("investments_date");
        investmentsDateElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(investmentsDateElement);

        Element investmentsTimeElement = doc.createElement("investments_time");
        investmentsTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(investmentsTimeElement);

        Element kitheadStartDateTimeElement = doc.createElement("kithead_start_date_time");
        kitheadStartDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(kitheadStartDateTimeElement);

        Element kitheadDateTimeElement = doc.createElement("kithead_date_time");
        kitheadDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(kitheadDateTimeElement);

        Element stats_kitHeadsElement = doc.createElement("stats_heads_kit");
        stats_kitHeadsElement.appendChild(doc.createTextNode("0"));
        newPlayer.appendChild(stats_kitHeadsElement);

        Element stats_vvHeadsElement = doc.createElement("stats_heads_vv");
        stats_vvHeadsElement.appendChild(doc.createTextNode("0"));
        newPlayer.appendChild(stats_vvHeadsElement);

        Element chest_tankStationDateTimeElement = doc.createElement("chest_TankStation");
        chest_tankStationDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(chest_tankStationDateTimeElement);

        Element chest_mrxDateTimeElement = doc.createElement("chest_MrX");
        chest_mrxDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(chest_mrxDateTimeElement);

        Element chest_treeDateTimeElement = doc.createElement("chest_Tree");
        chest_treeDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(chest_treeDateTimeElement);

        Element chest_sortportalDateTimeElement = doc.createElement("chest_SortPortal");
        chest_sortportalDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(chest_sortportalDateTimeElement);

        Element chest_mininDateTimeElement = doc.createElement("chest_Minen");
        chest_mininDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(chest_mininDateTimeElement);

        Element chest_fitnessDateTimeElement = doc.createElement("chest_Fitness");
        chest_fitnessDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        newPlayer.appendChild(chest_fitnessDateTimeElement);

        doc.getDocumentElement().appendChild(newPlayer);
      }

      // Remove whitespace nodes
      removeWhitespaceNodes(doc.getDocumentElement());

      // Write the updated XML file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File(fileName));
      transformer.transform(source, result);

      Logging.getLogger().info("Player data updated successfully.");

    } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
    }
  }

  private static void writeDefaultDataV2(File xmlFile, String playerName) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      Document doc;

      // Load the existing XML file if it exists, otherwise create a new one
      if (xmlFile.exists()) {
        doc = docBuilder.parse(xmlFile);
      } else {
        doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("players");
        doc.appendChild(rootElement);
      }

      // Check if the player already exists
      NodeList playersList = doc.getElementsByTagName("player");
      boolean playerExists = false;

      for (int i = 0; i < playersList.getLength(); i++) {
        Element player = (Element) playersList.item(i);
        String existingPlayerName = player.getElementsByTagName("playerName").item(0).getTextContent();
        if (existingPlayerName.equals(playerName)) {
          playerExists = true;
          break;
        }
      }

      // If the player does not exist, create a new player element
      if (!playerExists) {
        Element rootElement = doc.getDocumentElement();

        Element playerElement = doc.createElement("player");
        rootElement.appendChild(playerElement);

        Element playerNameElement = doc.createElement("playerName");
        playerNameElement.appendChild(doc.createTextNode(playerName));
        playerElement.appendChild(playerNameElement);

        Element investmentsDateElement = doc.createElement("investments_date");
        investmentsDateElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(investmentsDateElement);

        Element investmentsTimeElement = doc.createElement("investments_time");
        investmentsTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(investmentsTimeElement);

        Element kitheadStartDateTimeElement = doc.createElement("kithead_start_date_time");
        kitheadStartDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(kitheadStartDateTimeElement);

        Element kitheadDateTimeElement = doc.createElement("kithead_date_time");
        kitheadDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(kitheadDateTimeElement);

        Element statsKitHeadsElement = doc.createElement("stats_heads_kit");
        statsKitHeadsElement.appendChild(doc.createTextNode("0"));
        playerElement.appendChild(statsKitHeadsElement);

        Element statsVvHeadsElement = doc.createElement("stats_heads_vv");
        statsVvHeadsElement.appendChild(doc.createTextNode("0"));
        playerElement.appendChild(statsVvHeadsElement);

        Element chestTankStationDateTimeElement = doc.createElement("chest_TankStation");
        chestTankStationDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(chestTankStationDateTimeElement);

        Element chestMrxDateTimeElement = doc.createElement("chest_MrX");
        chestMrxDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(chestMrxDateTimeElement);

        Element chestTreeDateTimeElement = doc.createElement("chest_Tree");
        chestTreeDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(chestTreeDateTimeElement);

        Element chestSortportalDateTimeElement = doc.createElement("chest_SortPortal");
        chestSortportalDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(chestSortportalDateTimeElement);

        Element chestMininDateTimeElement = doc.createElement("chest_Minen");
        chestMininDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(chestMininDateTimeElement);

        Element chestFitnessDateTimeElement = doc.createElement("chest_Fitness");
        chestFitnessDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
        playerElement.appendChild(chestFitnessDateTimeElement);
      }

      // Write the content into the XML file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(xmlFile);
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.transform(source, result);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private static void writeDefaultData(File xmlFile,String playerName) {
    try {
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

      Document doc = docBuilder.newDocument();
      Element rootElement = doc.createElement("players");
      doc.appendChild(rootElement);

      Element playerElement = doc.createElement("players");
      rootElement.appendChild(playerElement);

      Element playerNameElement = doc.createElement("playerName");
      playerNameElement.appendChild(doc.createTextNode(playerName));
      playerElement.appendChild(playerNameElement);

      Element investmentsDateElement = doc.createElement("investments_date");
      investmentsDateElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(investmentsDateElement);

      Element investmentsTimeElement = doc.createElement("investments_time");
      investmentsTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(investmentsTimeElement);

      Element kitheadStartDateTimeElement = doc.createElement("kithead_start_date_time");
      kitheadStartDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(kitheadStartDateTimeElement);

      Element kitheadDateTimeElement = doc.createElement("kithead_date_time");
      kitheadDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(kitheadDateTimeElement);

      Element stats_kitHeadsElement = doc.createElement("stats_heads_kit");
      stats_kitHeadsElement.appendChild(doc.createTextNode("0"));
      playerElement.appendChild(stats_kitHeadsElement);

      Element stats_vvHeadsElement = doc.createElement("stats_heads_vv");
      stats_vvHeadsElement.appendChild(doc.createTextNode("0"));
      playerElement.appendChild(stats_vvHeadsElement);

      Element chest_tankStationDateTimeElement = doc.createElement("chest_TankStation");
      chest_tankStationDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(chest_tankStationDateTimeElement);

      Element chest_mrxDateTimeElement = doc.createElement("chest_MrX");
      chest_mrxDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(chest_mrxDateTimeElement);

      Element chest_treeDateTimeElement = doc.createElement("chest_Tree");
      chest_treeDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(chest_treeDateTimeElement);

      Element chest_sortportalDateTimeElement = doc.createElement("chest_SortPortal");
      chest_sortportalDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(chest_sortportalDateTimeElement);

      Element chest_mininDateTimeElement = doc.createElement("chest_Minen");
      chest_mininDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(chest_mininDateTimeElement);

      Element chest_fitnessDateTimeElement = doc.createElement("chest_Fitness");
      chest_fitnessDateTimeElement.appendChild(doc.createTextNode("Ingen data"));
      playerElement.appendChild(chest_fitnessDateTimeElement);

      // Write the content into XML file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(xmlFile);
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.transform(source, result);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void updateInvestmentsDateTime(String playerName, String date, String time) {
    try {
      String fileName = folderPath + playerName + ".xml";
      File xmlFile = new File(fileName);
      if (!xmlFile.exists()) {
        xmlFile.getParentFile().mkdirs();
        xmlFile.createNewFile();
        writeDefaultData(xmlFile,playerName);
      }
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(xmlFile);

      doc.getDocumentElement().normalize();

      NodeList playersList = doc.getElementsByTagName("players");

      for (int i = 0; i < playersList.getLength(); i++) {
        Node playerNode = playersList.item(i);

        if (playerNode.getNodeType() == Node.ELEMENT_NODE) {
          Element playerElement = (Element) playerNode;
          NodeList playerNameList = playerElement.getElementsByTagName("playerName");
          Element playerNameElement = (Element) playerNameList.item(0);
          String name = playerNameElement.getTextContent();

          if (name.equals(playerName)) {
            // Update investments_date
            Element investmentsDateElement = (Element) playerElement.getElementsByTagName("investments_date").item(0);
            investmentsDateElement.setTextContent(date);

            // Update investments_time
            Element investmentsTimeElement = (Element) playerElement.getElementsByTagName("investments_time").item(0);
            investmentsTimeElement.setTextContent(time);

            // Write the updated XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);

            Logging.getLogger().info("Investments date and time updated successfully.");
            return; // Exit the function after updating
          }
        }
      }

      // If playerName is not found, print an error message
      Logging.getLogger().error("Player '" + playerName + "' not found.");
    } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
    }
  }

  public static String getPlayerData(String playerName, String fieldType) {
    if(!playerFileExists(playerName)) {
      return null;
    }
    String fieldValue = null;
    try {
      String fileName = folderPath + playerName + ".xml";
      File xmlFile = new File(fileName);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(xmlFile);

      doc.getDocumentElement().normalize();

      NodeList playersList = doc.getElementsByTagName("players");

      for (int i = 0; i < playersList.getLength(); i++) {
        Element playerElement = (Element) playersList.item(i);
        NodeList playerNameList = playerElement.getElementsByTagName("playerName");
        Element playerNameElement = (Element) playerNameList.item(0);
        String name = playerNameElement.getTextContent();

        if (name.equals(playerName)) {
          if (fieldType.equals("investments")) {
            Element dateElement = (Element) playerElement.getElementsByTagName("investments_date").item(0);
            Element timeElement = (Element) playerElement.getElementsByTagName("investments_time").item(0);
            fieldValue = timeElement.getTextContent() + " " + dateElement.getTextContent();
          } else {
            Element fieldElement = (Element) playerElement.getElementsByTagName(fieldType).item(0);
            fieldValue = fieldElement.getTextContent();
          }
          break;
        }
      }
    } catch (ParserConfigurationException | SAXException | IOException e) {
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
    }
    return fieldValue;
  }

  public static String calculateTime(String playerName, String FieldType) {
    String storedDateTime = getPlayerData(playerName, FieldType);
    if (storedDateTime == null || storedDateTime.equals("Error: Player data file not found") || storedDateTime.equals("Error: Player not found") || storedDateTime.contains("Ingen data")) {
      return null;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    LocalDateTime storedDateTimeParsed = LocalDateTime.parse(storedDateTime, formatter);
    LocalDateTime currentDateTime = LocalDateTime.now();
    Duration duration = Duration.between(currentDateTime, storedDateTimeParsed);

    if (duration.isNegative()) {
      return "Kan tages";
    }

    // Convert duration to seconds
    long seconds = duration.getSeconds();
    long absSeconds = Math.abs(seconds);

    // Handle different units based on the duration
    long hours = TimeUnit.SECONDS.toHours(absSeconds);
    long minutes = TimeUnit.SECONDS.toMinutes(absSeconds) % 60;
    long remainingSeconds = absSeconds % 60;

    // Format the result based on the time units
    if (hours > 0) {
      return String.format("%d time, %d minutter og %d sekunder", hours, minutes, remainingSeconds);
    } else if (minutes > 0) {
      return String.format("%d minutter og %d sekunder", minutes, remainingSeconds);
    } else {
      return String.format("%d sekunder", remainingSeconds);
    }
  }

  public static String calculateInvestmentsTime(String playerName, String fieldType) {
    String storedDateTime = getPlayerData(playerName, fieldType);
    if (storedDateTime == null ||
        storedDateTime.equals("Error: Player data file not found") ||
        storedDateTime.equals("Error: Player not found") ||
        storedDateTime.equals("Ingen data")) {
      return "Ingen data";
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    LocalDateTime dateTime;
    try {
      dateTime = LocalDateTime.parse(storedDateTime, formatter);
    } catch (DateTimeParseException e) {
      return "Ugyldigt datoformat"; // "Invalid date format" in Danish
    }
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    String formattedDateTime = now.format(formatter2);

    if (storedDateTime.equals(formattedDateTime)) {
      return "0 minutter"; // "now" in Danish
    }

    Duration duration = Duration.between(dateTime, now);

    long days = duration.toDays();
    long hours = duration.toHours() % 24;
    long minutes = duration.toMinutes() % 60;

    // Translate units to Danish
    String daysStr = days == 1 ? "dag" : "dage";
    String hoursStr = hours == 1 ? "time" : "timer";
    String minutesStr = minutes == 1 ? "minut" : "minutter";

    StringBuilder result = new StringBuilder();
    if (days > 0) {
      result.append(days).append(" ").append(daysStr).append(" ");
    }
    if (hours > 0) {
      if (!result.isEmpty()) {
        result.append("og ");
      }
      result.append(hours).append(" ").append(hoursStr).append(" ");
    }
    if (minutes > 0) {
      if (!result.isEmpty()) {
        result.append("og ");
      }
      result.append(minutes).append(" ").append(minutesStr);
    }

    return result.toString();
  }


  public static boolean playerExists(String playerName, String fieldType) {
    String fileName = playerName + ".xml";
    File file = new File(folderPath + fileName);
    String data = getPlayerData(playerName,fieldType);
    if (data == null) {
      return false;
    }
    if (data.equalsIgnoreCase("Ingen data")) {
      return false;
    }

    return file.exists() && file.isFile();
  }

  public static boolean playerFileExists(String playerName) {
    String fileName = playerName + ".xml";
    File file = new File(folderPath + fileName);

    return file.exists() && file.isFile();
  }

  public static String[] getAllPlayerNames() {
    Set<String> namesSet = new HashSet<>();
    File folder = new File(folderPath);
    File[] files = folder.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.isFile()) {
          String fileName = file.getName();
          int index = fileName.lastIndexOf('.');
          if (index > 0) {
            String name = fileName.substring(0, index);
            namesSet.add(name);
          } else {
            namesSet.add(fileName); // If there's no file extension
          }
        }
      }
    }
    return namesSet.toArray(new String[0]);
  }

  public static boolean isDateOver24HoursAgo(String playerName, String fieldType) {
    String storedDateTime = getPlayerData(playerName, fieldType);
    if (storedDateTime == null || storedDateTime.equals("Error: Player data file not found") || storedDateTime.equals("Error: Player not found") || storedDateTime.contains("Ingen data")) {
      return false;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    LocalDateTime dateTime = LocalDateTime.parse(storedDateTime, formatter);
    LocalDateTime now = LocalDateTime.now();

    long hoursDifference = ChronoUnit.HOURS.between(dateTime, now);

    return hoursDifference >= 24;
  }



  public static String[] calculateAdjustedTime(int hours, int minutes, int seconds) {
    // Get the current local time
    LocalDateTime currentTime = LocalDateTime.now();

    // Add the provided time
    LocalDateTime adjustedTime = currentTime.plusHours(hours)
        .plusMinutes(minutes)
        .plusSeconds(seconds);
    // Subtract a day
    adjustedTime = adjustedTime.minusDays(1);

    // Formatting patterns
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter clockFormatter = DateTimeFormatter.ofPattern("HH:mm");

    // Format the adjusted time
    String date = adjustedTime.format(dateFormatter);
    String clock = adjustedTime.format(clockFormatter);
    String dateAndClock = adjustedTime.format(clockFormatter) + " " + adjustedTime.format(dateFormatter);

    return new String[]{date, clock, dateAndClock};
  }

  public static String formatPlayerTime(String playerData) {
    if(playerData.contains("Ingen data")) {
      return "Ingen data";
    }
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(playerData, inputFormatter);
    return dateTime.format(outputFormatter);
  }

  // Remove whitespace nodes
  private static void removeWhitespaceNodes(Node node) {
    NodeList children = node.getChildNodes();
    for (int i = children.getLength() - 1; i >= 0; i--) {
      Node child = children.item(i);
      if (child.getNodeType() == Node.TEXT_NODE && child.getTextContent().trim().isEmpty()) {
        node.removeChild(child);
      } else if (child.getNodeType() == Node.ELEMENT_NODE) {
        removeWhitespaceNodes(child);
      }
    }
  }

  public static LocalDateTime subtractTime(String time) {
    String[] parts = time.split(", ");
    int hours = 0;
    int minutes = 0;

    for (String part : parts) {
      if (part.contains("time")) {
        hours = Integer.parseInt(part.split(" ")[0]);
      } else if (part.contains("minutter")) {
        minutes = Integer.parseInt(part.split(" ")[0]);
      }
    }

    LocalDateTime now = LocalDateTime.now();
    return now.minusHours(hours).minusMinutes(minutes);
  }

  public static boolean isDateAWeekAgo(String playerName) {
    String playerData = getPlayerData(playerName, "kithead_start_date_time");
    if (playerData.equalsIgnoreCase("Ingen data")) {
      return false;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    LocalDateTime dateTime = LocalDateTime.parse(playerData, formatter);
    LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
    boolean isOneWeekAgoOrMore = dateTime.isBefore(oneWeekAgo) || dateTime.isEqual(oneWeekAgo);
    if (isOneWeekAgoOrMore) {
      updatePlayerData(playerName, "kithead_reset", 0);
    }
    return isOneWeekAgoOrMore;
  }

  public static void CheckPlayerFile(String playerName) {
    try {
      // Load or create XML file
      File playerFile = new File(folderPath + playerName + ".xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc;

      if (playerFile.exists()) {
        doc = dBuilder.parse(playerFile);
        doc.getDocumentElement().normalize();
      } else {
        // Create a new document if the file doesn't exist
        doc = dBuilder.newDocument();
        Element rootElement = doc.createElement("player");
        doc.appendChild(rootElement);
      }

      Element rootElement = doc.getDocumentElement();

      // Method to check and add missing elements
      checkAndAddElement(doc, rootElement, "playerName", playerName);
      checkAndAddElement(doc, rootElement, "investments_date", "Ingen data");
      checkAndAddElement(doc, rootElement, "investments_time", "Ingen data");
      checkAndAddElement(doc, rootElement, "kithead_start_date_time", "Ingen data");
      checkAndAddElement(doc, rootElement, "kithead_date_time", "Ingen data");
      checkAndAddElement(doc, rootElement, "stats_heads_kit", "0");
      checkAndAddElement(doc, rootElement, "stats_heads_vv", "0");
      checkAndAddElement(doc, rootElement, "chest_TankStation", "Ingen data");
      checkAndAddElement(doc, rootElement, "chest_MrX", "Ingen data");
      checkAndAddElement(doc, rootElement, "chest_Tree", "Ingen data");
      checkAndAddElement(doc, rootElement, "chest_SortPortal", "Ingen data");
      checkAndAddElement(doc, rootElement, "chest_Minen", "Ingen data");
      checkAndAddElement(doc, rootElement, "chest_Fitness", "Ingen data");

      // Save the updated document back to the file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(playerFile);
      transformer.transform(source, result);

      System.out.println("Player file updated successfully.");

    } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
      Logging.getLogger().error("Exception occurred: " + e.getMessage());
      for (StackTraceElement element : e.getStackTrace()) {
        Logging.getLogger().error(element.toString());
      }
    }
  }

  private static void checkAndAddElement(Document doc, Element rootElement, String tagName, String defaultValue) {
    NodeList nodeList = rootElement.getElementsByTagName(tagName);
    if (nodeList.getLength() == 0) {
      Element newElement = doc.createElement(tagName);
      newElement.appendChild(doc.createTextNode(defaultValue));
      rootElement.appendChild(newElement);
    }
  }

}