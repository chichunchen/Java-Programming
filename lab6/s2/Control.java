
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Control extends JFrame implements ActionListener{
    
	JButton b[];
	Shape s[];
	JPanel top_panel;
	JPanel button_panel;
	
	public Control(){
	    
		super("LAB6");
		
		b = new JButton[6];
		s = new Shape[2];
		
		setLayout(new GridLayout(1,2)); //Just an example

	    s[0] = new Rect();
		s[0].setBackground(Color.WHITE);
	    s[1] = new Oval();
		s[1].setBackground(Color.BLACK);
		
		this.add(s[0]);
		this.add(s[1]);
	
		//b[0] = new JButton("???");
		//b[0].addActionListener(this);
		
	    
	}
	
	public void actionPerformed(ActionEvent e){
	    
		//if(e.getSource() == b[0]){...}
		
		s[0].repaint();
		s[1].repaint();
	}
    	    


}