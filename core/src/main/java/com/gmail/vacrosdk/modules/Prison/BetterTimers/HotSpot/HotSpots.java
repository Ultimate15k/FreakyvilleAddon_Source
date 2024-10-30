package com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot;

import com.gmail.vacrosdk.language.MessageCatchLanguage;

public enum HotSpots {

  APLUS_BANK(new HotSpot(
      "A+ Bank",
      MessageCatchLanguage.APLUS_VV_CATCH,
      MessageCatchLanguage.APLUS_BANK_CONFIRMATION,
      MessageCatchLanguage.APLUS_BANK_UPDATE,
      60,
      10,
      10,
      720)),
  APLUS_GANGAREA(new HotSpot(
      "A+ Bandeområdet",
      MessageCatchLanguage.APLUS_GANGAREA_CATCH,
      MessageCatchLanguage.APLUS_GANGAREA_CONFIRMATION,
      MessageCatchLanguage.GANGAREA_UPDATE,
      15,
      5,
      60,
      120)),
  A_VAULT(new HotSpot(
      "A Vagtvault",
      MessageCatchLanguage.A_VV_CATCH,
      MessageCatchLanguage.A_VV_CONFIRMATION,
      MessageCatchLanguage.A_VV_UPDATE,
      30,
      5,
      8,
      720)),
  A_GANGAREA(new HotSpot(
      "A Bandeområdet",
      MessageCatchLanguage.A_GANGAREA_CATCH,
      MessageCatchLanguage.A_GANGAREA_CONFIRMATION,
      MessageCatchLanguage.GANGAREA_UPDATE,
      15,
      5,
      60,
      120)),
  BPLUS_VAULT(new HotSpot(
      "B+ Bank",
      MessageCatchLanguage.BPLUS_VV_CATCH,
      MessageCatchLanguage.BPLUS_VV_CONFIRMATION,
      MessageCatchLanguage.BPLUS_VV_UPDATE,
      70,
      10,
      13,
      720)),
  B_VAULT(new HotSpot(
      "B Vagtvault",
      MessageCatchLanguage.B_VV_CATCH,
      MessageCatchLanguage.B_VV_CONFIRMATION,
      MessageCatchLanguage.B_VV_UPDATE,
      30,
      5,
      5,
      30)),
  BPLUS_GANGAREA(new HotSpot(
      "B+ Bandeområdet",
      MessageCatchLanguage.BPLUS_GANGAREA_CATCH,
      MessageCatchLanguage.BPLUS_GANGAREA_CONFIRMATION,
      MessageCatchLanguage.BPLUS_GANGAREA_UPDATE,
      15,
      5,
      60,
      120)),
  B_GANG_AREA(new HotSpot(
      "B Bandeområdet",
      MessageCatchLanguage.B_GANGAREA_CATCH,
      MessageCatchLanguage.B_GANGAREA_CONFIRMATION,
      MessageCatchLanguage.B_GANGAREA_UPDATE,
      15,
      5,
      60,
      120)),
  B_PVP_CHEST(new HotSpot(
      "Den hemmelige chest",
      MessageCatchLanguage.B_PVP_CHEST_CATCH,
      MessageCatchLanguage.B_PVP_CHEST_CONFIRMATION,
      MessageCatchLanguage.PVP_CHEST_UPDATE,
      20,
      3,
      45,
      180)),
  C_VAULT(new HotSpot(
      "C Vagtvault",
      MessageCatchLanguage.C_VV_CATCH,
      MessageCatchLanguage.C_VV_CONFIRMATION,
      MessageCatchLanguage.C_VV_UPDATE,
      15,
      5,
      5,
      120)),
  A_ROCKER_TORBEN(new HotSpot(
      "A Rocker Torben",
      MessageCatchLanguage.ROCKER_TORBEN_CATCH,
      MessageCatchLanguage.ROCKER_TORBEN_CONFIRMATION,
      MessageCatchLanguage.ROCKER_TORBEN_UPDATE,
      120,
      10,
      180,
      720)),
  A_DISABLE_VAULTS(new HotSpot(
      "VV / Bank slået fra",
      MessageCatchLanguage.A_DISABLE_VAULTS_CATCH,
      MessageCatchLanguage.A_DISABLE_VAULTS_CONFIRMATION,
      MessageCatchLanguage.A_DISABLE_VAULTS_UPDATE,
      60,
      0,
      0,
      0)),
  NEW_GANG(new HotSpot(
      "Join BO Cooldown",
      MessageCatchLanguage.NEW_GANG_CATCH,
      MessageCatchLanguage.NEW_GANG_CONFIRMATION,
      MessageCatchLanguage.NEW_GANG_UPDATE,
      120,
      0,
      0,
      120)),
  NEW_FISHING_ROD(new HotSpot(
      "Fishing rod Cooldown",
      MessageCatchLanguage.NEW_FISHING_ROD_CATCH,
      MessageCatchLanguage.NEW_FISHING_ROD_CONFIRMATION,
      MessageCatchLanguage.NEW_FISHING_ROD_UPDATE,
      20,
      0,
      0,
      20)),
  B_KOBEN(new HotSpot(
      "Koben Cooldown",
      MessageCatchLanguage.B_KOBEN_CATCH,
      MessageCatchLanguage.B_KOBEN_CONFIRMATION,
      MessageCatchLanguage.B_KOBEN_UPDATE,
      120,
      0,
      0,
      120));
  private final HotSpot hotSpot;

  HotSpots(HotSpot hotSpot) {
    this.hotSpot = hotSpot;
  }

  public HotSpot getHotSpot() {
    return this.hotSpot;
  }
}
