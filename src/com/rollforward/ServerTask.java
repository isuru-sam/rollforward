package com.rollforward;



import java.util.concurrent.FutureTask;



/**
 * The tasks of the executor are always instances of the FutureTask class. We extends this class to
 * implement our task instances and store the commands on it and have access to its data
 * @author ISuru
 *
 * @param <V> This param is not used
 */
public class ServerTask<V> extends FutureTask<V> {

	/**
	 * Command that is executed by this task
	 */
	private RollForwardCommand command;
	
	/**
	 * Constructor of the class
	 * @param command Command that will be executed by this task
	 */
	public ServerTask(RollForwardCommand command) {
		super(command, null);
		this.command=command;
	}

	/**
	 * Method that returns the command executed by this task
	 * @return
	 */
	public RollForwardCommand getCommand() {
		return command;
	}

	/**
	 * Method that establish the command executed by this task
	 * @param command
	 */
	public void setCommand(RollForwardCommand command) {
		this.command = command;
	}

	
}
