package random1.thing;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;

/**
 * Copyright (c) Redraskal 2018.
 * [!] This works on Spigot 1.8.8 & 1.13.1
 */
public class UselessButUsefulFeature {

  /**
   * Ever wanted to literally change the max player count on a Spigot server?
   * Ever realized you actually can't do that because Minecraft is stupid?
   * WELL NOW YOU CAN
   * @param maxPlayers  the new player count
   * @throws ReflectiveOperationException
   */
  public static void setMaxPlayers(int maxPlayers) throws ReflectiveOperationException {
    Object craftServer = Bukkit.getServer().getClass().cast(getCraftbukkitClass("CraftServer"));
    Object nmsDedicatedPlayerList = getCraftbukkitClass("CraftServer").getMethod("getHandle").invoke(craftServer);
    Object nmsDedicatedServer = getNMSClass("DedicatedPlayerList").getMethod("getServer").invoke(nmsDedicatedPlayerList);

    Field field_v = getNMSClass("MinecraftServer").getDeclaredField(getNMSVersion().equals("v1_13_R2") ? "s" : "v");
    field_v.setAccessible(true);
    Object nmsPlayerList = field_v.get(nmsDedicatedServer);
    Field field_maxPlayers = getNMSClass("PlayerList").getDeclaredField("maxPlayers");
    field_maxPlayers.setAccessible(true);
    field_maxPlayers.set(nmsPlayerList, maxPlayers);
  }

  public static String getNMSVersion() {
    return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
  }

  public static Class<?> getNMSClass(String name) {
    String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    try {
        return Class.forName("net.minecraft.server." + version + "." + name);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return null;
    }
  }

  public static Class<?> getCraftbukkitClass(String name) {
    String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    try {
        return Class.forName("org.bukkit.craftbukkit." + version + "." + name);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return null;
    }
  }
}