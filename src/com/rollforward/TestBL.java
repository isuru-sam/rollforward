package com.rollforward;

import java.util.concurrent.CopyOnWriteArrayList;

//import com.java.executor.test.TaskDetailsDto;

public class TestBL {
	private static ServerExecutor pool = new ServerExecutor();
	private static CopyOnWriteArrayList<ServerTask<?>> l = new CopyOnWriteArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RollForwardCommand rc = new RollForwardCommand("f111", "user1");
		ServerTask<?> controller = (ServerTask<?>) pool.submit(rc);
		l.add(controller);

	}
public static void  remove() {
	
	l.removeIf(x->x.getCommand().getFlightId()=="ee");
}
}
