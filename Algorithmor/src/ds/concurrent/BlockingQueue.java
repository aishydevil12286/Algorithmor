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
				queueEmpty.signalAll();
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
			queueFull.signalAll();
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
		return queue.size() == 0;
	}
	
	public boolean isFull(){
		return queue.size() == size;
	}
}
