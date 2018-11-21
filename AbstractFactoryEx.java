import javax.swing.JOptionPane;


class BankAccount {
	protected final double timePeriod = 0.5;
	protected double rateOfInterest=0;
	public double calculateInterest(double principle) {
		double interest = (principle * rateOfInterest * timePeriod)/100;
		return interest;
	}
}

class SavingAccount extends BankAccount{
	SavingAccount(){
	rateOfInterest = 4.0;
	}
}

class CurrentAccount extends BankAccount{
	CurrentAccount(){	
	 rateOfInterest = 3.5;
	}
}

class SweepInAccount extends BankAccount{
	SweepInAccount(){
	rateOfInterest = 8.25;
	}

}

abstract class AbstractFactory {
	   abstract BankAccount getAccountInstance(String accType);
	   abstract BankName getBankInstance(String bankType) ;
	}
class AccountFactory extends AbstractFactory {

	BankAccount getAccountInstance(String accType){
		
		if(accType.equals("current"))
			return new CurrentAccount();
		else if(accType.equals("savings"))
			return new SavingAccount();
		else if(accType.equals("sweep"))
			return new SweepInAccount();
		else
			return null;
	
	}

	@Override
	BankName getBankInstance(String bankType) {
		return null;
	}
}

class BankName{
	protected String Name = null;
	
	public String getName() {
	return Name;}
}

class YesBank extends BankName
{
	YesBank(){
		Name = "YES BANK";
	}
}

class SBI extends BankName
{
	SBI(){
		Name = "SBI";
	}
}

class BankFactory extends AbstractFactory{
	BankName getBankInstance(String bankType) {
		if(bankType.equals("sbi"))
			return new SBI();
		else if (bankType.equals("yes bank"))
			return new YesBank();
		else
			return null;
	}

	@Override
	BankAccount getAccountInstance(String accType) {
		return null;
	}
}

class FactoryProducer {
	   public static AbstractFactory getFactory(String choice){
	   
	      if(choice.equalsIgnoreCase("account")){
	         return new AccountFactory();
	         
	      }else if(choice.equalsIgnoreCase("bank")){
	         return new BankFactory();
	      }
	      
	      return null;
	   }
	}

public class AbstractFactoryEx {

	public static void main(String[] args){
		    
		String accType, bankType;
		double amount;
		double interest;
		BankAccount baAbstract = null;
		BankName bnAbstract = null;
		
		bankType = JOptionPane.showInputDialog("Enter the Bank Name");
		accType = JOptionPane.showInputDialog("Enter the account type");
		amount = Double.parseDouble((JOptionPane.showInputDialog("Enter the amount")));
		
		AbstractFactory bankFactory = FactoryProducer.getFactory("bank");
		bnAbstract = bankFactory.getBankInstance(bankType);
		bankFactory = FactoryProducer.getFactory("account");
		baAbstract = bankFactory.getAccountInstance(accType);
		interest = baAbstract.calculateInterest(amount);
		
		System.out.println(interest);
		System.out.println(bnAbstract.Name);
		
		JOptionPane.showConfirmDialog(null, "For "+bnAbstract.getName()+" Interest is: "+ interest);
		System.exit(0);
	  		
	}
}

