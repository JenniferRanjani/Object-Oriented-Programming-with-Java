import java.awt.*;  
import java.awt.event.*;  

public class Mouse_WindowAdapterEx extends Frame 
{    
    Mouse_WindowAdapterEx()
    {  
    	setSize(400,400);  
        setVisible(true);  
        Label l=new Label();  
        l.setBounds(20,50,200,20); 
        l.setBackground(Color.cyan);

        TextArea area=new TextArea();  
        area.setBounds(20,80,300, 150);  
        area.addMouseListener(new MouseAdapter() 
        {
        	public void mouseReleased(MouseEvent e)
        	{
        		l.setText(area.getSelectedText());
            } 
        }); 
        
        addWindowListener(new WindowAdapter()
        {
    		public void windowClosing(WindowEvent e) 
    		{
    			System.exit(0);
    		}
    	});

          
        add(l);add(area);    
    }   
    public static void main(String[] args)
    {  
        new Mouse_WindowAdapterEx();  
    }  
}
