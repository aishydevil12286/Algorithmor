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
			PoolThread t = new PoolThread();
			threads.add(t);
			t.start();			;
		}
	}
	
	public synchronized void execute(Runnable task){
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
	
	private class PoolThread extends Thread{
		
		private boolean isStopped = false;
		
		@Override
		public void run() {
			while(!isStopped){
				try{
					Runnable task = taskQueue.dequeue();
					task.run();
				}catch(Exception e){
					if(!isStopped()){
						e.printStackTrace();
					}
				}
			}
		}

		public synchronized void doStop(){
			isStopped = true;
			this.interrupt();
		}
		
		public synchronized boolean isStopped(){
	        return isStopped;
	    }
	}
}
