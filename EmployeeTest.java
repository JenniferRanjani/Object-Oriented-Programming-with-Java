package class1;

import java.util.*;

abstract class Employee{
	private String name;
	private int num;
	Employee(String name,int num){
		this.name = name;
		this.num = num;
	}
	abstract double computePay();
	
	public String toString() {
		return "Name: "+name+"Num: "+num;
	}	
}

class Salary extends Employee{
	private double sal;
	
Salary(String name, int num,double sal){
	super(name,num);
	this.sal = sal;
}

double getSal() {
	return sal;
}

double computePay() {
	return sal/52;
}
	
}
class EmployeeTest{
public static void main(String[] args) {

	LinkedList<Salary> al = new LinkedList<Salary>();
	
	al.add(new Salary("Ankit",111,100000.0));
	al.add(new Salary("Amit",222,50000000.0));
	al.add(new Salary("Ankur",333,10000000.0));
	
	for (Salary a : al) {
		a.computePay();
	}
	
	Collections.sort(al, new Comparator<Salary>() {

		public int compare(Salary s1, Salary s2) {
			if (s1.getSal() == s2.getSal())
					return 0;
			else if (s1.getSal() < s2.getSal())
				return 1;
			else
				return -1;
		}
		
	});
	
	for (Salary a : al) {
		System.out.println(a);
	}
	
}
}
