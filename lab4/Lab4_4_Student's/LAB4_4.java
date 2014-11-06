import javax.swing.*;
import java.awt.*;

public class LAB4_4 {
public static void main(String[] args) {
		DemoFrame frame = new DemoFrame();
		
		Dimension d = frame.getMaximumSize();
		frame.setSize(d.width, d.height);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
