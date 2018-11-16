class Account
{
	float amount;
	
	synchronized void withdraw(float amt) {
		try
        { 
			System.out.println("Details for Thread"+Thread.currentThread());
            Thread.sleep(1000); 
            
            if(amount - amt < 0)
    			System.out.println("Insufficient Funds. Current Balance is"+amount);
    		else {
    			amount -=amt;
    			System.out.println("Balance is "+amount);
    		}
        } 
        catch (Exception e) 
        { 
            System.out.println("Thread  interrupted."); 
        } 	
	}
}

class AccountThread extends Thread
{
	private float amt;
	Account A;
	
	AccountThread(float amt, Account A1){
		this.amt = amt;
		this.A = A1;
	}
	
	public void run() {
// Uncomment the following lines if we dont have access to the Account class and withdraw method can not be synchronized.
//		synchronized(A)
//		{
			A.withdraw(amt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
//		}
	}
}


class SynchronizationBankEx
{
	public static void main(String args[]) {
		Account A = new Account();
		A.amount = 7000;
		AccountThread T1 = new AccountThread(5000, A);
		AccountThread T2 = new AccountThread(7000, A);
		
		T1.start();
		T2.start();
		
		try {
			T1.join();
			T2.join();
		}
		catch(Exception e) {
			System.out.println("Interrupted"); 
		}
	}
}
