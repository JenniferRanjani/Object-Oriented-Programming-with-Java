import java.util.*;
class SingleRandom
{
private Random generator;
private static SingleRandom instance = null;
 private SingleRandom() { generator = new Random(); }
 public void setSeed(int seed) { generator.setSeed(seed); }
 public int nextInt() { return generator.nextInt(); }
 public static synchronized SingleRandom getInstance() 
 {
	 if (instance ==null)
	 {
		 instance = new SingleRandom();
	 }
	 return instance; 
 }

protected Object clone() throws CloneNotSupportedException {
throw new CloneNotSupportedException("Clone is not allowed.");
}
}
public class SingletonEx{
public static void main(String args[]){  
	int r1 = SingleRandom.getInstance().nextInt();
	System.out.println(r1);
	r1 = SingleRandom.getInstance().nextInt();
	System.out.println(r1);
}

}
