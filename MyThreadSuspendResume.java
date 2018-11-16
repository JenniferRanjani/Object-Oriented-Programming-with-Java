class NewThread extends Thread{
	String name;
	boolean flag;
	
	NewThread(String tName){
		super(tName);
		name= tName;
		flag = false;
		System.out.println("Child"+this);
	}
	
	public void run()
	{
		try {
			for(int n = 5; n>0; n--) {
				System.out.println("Child Thread: "+name+": "+n);
				Thread.sleep(2000);   
				
				synchronized(this)
				{
					while(flag) {
						wait();
					}
				}
				
			}
		}catch(InterruptedException e) {
			System.out.println("Child Interrupted");
		}
		System.out.println("Exiting Child");
	}
	
	synchronized void mySuspend()
	{
		flag = true;
	}
	
	synchronized void myResume()
	{
		flag = false;
		notify();
	}
}


class MyThreadSuspendResume
{
	public static void main(String args[]) {
		Thread t = Thread.currentThread();
		t.setPriority(1);
		
		NewThread nt1 = new NewThread("One");
		NewThread nt2 = new NewThread("Two");
		
		
		nt1.start();
		nt2.start();
		
		
		try {
			Thread.sleep(2000);
			
			nt1.mySuspend();
			System.out.println("Suspending first Thread");
			
			nt2.mySuspend();
			System.out.println("Suspending second Thread");
			Thread.sleep(2000);
			
			System.out.println("Resuming first Thread");
			nt1.myResume();
			Thread.sleep(3000);
			System.out.println("Resuming second Thread");
			nt2.myResume();
			
			
		}
			catch(Exception e) {
				System.out.println("Main Interrupted");
			}
		
		try {
			nt1.join();
			nt2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Exiting Main");
		}
}




