package com.saerix.methodcommands;

public interface HelpHandler {
	public String[] getHelpMessage(RegisteredCommand command);
	public String getUsage(RegisteredCommand command);
}
