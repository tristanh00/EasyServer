package com.tristancode.easyserver.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import com.tristancode.easyserver.EasyServer;

public class Motd implements Listener {
	private EasyServer pl;

	public Motd(EasyServer pl) {
		this.pl = pl;
	}
	
	@EventHandler
	public void onServerLookup(ServerListPingEvent e) {
		String motd = this.pl.getConfig().getString("motd.message").replaceAll("&", "§");
		e.setMotd(motd);
	}
}
