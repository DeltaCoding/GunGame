package de.deltadrizz.gungame.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.deltadrizz.gungame.main.Main;

public class EntityDamage implements Listener {

	@EventHandler
	public void on(EntityDamageByEntityEvent e) {
		Player damager = null;
		Entity victim = null;
		
		if(e.getDamager() instanceof Player)
			damager = (Player) e.getDamager();
		if(e.getEntity() instanceof Player)
			victim = (Player) e.getEntity();
		
		if(Main.getInstance().nonPVPmiddle.distance(damager.getLocation()) < 10 ||
				Main.getInstance().nonPVPmiddle.distance(victim.getLocation()) < 10) {
			e.setCancelled(true);
			damager.sendMessage(Main.getInstance().prefix + "§cThis is a non-pvp zone!");
		} else {
			e.setCancelled(false);
		}
	}
	
}
