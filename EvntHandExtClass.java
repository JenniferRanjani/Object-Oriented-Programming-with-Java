import java.awt.*;
import java.awt.event.*;
class EvntHandExtClass extends Frame{  
TextField tf;
Label l;
test() {
    setTitle("Core Banking"); 
    tf = new TextField();
    tf.setBounds(100,100,170,30); 
        
    Button b=new Button("Submit");  
    b.setBounds(100,150,100,30);  
    
    l = new Label();
    l.setBounds(100,50,170,30);
    l.setBackground(Color.green);
    
    add(b);  
    add(tf);
    add(l);
    
    AHandler a = new AHandler(this);
    b.addActionListener(a);
    tf.addTextListener(a);
    
    setSize(1000,1000);  
    setBackground(Color.cyan);
    setLayout(null);  
    setVisible(true);   
    }
public static void main(String[] args) {  
	EvntHandExtClass t= new EvntHandExtClass(); }
}

class AHandler implements ActionListener,TextListener{
EvntHandExtClass obj;
AHandler(EvntHandExtClass t){
this.obj = t; 
}
public void textValueChanged(TextEvent e) {
      obj.l.setText("Entered text: " + obj.tf.getText());               
      }

public void actionPerformed(ActionEvent E) {
      obj.l.setText("Welcome to Core Banking");}
}
