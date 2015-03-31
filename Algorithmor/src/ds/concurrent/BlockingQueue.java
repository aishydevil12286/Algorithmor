package ds.concurrent;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
	private LinkedList<T> queue;
	private int size;
	private final int MAXSIZE = Integer.MAX_VALUE;
	
	Lock lock = new ReentrantLock(true);
	
	Condition queueEmpty = lock.newCondition();
	Condition queueFull  = lock.newCondition();
	
	public BlockingQueue(int size){
		this.size = size;
		queue = new LinkedList<T>();
	}
	
	public void enqueue(T item){
		lock.lock();
			try{
				if(queue.size() > size){
					queueFull.await();
				}
				queue.offerLast(item); // adds the item to the end of 
				System.out.println("Added element by "+Thread.currentThread().getName());
				queueEmpty.signal();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
	};
	
	public T dequeue(){
		lock.lock();
		T item = null;
		try{
			if(queue.isEmpty()){
				queueEmpty.await();
			}
			item = queue.pollFirst();
			System.out.println("Removed element by "+Thread.currentThread().getName());
			queueFull.signal();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return item;
	}
	
	public synchronized boolean increaseSize(int increment){
		boolean updateFlag = false;
		if ((size + increment) <= MAXSIZE){
			size += increment;
			updateFlag = true;
		}
		return updateFlag;
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public boolean isFull(){
		return queue.size() == size;
	}
	
	public static void main(String[] args)
		    {
		 
		            final BlockingQueue<String> queueInstance = new BlockingQueue<String>(10);
		            Runnable Thread1 = new Runnable()
		            {		 
		                @Override
		                public void run()
		                    {
		                        for(int i=0;i<5;i++)
		                        {
		                            queueInstance.enqueue(String.valueOf(i));
		                                     
		                            try
		                            {
		                                Thread.sleep(50);
		                            }
		                            catch (InterruptedException e)
		                            {
		                                e.printStackTrace();
		                            }
		                        }
		                    }
		            };
		            Runnable Thread2 = new Runnable()
		            {		 
		                @Override
		                public void run()
		                    {
		                	for(int i=0;i<5;i++)
		                        {
		                            queueInstance.dequeue();
		                            try
		                            {
		                                Thread.sleep(200);
		                            }
		                            catch (InterruptedException e)
		                            {
		                                e.printStackTrace();
		                            }
		                        }
		                    }
		            };
		            Thread t1 = new Thread(Thread1, "Thread1");
		            Thread t2 = new Thread(Thread2, "Thread2");
		            t1.start();
		            t2.start();
		    }
	
	
}
