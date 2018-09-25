import java.awt.*;  
import java.awt.event.*;  
public class MouseListenerEx extends Frame implements MouseListener{  
    String msg ="Welcome";  
    Color c = Color.red;
    
        MouseListenerEx()
        {  
    	 	  addMouseListener(this);  
        	setSize(300,300);  
        	setLayout(null);  
        	setVisible(true);     
          }  
        
        public void mouseEntered(MouseEvent e) 
        {  
            msg = "Mouse Entered";  
            repaint();        
            }  
            
        public void mouseExited(MouseEvent e) 
        {  
            msg = "Mouse Exited"; 
            repaint();        
            }    

        public void mouseClicked(MouseEvent e) 
        {  
        		Graphics g=getGraphics();
        		g.setColor(Color.BLUE);  
        		g.fillOval(e.getX(),e.getY(),30,30);     
            }  

        public void mousePressed(MouseEvent e) 
        {       
        }  
        public void mouseReleased(MouseEvent e) 
        {
        }  

		public void paint(Graphics g) 
    {
        		g.setColor(c);
        		Font font = new Font("TimesNewRoman", Font.PLAIN, 24);
        		g.setFont(font);
        		g.drawString(msg, 50, 150);      
            }

    public static void main(String[] args) 
    {  
    new MouseListenerEx();  
    }  
}
