import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex5_4_1 extends JFrame implements Runnable {
    int num=0, flag, i;
    Image[ ] img;
      
    public Ex5_4_1() {
        super("Ex5_4_1");
        setSize(350, 350);
        Toolkit tk = Toolkit.getDefaultToolkit();
        img = new Image[10];
        
		for(i=0; i<10; i++) {
           img[i] = tk.getImage("char" + i + ".png");         
		}
			setVisible(true);
			new Thread(this).start();       
		}

    public void run() {
		while(true) {
			flag = num % 10;  
			repaint();
			num = num + 1;         
			try{Thread.sleep(500);}
			catch(InterruptedException e) {;}       
		}
    }

    public void paint(Graphics g) {        
		super.paint(g);        
		g.drawImage(img[flag], 50, 50, this);      
	}
    
    public static void main(String args[]) {
		Ex5_4_1 workStart=new Ex5_4_1();
		workStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	}
}
