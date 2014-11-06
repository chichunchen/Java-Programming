
import java.io.*;
import java.net.*;

public class Capitalizer extends Thread 
{
	private Socket socket;
	private int clientNumber;

	public Capitalizer(Socket socket, int clientNumber) 
	{
		this.socket = socket;
		this.clientNumber = clientNumber;
		log("New connection with client# " + clientNumber + " at " + socket);
	}

	public void run() {
		try {

                // Decorate the streams so we can send characters
                // and not just bytes.  Ensure output is flushed
                // after every newline.
                BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message to the client.
                out.println("Hello, you are client #" + clientNumber + ".");
                out.println("Enter bye to quit\n");

                while (true) 
                {
                    String input = in.readLine();
                    if (input == null || input.equals("bye")) {
                        break;
                    }
                    else if(input.equals("Guess what")) {
                        out.println("Server>>> What?");
                    }
                    else if (input.equals("I dreamed last night!!")) {
                        out.println("Server>>> What kind of dream?");
                    }
                    else if (input.equals("I have dreamed that my idol and I")) {
                        out.println("Server>>> ...OK, I already knew what you gonna say.");
                    }
                    else if (input.equals("what will I say")) {
                        out.println("Server>>> You'll say you and your idol do something that won't happend in real life.");
                    }
                    else{
                        out.println("Server>>> Sorry, I can't figure out wat you'r talking about. ~_~");
                    }
                }
            } 
            catch (IOException e) 
            {
                log("Error handling client# " + clientNumber + ": " + e);
            } 
            finally 
            {
                try 
                {
                    socket.close();
                } 
                catch (IOException e) 
                {
                    log("Couldn't close a socket, what's going on?");
                }
                
                log("Connection with client# " + clientNumber + " closed");
            }
	}

	private void log(String message) {
		System.out.println(message);
	}
}