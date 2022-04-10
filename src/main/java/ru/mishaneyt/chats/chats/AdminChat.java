package ru.mishaneyt.chats.chats;

import ru.mishaneyt.chats.Main;
import ru.mishaneyt.chats.utils.UtilsConfig;
import ru.mishaneyt.chats.utils.UtilsManager;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChat implements CommandExecutor {

    public AdminChat(Main main) {
        main.getCommand("adminchat").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!Main.getInstance().getConfig().getBoolean("Settings.AdminChat")) {
            sender.sendMessage(UtilsConfig.ADMINCHAT_DISABLE); return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(UtilsConfig.PLAYER); return true;
        }

        if (!sender.hasPermission(UtilsConfig.ADMINCHAT_PERMISSION)) {
            sender.sendMessage(UtilsConfig.ADMINCHAT_NOPERM); return true;
        }

        if (args.length == 0) {
            sender.sendMessage(UtilsConfig.ADMINCHAT_USE); return true;
        }

        Player p = (Player) sender;
        String m = UtilsManager.strip(String.join(" ", args));

        for (Player all : Bukkit.getOnlinePlayers()) {

            String message = UtilsConfig.ADMINCHAT_FORMAT.replace("{player}", p.getName()).replace("{message}", m);
            message = PlaceholderAPI.setPlaceholders(p, message);

            if (all.hasPermission(UtilsConfig.ADMINCHAT_PERMISSION))
                all.sendMessage(message);
        }
        return false;
    }
}