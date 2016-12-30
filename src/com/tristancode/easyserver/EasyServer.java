package com.tristancode.easyserver;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tristancode.easyserver.commands.*;
import com.tristancode.easyserver.events.*;

public class EasyServer extends JavaPlugin implements Listener {
	public PluginDescriptionFile pyml = this.getDescription();
	
  	//On Server Start
	@Override
	public void onEnable() {
		ConsoleCommandSender logger = this.getServer().getConsoleSender();

		logger.sendMessage(ChatColor.RED + "---------------------------------------");
		logger.sendMessage(ChatColor.GREEN + "["+pyml.getName()+"] has been enabled!");
		logger.sendMessage(ChatColor.RED + "---------------------------------------");
		
		//Get configuration file
		this.saveDefaultConfig();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinLeave(this), this);
		pm.registerEvents(new MOTD(this), this);


		this.getCommand("es").setExecutor(new AdminCommands(this));
		this.getCommand("hand").setExecutor(new Hand(this));


	}
	
  	//On Server Stop
	@Override
	public void onDisable() {
		ConsoleCommandSender logger = this.getServer().getConsoleSender();

		logger.sendMessage(ChatColor.RED + "---------------------------------------");
		logger.sendMessage(ChatColor.GREEN + "["+pyml.getName()+"] has been disabled!");
		logger.sendMessage(ChatColor.RED + "---------------------------------------");
	}
	
}