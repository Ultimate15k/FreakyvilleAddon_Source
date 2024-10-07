package com.gmail.vacrosdk.modules.Friheden.BetterApartments.House;

public enum HouseIdentifier {
  DIAMOND("a"),
  GOLD("ab"),
  VTOWER("z"),
  HA("ha"),
  HB("hb"),
  FAMILY_APARTMENTS("hc"),
  FAMILY_APARTMENTS_2("hb"),
  GG("gg"),
  M("m"),
  BH("bh"),
  MA("ma"),
  G("g"),
  BG("bg"),
  K("k"),
  BORG("borg");

  private final String stringIdentifier;

  HouseIdentifier(String stringIdentifier) {
    this.stringIdentifier = stringIdentifier;
  }

  public String getStringIdentifier() {
    return stringIdentifier;
  }
}
