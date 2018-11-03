class NewThread extends Thread{
	Thread t;
	
	NewThread(){
		super("Demo");
		System.out.println("Child"+this);
//		start();    //starting the thread during its creation
	}
	
	public void run()
	{
		try {
			for(int n = 5; n>0; n--) {
				System.out.println("Child Thread"+n);
				Thread.sleep(500);   // time specified in milli seconds u can also use Thread.sleep(milli,nano)
			}
		}catch(InterruptedException e) {
			System.out.println("Child Interrupted");
		}
		System.out.println("Exiting Child");
	}
}


class ThreadClassEx
{
	public static void main(String args[]) {
		
		NewThread nt = new NewThread();
		
		nt.start();
		try {
			for(int n = 5; n>0; n--) {
				System.out.println("Main thread"+n);
				Thread.sleep(1000);   // time specified in milli seconds u can also use Thread.sleep(milli,nano)
			}
		}
			catch(InterruptedException e) {
				System.out.println("Main Interrupted");
			}
		System.out.println("Exiting Main");
		}
}
