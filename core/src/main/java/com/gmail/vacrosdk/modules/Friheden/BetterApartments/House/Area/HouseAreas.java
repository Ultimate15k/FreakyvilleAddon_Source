package com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.Area;

import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.HouseIdentifier;

public enum HouseAreas {
  DIA_ETAGE_1(new HouseArea(1, 5, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 1", "Borger")),
  DIA_ETAGE_2(new HouseArea(6, 11, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 2", "Borger")),
  DIA_ETAGE_3(new HouseArea(12, 14, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 3", "Borger")),
  DIA_ETAGE_3_1(new HouseArea(57, 59, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 3", "Borger")),
  DIA_ETAGE_4(new HouseArea(15, 20, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 4", "Borger")),
  DIA_ETAGE_5(new HouseArea(21, 26, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 5", "Borger")),
  DIA_ETAGE_6(new HouseArea(27, 32, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 6", "Borger")),
  DIA_ETAGE_7(new HouseArea(33, 38, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 7", "Borger")),
  DIA_ETAGE_8(new HouseArea(39, 44, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 8", "Borger")),
  DIA_ETAGE_9(new HouseArea(45, 50, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 9", "Borger")),
  DIA_ETAGE_10(new HouseArea(51, 53, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 10", "Borger")),
  DIA_ETAGE_11(new HouseArea(54, 56, HouseIdentifier.DIAMOND, "Diamond Lejligheder", "Etage 11", "Borger")),

  GOLD_ETAGE_1(new HouseArea(1, 10, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 1", "Borger")),
  GOLD_ETAGE_2(new HouseArea(11, 20, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 2", "Borger")),
  GOLD_ETAGE_3(new HouseArea(21, 30, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 3", "Borger")),
  GOLD_ETAGE_4(new HouseArea(31, 40, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 4", "Borger")),
  GOLD_ETAGE_5(new HouseArea(41, 50, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 5", "Borger")),
  GOLD_ETAGE_6(new HouseArea(51, 60, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 6", "Borger")),
  GOLD_ETAGE_7(new HouseArea(61, 70, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 7", "Borger")),
  GOLD_ETAGE_8(new HouseArea(71, 80, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 8", "Borger")),
  GOLD_ETAGE_9(new HouseArea(81, 90, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 9", "Borger")),
  GOLD_ETAGE_10(new HouseArea(91, 100, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 10", "Borger")),
  GOLD_ETAGE_11(new HouseArea(101, 110, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 11", "Borger")),
  GOLD_ETAGE_12(new HouseArea(111, 120, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 12", "Borger")),
  GOLD_ETAGE_13(new HouseArea(121, 130, HouseIdentifier.GOLD, "Gold Lejligheder", "Etage 13", "Borger")),

  VTOWER_ETAGE_1(new HouseArea(1, 3, HouseIdentifier.VTOWER, "V-Tower", "Etage 1", "Løsladt")),
  VTOWER_ETAGE_2(new HouseArea(4, 6, HouseIdentifier.VTOWER, "V-Tower", "Etage 2", "Løsladt")),
  VTOWER_ETAGE_3(new HouseArea(7, 9, HouseIdentifier.VTOWER, "V-Tower", "Etage 3", "Løsladt")),
  VTOWER_ETAGE_4(new HouseArea(10, 12, HouseIdentifier.VTOWER, "V-Tower", "Etage 4", "Løsladt")),
  VTOWER_ETAGE_5(new HouseArea(13, 15, HouseIdentifier.VTOWER, "V-Tower", "Etage 5", "Løsladt")),

  //FAMILIE HUSE (Lvl 1+)
  FAMILY_HOUSE(new HouseArea(27, 50, HouseIdentifier.HA, "Familie Huse", "Station 6", "Familie Lvl 1+")),
  FAMILY_HOUSE_2(new HouseArea(14, 19, HouseIdentifier.HB, "Familie Huse", "Station 6", "Familie Lvl 1+")),
  FAMILY_HOUSE_3(new HouseArea(4, 4, HouseIdentifier.HB, "YOUTUBE AVENUE", "Youtube avenue", "Familie Lvl 1+")),
  FAMILY_HOUSE_4(new HouseArea(20, 24, HouseIdentifier.HA, "Familie Huse", "Hospitalet", "Familie Lvl 1+")),
  FAMILY_HOUSE_5(new HouseArea(7, 17, HouseIdentifier.HA, "Familie Huse", "Youtube avenue", "Familie Lvl 1+")),
  FAMILY_HOUSE_6(new HouseArea(1, 6, HouseIdentifier.HA, "Familie Huse", "Station 4", "Familie Lvl 1+")),
  FAMILY_HOUSE_7(new HouseArea(1, 3, HouseIdentifier.HB, "Familie Huse", "Station 4", "Familie Lvl 1+")),

  //FAMILIE HUSE (Lvl 8+)
  FAMILY_HOUSE_8(new HouseArea(1, 8, HouseIdentifier.K, "Familie Huse (Med Kælder)", "Station 4", "Familie Lvl 8+")),
  FAMILY_HOUSE_9(new HouseArea(9, 10, HouseIdentifier.K, "Familie Huse (Uden Kælder)", "Station 4", "Familie Lvl 8+")),
  FAMILY_HOUSE_10(new HouseArea(11, 13, HouseIdentifier.K, "Familie Rækkehus", "Station 4", "Familie Lvl 8+")),
  FAMILY_HOUSE_11(new HouseArea(14, 17, HouseIdentifier.K, "Familie Huse (Uden Kælder)", "Station 4", "Familie Lvl 8+")),

  //FAMILIE LEJLIGHEDER
  FAMILY_APARTMENTS(new HouseArea(1, 10, HouseIdentifier.FAMILY_APARTMENTS, "Familie Lejligheder", "Station 6", "Familie Lvl 1+")),
  FAMILY_APARTMENTS_2(new HouseArea(6, 13, HouseIdentifier.FAMILY_APARTMENTS_2, "Familie Lejligheder", "Station 6", "Familie Lvl 1+")),

  //No Pvp Ghetto
  NO_PVP_GHETTO(new HouseArea(1, 33, HouseIdentifier.GG, "No pvp ghetto", "Etage 1", "Løsladt")),
  NO_PVP_GHETTO_2(new HouseArea(34, 66, HouseIdentifier.GG, "No pvp ghetto", "Etage 2", "Løsladt")),
  NO_PVP_GHETTO_3(new HouseArea(67, 100, HouseIdentifier.GG, "No pvp ghetto", "Etage 3", "Løsladt")),
  NO_PVP_GHETTO_4(new HouseArea(101, 134, HouseIdentifier.GG, "No pvp ghetto", "Etage 4", "Løsladt")),
  NO_PVP_GHETTO_5(new HouseArea(135, 168, HouseIdentifier.GG, "No pvp ghetto", "Etage 5", "Løsladt")),
  NO_PVP_GHETTO_6(new HouseArea(169, 202, HouseIdentifier.GG, "No pvp ghetto", "Etage 6", "Løsladt")),
  NO_PVP_GHETTO_7(new HouseArea(203, 236, HouseIdentifier.GG, "No pvp ghetto", "Etage 7", "Løsladt")),
  NO_PVP_GHETTO_8(new HouseArea(237, 270, HouseIdentifier.GG, "No pvp ghetto", "Etage 8", "Løsladt")),

  //Gult lejlighedskompleks
  YELLOW_COMPLEX(new HouseArea(253, 264, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 1", "Tilflytter")),
  YELLOW_COMPLEX_2(new HouseArea(265, 276, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 2", "Tilflytter")),
  YELLOW_COMPLEX_3(new HouseArea(277, 288, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 3", "Tilflytter")),
  YELLOW_COMPLEX_4(new HouseArea(289, 300, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 4", "Tilflytter")),
  YELLOW_COMPLEX_5(new HouseArea(307, 318, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 5", "Tilflytter")),
  YELLOW_COMPLEX_6(new HouseArea(319, 330, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 6", "Tilflytter")),
  YELLOW_COMPLEX_7(new HouseArea(331, 342, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 7", "Tilflytter")),
  YELLOW_COMPLEX_8(new HouseArea(343, 354, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 8", "Tilflytter")),
  YELLOW_COMPLEX_9(new HouseArea(361, 372, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 9", "Tilflytter")),
  YELLOW_COMPLEX_10(new HouseArea(373, 384, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 10", "Tilflytter")),
  YELLOW_COMPLEX_11(new HouseArea(385, 396, HouseIdentifier.M, "Gult lejlighedskompleks", "Etage 11", "Tilflytter")),

  PURPLE_COMPLEX(new HouseArea(109, 120, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 1", "Tilflytter")),
  PURPLE_COMPLEX_2(new HouseArea(121, 132, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 2", "Tilflytter")),
  PURPLE_COMPLEX_3(new HouseArea(133, 144, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 3", "Tilflytter")),
  PURPLE_COMPLEX_4(new HouseArea(145, 156, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 4", "Tilflytter")),
  PURPLE_COMPLEX_5(new HouseArea(157, 168, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 5", "Tilflytter")),
  PURPLE_COMPLEX_6(new HouseArea(169, 180, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 6", "Tilflytter")),
  PURPLE_COMPLEX_7(new HouseArea(181, 192, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 7", "Tilflytter")),
  PURPLE_COMPLEX_8(new HouseArea(193, 204, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 8", "Tilflytter")),
  PURPLE_COMPLEX_9(new HouseArea(205, 216, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 9", "Tilflytter")),
  PURPLE_COMPLEX_10(new HouseArea(217, 228, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 10", "Tilflytter")),
  PURPLE_COMPLEX_11(new HouseArea(229, 240, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 11", "Tilflytter")),
  PURPLE_COMPLEX_12(new HouseArea(241, 252, HouseIdentifier.M, "Lilla lejlighedskompleks", "Etage 12", "Tilflytter")),

  //Bade Hotel
  BADEHOTEL(new HouseArea(1, 14, HouseIdentifier.BH, "Badehotellet", "Etage 1", "Donator Rank")),
  BADEHOTEL_2(new HouseArea(15, 28, HouseIdentifier.BH, "Badehotellet", "Etage 2", "Donator Rank")),
  BADEHOTEL_3(new HouseArea(29, 42, HouseIdentifier.BH, "Badehotellet", "Etage 3", "Donator Rank")),
  BADEHOTEL_4(new HouseArea(43, 56, HouseIdentifier.BH, "Badehotellet", "Etage 4", "Donator Rank")),
  BADEHOTEL_5(new HouseArea(57, 70, HouseIdentifier.BH, "Badehotellet", "Etage 5", "Donator Rank")),
  BADEHOTEL_6(new HouseArea(71, 84, HouseIdentifier.BH, "Badehotellet", "Etage 6", "Donator Rank")),
  BADEHOTEL_7(new HouseArea(85, 98, HouseIdentifier.BH, "Badehotellet", "Etage 7", "Donator Rank")),
  BADEHOTEL_8(new HouseArea(99, 112, HouseIdentifier.BH, "Badehotellet", "Etage 8", "Donator Rank")),
  BADEHOTEL_9(new HouseArea(113, 126, HouseIdentifier.BH, "Badehotellet", "Etage 9", "Donator Rank")),
  BADEHOTEL_10(new HouseArea(127, 140, HouseIdentifier.BH, "Badehotellet", "Etage 10", "Donator Rank")),
  BADEHOTEL_11(new HouseArea(141, 154, HouseIdentifier.BH, "Badehotellet", "Etage 11", "Donator Rank")),

  //Freak Enterprise
  ENTERPRISE(new HouseArea(1, 14, HouseIdentifier.MA, "Freak Enterprise", "Etage 1", "Forbryder Rank")),
  ENTERPRISE_2(new HouseArea(15, 28, HouseIdentifier.MA, "Freak Enterprise", "Etage 2", "Forbryder Rank")),
  ENTERPRISE_3(new HouseArea(29, 42, HouseIdentifier.MA, "Freak Enterprise", "Etage 3", "Forbryder Rank")),
  ENTERPRISE_4(new HouseArea(43, 50, HouseIdentifier.MA, "Freak Enterprise", "Etage 4", "Forbryder Rank")),

  //Pvp Ghetto
  PVP_GHETTO(new HouseArea(1, 644, HouseIdentifier.G, "Pvp Ghetto", "Ingen pt", "Løsladt")),

  // Andre
  BORG(new HouseArea(1, 1, HouseIdentifier.BORG, "Borgmester Lejlighed", "Borgmester Lejlighed", "Borgmester Rank")),
  BYGGEGRUNDE(new HouseArea(1, 23, HouseIdentifier.BG, "Bygge Grunde", "Ingen pt", "Familie Lvl 10+"));


  private final HouseArea houseArea;

  HouseAreas(HouseArea houseArea) {
    this.houseArea = houseArea;
  }

  public HouseArea getHouseArea() {
    return houseArea;
  }

  public int getFirstHouseNumber() {
    return houseArea.getFirstHouseNumber();
  }

  public int getLastHouseNumber() {
    return houseArea.getLastHouseNumber();
  }

  public HouseIdentifier getIdentifier() {
    return houseArea.getIdentifier();
  }

}