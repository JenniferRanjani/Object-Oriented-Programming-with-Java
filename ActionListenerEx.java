import java.awt.*;
import java.awt.event.*;

class ActionListenerEx extends Frame implements ActionListener{  
TextField tf;
test(){
    setTitle("Core Banking"); 
    tf = new TextField();
    tf.setBounds(100,50,170,30); 
    Button b=new Button("Submit");  
    b.setBounds(100,100,100,30);  
    add(b);  
    add(tf);
    
    b.addActionListener(this);
    setSize(1000,1000);  
    setBackground(Color.cyan);
    setLayout(null);  
    setVisible(true);  
 }
public static void main(String[] args)
{  
	ActionListenerEx t= new ActionListenerEx();
}

public void actionPerformed(ActionEvent E)
{
tf.setText("Welcome to Core Banking");
}
}

