package ru.mishaneyt.chats.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import ru.mishaneyt.chats.Main;

import java.util.ArrayList;
import java.util.List;

public class CommandsTab implements TabCompleter {

    public CommandsTab(Main main) {
        main.getCommand("pleasantchats").setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        ArrayList<String> arg = new ArrayList<>();

        if (args.length == 1) {
            arg.add("reload");
        }
        return arg;
    }
}