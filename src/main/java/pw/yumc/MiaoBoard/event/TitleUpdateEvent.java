package pw.yumc.MiaoBoard.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * 记分板标题更新
 *
 * @author MiaoWoo
 * @date 2017/3/7 0007
 */
public class TitleUpdateEvent extends Event {
    private Player player;
    private String title;

    public TitleUpdateEvent(Player player) {
        super(true);
        this.player = player;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Player getPlayer() {
        return player;
    }

    public String getTitle() {
        return title;
    }

    private static HandlerList handlerList = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
