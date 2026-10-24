package com.gmail.vacrosdk;

import com.gmail.vacrosdk.config.FreakyvilleConfig;
import com.gmail.vacrosdk.language.MessageCatchLanguage;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.House.Area.HouseAreaManager;
import com.gmail.vacrosdk.modules.Friheden.BetterApartments.Listeners.HouseChatListener;
import com.gmail.vacrosdk.modules.Friheden.BetterInvestments.Commands.InvestmentsCommand;
import com.gmail.vacrosdk.modules.Friheden.BetterInvestments.Listener.InvestmentsTimeUpdaterListener;
import com.gmail.vacrosdk.modules.Friheden.BetterInvestments.Listener.InvestmentsUpdaterListener;
import com.gmail.vacrosdk.modules.Friheden.BetterInvestments.ServerJoin;
import com.gmail.vacrosdk.modules.Friheden.Renter;
import com.gmail.vacrosdk.modules.Prison.BetterCells.ChatListener;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Chests.Commands.ChestCommand;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Chests.Listener.ChestListener;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Chests.Listener.ChestUpdateListener;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Commands.GlobalTimersCommand;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Commands.PersonalTimersCommand;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.CGangAreaTimerWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.CMVaultTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.chest_FitnessTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.chest_MinenTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.chest_MrXTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.chest_SortPortalTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.chest_TankStationTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.chest_TreeTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.BoLootEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.CGangAreaEvent;
import com.gmail.vacrosdk.modules.Prison.vagt.VagtJoinListener;
import com.gmail.vacrosdk.plugin.DeleteFolderC;
import com.gmail.vacrosdk.plugin.DeleteFolderCC;
import com.gmail.vacrosdk.plugin.Stats.StatsListener;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Listeners.CatchListener;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Listeners.ConfirmListener;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Listeners.UpdateListener;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Managers.CatchManager;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.AGangAreaTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.APlusGangAreaTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.APlusVaultTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.AVaultDisabledTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.AVaultTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.BGangAreaTimerWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.BPlusBankTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.BPlusGangAreaTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.BPvPChestTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.BVaultTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.CVaultTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.GangJoinCooldownTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.SubWidgets.RockerTorbenTimerTextHudWidget;
import com.gmail.vacrosdk.modules.Prison.BetterTimers.Widget.WidgetUpdater;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.AGangAreaEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.APlusGangAreaEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.APlusVaultEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.AVaultEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.BGangAreaEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.BPlusGangAreaEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.BPlusVaultEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.BPvPChestEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.BVaultEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.CVaultEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.GuardKillEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.GuardsDisableVaultsEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.HeadEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.RockerTorbenEvent;
import com.gmail.vacrosdk.modules.Prison.EventNotifier.Event.SubEvents.StringCaughtEvent;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.Commands.NameTagCommand;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.Listeners.PlayerNameTagRenderListener;
import com.gmail.vacrosdk.modules.Prison.NameTagChanger.NameTagPlayerManager;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Commands.PlayerNotifierCommand;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Listeners.JoinListener;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.Listeners.LeaveListener;
import com.gmail.vacrosdk.modules.Prison.PlayerNotifier.PlayerNotifierManager;
import com.gmail.vacrosdk.modules.Prison.Quest.Commands.QuestCommand;
import com.gmail.vacrosdk.modules.Prison.vagt.VagtLeaveListener;
import com.gmail.vacrosdk.plugin.CampCommand;
import com.gmail.vacrosdk.plugin.Stats.StatsCommand;
import com.gmail.vacrosdk.utils.Utils;
import com.gmail.vacrosdk.utils.debug.DebugChatListener;
import com.gmail.vacrosdk.utils.debug.DebugCommand;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.gui.hud.HudWidgetRegistry;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.models.addon.annotation.AddonMain;

import static com.gmail.vacrosdk.utils.CSVFunctions.preloadCSV;

@AddonMain
public class FreakyvilleAddon extends LabyAddon<FreakyvilleConfig> {
  private final HouseAreaManager houseAreaManager = new HouseAreaManager();
  private final PlayerNotifierManager playerNotifierPlayerManager = new PlayerNotifierManager(this);
  private final NameTagPlayerManager nameTagPlayerManager = new NameTagPlayerManager(this);
  private final CatchManager catchManager = new CatchManager();
  private HudWidgetCategory widgetCategory;

  public Boolean IsOnGuard = false;

  private boolean isOnlineOnFreakyville;

  @Override
  public void enable() {
    this.registerSettingCategory();
    labyAPI().hudWidgetRegistry().categoryRegistry().register(this.widgetCategory = new HudWidgetCategory("freakyvilleaddon_category"));

    handleMainPlugin();
    handleModules();

    this.logger().info("Enabled the Addon");

    Utils.createNotification("FreakyvilleAddon", "Addon er aktiveret! Version: (" + addonInfo().getVersion() + ")", Icon.head(this.labyAPI().getName()));

    preloadCSV();
    this.logger().info("CSV data successfully preloaded.");

    isOnlineOnFreakyville = true;
  }

  private void handleModules() {
    handleVagt();
    handleTimers();
    handleCells();
    handleFrihedenPlugin();
    handlePlayerNotifier();
    handleCustomNameTags();
    handleEventNotifier();
  }

  private void handleEventNotifier() {
    this.registerListener(new APlusVaultEvent(MessageCatchLanguage.APLUS_VV_CATCH, this));
    this.registerListener(new AVaultEvent(MessageCatchLanguage.A_VV_CATCH, this));
    this.registerListener(new BPlusVaultEvent(MessageCatchLanguage.BPLUS_VV_CATCH, this));
    this.registerListener(new BVaultEvent(MessageCatchLanguage.B_VV_CATCH, this));
    this.registerListener(new CVaultEvent(MessageCatchLanguage.C_VV_CATCH, this));
    this.registerListener(new APlusGangAreaEvent(MessageCatchLanguage.APLUS_GANGAREA_CATCH, this));
    this.registerListener(new AGangAreaEvent(MessageCatchLanguage.A_GANGAREA_CATCH, this));
    this.registerListener(new BPlusGangAreaEvent(MessageCatchLanguage.BPLUS_GANGAREA_CATCH, this));
    this.registerListener(new BGangAreaEvent(MessageCatchLanguage.B_GANGAREA_CATCH, this));
    this.registerListener(new CGangAreaEvent(MessageCatchLanguage.C_GANGAREA_CATCH, this));
    this.registerListener(new RockerTorbenEvent(MessageCatchLanguage.ROCKER_TORBEN_CATCH, this));
    this.registerListener(new GuardsDisableVaultsEvent(MessageCatchLanguage.A_DISABLE_VAULTS_CATCH, this));
    this.registerListener(new StringCaughtEvent(MessageCatchLanguage.STRING_CAUGHT_CATCH, this));
    this.registerListener(new BoLootEvent(MessageCatchLanguage.BO_LOOT_CLAIM, this));
    this.registerListener(new HeadEvent(MessageCatchLanguage.HEAD_EVENT_CATCH, this));
    this.registerListener(new GuardKillEvent(MessageCatchLanguage.GUARD_KILL_CATCH, this));
    this.registerListener(new BPvPChestEvent(MessageCatchLanguage.B_PVP_CHEST_CATCH, this));
  }

  private void handleVagt() {
    this.registerListener(new VagtJoinListener(this));
    this.registerListener(new VagtLeaveListener(this));
  }

  private void handleMainPlugin() {
    this.registerListener(new FreakyvilleConnectionListener(this));
    this.registerCommand(new CampCommand("camp", playerNotifierPlayerManager, nameTagPlayerManager, this));
    this.registerCommand(new QuestCommand("quests", this));
    this.registerCommand(new DebugCommand("addonhid", this));
    this.registerCommand(new StatsCommand("stats", this));

    this.registerCommand(new DeleteFolderC("deleteAll", this));
    this.registerCommand(new DeleteFolderCC("confirm", this));
  }

  private void handleFrihedenPlugin() {
    this.registerCommand(new InvestmentsCommand("inv", this));
    this.registerCommand(new Renter("renter", this));

    this.registerListener(new HouseChatListener(this, houseAreaManager));

    this.registerListener(new InvestmentsUpdaterListener(this));
    this.registerListener(new InvestmentsTimeUpdaterListener(this));
    this.registerListener(new ServerJoin(this));
    this.registerListener(new DebugChatListener(this));
  }

  private void handleCells() {
    this.registerListener(new ChatListener(this));
  }

  private void handleTimers() {
    this.registerListener(new CatchListener(this, catchManager));
    this.registerListener(new ConfirmListener(this, catchManager));
    this.registerListener(new UpdateListener(this, catchManager));
    this.registerListener(new StatsListener(this));
    this.registerListener(new ChestListener(this));
    this.registerListener(new ChestUpdateListener(this));

    this.registerCommand(new ChestCommand(this));
    this.registerCommand(new GlobalTimersCommand("timers", this));
    this.registerCommand(new PersonalTimersCommand("pTimers", this));

    registerTimerWidgets();

  }
  private static final ResourceLocation ICON_SHEET = ResourceLocation.create(
      "freakyvilleaddon",
      "themes/fancy/textures/settings/icons2.png");

  private static Icon icon(int x, int y) {
    return Icon.sprite16(ICON_SHEET, x, y);
  }


  public HudWidgetCategory getWidgetCategory() {
    return this.widgetCategory;
  }

  private void registerTimerWidgets() {
    this.registerListener(new WidgetUpdater(this));

    HudWidgetRegistry registry = labyAPI().hudWidgetRegistry();

    // Vaults (id, icon, addon)
    registry.register(new AVaultDisabledTextHudWidget("Vaults_disabled_widget", icon(5, 0), this));
    registry.register(new APlusVaultTimerTextHudWidget("A+_Vault_widget", icon(0, 0), this));
    registry.register(new AVaultTimerTextHudWidget("A_Vault_widget", icon(1, 0), this));
    registry.register(new BPlusBankTimerTextHudWidget("B+_Vault_widget", icon(2, 0), this));
    registry.register(new BVaultTimerTextHudWidget("B_Vault_widget", icon(3, 0), this));
    registry.register(new CVaultTimerTextHudWidget("C_Vault_widget", icon(4, 0), this));
    registry.register(new CMVaultTimerTextHudWidget("CM_Vault_widget", icon(4, 0), this));

    // Gang areas (id, icon, addon)
    registry.register(new APlusGangAreaTimerTextHudWidget("A+_Bandeområde_widget", icon(0, 1), this));
    registry.register(new AGangAreaTimerTextHudWidget("A_Bandeområde_widget", icon(1, 1), this));
    registry.register(new BPlusGangAreaTimerTextHudWidget("B+_GangArea_Timer", icon(2, 1), this));
    registry.register(new BGangAreaTimerWidget("B_GangArea_Timer", icon(3, 1), this));
    registry.register(new CGangAreaTimerWidget("C_GangArea_Timer", icon(3, 3), this));

    // (id, icon, addon)
    registry.register(new BPvPChestTimerTextHudWidget("B_PvPChest_Timer", icon(4, 1), this));
    registry.register(new RockerTorbenTimerTextHudWidget("Rocker_Torben_widget", icon(5, 1), this));
    registry.register(new GangJoinCooldownTimerTextHudWidget("Gang_Cooldown_GangArea_Timer", icon(2, 1), this));

    // Chests (id, icon, addon)
    registry.register(new chest_TankStationTimerTextHudWidget("chest_TankStationTimerTextHudWidget", icon(0, 2), this));
    registry.register(new chest_MrXTimerTextHudWidget("chest_MrXTimerTextHudWidget", icon(1, 2), this));
    registry.register(new chest_FitnessTimerTextHudWidget("chest_FitnessTimerTextHudWidget", icon(2, 2), this));
    registry.register(new chest_MinenTimerTextHudWidget("chest_MinenTimerTextHudWidget", icon(3, 2), this));
    registry.register(new chest_TreeTimerTextHudWidget("chest_TreeTimerTextHudWidget", icon(4, 2), this));
    registry.register(new chest_SortPortalTimerTextHudWidget("chest_SortPortalTimerTextHudWidget", icon(5, 2), this));
  }

  private void handleCustomNameTags() {
    this.registerListener(new PlayerNameTagRenderListener(this, nameTagPlayerManager));

    this.registerCommand(new NameTagCommand("nt", this, nameTagPlayerManager));

  }

  private void handlePlayerNotifier() {

    this.registerListener(new JoinListener(this, playerNotifierPlayerManager));
    this.registerListener(new LeaveListener(this, playerNotifierPlayerManager));

    this.registerCommand(new PlayerNotifierCommand("pn", this, playerNotifierPlayerManager));
  }

  @Override
  protected Class<FreakyvilleConfig> configurationClass() {
    return FreakyvilleConfig.class;
  }

  public boolean isOnlineOnFreakyville() {
    return isOnlineOnFreakyville;
  }

  public void setOnlineOnFreakyville(boolean b) {
    this.isOnlineOnFreakyville = b;
  }

  public Boolean IsPlayerOnGuard() {
    return IsOnGuard;
  }

  public void SetIsPlayerOnGuard(boolean b) {
    this.IsOnGuard = b;
  }
}
