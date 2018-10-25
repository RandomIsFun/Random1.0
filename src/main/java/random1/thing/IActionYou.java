package random1.thing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class IActionYou {

    // This is a very complex method, which invokes another function to get the message to send to the player.
    public static void doAction(String action, Player giver, Player target){
        Bukkit.broadcastMessage(ChatColor.GREEN + giver.getName() + " " + action + " " + target.getName());
    }

}
