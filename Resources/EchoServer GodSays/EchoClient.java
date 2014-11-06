
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EchoClient extends JFrame 
{
   private JTextField enterField; 
   private JTextArea displayArea; 
   private ObjectOutputStream output;  // output stream to server
   private ObjectInputStream input;    // input stream from server
   private String message = "";        // message from server
   private String chatServer;          // host server for this application
   private Socket client;              // socket to communicate with server


   public EchoClient( String host )
   {
      super( "God Says..." );

      chatServer = host; // set server to which this client connects

      enterField = new JTextField(); 
      enterField.setEditable( false );
      enterField.addActionListener(
         new ActionListener() 
         {
            public void actionPerformed( ActionEvent event )
            {
               sendData( event.getActionCommand() );
               enterField.setText( "" );
            } 
         } 
      ); 

      add( enterField, BorderLayout.NORTH );

      displayArea = new JTextArea(); // create displayArea
      add( new JScrollPane( displayArea ), BorderLayout.CENTER );
   } 


   public void runClient() 
   {
      try 
      {
         connectToServer(); 
         getStreams(); 
         processConnection();
      }
      catch ( EOFException eofException ) 
      {
         displayMessage( "\nGod terminated connection" );
      } 
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } 
      finally 
      {
         closeConnection(); 
      } 
   } 

   private void connectToServer() throws IOException
   {      
      displayMessage( "Attempting connection\n" );

      client = new Socket( InetAddress.getByName( chatServer ), 13512 );

      displayMessage( "Connected to: " + client.getInetAddress().getHostName() );
   } 

   private void getStreams() throws IOException
   {
      output = new ObjectOutputStream( client.getOutputStream() );      
      output.flush();

      input = new ObjectInputStream( client.getInputStream() );

      displayMessage( "\nGot I/O streams\n" );
   } 

   private void processConnection() throws IOException
   {
      setTextFieldEditable( true );

      do 
      { 
         try 
         {
            message = ( String ) input.readObject(); 
            displayMessage( "\n" + message );
         } 
         catch ( ClassNotFoundException classNotFoundException ) 
         {
            displayMessage( "\nUnknown object type received" );
         } 

      } while ( !message.equals( "Universe>>> TERMINATE" ) );
   } 

   private void closeConnection() 
   {
      displayMessage( "\nClosing connection" );
      setTextFieldEditable( false ); 

      try 
      {
         output.close(); 
         input.close(); 
         client.close();
      } 
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } 
   } 

   private void sendData( String message )
   {
      try 
      {
         output.writeObject( "God>>> " + message );
         output.flush(); 
         displayMessage( "\nGod>>> " + message );
      } 
      catch ( IOException ioException )
      {
         displayArea.append( "\nError writing object" );
      } 
   } 

   private void displayMessage( final String messageToDisplay )
   {
      SwingUtilities.invokeLater(
         new Runnable()
         {
            public void run() 
            {
               displayArea.append( messageToDisplay );
            } 
         }  
      ); 
   } 

   private void setTextFieldEditable( final boolean editable )
   {
      SwingUtilities.invokeLater(
         new Runnable() 
         {
            public void run() 
            {
               enterField.setEditable( editable );
            } 
         } 
      );
   } 
} 

