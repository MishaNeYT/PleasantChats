package mc.pleasantvkchannel.pleasantchats.chats;

import mc.pleasantvkchannel.pleasantchats.Main;
import mc.pleasantvkchannel.pleasantchats.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (Main.getInstance().getConfig().getBoolean("Settings.Chat")) {
            event.setCancelled(true);
            Player player = event.getPlayer();

            if (player.hasPermission(Utils.getString("Permissions.Chat"))) {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.sendMessage(Utils.ColorChat(Utils.getString("ChatsFormat.Chat"))
                            .replace("%player%", player.getName()).replace("%message%", event.getMessage()));
                }
            } else {
                player.sendMessage(Utils.ColorChat(Utils.getString("ChatsFormat.NoPerm")));
            }
        }
    }
}