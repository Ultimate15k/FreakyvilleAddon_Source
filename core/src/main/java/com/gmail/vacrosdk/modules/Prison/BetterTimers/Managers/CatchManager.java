package com.gmail.vacrosdk.modules.Prison.BetterTimers.Managers;

import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpot;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.HotSpot.HotSpots;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CatchManager {

  public CatchManager() {
    load();
  }

  private final Map<HotSpot, HotSpot> map = new HashMap<>();
  private final Set<HotSpot> confirmSet = new HashSet<>();

  public void load() {
    map.put(HotSpots.A_VAULT.getHotSpot(), HotSpots.A_VAULT.getHotSpot());
    map.put(HotSpots.APLUS_BANK.getHotSpot(), HotSpots.APLUS_BANK.getHotSpot());
    map.put(HotSpots.C_VAULT.getHotSpot(), HotSpots.C_VAULT.getHotSpot());
    map.put(HotSpots.APLUS_GANGAREA.getHotSpot(), HotSpots.APLUS_GANGAREA.getHotSpot());
    map.put(HotSpots.A_GANGAREA.getHotSpot(), HotSpots.A_GANGAREA.getHotSpot());
    map.put(HotSpots.B_VAULT.getHotSpot(), HotSpots.B_VAULT.getHotSpot());
    map.put(HotSpots.A_ROCKER_TORBEN.getHotSpot(), HotSpots.A_ROCKER_TORBEN.getHotSpot());
    map.put(HotSpots.A_DISABLE_VAULTS.getHotSpot(), HotSpots.A_DISABLE_VAULTS.getHotSpot());
    map.put(HotSpots.BPLUS_GANGAREA.getHotSpot(), HotSpots.BPLUS_GANGAREA.getHotSpot());
    map.put(HotSpots.B_GANG_AREA.getHotSpot(), HotSpots.B_GANG_AREA.getHotSpot());
    map.put(HotSpots.B_PVP_CHEST.getHotSpot(), HotSpots.B_PVP_CHEST.getHotSpot());
    map.put(HotSpots.BPLUS_VAULT.getHotSpot(), HotSpots.BPLUS_VAULT.getHotSpot());
    map.put(HotSpots.NEW_GANG.getHotSpot(), HotSpots.NEW_GANG.getHotSpot());
    map.put(HotSpots.NEW_FISHING_ROD.getHotSpot(), HotSpots.NEW_FISHING_ROD.getHotSpot());
    map.put(HotSpots.B_KOBEN.getHotSpot(), HotSpots.B_KOBEN.getHotSpot());
  }

  public void addToConfirmList(HotSpot key) {
    confirmSet.add(key);
  }

  public Set<HotSpot> getConfirmSet() {
    return confirmSet;
  }

  public Set<HotSpot> getKeySet() {
    return map.keySet();
  }

  public boolean confirmSetContains(HotSpot hotSpot) {
    return confirmSet.contains(hotSpot);
  }

  public void removeFromSetContains(HotSpot hotSpot) {
    confirmSet.remove(hotSpot);
  }

}
