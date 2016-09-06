package pw.yumc.MiaoBoard.scoreboard.updater;

import java.util.Iterator;

import org.bukkit.entity.Player;

import cn.citycraft.PluginHelper.callback.CallBackReturn;
import pw.yumc.MiaoBoard.MiaoBoard;
import pw.yumc.MiaoBoard.misc.Checker;
import pw.yumc.MiaoBoard.misc.Replace;
import pw.yumc.MiaoBoard.model.BoardModel;
import pw.yumc.YumCore.bukkit.P;

/**
 * 记分板标题更新类
 *
 * @since 2016年7月4日 下午4:47:17
 * @author 喵♂呜
 */
public class TitleUpdater extends CallBackReturn.One<Player, String> {
    MiaoBoard plugin = P.getPlugin();

    @Override
    public String run(final Player param) {
        final Iterator<BoardModel> iterator = plugin.getScoreBoardManager().getModels().iterator();
        while (iterator.hasNext()) {
            final BoardModel bmodel = iterator.next();
            if (Checker.$(param, bmodel)) {
                return Replace.$(param, bmodel.title);
            }
        }
        return null;
    }

}
