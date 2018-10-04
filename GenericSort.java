package class1;

import java.util.*;

public class GenericSort  {  
	
	static <T extends Comparable<T>> T[] sort(T[] a) {
		int n = a.length;
		T temp;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if (a[i].compareTo(a[j])<0)
					{
						temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}			
			}			
		}
		
		return a;
	}
	public static void main(String args[]) {
		Integer[] items = { 22, 55, 66, 11, 32, 56, 67, 89, 95, 10 };
		
		Double[] dItems = { 11.3, 13.3, 6.0, 9.6, 45.7, 23.2 };
		
		String sItems[] = {"java","fun","program"};
		
		items = sort(items);
		dItems = sort(dItems);
		sItems = sort(sItems);
		
		System.out.println(Arrays.toString(items));
		
		System.out.println(Arrays.toString(dItems));

		System.out.println(Arrays.toString(sItems));
		
		
		
	}
}