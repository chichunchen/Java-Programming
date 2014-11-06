
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Random;

import pack.DataStructure.StackX;
import pack.Shapes.MyOval;

public class EchoServer extends JFrame {

    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;  // output stream to client
    private ObjectInputStream input;    // input stream from client
    private ServerSocket server;
    private Socket connection;      // connection to client
    private int counter = 1;        // counter of number of connection
    private JFrame newWorld;
    public DrawShape world;

    private Random randNum = new Random();  
    private StackX shapeStack = new StackX( 10000 );

    public EchoServer() 
    {
        super("Universe");

        enterField = new JTextField();
        enterField.setEditable(false);
        enterField.addActionListener (
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent event) {
                    sendData(event.getActionCommand());
                    enterField.setText("");
                }
            }
        );
        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add( new JScrollPane( displayArea ), BorderLayout.CENTER );
    }

    public void runServer() {

        try {
            server = new ServerSocket( 13512, 100 );

            while( true ) 
            {
                try {
                    waitForConnection();
                    getStreams();
                    processConnection();
                }
                catch( EOFException eofException ) {
                    displayMessage( "\nUniverse terminated connection" );
                }
                finally {
                    closeConnection();
                    ++counter;
                }
            }
        }
        catch( IOException ioException ) {
            ioException.printStackTrace();
        }
    }

    private void waitForConnection() throws IOException
    {
        displayMessage( "Wait for connection\n");
        connection = server.accept();   // allow server to accept connection
        displayMessage( "Connection " + counter + " received from: " + connection.getInetAddress().getHostName() );
    }

    private void getStreams() throws IOException 
    {
        output = new ObjectOutputStream( connection.getOutputStream() );
        output.flush();

        input = new ObjectInputStream( connection.getInputStream() );

        displayMessage( "\nGot I/O streams\n" );
    }

    private void processConnection() throws IOException 
    {
        String message = "Connection successfully";
        sendData(message);

        setTextFieldEditable( true );

        do{
            try {
                message = (String)input.readObject();
                
                if(message.equals("God>>> new")) {
                    CreateNewWorld();
                }
                else if (message.equals("God>>> sun")) {
                    int x = world.getWidth();
                    int y = world.getHeight();
                    MyOval myOval = new MyOval(randNum.nextInt( x ), randNum.nextInt( y ), randNum.nextInt( x ), randNum.nextInt( y ), randNum.nextInt(256), randNum.nextInt(256), randNum.nextInt(256), true );
                    shapeStack.push( myOval );
                    world.setBackground(Color.WHITE);
                    world.repaint();
                }
                else if (message.equals("God>>> light")) {
                    world.setBackground(Color.WHITE);
                }
                else if(message.equals("God>>> dark")) {
                    world.setBackground(Color.BLACK);
                }
                else if (message.equals("God>>> punish")) {
                    newWorld.dispose();
                }


                displayMessage("\n" + message);
            }
            catch(ClassNotFoundException classNotFoundException) 
            {
                displayMessage("\nUnknown object type received");
            }
        }
        while( !message.equals("God>>> Bye") );
    }

    private void closeConnection() 
    {
        displayMessage("\nClose connection\n");
        setTextFieldEditable(false);

        try {
            output.close();
            input.close();
            connection.close();
        }
        catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void sendData( String message )
    {
        try {
            output.writeObject( "Universe>>> " + message );
            output.flush();
            displayMessage( "\nUniverse>>>" + message );
        }
        catch ( IOException ioException ) 
        {
            displayArea.append( "\nError writing object" );
        }
    }

    private void displayMessage( final String messageToDisplay ) 
    {
        SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
                    displayArea.append( messageToDisplay );
                }
            }
        );
    }

    private void setTextFieldEditable( final boolean editable ) 
    {
        SwingUtilities.invokeLater(
            new Runnable() {
                public void run() {
                    enterField.setEditable( editable );
                }
            }
        );   
    }

    public void CreateNewWorld() {

        System.out.println("new");

        newWorld = new JFrame("New world");
        world = new DrawShape(shapeStack);
        world.setBackground(Color.BLACK);
        newWorld.add(world);
        newWorld.setSize(450, 200);
        newWorld.setVisible(true);
        newWorld.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}