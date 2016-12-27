package com.tristancode.EasyServer.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import com.tristancode.EasyServer.EasyServer;

public class MOTD implements Listener {
	private EasyServer pl;

	public MOTD(EasyServer pl) {
		this.pl = pl;
	}
	
	@EventHandler
	public void onServerLookup(ServerListPingEvent e) {
		String motd = this.pl.getConfig().getString("motd.message").replaceAll("&", "§");
		e.setMotd(motd);
	}
}
