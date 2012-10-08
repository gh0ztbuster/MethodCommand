package com.saerix.methodcommands;

import java.lang.reflect.Method;

import org.bukkit.command.PluginCommand;


public class RootCommand extends RegisteredCommand {
	private PluginCommand root;
	
	RootCommand(PluginCommand root, CommandHandler handler) {
		super(root.getLabel(), handler, null);
		this.root = root;
	}
	
	public PluginCommand getBukkitCommand() {
		return root;
	}
	
	@Override
	void set(Object methodInstance, Method method) {
		super.set(methodInstance, method);
		root.setDescription(getDescription());
		root.setUsage(getUsage());
	}
}
