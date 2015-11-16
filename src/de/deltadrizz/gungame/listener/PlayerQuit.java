package de.deltadrizz.gungame.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.deltadrizz.gungame.main.Main;

public class PlayerQuit implements Listener {

	@EventHandler
	public void on(PlayerQuitEvent e) {
		e.setQuitMessage("");
		Main.getInstance().playerLevels.remove(e.getPlayer());
	}
	
}
