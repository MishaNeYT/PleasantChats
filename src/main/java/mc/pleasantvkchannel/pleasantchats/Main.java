package mc.pleasantvkchannel.pleasantchats;

import mc.pleasantvkchannel.pleasantchats.chats.AdminChatFormat;
import mc.pleasantvkchannel.pleasantchats.chats.ChatFormat;
import mc.pleasantvkchannel.pleasantchats.chats.DonateChatFormat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
        }

        setuper();

        System.out.println("§9-----------------------------------");
        System.out.println("§bPleasantChat §f- успешно включён");
        System.out.println("§fВконтакте §bvk.com/pleasantvkchannel");
        System.out.println("§9-----------------------------------");

        saveConfig();
    }

    public void setuper() {
        getCommand("pleasantchat").setExecutor(new Reload());
        getCommand("donatechat").setExecutor(new DonateChatFormat());
        getCommand("adminchat").setExecutor(new AdminChatFormat());

        Bukkit.getPluginManager().registerEvents(new ChatFormat(), this);
    }
}