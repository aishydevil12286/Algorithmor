package ds.concurrent;

public class BlockingQueueTest {

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
