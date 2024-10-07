package com.gmail.vacrosdk.modules.Prison.NameTagChanger;

public enum FontType {
  BOLD("§l"),
  UNDER_LINE("§n"),
  ITALIC("§o"),
  MAGIC("§k"),
  STRIKE("§m");
  
  private final String colorCode;

  FontType(String colorCode) {
    this.colorCode = colorCode;
  }

  public String getColorCode() {
    return colorCode;
  }
}
