import java.util.*;

class Account{  
int acc;  
String name;  
float amt;  
Account(int acc,String name,float amt){
this.acc = acc;
this.name = name;
this.amt = amt; }
public String toString() {    
return "Acc. No.: "+acc+" Name: "+name+" Amount: "+amt;}
} 

class AmtCmp implements Comparator<Account>{
public int compare(Account a1,Account a2){  
if(a1.amt==a2.amt)  
return 0;  
else if(a1.amt>a2.amt)  
return 1;  
else  
return -1; }
}

class AccCmp implements Comparator<Account>{
public int compare(Account a1,Account a2){  
if(a1.acc==a2.acc)  
return 0;  
else if(a1.acc>a2.acc)  
return 1;  
else  
return -1; }
}

class AccountComparatorEx {  
public static void main(String[] args) {  
List<Account> al = new ArrayList<Account>();

al.add(new Account(123,"Ankit",5000));
al.add(new Account(112,"Ashok",4000));
al.add(new Account(111,"Ryan",5000));

System.out.println("Comparison on Amount");
Collections.sort(al,new AmtCmp());
for(Account a:al) 
System.out.println(a);

System.out.println("Comparison on Acc. No.");
Collections.sort(al,new AccCmp());
for(Account a:al) 
System.out.println(a);  }
}
