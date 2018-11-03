class EnumEx{
	enum Color{
		 RED(100), GREEN(101), BLUE(102);
		
		int value;
		private Color(int val) 
	    { 
	        value = val;
	    } 
		int getValue() {
			return value;
		}
		
	 }
	 public static void main(String[] args) {
		 Color c1 = Color.BLUE; 
		 Color v[] = Color.values();
		 
		 System.out.println(c1);
		 System.out.println(c1.name());
		 
	     System.out.println(c1.getValue());
	     System.out.println(c1.ordinal());
	     
	     for(Color c: v)
	     System.out.println(c);
	    }
}
