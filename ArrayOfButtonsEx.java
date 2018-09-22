import java.awt.*;  
import java.awt.event.*;  
public class ArrayOfButtonsEx implements ActionListener {  
       Frame f; 
       TextField tf = new TextField();
       Button b[] = new Button[3];
        ArrayOfButtonsEx(){  
        	f = new Frame("ButtonExample");
        	b[0] = new Button("Yes");
        	b[1] = new Button("No");
        	b[2] = new Button("May Be");
        
        	f.add(b[0]);
        	f.add(b[1]);
        	f.add(b[2]);
        	
        	for(int i = 0;i<3;i++)
        	{
        		b[i].setBounds(100,100+i*50,100,30);
        	}
        	
        	for(int i =0;i<3;i++)
        	{
        		b[i].addActionListener(this); 
        	}
        	tf.setBackground(Color.cyan);
        	tf.setBounds(100,250,200,30);
    	 	f.add(tf);  
        	f.setSize(300,300);  
        	f.setLayout(null);  
        	f.setVisible(true);     }  
        	
        	public void actionPerformed(ActionEvent e) 
        	{
				for (int j=0;j<3;j++)
				{
					if(e.getSource() == b[j])
						tf.setText("Button Pressed: "+b[j].getLabel());
				}					
			}	
        
           public static void main(String[] args) 
           {
        	   new ArrayOfButtonsEx();
           }
}
