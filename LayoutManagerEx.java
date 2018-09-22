//Uncomment the appropriate layout choice and comment the remaining segments to understand how each layout manager works.
import java.awt.*;  
import java.awt.event.*;  
public class LayoutManagerEx implements ActionListener {  
       Frame f; 
       TextField tf;
       Button b[] = new Button[3];
       LayoutManagerEx(){  
        	f = new Frame("ButtonExample");

        	b[0] = new Button("Yes");
        	b[1] = new Button("No");
        	b[2] = new Button("May Be");
        	
        	f.add(b[0]);
        	f.add(b[1]);
        	f.add(b[2]);
       	
        	tf = new TextField();
        	tf.setBackground(Color.cyan);
        	f.add(tf);
        	
        	
//        	**************Manual Positioning**********
        	for(int i = 0;i<3;i++)
        	{
        		b[i].setBounds(100,100+i*50,100,30);
        	}
        	
        	tf.setBounds(100,250,200,30);
        	f.setLayout(null);
        	
//        	**************Flow Layout***************
//        	f.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        	f.setLayout(new FlowLayout(FlowLayout.LEADING));
        	
//        	****************Grid Layout*************
        	
//        	f.setLayout(new GridLayout(2,2));
        	
//        	***************Border Layout************
        	
//        	
//        	f.setLayout(new BorderLayout());
//        	
//        	f.add(b[0],BorderLayout.WEST);
//        	f.add(b[1],BorderLayout.EAST);
//        	f.add(b[2],BorderLayout.NORTH);
//    	 	  f.add(tf, BorderLayout.SOUTH);
        	 	       	        	

        	
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
        	   new LayoutManagerEx();
           }
}

