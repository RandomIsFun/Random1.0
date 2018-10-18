package random1.thing;

import java.util.Set;
import java.util.stream.Collectors;

import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * I lied it isn't useful
 */
public class UsefulButUselessFeature {
	
	public static Set<Player> getPlayersInWorldWithGhettoStreamsYo(World world) {
		// because world.getPlayers() is too difficult
		return world.getEntities().stream().filter(Player.class::isInstance).map(Player.class::cast).collect(Collectors.toSet());
	}

}
