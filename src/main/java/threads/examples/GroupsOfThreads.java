package threads.examples;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* Let's say we need to search for something in a set of huge files. It is possible that the data we are looking for is not in the first two 
 * files at all and is present at the start of the third file. So, one approach we can follow is to have search threads invoked for each file and then 
 * if one of the threads finishes the search we can interrupt all the search threads because the result has already been found. 
 */

class Result{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class SearchTask implements Runnable{
	 private Result result;
	  public SearchTask(Result result) {
	    this.result=result;
	  }
	
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
	    System.out.printf("Thread %s: Start\n",name);
	    try {
	      doTask();
	      result.setName(name);
	    } catch (InterruptedException e) {
	      System.out.printf("Thread %s: Interrupted\n",name);
	      return;
	    }
	    System.out.printf("Thread %s: End\n",name);
	  }
	
	 private void doTask() throws InterruptedException {
		    Random random=new Random((new Date()).getTime());
		    int value=(int)(random.nextDouble()*100);
		    System.out.printf("Thread %s: %d\n",Thread.currentThread().
		getName(),value);
		    TimeUnit.SECONDS.sleep(value);
		  }
	}

public class GroupsOfThreads {
	
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		
		// create 10 Thread objects using the SearchTask object
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.print(String.format("Number of Threads: %d\n",(Integer)threadGroup.activeCount()));
		System.out.print(String.format("Information about the Thread Group\n"));
		threadGroup.list();
		
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n", threads[i].getName(),
					threads[i].getState());
		}
		
		GroupsOfThreads.waitFinish(threadGroup);
		 threadGroup.interrupt();
	}
}
