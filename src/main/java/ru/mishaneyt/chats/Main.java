package ru.mishaneyt.chats;

import org.bukkit.plugin.PluginManager;
import ru.mishaneyt.chats.chats.AdminChat;
import ru.mishaneyt.chats.chats.DefaultChat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mishaneyt.chats.chats.DonateChat;
import ru.mishaneyt.chats.commands.Commands;
import ru.mishaneyt.chats.commands.CommandsTab;
import ru.mishaneyt.chats.commands.Msg;
import ru.mishaneyt.chats.utils.UtilsConfig;
import ru.mishaneyt.chats.utils.UtilsManager;

import java.io.File;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) saveDefaultConfig();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DefaultChat(), this);

        new Commands(this);
        new DonateChat(this);
        new AdminChat(this);

        new Msg(this);
        new CommandsTab(this);

        UtilsManager.onPlaceholderAPI(this);
        UtilsConfig.onConfig();

        getLogger().info("");
        getLogger().info("§e PleasantChats - плагин успешно включен!");
        getLogger().info("§e Спасибо, что скачали! С любовью, PleasantVKChannel.");
        getLogger().info("");
    }

    public static Main getInstance() {
        return instance;
    }
}