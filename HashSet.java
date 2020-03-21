import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Account
{
	private String name;
	private int age;

	// Constructor
	Account(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object ob) {

		if (ob == this)
			return true;

		if (ob == null || ob.getClass() != getClass()) {
			return false;
		}

		Account p = (Account) ob;
		return Objects.equals(name, p.name) && p.age == age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name,age);
	}

	@Override
	public String toString() {
		return "{" + name + ", " + age + "}";
	}
}

class Main{

	public static void main (String[] args)
	{
		Account p1 = new Account("John", 19);
		Account p2 = new Account("John", 20);
		Account p3 = new Account("Carol", 16);
		Account p4 = new Account("Zen", 14);


		Set<Account> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
        
      System.out.println(set);

      System.out.println(p1.hashCode());
      System.out.println(p2.hashCode());


		System.out.println(p1.equals(p2));
	}
}
