package com.arcanetravel.util;

import com.arcanetravel.database.tables.CartItem;
import com.arcanetravel.shopconnectbridge;
import dev.triumphteam.gui.guis.StorageGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonUtil {

    public static final String LOAD = "&7&l[&2+&7]";
    public static final String WARN = "&7&l[&6!&7]";
    public static final String INFO = "&7&l[&2I&7]";
    public static final String ERROR = "&7&l[&cx&7]";

    public static java.util.logging.@NotNull Logger logger = Bukkit.getLogger();


    public static void showLog(String state, String log) {

        CommonUtil.logger.info(ChatColor.translateAlternateColorCodes('&', state + " " + log));

    }

    //全局GUI储存 适用于关闭服务请求
    public static void globalSave(HashMap<String, StorageGui> playerDeliverGUI) {

        Integer[] cache = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};
        List<Integer> avaliableIndex = Arrays.asList(cache);


        for (String key : playerDeliverGUI.keySet()) {
            StorageGui playerGui = playerDeliverGUI.get(key);
            String uuid = String.valueOf(key.replace("-", ""));

            for (Integer number : avaliableIndex) {
                if (playerGui.getInventory().getItem(number) != null) {
                    //
                    CartItem cacheItem = new CartItem(uuid, Stream.writeEncodedObject(playerGui.getInventory().getItem(number)), number, 0);

                    try {
                        shopconnectbridge.cartItemDao.create(cacheItem);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }
            }


        }


    }

}
