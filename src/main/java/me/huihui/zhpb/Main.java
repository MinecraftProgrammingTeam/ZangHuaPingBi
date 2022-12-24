package me.huihui.zhpb;

import me.huihui.zhpb.events.playerchat;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Plugin plugin = getPlugin(Main.class);
        // register events
        getServer().getPluginManager().registerEvents(new playerchat(), this);
        System.out.println(ChatColor.RED + "[脏话屏蔽]插件已启用");
        System.out.println("列表里的脏话：" + plugin.getConfig().getStringList("ZangHuaList").toString());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
