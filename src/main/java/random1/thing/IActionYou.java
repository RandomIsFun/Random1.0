package random1.thing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.RED;

public class IActionYou {

    // This is a very complex method, which invokes another function to get the message to send to the player.
    public static void doAction(String action, Player giver, Player target){
        Bukkit.broadcastMessage(ChatColor.GREEN + giver.getName() + " " + action + " " + target.getName());
    }

    public static void doAnotherAction(String... actions) {
        Bukkit.broadcastMessage(RED + actions[0]);
    }

}