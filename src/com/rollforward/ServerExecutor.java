package com.rollforward;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * This class implements the Executor that will execute the server tasks. It
 * extends the ThreadPoolExecutor
 * 
 * @author Isuru
 *
 */
public class ServerExecutor extends ThreadPoolExecutor {

	/**
	 * Core pool size of the executor. Initialize with the available processors
	 */
	private static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

	/**
	 * Maximum pool size of the executor. Initialize with the available
	 * processors
	 */
	private static int MAXIMUM_POOL_SIZE = Runtime.getRuntime().availableProcessors();

	/**
	 * Time the threads of the executor can be idle
	 */
	private static long KEEP_ALIVE_TIME = 10;


	/**
	 * Constructor of the class
	 */
	public ServerExecutor() {
		super(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, 
				TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

	
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		ServerTask<?> task = (ServerTask<?>) r;
		RollForwardCommand command = task.getCommand();

		if (t == null) {
			if (!task.isCancelled()) {
				
			} else {
				String message = "The task " + command.hashCode() + " of user " + command.getUserName()
						+ " has been cancelled.";
				// Logger.sendMessage(message);
			}

		} else {
			String message = "The exception " + t.getMessage() + " has been thrown.";

		}
	}

	
	/**
	 * This method is executed to create the Task object that will execute a
	 * Runnable (our commands in this case) in the executor. We override the
	 * default task to store the command on it and have access to its data in
	 * the afterExecute() method
	 */
	@Override
	protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
		return new ServerTask<T>((RollForwardCommand) runnable);
	}

}
