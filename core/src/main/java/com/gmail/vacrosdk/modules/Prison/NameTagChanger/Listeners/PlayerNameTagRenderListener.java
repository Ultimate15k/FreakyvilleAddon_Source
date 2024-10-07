package com.gmail.vacrosdk.modules.Prison.NameTagChanger.Listeners;

import com.gmail.vacrosdk.FreakyvilleAddon;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.FontType;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.NameTagPlayerManager;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.TextColor;
import net.labymod.api.client.network.NetworkPlayerInfo;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.render.PlayerNameTagRenderEvent;

public class PlayerNameTagRenderListener {

  private final FreakyvilleAddon addon;
  private final NameTagPlayerManager playerManager;

  public PlayerNameTagRenderListener(FreakyvilleAddon addon,
      NameTagPlayerManager playerManager) {
    this.addon = addon;
    this.playerManager = playerManager;
  }

  @Subscribe
  public void onPlayerNameTagRender(PlayerNameTagRenderEvent event) {
    if (!addon.isOnlineOnFreakyville()) {
      return;
    }
    if(moduleIsDisabled()) {
      return;
    }
    doEvent(event);
  }

  private void doEvent(PlayerNameTagRenderEvent event) {
    if(playerManager.isEmpty()) {
      return;
    }
    NetworkPlayerInfo networkPlayerInfo = event.playerInfo();
    if(networkPlayerInfo == null) {
      return;
    }
    String username = networkPlayerInfo.profile().getUsername();
    if(playerManager.contains(username)) {
      updateNameTag(event, username);
    }
  }

  private boolean moduleIsDisabled() {
    return addon.configuration().getNameTags().get().equals(false) || addon.configuration().enabled().get().equals(false)|| addon.configuration().getPrisonEnabled().get().equals(false);
  }
  private void updateNameTag(PlayerNameTagRenderEvent event, String userName) {
    int i = addon.configuration().getNameTagColor().get().get();
    TextColor textColor = TextColor.color(i);
    if(addon.configuration().getBoldFont().get()) {
      userName = FontType.BOLD.getColorCode() + userName;
    }
    if(addon.configuration().getUnderlineFont().get()) {
      userName = FontType.ITALIC.getColorCode() + userName;
    }
    if(addon.configuration().getItalicFont().get()) {
      userName = FontType.ITALIC.getColorCode() + userName;
    }
    if(addon.configuration().getStrikeFont().get()) {
      userName = FontType.STRIKE.getColorCode() + userName;
    }
    if(addon.configuration().getMagicFont().get()) {
      userName = FontType.MAGIC.getColorCode() + userName;
    }
    event.setNameTag(Component.text(userName).color(textColor));
  }
}
