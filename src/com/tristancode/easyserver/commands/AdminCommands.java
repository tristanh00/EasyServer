package com.tristancode.easyserver.commands;

import com.tristancode.easyserver.EasyServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {
	private EasyServer pl;

	public AdminCommands(EasyServer pl) {
		this.pl = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdN, String[] args) {
		Player p = (Player) sender;
		if(p instanceof Player) {

		if(p.hasPermission("es.admin")) {
		if(args.length < 1) {
			p.sendMessage("§r[§6EasyServer§r] §cby TristanCode");
			p.sendMessage("§a/es motd §7Display current MOTD");
			p.sendMessage("§a/es setmotd §7Et current MOTD");
			p.sendMessage("§a/es jq §7Display the join/quit message");
			p.sendMessage("§a/es setjoin §7Edit current join message");
			p.sendMessage("§a/es setquit §7Edit current quit message");
			p.sendMessage("§a/es welcome §7Display current welcome message");
			p.sendMessage("§a/es setwelcome §7Edit current welcome message");
			p.sendMessage("§a/es playercount §7Display's number of unique joins");
			p.sendMessage("§bC§ao§1l§2o§3r§4C§5o§6d§7e§8s §7work with this plugin, yay!");
		}		
		if(args.length >= 1) {
		if(args[0].equalsIgnoreCase("playercount")) {
			p.sendMessage("§7Number of unique joins : §c" + this.pl.getConfig().getInt("stats.playercount"));
		}
		
		if(args[0].equalsIgnoreCase("motd")) {
			p.sendMessage("§7MOTD : " + this.pl.getConfig().getString("motd.message").replaceAll("&", "§"));
		}
		if(args[0].equalsIgnoreCase("welcome")) {
			p.sendMessage("§7Welcome : §c" + this.pl.getConfig().getString("message.welcome").replaceAll("&", "§"));
		}
		
		if(args[0].equalsIgnoreCase("jq")) {
			p.sendMessage("§7JOIN : "+ ChatColor.RESET + this.pl.getConfig().getString("message.join").replaceAll("&", "§"));
			p.sendMessage("§7QUIT : "+ ChatColor.RESET + this.pl.getConfig().getString("message.quit").replaceAll("&", "§"));
		}
		
		//-------------------------------------
		//Set Messages Commands Bellow
		//-------------------------------------
		
			//Motd
			if(args[0].equalsIgnoreCase("setmotd")) {
				String newMOTD = "";
				for (int i = 1; i < args.length; i++) {
					 if (i == args.length - 1) {
					   newMOTD = newMOTD + args[i];
					 } else {
				       newMOTD = newMOTD + args[i] + " ";
				     }
				}
				if(newMOTD == "") {
					p.sendMessage("§7Current MOTD : " + this.pl.getConfig().getString("motd.message").replaceAll("&", "§"));
					p.sendMessage("§cPlease do /es setmotd <motd> to change the current MOTD.");
				} else {
					newMOTD = newMOTD.replaceAll("&", "§");
					p.sendMessage("§7New MOTD: "+ ChatColor.RESET + newMOTD);
					this.pl.getConfig().set("motd.message", newMOTD);
				    this.pl.saveConfig();
				}
				
			}
			
			//Join
			if(args[0].equalsIgnoreCase("setjoin")) {
				String newJoin = "";
				p.sendMessage("§cPlayer name is represented by %player%");
				for (int i = 1; i < args.length; i++) {
					 if (i == args.length - 1) {
					   newJoin = newJoin + args[i];
					 } else {
				       newJoin = newJoin + args[i] + " ";
				     }
				}
				if(newJoin == "") {
					p.sendMessage("§7Current Join Message : " + this.pl.getConfig().getString("message.join").replaceAll("&", "§"));
					p.sendMessage("§cPlease do /es setjoin <message> to change the join message.");
				} else {
					newJoin = newJoin.replaceAll("&", "§");
					p.sendMessage("§7New Join Message: "+ ChatColor.RESET + newJoin);
					this.pl.getConfig().set("message.join", newJoin);
				    this.pl.saveConfig();
				}
				
			}
			
			//Quit
			if(args[0].equalsIgnoreCase("setquit")) {
				String newQuit = "";
				p.sendMessage("§cPlayer name is represented by %player%");
				for (int i = 1; i < args.length; i++) {
					 if (i == args.length - 1) {
					   newQuit = newQuit + args[i];
					 } else {
					   newQuit = newQuit + args[i] + " ";
				     }
				}
				if(newQuit == "") {
					p.sendMessage("§7Current Quit Message : " + this.pl.getConfig().getString("message.quit").replaceAll("&", "§"));
					p.sendMessage("§cPlease do /es setquit <message> to change the quit message.");
				} else {
					newQuit = newQuit.replaceAll("&", "§");
					p.sendMessage("§7New Quit Message: "+ ChatColor.RESET + newQuit);
					this.pl.getConfig().set("message.quit", newQuit);
				    this.pl.saveConfig();
				}
				
			}
			
			//Welcome
			if(args[0].equalsIgnoreCase("setwelcome")) {
				String Welcome = "";
				p.sendMessage("§cPlayer name is represented by %player%");
				for (int i = 1; i < args.length; i++) {
					 if (i == args.length - 1) {
					   Welcome = Welcome + args[i];
					 } else {
					   Welcome = Welcome + args[i] + " ";
				     }
				}
				if(Welcome == "") {
					p.sendMessage("§7Current Welcome Message : " + this.pl.getConfig().getString("message.welcome").replaceAll("&", "§"));
					p.sendMessage("§cPlease do /es setwelcome <message> to change the welcome message.");
				} else {
					Welcome = Welcome.replaceAll("&", "§");
					p.sendMessage("§7New Welcome Message: "+ ChatColor.RESET + Welcome);
					this.pl.getConfig().set("message.welcome", Welcome);
				    this.pl.saveConfig();
				}
				
			}
		}
	
	}}
		
		return false;
		
	}
}	
