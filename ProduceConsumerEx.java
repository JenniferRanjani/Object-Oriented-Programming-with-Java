public class ProduceConsumerEx {
   public static void main(String[] args) {
      CubbyHole c = new CubbyHole();
      Producer p1 = new Producer(c, 1);
      Consumer c1 = new Consumer(c, 1);
      Consumer c2 = new Consumer(c, 2);
      p1.start(); 
      c1.start();
      c2.start();
   }
}

//Uncomment these lines to understand what will happen when inter thread communication is not available.
//class CubbyHole
//{
//	private int contents;
//	
//	synchronized int get()
//	{
//		return contents;
//	}
//	
//	synchronized void put(int value) {
//		contents = value;
//	}
//}
class CubbyHole {
   private int contents;
   private boolean available = false;
   
   public synchronized int get() {
      while (available == false) {
         try {
            wait();
         } catch (InterruptedException e) {}
      }
      available = false;
      notifyAll();
      return contents;
   }
   public synchronized void put(int value) {
      while (available == true) {
         try {
            wait();
         } catch (InterruptedException e) { } 
      }
      contents = value;
      available = true;
      notifyAll();
   }
}
class Consumer extends Thread {
   private CubbyHole cubbyhole;
   private int number;
   
   public Consumer(CubbyHole c, int number) {
      cubbyhole = c;
      this.number = number;
   }
   public void run() {
      int value = 0;
      for (int i = 0; i < 10; i++) {
         value = cubbyhole.get();
         System.out.println("Consumer #" + this.number + " got: " + value);
      }
   }
}
class Producer extends Thread {
   private CubbyHole cubbyhole;
   private int number;
   public Producer(CubbyHole c, int number) {
      cubbyhole = c;
      this.number = number;
   } 
   public void run() {
      for (int i = 0; i < 20; i++) {
    	 int val = (int)(Math.random() * 100);
         cubbyhole.put(val);
         System.out.println("Producer #" + this.number + " put: " + val);
         try {
            sleep(1000);
         } catch (InterruptedException e) { }
      } 
   }
} 
