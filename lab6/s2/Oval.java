


import java.awt.*;
import javax.swing.*;

public class Oval extends Shape{

	public void paintComponent(Graphics g){
	    super.paintComponent(g);
		g.setColor(c);
		g.fillOval((getWidth()-w)/2,(getHeight()-h)/2,w,h);
	}

}