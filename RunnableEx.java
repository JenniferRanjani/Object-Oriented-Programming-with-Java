class NewThread implements Runnable{
	Thread t;
	
	NewThread(){
		t = new Thread(this,"Demo");
		System.out.println("Child"+t);
//		t.start();    // Thread can also be started while it is created
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


class RunnableEx
{
	public static void main(String args[]) {
		
		NewThread nt = new NewThread();
		
		nt.t.start();
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
