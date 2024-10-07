package com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.Area;

import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.HouseIdentifier;

public class HouseArea {
  private final HouseIdentifier houseIdentifier;
  private final int firstHouseNumber;
  private final int lastHouseNumber;
  private final String stringName;
  private final String stringDes;
  private final String houseReq;

  public HouseArea(int firstHouseNumber, int lastHouseNumber, HouseIdentifier houseIdentifier, String name, String description, String requirements) {
    this.houseIdentifier = houseIdentifier;
    this.firstHouseNumber = firstHouseNumber;
    this.lastHouseNumber = lastHouseNumber;
    this.stringName = name;
    this.stringDes = description;
    this.houseReq = requirements;
  }

  public String getStringName() {
    return stringName;
  }
  public String getStringDescription() {
    return stringDes;
  }
  public int getFirstHouseNumber() {
    return firstHouseNumber;
  }
  public int getLastHouseNumber() {
    return lastHouseNumber;
  }
  public HouseIdentifier getIdentifier() {
    return houseIdentifier;
  }
  public String getHouseRequirements() {
    return houseReq;
  }

}