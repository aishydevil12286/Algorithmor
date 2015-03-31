package ds.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool{
	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThread> threads = new ArrayList<PoolThread>();
	private boolean isStopped = false;
	
	public ThreadPool(int size){
		taskQueue = new BlockingQueue<Runnable>(size);
		//Add threads as per the size and start them
		for(int i=0;i<size;i++){
			PoolThread t = new PoolThread("Thread"+i,taskQueue);
			threads.add(t);
		}
		
		for(PoolThread thread : threads){
            thread.start();
        }
		
	}
	
	public synchronized void execute(Runnable task) throws Exception{
		if(this.isStopped){
			throw new IllegalStateException("ThreadPool is stopped");
		}
        this.taskQueue.enqueue(task);
	}
	
	public synchronized void stop(){
		this.isStopped = true;
		for(PoolThread thread : threads){
			thread.doStop();
		}
	}
	
	public static void main(String[] args){
		ThreadPool pool = new ThreadPool(2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		for(int i =0;i<100;i++){
			Runnable task = new Runnable(){
				public void run(){
					System.out.println("Task"+Thread.currentThread().getName());
				}
			};
			try{
			pool.execute(task);
			}catch(Exception e){
				System.out.println("Exception occured in execution");
			}
		}
	}
}
