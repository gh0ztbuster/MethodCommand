package com.saerix.methodcommands.handlers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.saerix.methodcommands.ArgumentHandler;
import com.saerix.methodcommands.ArgumentVariable;
import com.saerix.methodcommands.CommandArgument;
import com.saerix.methodcommands.CommandError;
import com.saerix.methodcommands.TransformError;

public class PlayerArgumentHandler extends ArgumentHandler<Player> {
	public PlayerArgumentHandler() {
		setMessage("player_not_online", "The player %1 is not online");
		
		addVariable("sender", "The command executor", new ArgumentVariable<Player>() {
			@Override
			public Player var(CommandSender sender, CommandArgument argument, String varName) throws CommandError {
				if(!(sender instanceof Player))
					throw new CommandError(argument.getMessage("cant_as_console"));
				
				return ((Player)sender);
			}
		});
	}

	@Override
	public Player transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
		Player p = Bukkit.getPlayer(value);
		if(p == null)
			throw new TransformError(argument.getMessage("player_not_online", value));
		
		return p;
	}
}
