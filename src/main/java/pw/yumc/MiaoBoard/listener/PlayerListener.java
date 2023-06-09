package pw.yumc.MiaoBoard.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import pw.yumc.MiaoBoard.MiaoBoard;
import pw.yumc.MiaoBoard.config.MiaoBoardConfig;
import pw.yumc.MiaoBoard.scoreboard.ScoreBoardManager;
import pw.yumc.YumCore.bukkit.P;
import pw.yumc.YumCore.statistic.Statistics;
import pw.yumc.YumCore.update.SubscribeTask;

/**
 * 玩家监听
 *
 * @author MiaoWoo
 * @date 2016年6月24日 下午3:29:39
 */
public class PlayerListener implements Listener {
    private MiaoBoard plugin = P.getPlugin();
    private ScoreBoardManager manager = plugin.getScoreBoardManager();

    public PlayerListener() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        new Statistics();
        new SubscribeTask(true, SubscribeTask.UpdateType.MAVEN);
    }

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent e) {
        if (MiaoBoardConfig.i().DisableWorld.contains(e.getPlayer().getWorld().getName())) {
            manager.removeTarget(e.getPlayer());
        } else {
            manager.addTarget(e.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        manager.addTarget(e.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        manager.removeTarget(e.getPlayer());
    }
}
