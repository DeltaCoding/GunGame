package de.deltadrizz.gungame.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import de.deltadrizz.gungame.main.Main;

public class EntityDeath implements Listener {

	public void on(EntityDeathEvent e) {
		Player victim = null;
		Player killer = null;
		
		if(e.getEntity() instanceof Player)
			victim = (Player) e.getEntity();
		if(victim.getKiller() instanceof Player)
			killer = victim.getKiller();
		
		int levelVictim = Main.getInstance().playerLevels.get(victim);
		int levelKiller = Main.getInstance().playerLevels.get(killer);
		
		if(levelKiller++ > 3)
			levelKiller = 3;
		else
			levelKiller++;
		
		if(levelVictim-- > 3)
			levelVictim = 3;
		else
			levelVictim--;
		
		victim.getInventory().clear();
		killer.getInventory().clear();
		
		for(ItemStack item : Main.getInstance().equipment.get(levelVictim)) {
			victim.getInventory().addItem(item);
		}
		
		for(ItemStack item : Main.getInstance().equipment.get(levelKiller)) {
			killer.getInventory().addItem(item);
		}
		
		Main.getInstance().playerLevels.put(victim, levelVictim);
		Main.getInstance().playerLevels.put(killer, levelKiller);
	}
	
}
