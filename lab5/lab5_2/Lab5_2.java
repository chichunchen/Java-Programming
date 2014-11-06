import java.awt.*;
import javax.swing.*;

public class Lab5_2{

   public static void main(String[] args){
   
        P_2 panel = new P_2();
		
        JFrame frame = new JFrame("Lab5");
	      frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
   }
}