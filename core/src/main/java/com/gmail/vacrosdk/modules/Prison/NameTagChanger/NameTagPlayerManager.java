package com.gmail.vacrosdk.modules.Prison.NameTagChanger;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class NameTagPlayerManager {

  private final Map<String, Boolean> playerMap = new HashMap<>();
  private final FreakyvilleAddon addon;

  public NameTagPlayerManager(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  public void add(String username, TextColor color) {
    if(playerMap.containsKey(username.toLowerCase())) {
      addon.displayMessage(Component.text("This person is already added to CustomNameTags.").color(color));
      return;
    }
    playerMap.put(username.toLowerCase(), true);
    addon.displayMessage(Component.text("You added " + username + " to CustomNameTags.").color(color));
  }

  public void remove(String username, TextColor color) {
    if(!playerMap.containsKey(username.toLowerCase())) {
      addon.displayMessage(Component.text("This person is not added to CustomNameTags.").color(color));
      return;
    }
    playerMap.remove(username.toLowerCase());
    addon.displayMessage(Component.text("You removed " + username + " from CustomNameTags.").color(color));
  }

  public void print(TextColor color) {
    addon.displayMessage(Component.text("List of players in CustomNameTags:").color(color));
    Collection<String> values = playerMap.keySet();
    values.forEach(value -> addon.displayMessage(Component.text("- " + value).color(color)));
  }

  public void clear() {
    playerMap.clear();
    TextColor color = TextColor.color(addon.configuration().getNameTagMessageColor().get().get());
    addon.displayMessage(Component.text("You cleared all players from CustomNameTags").color(color));
  }

  public boolean contains(String username) {
    return playerMap.containsKey(username.toLowerCase());
  }

  public boolean isEmpty() {
    return playerMap.isEmpty();
  }
}
