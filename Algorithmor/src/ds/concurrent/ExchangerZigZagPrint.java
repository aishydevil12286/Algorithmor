package ds.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerZigZagPrint {

	public static void main(String[] args) {
	    Exchanger<Boolean> exgr = new Exchanger<Boolean>();
	    
	    new PrintEven(exgr); 
	    new PrintOdd(exgr);
	}
}

//A Thread that constructs a string. 
class PrintEven implements Runnable { 
Exchanger<Boolean> ex; 
Boolean flag; 

PrintEven(Exchanger<Boolean> c) { 
 ex = c; 
 flag = new Boolean(false); 

 new Thread(this).start(); 
} 

public void run() { 
 for(int i = 0; i < 30; i++) { 
   try {
     flag = ex.exchange(flag);
   } catch(InterruptedException exc) { 
     System.out.println(exc); 
   }
   if(flag){
	   System.out.println("PrintEven "+i);
   }
 }         
} 
} 

//A Thread that constructs a string. 
class PrintOdd implements Runnable { 
Exchanger<Boolean> ex; 
Boolean flag; 

PrintOdd(Exchanger<Boolean> c) { 
ex = c; 
flag = new Boolean(true); 

new Thread(this).start(); 
} 

public void run() { 
for(int i = 0; i < 30; i++) { 
 try {
   flag = ex.exchange(flag);
 } catch(InterruptedException exc) { 
   System.out.println(exc); 
 }
 if(flag){
	   System.out.println("PrintOdd "+i);
 }
}         
} 
} 