package de.deltadrizz.gungame.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import de.deltadrizz.gungame.main.Main;

public class PlayerJoin implements Listener {

	@EventHandler
	public void on(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("");
		Main.getInstance().playerLevels.put(e.getPlayer(), 0);
		p.getInventory().clear();
		
		for(ItemStack item : Main.getInstance().equipment.get(0)) {
			p.getInventory().addItem(item);
		}
	}
	
}
