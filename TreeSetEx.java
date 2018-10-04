import java.util.*;

public class TreeSetEx  {  
	
	static <T> TreeSet<T> set(TreeSet<T> A, TreeSet<T> B, char op) {
		
		if (op == '+')
	         A.addAll(B);     // Union.
	      else if (op == '*')
	         A.retainAll(B);  // Intersection.
	      else
	         A.removeAll(B);  // Set difference.
		
		return A;
	}
	public static void main(String args[]) {
		TreeSet<Integer> I1 = new TreeSet<Integer>();
		I1.add(10);
		I1.add(20);
		I1.add(30);
		I1.add(40);
		
		TreeSet<Integer> I2 = new TreeSet<Integer>();
		I2.add(10);
		I2.add(20);
		I2.add(50);
		I2.add(60);
		
		TreeSet<String> S1 = new TreeSet<String>();
		S1.add("java");
		S1.add("C++");
		S1.add("DIP");
		S1.add("C");
		
		TreeSet<String> S2 = new TreeSet<String>();
		S2.add("C");
		S2.add("C++");
		S2.add("Python");
		S2.add("Graphics");
		
		
		I1 = set(I1,I2,'*');		
		System.out.println(I1);

		S1 = set(S1,S2,'-');
		System.out.println(S1);
		
		
		
	}
}
