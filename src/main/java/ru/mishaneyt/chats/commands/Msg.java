package ru.mishaneyt.chats.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.mishaneyt.chats.Main;
import ru.mishaneyt.chats.utils.UtilsConfig;

public class Msg implements CommandExecutor {

    public Msg(Main main) {
        main.getCommand("msg").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(UtilsConfig.PLAYER); return true;
        }

        if (!sender.hasPermission(UtilsConfig.MSG_PERMISSION)) {
            sender.sendMessage(UtilsConfig.NOPERM); return true;
        }

        if (args.length <= 1) {
            sender.sendMessage(UtilsConfig.MSG_USE); return true;
        }

        Player p = (Player) sender, t = Bukkit.getPlayer(args[0]);
        String m = String.join(" ", args).substring(args[0].length() + 1);

        if (t == null || t == p) {
            p.sendMessage(t != p ? UtilsConfig.MSG_OFFLINE : UtilsConfig.MSG_SENDYOU); return true;
        }

        String send = UtilsConfig.MSG_SEND.replace("{target}", t.getName()).replace("{message}", m);
        String to = UtilsConfig.MSG_TO.replace("{target}", p.getName()).replace("{message}", m);

        p.sendMessage(send);
        t.sendMessage(to);

        return false;
    }
}