import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Practice{
	
	 public static void main(String args[])
	 {
		 BlockingQueue<Integer> items = new ArrayBlockingQueue<Integer>(5);
		 
		 Thread R1 = new Thread(new producer("Produced",items));
		 Thread R2 = new Thread(new consumer("Consumed",items));
		 R1.start();
		 R2.start();
		 
		 
	 }

}

class producer extends Thread{
	private String threadName;
	private BlockingQueue<Integer> q;
	
	producer(String name, BlockingQueue<Integer> item)
	{
		threadName=name;
		this.q=item;
	}
	
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			try {
				q.put(i);
				System.out.println(threadName+": "+ i);
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class consumer extends Thread{
	private String threadName;
	private BlockingQueue<Integer> q;
	
	consumer(String name, BlockingQueue<Integer> item)
	{
		threadName=name;
		this.q=item;
	}
	
	public void run()
	{
		while(true)
		{
		try {
			int temp=q.take();
			System.out.println(threadName+": "+ temp);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}