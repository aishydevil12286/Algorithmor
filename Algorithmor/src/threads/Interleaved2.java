package threads;

class Thread1 implements Runnable {
private int counter = 1;
@Override
public void run() {
    while(true){
        synchronized (Interleaved2.obj) {
            try {
            	Interleaved2.obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(counter);
        counter += 2;



        synchronized (Interleaved2.obj) {

        	Interleaved2.obj.notify();

        }
    }

}

}


class Thread2 implements Runnable{
	private int counter = 2;
@Override
public void run() {
    while(true){
        synchronized (Interleaved2.obj) {
            try {
            	Interleaved2.obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counter);
        counter += 2;
        synchronized (Interleaved2.obj) {

        	Interleaved2.obj.notify();

        }
    }

}
}


public class Interleaved2 {

public volatile static Object obj =  new Object();

/**
 * @param args
 */
public static void main(String[] args) {

    Thread t1 = new Thread(new Thread1());
    Thread t2 = new Thread(new Thread2());
    t1.start();
    t2.start();
    synchronized (obj) {
        obj.notifyAll();
    }

}

}
