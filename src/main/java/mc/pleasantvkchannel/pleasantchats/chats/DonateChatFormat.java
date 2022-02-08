package mc.pleasantvkchannel.pleasantchats.chats;

import mc.pleasantvkchannel.pleasantchats.Main;
import mc.pleasantvkchannel.pleasantchats.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DonateChatFormat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Main.getInstance().getConfig().getBoolean("Settings.DonateChat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Utils.ColorChat(Utils.getString("Messages.OnlyPlayer")));
                return false;
            }

            if (!sender.hasPermission(Utils.getString("Permissions.DonateChat"))) {
                sender.sendMessage(Utils.ColorChat(Utils.getString("DonateChatFormat.NoPerm")));
                return false;
            }

            if (args.length == 0) {
                sender.sendMessage(Utils.ColorChat(Utils.getString("DonateChatFormat.Use")));
                return true;
            }

            StringBuilder sb = new StringBuilder();
            for (String s : args) sb.append(s).append(" ");
            String msg = sb.toString();

            Player player = (Player) sender;

            if (sender.hasPermission(Utils.getString("Permissions.DonateChat"))) {
                for (Player donatechat : Bukkit.getOnlinePlayers()) {
                    String message = (Utils.ColorChat(Utils.getString("DonateChatFormat.DonateChat")
                            .replace("%player%", sender.getName()).replace("%message%", msg)));

                    message = PlaceholderAPI.setPlaceholders(player.getKiller(), message);
                    donatechat.sendMessage(message);
                }
            }
        }
        return false;
    }
}