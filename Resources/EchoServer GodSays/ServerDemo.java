import javax.swing.JFrame;

public class ServerDemo
{
	public static void main(String[] args) {
        
        EchoServer application = new EchoServer();
        application.setSize(500, 300);
        application.setVisible(true);
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.runServer();       
    }
}