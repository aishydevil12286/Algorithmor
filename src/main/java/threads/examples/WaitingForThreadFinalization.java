package threads.examples;

/*
 * In some cases we need a particular task to complete before we can start off with another task. In such cases we can use the join method to 
 * suspend the execution of the calling thread until the execution of the called thread finishes. For example, this can be helpful if we want certain 
 * resources to be initialized, which need to finish before moving onto the next task. IN such a case we can have an initializationTask executes as a
 * thread and then the calling thread can join to the initializationTask thread so that the further execution happens when the initialization completes.
 */

public class WaitingForThreadFinalization {
	public class initializationTask1 implements Runnable{
		@Override
		public void run(){
			System.out.println("Starting initialization task 1");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Ending initialization task 1");
		}
	}
	
	public class initializationTask2 implements Runnable{
		@Override
		public void run(){
			System.out.println("Starting initialization task 2");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Ending initialization task 2");
		}
	}
	
	public static void main(String[] args){
		WaitingForThreadFinalization w = new WaitingForThreadFinalization();
		WaitingForThreadFinalization.initializationTask1 task1 = w.new initializationTask1();
		WaitingForThreadFinalization.initializationTask2 task2 = w.new initializationTask2();
		
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All initializations complete");
		System.out.println("Executing the main task now");		
	}
}
