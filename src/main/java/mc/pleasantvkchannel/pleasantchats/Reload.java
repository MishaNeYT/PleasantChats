package mc.pleasantvkchannel.pleasantchats;

import mc.pleasantvkchannel.pleasantchats.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("pleasantchat.admin")) {
            sender.sendMessage(Utils.ColorChat(Utils.getString("Messages.NoPerm")));
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(Utils.ColorChat(Utils.getString("Messages.Error")));
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            Main.getInstance().reloadConfig();
            Main.getInstance().saveConfig();
            sender.sendMessage(Utils.ColorChat(Utils.getString("Messages.Reload")));
        } else {
            sender.sendMessage(Utils.ColorChat(Utils.getString("Messages.Error")));
            return true;
        }
        return false;
    }
}