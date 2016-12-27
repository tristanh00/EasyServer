package commands;

import com.tristancode.EasyServer.EasyServer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Hand implements CommandExecutor {
	//private EasyServer pl;

	public Hand(EasyServer pl) {
	//	this.pl = pl;
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdN, String[] args) {
		Player p = (Player) sender;
		StringBuilder stringBuilder = new StringBuilder();
		ItemStack itemStack = p.getItemInHand();

		stringBuilder.append(itemStack.getTypeId());

        if (itemStack.getData() != null && itemStack.getData().getData() != 0) {
            stringBuilder.append(":" + itemStack.getData().getData());
        }
         
		if(p instanceof Player) {
			if(args.length < 1) {
				p.sendMessage("§aItem Name : §7" + p.getItemInHand().getType());
				p.sendMessage("§aItem ID in your hand : §7" + stringBuilder.toString());
			}		
		}
		return false;
		
	}
}	
