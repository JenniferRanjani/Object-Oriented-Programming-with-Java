package class1;

import java.util.*;
class Student implements Comparable<Student>{  
  
String name;  
float cgpa;  

Student(String name,float cgpa){
this.name = name;
this.cgpa = cgpa; }

public int compareTo(Student ac){  
if(cgpa==ac.cgpa)  
{
	if (name.compareTo(ac.name)==0)
		return 0;  
	else if (name.compareTo(ac.name)>0)
		return 1;
	else 
		return -1;			
}
else if(cgpa<ac.cgpa)  
return 1;  
else
return -1;  }  

void display(){System.out.println(name+" "+cgpa);}  
}  

class StudentTest{  
public static void main(String[] args) {  
	
	List<Student> al = new ArrayList<Student>();

al.add(new Student("Ankit",9.1f));
al.add(new Student("Ashok",8.5f));
al.add(new Student("Aathesh",8.5f));

Collections.sort(al);

for(Student a:al) 
a.display();
   
}
}


