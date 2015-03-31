package threads.examples;

/*
 * This is to demonstrate how a thread can be interrupted during its operation. PrimeGenerator is a runnable with overridden run() method 
 * which prints prime numbers infinitely. PrimeGenerator instance task is started and then the main Thread sleeps for 5 seconds and then interrupts
 * the task. Primegenerator's run method loop checks if the thread is interrupted and if yes, it prints a message and stops execution.
 */

public class ThreadInterruption {
	public class PrimeGenerator extends Thread{
		
		@Override
		public void run() {
			long number=1L;
			while (true) {
				if (isPrime(number)) {
					System.out.println(String.format("Number %d is Prime",number));
				}
				if (isInterrupted()) {
					System.out.println(String.format("The Prime Generator has been Interrupted"));
					return;
				}
				number++;
			}
		}
		
		private boolean isPrime(long number) {
			if (number <= 2) {
				return true;
			}
			for (long i = 2; i < number; i++) {
				if ((number % i) == 0) {
					return false;
				}
			}
			return true;
		}
	}
		public static void main(String[] args){
			ThreadInterruption t = new ThreadInterruption();
			ThreadInterruption.PrimeGenerator task = t.new PrimeGenerator();
		    task.start();
		    try {
		        Thread.sleep(5000);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		  task.interrupt();
		}
	}
