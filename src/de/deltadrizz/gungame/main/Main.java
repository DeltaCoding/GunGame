package de.deltadrizz.gungame.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import de.deltadrizz.gungame.listener.EntityDamage;
import de.deltadrizz.gungame.listener.EntityDeath;
import de.deltadrizz.gungame.listener.PlayerJoin;
import de.deltadrizz.gungame.listener.PlayerQuit;

public class Main extends JavaPlugin {

	private static Main instance;
	
	public final String prefix = "§a[§6GunGame§a]§r ";
	
	//Location of Middle point
	public Location nonPVPmiddle;
	
	//Store levels of Player & Level -> equipment
	public Map<Player, Integer> playerLevels;
	public Map<Integer, List<ItemStack>> equipment;
	
	@Override
	public void onLoad() {
		Main.instance = this;
		this.nonPVPmiddle = new Location(Bukkit.getWorld("world"), -1, 76, 171);
		this.playerLevels = new HashMap<Player, Integer>();
		this.equipment = new HashMap<Integer, List<ItemStack>>();
		this.initializeEquipment();
	}
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(this.prefix + "GunGame v" + this.getDescription().getVersion() + " enabled");
		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		this.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
		this.getServer().getPluginManager().registerEvents(new EntityDeath(), this);
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(this.prefix + "GunGame v" + this.getDescription().getVersion() + " disabled");
	}
	
	public static Main getInstance() {
		return Main.instance;
	}
	
	private void initializeEquipment() {
		List<ItemStack> level0 = new ArrayList<ItemStack>();
		level0.add(new ItemStack(Material.WOOD_SWORD));
		
		List<ItemStack> level1 = new ArrayList<ItemStack>();
		level1.add(new ItemStack(Material.STONE_SWORD));
		
		List<ItemStack> level2 = new ArrayList<ItemStack>();
		level2.add(new ItemStack(Material.IRON_SWORD));
		
		List<ItemStack> level3 = new ArrayList<ItemStack>();
		level3.add(new ItemStack(Material.DIAMOND_SWORD));
		level3.add(new ItemStack(Material.FIREBALL));
		
		this.equipment.put(0, level0);
		this.equipment.put(1, level1);
		this.equipment.put(2, level2);
		this.equipment.put(3, level3);
	}
	
}
