package com.gmail.vacrosdk.modules.Friheden.BetterApartments.House;

public class House {
  private final HouseIdentifier houseIdentifier;
  private final int houseNumber;

  public House(HouseIdentifier houseIdentifier, int houseNumber) {
    this.houseIdentifier = houseIdentifier;
    this.houseNumber = houseNumber;
  }
  public HouseIdentifier getIdentifier() {
    return houseIdentifier;
  }
  public int getHouseNumber() {
    return houseNumber;
  }

}
