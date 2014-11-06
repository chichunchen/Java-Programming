

import java.awt.*;
import javax.swing.*;

public abstract class Shape extends JPanel{

    protected int x;
    protected int y;
    protected int h;
    protected int w;
    protected Color c;

    public Shape(){
	
	    x=0;
		y=0;
		h=20;
		w=20;
	    randColor();
	} 	
	
	public void randColor(){
	
	    c = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
	
	}
	


}