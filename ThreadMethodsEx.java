
class NewThread extends Thread{
	String name;
	NewThread(String tName){
		super(tName);
		name= tName;
		System.out.println("Child"+this);
	}
	
	public void run()
	{
		try {
			for(int n = 5; n>0; n--) {
				System.out.println("Child Thread: "+name+": "+n);
				Thread.sleep(500);   // time specified in milli seconds u can also use Thread.sleep(milli,nano)
			}
		}catch(InterruptedException e) {
			System.out.println("Child Interrupted");
		}
		System.out.println("Exiting Child");
	}
}


class ThreadMethodsEx
{
	public static void main(String args[]) {
		
		NewThread nt1 = new NewThread("One");
		NewThread nt2 = new NewThread("Two");
		NewThread nt3 = new NewThread("Three");
		
		nt1.start();
		nt2.start();
		nt3.start();
		
		try {
// Uncomment the following lines to learn the impact of isAlive()
//			while(nt1.isAlive() | nt2.isAlive() | nt3.isAlive())
//				{	Thread.sleep(5000);
//				}

// Uncomment the following lines to learn the impact of join()
//			nt1.join();
//			nt2.join();
//			nt3.join();
			
			
			for(int n = 5; n>0; n--) {
				System.out.println("Main thread"+n);
				   Thread.sleep(1000);   // time specified in milli seconds u can also use Thread.sleep(milli,nano)
// Try using yield() instead of sleep()
//				Thread.yield();
			}
		}
			catch(Exception e) {
				System.out.println("Main Interrupted");
			}
		System.out.println("Exiting Main");
		}
}
