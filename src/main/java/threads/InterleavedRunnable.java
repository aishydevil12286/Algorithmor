package threads;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class InterleavedRunnable implements Runnable{

	  private final String name;
	  private final Exchanger<Boolean> exchanger;

	  private Boolean state;

	  public InterleavedRunnable(String name, Exchanger<Boolean> exchanger, 
	       Boolean state) {
	    this.name = name;
	    this.exchanger = exchanger;
	    this.state = state;
	  }         

	  @Override
	  public void run() {
	    try {
	      while (true) {
	        if (state) {
	          System.out.println(name);
	        }
	        state = exchanger.exchange(state);
	      }
	    } catch (InterruptedException ex) {
	      Logger.getLogger(name).info("Interrupted");
	    }
	  }
	  
	  public static void main(String[] args) {
		    Exchanger<Boolean> exchanger = new Exchanger<Boolean>();
		    Thread thread1 = new Thread(new InterleavedRunnable("Thread 1", exchanger, true));
		    Thread thread2 = new Thread(new InterleavedRunnable("Thread 2", exchanger, false));
		    thread1.start();
		    thread2.start();
	  }
}
