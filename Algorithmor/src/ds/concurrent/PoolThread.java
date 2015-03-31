package ds.concurrent;

public class PoolThread extends Thread {
	BlockingQueue<Runnable> taskQueue = null;	
	private boolean isStopped = false;
	
	public PoolThread(String name,BlockingQueue queue){
		this.setName(name);
		this.taskQueue = queue;
	}
	
	@Override
	public void run() {
		while(!isStopped){
			try{
				if(!taskQueue.isEmpty()){
				Runnable task = taskQueue.dequeue();
				task.run();
				}
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
