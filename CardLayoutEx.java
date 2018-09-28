import java.awt.*;  
import java.awt.event.*;

public class CardLayoutEx {  
	String msg="";
	TextField tf;
	CheckboxGroup type;
	CardLayoutEx()
	{
		Frame f = new Frame("Adapter Example");
		f.setTitle("Banking Application");
		f.setSize(500,500);  
		f.setVisible(true); 
		f.setLayout(new FlowLayout(FlowLayout.LEFT,100,15));
		
		
        Label l1 = new Label("Name");
        f.add(l1);
        
        tf = new TextField("Enter your name");
        f.add(tf);
        
        Label l2 = new Label("Mode");
        f.add(l2);
        
        type = new CheckboxGroup();
        Checkbox net,debit;
        net = new Checkbox("Net Banking",type,true);
        debit = new Checkbox("Debit Card",type,false);
        f.add(net);
        f.add(debit);
        
        CardLayout cLo =  new CardLayout();
        Panel deck = new Panel();
        deck.setLayout(cLo);
        Panel card1 = new Panel();
        Panel card2 = new Panel();       
            
        Label l3 = new Label("User Name: ");
        TextField tf2 = new TextField();
        Label l4 = new Label("Password ");
        TextField tf3 = new TextField();
        tf3.setEchoChar('*');
        card1.add(l3);
        card1.add(tf2);
        card1.add(l4);
        card1.add(tf3);
        
        Label l5 = new Label("Card No. ");
        TextField tf4 = new TextField();
        Label l6 = new Label("cvv");
        TextField tf5 = new TextField("");
                
        card2.add(l5);
        card2.add(tf4);
        card2.add(l6);
        card2.add(tf5);
        
        deck.add(card1,"Net Banking");
        deck.add(card2,"Debit Card");
        
        f.add(deck);
        
        net.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {	
        		cLo.show(deck,"Net Banking");
        	}
        });
        
        debit.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {     		
        		cLo.show(deck,"Debit Card");
        	}
        });
        
        
        
    } 
   
    public static void main(String[] args) 
    {
       new CardLayoutEx();
    }
	
}


