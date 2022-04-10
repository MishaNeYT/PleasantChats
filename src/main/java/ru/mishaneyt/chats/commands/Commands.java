package ru.mishaneyt.chats.commands;

import ru.mishaneyt.chats.Main;
import ru.mishaneyt.chats.utils.UtilsConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

    public Commands(Main main) {
        main.getCommand("pleasantchats").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("pleasantchats.admin")) {
            sender.sendMessage(UtilsConfig.NOPERM); return true;
        }

        if (args.length != 1) {
            sender.sendMessage(UtilsConfig.ERROR); return true;

        } else if ("reload".equalsIgnoreCase(args[0])) {
            Main.getInstance().reloadConfig();
            sender.sendMessage(UtilsConfig.RELOAD); return true;

        } else sender.sendMessage(UtilsConfig.ERROR);
        return false;
    }
}