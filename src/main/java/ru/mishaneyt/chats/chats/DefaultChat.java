package ru.mishaneyt.chats.chats;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.configuration.Configuration;
import ru.mishaneyt.chats.Main;
import ru.mishaneyt.chats.utils.UtilsConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class DefaultChat implements Listener {
    static Configuration config = Main.getInstance().getConfig();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (!config.getBoolean("Settings.DefaultChat")) return;

        if (!p.hasPermission(UtilsConfig.CHAT_PERMISSION)) {
            e.setCancelled(true);
            p.sendMessage(UtilsConfig.CHAT_NOPERM);
        }

        String message = UtilsConfig.CHAT_FORMAT.replace("{message}", e.getMessage()).replace("{player}", p.getName());
        message = PlaceholderAPI.setPlaceholders(p, message);

        e.setFormat(message);
    }
}