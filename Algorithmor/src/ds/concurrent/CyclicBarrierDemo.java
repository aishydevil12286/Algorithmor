package ds.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
	    CyclicBarrier cb = new CyclicBarrier(3, new BarAction() ); 
	    
	    System.out.println("Starting"); 
	 
	    new MyBarrierThread(cb, "A"); 
	    new MyBarrierThread(cb, "B"); 
	    new MyBarrierThread(cb, "C");
	    new MyBarrierThread(cb, "X");
	    new MyBarrierThread(cb, "Y"); 
	    new MyBarrierThread(cb, "Z"); 
	    new MyBarrierThread(cb, "M"); 
	    new MyBarrierThread(cb, "N"); 
	    new MyBarrierThread(cb, "O"); 

	}

}

//A thread of execution that uses a CyclicBarrier. 
class MyBarrierThread implements Runnable { 
CyclicBarrier cbar; 
String name; 

MyBarrierThread(CyclicBarrier c, String n) { 
 cbar = c; 
 name = n; 
 new Thread(this).start(); 
} 

public void run() { 
  
 System.out.println(name); 

 try { 
   cbar.await(); 
 } catch (BrokenBarrierException exc) { 
   System.out.println(exc); 
 } catch (InterruptedException exc) { 
   System.out.println(exc); 
 } 
} 
} 

//An object of this class is called when the  
//CyclicBarrier ends. 
class BarAction implements Runnable { 
public void run() { 
 System.out.println("Barrier Reached!"); 
} 
}