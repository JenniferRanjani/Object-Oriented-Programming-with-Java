import java.util.*;

class Account{  
int acc;  
String name;  
float amt;  
Account(int acc,String name,float amt){
this.acc = acc;
this.name = name;
this.amt = amt; }

void withdraw(float amt) throws MaxLimitException
{
	if (amt > 20000)
		throw new MaxLimitException(amt-20000);
}
} 

class MaxLimitException extends Exception
{
	private float amt;
	
	MaxLimitException(float amt)
	{
	this.amt = amt;	
	}
	
	public String toString()
	{
		return "You are trying to withdraw an extra amount of Rs. "+amt;
	}
}

class AccountExceptionEx {  
public static void main(String[] args) {  

Account a[] = new Account[3];


a[0]= new Account(123,"Ankit",50000);
a[1]= new Account(112,"Ashok",40000);
a[2]= new Account(111,"Ryan",25000);

try {
a[2].withdraw(21999);
}
catch(MaxLimitException e)
{
	System.out.println(e);
}

 }
}
