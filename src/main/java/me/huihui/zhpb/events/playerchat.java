package me.huihui.zhpb.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import me.huihui.zhpb.Main;

import java.util.List;

public class playerchat implements Listener {
    Plugin plugin = Main.getPlugin(Main.class);
    @EventHandler
    public void playerchat(AsyncPlayerChatEvent event){
        List<String> zhList = plugin.getConfig().getStringList("ZangHuaList");
        String Message = event.getMessage();
        boolean isZangHuaSpeak = false;
        StringBuilder replacement = new StringBuilder("*");
        for (int i = 0; i < zhList.toArray().length; i++){
            if (Message.contains(zhList.get(i))){
                for (int x = 1; x < zhList.get(i).length(); x++){
                    replacement.append("*");
                }
                Message = Message.replace(zhList.get(i), replacement);
                event.getPlayer().sendMessage(ChatColor.RED + "您说了脏话：" + zhList.get(i));
                isZangHuaSpeak = true;
            }
        }
        if (isZangHuaSpeak){
            event.setMessage(Message);
        }
    }
}
