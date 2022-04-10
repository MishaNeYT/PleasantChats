package ru.mishaneyt.chats.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import ru.mishaneyt.chats.Main;

public class UtilsManager {

    public static String getString(String msg) {
        return Main.getInstance().getConfig().getString(msg);
    }

    public static String getStringColor(String msg) {
        return getString(msg).replace("&", "§");
    }

    public static String strip(String string) {
        return string == null ? "" : ChatColor.stripColor(string);
    }

    public static void onPlaceholderAPI(Main main) {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(main, main);
        } else main.getLogger().warning("Плагин PlaceholderAPI не найден.");
    }
}