package com.gmail.vacrosdk.modules.Prison.EventNotifier.Sounds;

public enum NotificationSound {
  NOTE_PLING("note.pling"),
  ANVIL_USE("random.anvil_use"),
  ANVIL_LAND("random.anvil_land"),
  THUNDER("ambient.weather.thunder"),
  FIRE_CHARGE("item.fireCharge.use"),
  LEVEL_UP("random.levelup"),
  ENDER_MAN_SCREAM("mob.endermen.scream"),
  EXPLOSION("random.explode"),
  ENDER_DRAGON_GROWL("mob.enderdragon.growl");


  private final String soundString;

  NotificationSound(String soundString) {
    this.soundString = soundString;
  }

  public String getSoundString() {
    return soundString;
  }
}
