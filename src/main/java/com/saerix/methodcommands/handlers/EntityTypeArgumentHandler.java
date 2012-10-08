package com.saerix.methodcommands.handlers;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;

import com.saerix.methodcommands.ArgumentHandler;
import com.saerix.methodcommands.CommandArgument;
import com.saerix.methodcommands.TransformError;

public class EntityTypeArgumentHandler extends ArgumentHandler<EntityType> {
	public EntityTypeArgumentHandler() {
		setMessage("parse_error", "There is no entity named %1");
		setMessage("include_error", "There is no entity named %1");
		setMessage("exclude_error", "There is no entity named %1");
	}

	@Override
	public EntityType transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
		try {
			return EntityType.fromId(Integer.parseInt(value));
		}
		catch(NumberFormatException e) {}
		
		EntityType t = EntityType.fromName(value);
		
		if(t != null)
			return t;
		
		throw new TransformError(argument.getMessage("parse_error", value));
	}
	
}
