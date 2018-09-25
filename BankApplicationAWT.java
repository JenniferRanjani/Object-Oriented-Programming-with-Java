import java.awt.*;  
import java.awt.event.*;  
import java.text.*;
public class BankApplicationAWT implements ItemListener,ActionListener{  
	String msg="";
	TextField tf;
	CheckboxGroup gender;
	Choice state;
	double pchange,interest;
	Label l5,l6;
	Frame f;
	BankApplicationAWT()
	{
		f = new Frame("Adapter Example");
		f.setTitle("Banking Application");
		f.setSize(500,500);  
		f.setVisible(true); 
		f.setLayout(new FlowLayout(FlowLayout.LEFT,100,25));
                
        Label l1 = new Label("Name");
        f.add(l1);
        
        tf = new TextField("Enter your name");
        f.add(tf);
        
        Label l2 = new Label("Gender");
        f.add(l2);
        
        gender = new CheckboxGroup();
        Checkbox male,female;
        male = new Checkbox("Male",gender,false);
        female = new Checkbox("Female",gender,false);
        f.add(male);
        f.add(female);
      
        Label l3 = new Label("State");
        f.add(l3);
        
        state = new Choice();
        state.add("None");
        state.add("Rajasthan");
        state.add("Haryana");
        state.add("Andhra");
        state.add("TamilNadu");
        f.add(state);
        
        Label l4 = new Label("Interest Rate");
        f.add(l4);
        
        l5 = new Label("0.0");
        f.add(l5);
        l6 = new Label(msg);
        f.add(l6);
        Button b1 = new Button("Find Interest");
        f.add(b1);
        
        male.addItemListener(this);
        female.addItemListener(this);
        state.addItemListener(this);   
        b1.addActionListener(this);
    } 
   
    public static void main(String[] args) 
    {
       new BankApplicationAWT();
    }

	public void itemStateChanged(ItemEvent e) {
		
		if (gender.getSelectedCheckbox().getLabel().equals("Female"))
			   pchange = 0.8;
		else
			   pchange = 1;
	}

	public void actionPerformed(ActionEvent e) {
		
		switch(state.getSelectedIndex())
		{
		case 1: interest = 10.25; break;
		case 2: interest = 9.25; break;
		case 3: interest = 9; break;
		case 4: interest = 9.75; break;
		}
		
		DecimalFormat dec = new DecimalFormat("#0.00");
		l5.setText(dec.format(interest*pchange));
//		l5.setText(String.format("%.2f", interest*pchange));
//		l5.setText(Double.toString(interest*pchange));
		
		msg+="The interest rate for ";
		msg+=tf.getText() +"(" + gender.getSelectedCheckbox().getLabel()+") from" + state.getSelectedItem() +" is: "+l5.getText();
		l6.setText(msg);
		msg="";
		
	}
	
	public void paint(Graphics g) {
		g.drawString(msg, 450,50);
		msg="";
	}
}

