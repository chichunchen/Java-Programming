
import javax.swing.JFrame;

public class ClientDemo
{
	public static void main(String[] args) {
        
        EchoClient application;

        if( args.length == 0) 
        	application = new EchoClient("localhost");
        else
        	application = new EchoClient( args[0] );

        application.setSize(500, 300);
        application.setVisible(true);
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.runClient();      
    }
}