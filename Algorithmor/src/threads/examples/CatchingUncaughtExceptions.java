package threads.examples;

import java.lang.Thread.UncaughtExceptionHandler;

class ExceptionHandler implements UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(),
				e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		// Do something illegal that will throw an unchecked exception
		int numero = Integer.parseInt("TTT");
	}
}

public class CatchingUncaughtExceptions {
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
