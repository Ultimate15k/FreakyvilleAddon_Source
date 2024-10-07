package com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.Area;

import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.House;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.HouseIdentifier;
import java.util.HashMap;
import java.util.Map;

public class HouseAreaManager {

  public HouseArea getHouseArea(House house) {
    HouseAreas[] areas = HouseAreas.values();
    for (HouseAreas area : areas) {
      HouseArea houseArea = area.getHouseArea();
      if(!identifierIsCorrect(house, houseArea.getIdentifier())) {
        continue;
      }
      if(getHouseNumbersInHouseArea(houseArea).containsKey(getHouseString(house))){
        return houseArea;
      }
    }
    return null;
  }

  private String getHouseString(House house) {
    return house.getIdentifier().getStringIdentifier().toLowerCase() + house.getHouseNumber();
  }

  private boolean identifierIsCorrect(House house, HouseIdentifier houseIdentifier) {
    return houseIdentifier.getStringIdentifier().equalsIgnoreCase(house.getIdentifier().getStringIdentifier());
  }

  public Map<String, Boolean> getHouseNumbersInHouseArea(HouseArea houseArea) {
    Map<String, Boolean> map = new HashMap<>();
    for (int i = houseArea.getFirstHouseNumber(); i <= houseArea.getLastHouseNumber(); i++) {
      map.put(houseArea.getIdentifier().getStringIdentifier().toLowerCase() + i, true);
    }
    return map;
  }

}
