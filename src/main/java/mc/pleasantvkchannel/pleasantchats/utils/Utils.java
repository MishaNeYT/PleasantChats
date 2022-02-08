package mc.pleasantvkchannel.pleasantchats.utils;

import mc.pleasantvkchannel.pleasantchats.Main;
import org.bukkit.ChatColor;

public class Utils {

    public static String ColorChat(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String getString(String msg) {
        return Main.getInstance().getConfig().getString(msg);
    }
}