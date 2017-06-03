package threads.examples;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

/* Java has a special kind of thread called daemon thread. These kind of threads have very low 
 * priority and normally only executes when no other thread of the same program is running. 
 * When daemon threads are the only threads running in a program, the JVM ends the program 
 * finishing these threads.
 * 
 * With these characteristics, the daemon threads are normally used as service providers for 
 * normal (also called user) threads running in the same program. They usually have an infinite 
 * loop that waits for the service request or performs the tasks of the thread. They can't do 
 * important jobs because we don't know when they are going to have CPU time and they can 
 * finish any time if there aren't any other threads running. A typical example of these kind of 
 * threads is the Java garbage collector. 
 * 
 * In this recipe, we will learn how to create a daemon thread developing an example with two 
 * threads; one user thread that writes events on a queue and a daemon one that cleans that 
 * queue, removing the events which were generated more than 10 seconds ago.
*/

class Event{
	private final Date date;
	private final String type;
	
	public Event(Date date,String type){
		this.date = date;
		this.type = type;
	}
	
	public Date getDate() {
		return date;
	}

	public String getType() {
		return type;
	}	
}

 class WriterTask implements Runnable{
	private Deque<Event> deque;
	
	public WriterTask(Deque<Event> deque){
		this.deque = deque;
	}

	@Override
	public void run() {
		for (int i=1; i<10000; i++) {		      
              String type = String.format("The thread %s has generated an event",Thread.currentThread().getId());
              System.out.println(type);
		      Event event=new Event(new Date(),type);
		      deque.addFirst(event);
		      try {
		        Thread.sleep(10);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
	}
	 
 }

 /*
  * Daemon Thread that cleans the events that are added to the deque
  */
 class DaemonCleaner extends Thread {
	
	 private Deque<Event> deque;
	 
	 public DaemonCleaner(Deque<Event> deque) {
	    this.deque = deque;
	    setDaemon(true);
	 }
	 
	 @Override
	  public void run() {
	    while (true) {
	      Date date = new Date();
	      clean(date);
	    }
	  }
	 
	 private void clean(Date date) {
		    long difference;
		    boolean delete;
		    
		    if (deque.size()==0) {
		      return;
		    }
		    delete=false;
		    do {
		      Event e = deque.getLast();
		      difference = date.getTime() - e.getDate().getTime();
		      if (difference > 10000) {
		        System.out.println(String.format("Cleaner: %s\n",e.getType()));
		        deque.removeLast();
		        delete=true;
		      }  
		    } while (difference > 10000);
		    if (delete){
		      System.out.printf("Cleaner: Size of the queue: %d\n",deque.
		size());
		    }
		  }
}

public class DaemonThread{
	public static void main(String[] args) {
		 Deque<Event> deque=new ArrayDeque<Event>();
		 
		 WriterTask writer=new WriterTask(deque);
		    for (int i=0; i<3; i++){
		      Thread thread=new Thread(writer);
		      thread.start();
		    }
		    DaemonCleaner cleaner=new DaemonCleaner(deque);
		    cleaner.start();
	}
}
