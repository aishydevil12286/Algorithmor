package threads.examples;

import java.util.Random;

class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(String.format("The thread %s has thrown an Exception\n", t.getId()));
		e.printStackTrace(System.out);
		System.out.println(String.format("Terminating the rest of the Threads\n"));
		interrupt();
	}
}

class Divisortask implements Runnable {
	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while (true) {
			result = 1000 / ((int) (random.nextDouble() * 1000));
			System.out.println(String.format("%s : %f\n", Thread.currentThread().getId(),result));
			if (Thread.currentThread().isInterrupted()) {
				System.out.println(String.format("%d : Interrupted\n", Thread.currentThread().getId()));
				return;
			}
		}
	}
}

public class CatchThreadGroupUncaughtException {
	public static void main(String[] args) {
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		Divisortask task = new Divisortask();

		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
	}
}
