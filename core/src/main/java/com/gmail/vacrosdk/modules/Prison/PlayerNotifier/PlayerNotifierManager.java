package com.gmail.vacrosdk.modules.Prison.PlayerNotifier;

import com.gmail.vacrosdk.FreakyvilleAddon;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;

public class PlayerNotifierManager {

  private final Map<String, Boolean> playerMap = new HashMap<>();
  private final FreakyvilleAddon addon;

  public PlayerNotifierManager(FreakyvilleAddon addon) {
    this.addon = addon;
  }

  public void add(String username, TextColor textColor) {
    if(playerMap.containsKey(username.toLowerCase())) {
      addon.displayMessage(Component.text("This person is already added to PlayerNotifier.").color(textColor));
      return;
    }
    playerMap.put(username.toLowerCase(), true);
    addon.displayMessage(Component.text("You added " + username + " to PlayerNotifier.").color(textColor));
  }

  public void remove(String username, TextColor textColor) {
    if(!playerMap.containsKey(username.toLowerCase())) {
      addon.displayMessage(Component.text("This person is not added to PlayerNotifier.").color(textColor));
      return;
    }
    playerMap.remove(username.toLowerCase());
    addon.displayMessage(Component.text("You removed " + username + " from PlayerNotifier.").color(textColor));
  }

  public void print(TextColor textColor) {
    addon.displayMessage(Component.text("List of players in PlayerNotifier:").color(textColor));
    Collection<String> values = playerMap.keySet();
    values.forEach(value -> addon.displayMessage(Component.text("- " + value).color(textColor)));
  }

  public void clear() {
    playerMap.clear();
    TextColor textColor = TextColor.color(addon.configuration().getPlayerNotifierColor().get().get());
    addon.displayMessage(Component.text("You cleared all players from PlayerNotifier").color(textColor));
  }

  public boolean contains(String username) {
    return playerMap.containsKey(username);
  }
  public boolean isEmpty() {
    return playerMap.isEmpty();
  }

}
