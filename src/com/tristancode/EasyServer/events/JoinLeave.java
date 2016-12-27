package com.tristancode.EasyServer.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import com.tristancode.EasyServer.EasyServer;

public class JoinLeave implements Listener {
	private EasyServer pl;

	public JoinLeave(EasyServer pl) {
		this.pl = pl;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent join) {
		String player = join.getPlayer().getName();

		//Player Counter
		if (!join.getPlayer().hasPlayedBefore()) {
		  Bukkit.getServer().broadcastMessage(this.pl.getConfig().getString("message.welcome").replaceAll("%player%", player).replaceAll("&", "§"));
	      int PlayerCount = this.pl.getConfig().getInt("stats.playercount");
	      PlayerCount++;
	      this.pl.getConfig().set("stats.playercount", PlayerCount);
	      this.pl.saveConfig();
		}
		
		String JoinM = this.pl.getConfig().getString("message.join").replaceAll("%player%", player).replaceAll("&", "§");;

		join.setJoinMessage(JoinM);
	}

	 
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent leave) {
		String player = leave.getPlayer().getName();
		String LeaveM = this.pl.getConfig().getString("message.quit").replaceAll("%player%", player).replaceAll("&", "§");;
		
        leave.setQuitMessage(LeaveM);
	}
}
