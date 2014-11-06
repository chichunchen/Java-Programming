import java.awt.*;
import javax.swing.*;

public class Lab5_4{

   public static void main(String[] args){
   
        P_4 panel = new P_4();
        panel.setFocusable( true );
		
        JFrame frame = new JFrame("Lab5");
	      frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
	   
   }
}