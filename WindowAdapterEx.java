import java.awt.*;  
import java.awt.event.*;  
public class WindowAdapterEx extends WindowAdapter {  
	
	WindowAdapterEx()
	{
		Frame f = new Frame("Adapter Example");
      
        	f.setSize(300,300);  
        	f.setVisible(true); 
        	f.addWindowListener(this); 	
    } 
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
   
    public static void main(String[] args) 
    {
       new WindowAdapterEx();
    }
}
