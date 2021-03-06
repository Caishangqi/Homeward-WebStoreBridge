package com.arcanetravel.util;

import com.arcanetravel.command.Main;
import com.arcanetravel.command.OpenDelivery;
import com.arcanetravel.command.TestSerialize;
import com.arcanetravel.shopconnectbridge;
import org.bukkit.ChatColor;

//用来测试命令注册
public class CommandRegister {
    public shopconnectbridge plugin;

    public CommandRegister() {

    }

    public CommandRegister(shopconnectbridge plugin) {
        this.plugin = plugin;
    }

    public void RegisterCommand() {
        Util.logger.info(ChatColor.translateAlternateColorCodes('&', "&7&l[&6!&7] &f指令模块开始注册"));
        plugin.getCommand("purchase").setExecutor(new OpenDelivery(plugin));
        plugin.getCommand("serialize").setExecutor(new TestSerialize());
        //利用API注册的指令
        shopconnectbridge.commandManager.register(new Main());
        Util.logger.info(ChatColor.translateAlternateColorCodes('&', "&7&l[&2+&7] &f指令模块注册完毕"));
    }
}
