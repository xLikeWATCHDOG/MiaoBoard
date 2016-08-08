package pw.yumc.MiaoBoard.scoreboard.updater;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.entity.Player;

import cn.citycraft.PluginHelper.callback.CallBackReturn;
import cn.citycraft.PluginHelper.kit.StrKit;
import cn.citycraft.PluginHelper.pluginapi.PluginAPI;
import pw.yumc.MiaoBoard.model.BoardModel;
import pw.yumc.MiaoBoard.scoreboard.ScoreBoardManager;

/**
 * 记分板行更新类
 *
 * @since 2016年7月4日 下午4:47:17
 * @author 喵♂呜
 */
public class BodyUpdater extends CallBackReturn.One<Player, List<String>> {

    @Override
    public List<String> run(final Player param) {
        final Iterator<BoardModel> iterator = ScoreBoardManager.getModels().iterator();
        while (iterator.hasNext()) {
            final BoardModel bmodel = iterator.next();
            if (param.hasPermission(bmodel.permission)) {
                final List<String> temp = new LinkedList<>();
                for (final String line : bmodel.lines) {
                    temp.add(StrKit.substring(PluginAPI.PlaceholderAPI(param, line), 0, 40));
                }
                return temp;
            }
        }
        return Collections.emptyList();
    }

}
