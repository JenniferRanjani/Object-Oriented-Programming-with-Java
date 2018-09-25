import java.awt.*;  
import java.awt.event.*;  
public class GridBagLayoutEx implements ActionListener {  
       Frame f,p; 
       
       TextField tf;
       Button b[] = new Button[3];
        GridBagLayoutEx(){  
        	f = new Frame("ButtonExample");

        	b[0] = new Button("Yes");
        	b[1] = new Button("No");
        	b[2] = new Button("May Be");
        	
        	
       	
        	tf = new TextField();
        	tf.setBackground(Color.cyan);
        	
// *********************Grid Bag Constraints**********************
        	  GridBagConstraints gbc = new GridBagConstraints();  
            f.setLayout(new GridBagLayout());  
            
            gbc.fill = GridBagConstraints.HORIZONTAL;  
            gbc.gridx = 0;  
            gbc.gridy = 0; 
            gbc.weightx = 0.5;
            f.add(b[0],gbc);
            
            gbc.ipady = 40;
            gbc.gridx = 1;  
            gbc.gridy = 0;  
            f.add(b[1],gbc);
        	
        	
            	gbc.gridwidth = 2;
            	gbc.insets = new Insets(10,10,10,10);
            	gbc.gridx = 0;  
            	gbc.gridy = 1;  
        	f.add(b[2],gbc);
        	
        	gbc.ipady = 0;
          gbc.weighty = 1;
        	gbc.anchor = GridBagConstraints.PAGE_END;
        	gbc.gridx = 0;  
            	gbc.gridy = 2;  
            	gbc.gridwidth = 1;  
        	f.add(tf,gbc);
//*********************End of Constraints*************************        	
        	
        	for(int i =0;i<3;i++)
        	{
        		b[i].addActionListener(this); 
        	}
        	
        	f.setSize(300,300);  
        	f.setVisible(true);   
        	

        	}  
        	
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
        	   new GridBagLayoutEx();
           }
}


