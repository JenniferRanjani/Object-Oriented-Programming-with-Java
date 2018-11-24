class Test1 
{ 
    int x, y; 
    
    Test1()
    {
    	
    }
    Test1(Test1 t){
    	this.x = t.x;
    	this.y = t.y;
    }
} 
  
class Test2 implements Cloneable 
{ 
    int a, b; 
  
   Test1 c = new Test1(); 
  
    public Object clone() throws
                CloneNotSupportedException 
    {  
    	Test2 t = (Test2)super.clone();
    	t.c = new Test1(this.c);    //Comment this line for Shallow copy
    	return t;
    } 
} 
  
class test
{ 
    public static void main(String args[]) throws
                             CloneNotSupportedException 
    { 
       Test2 t1 = new Test2(); 
       t1.a = 10; 
       t1.b = 20; 
       t1.c.x = 30; 
       t1.c.y = 40; 
  
       Test2 t3 = (Test2)t1.clone(); 
//       t3.a = 100; 
//       t3.b = 200;
//       t3.c.x = 300; 
  
       System.out.println(t1.a + " " + t1.b + " " + 
                          t1.c.x + " " + t1.c.y); 
       System.out.println(t3.a + " " + t3.b + " " + 
                          t3.c.x + " " + t3.c.y); 
    } 
} 
   
