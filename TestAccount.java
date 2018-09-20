/* Banking Application that demonstrates the use of Inheritance, Interfaces, Method Overriding and Dynamic Method Dispatch*/

import java.util.*;

interface Bank{
	void deposit(float amount);
	void withdraw(float amount);
	void deductFee();
}
class BankAccount implements Bank{  
private int acc;  
private String name;  
private float amount;  

BankAccount(int acc,String name,float amt){
this.acc = acc;
this.name = name;
this.amount = amt;
}

void setAcc(int acc)
{
	this.acc = acc;
}
void setName(String name)
{
	this.name = name;
}
float getBalance(){
return amount;}  

public void deposit(float amount)
{
	this.amount = this.amount+amount;
}

public void withdraw(float amount)
{
	if (this.amount < amount)
	System.out.println("Insufficient Funds. Withdrawal Failed");
	else
		this.amount=this.amount-amount;
}

public void deductFee()
{
}
}  

class CheckingAccount extends BankAccount implements Bank
{
	private static final float TRANS_FEE = 25;
	private static final int FREE_TRANS = 2;
	private float TransCount =0;
	
	
	CheckingAccount(int acc,String name,float amt)
	{
		super(acc,name,amt);   }
	
	public void deductFee()
	{
		if(TransCount > FREE_TRANS)
		 {float fee = (TransCount-FREE_TRANS)*TRANS_FEE;
		super.withdraw(fee);
		TransCount=0;}
	}
	
	public void deposit(float amount)
	{
		TransCount++;
		super.deposit(amount);
	}
	public void withdraw(float amount)
	{
		TransCount++;
		super.withdraw(amount);
	}
	
}
class TestAccount{  
public static void main(String[] args) {  
	
	Scanner sr = new Scanner(System.in);
	
	System.out.println("Enter 1 for new customers (< 1 year) and 0 for others");
	int yr = sr.nextInt();
	
	
	BankAccount ba;
	if (yr==1) 
		ba = new BankAccount(111,"Ankit",5000);
	else
		ba = new CheckingAccount(111,"Ankit",5000);
    
	
	System.out.println("Initial: "+ba.getBalance());
	
	ba.deposit(1000);
	ba.withdraw(2000);
	ba.deposit(6000);
	System.out.println("After three Transactions: " + ba.getBalance());
	
	ba.deductFee();
	
	System.out.println("After fee Deduction: " + ba.getBalance());
	sr.close();
	
}}

