import pack.sierpPanel.SierpPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sierp extends JApplet implements ActionListener {
	
	private JTextField input = new JTextField( "0", 5 );
	private SierpPanel sp = new SierpPanel();
	private JButton addButton = new JButton( "+1" );
	private JButton subButton = new JButton( "-1" );

	public Sierp() {
		JPanel  pl = new JPanel();
		
		pl.add( subButton );
		
		pl.add( input );
		input.setHorizontalAlignment( SwingConstants.RIGHT );
		
		pl.add( addButton );
		
		add( sp );
		add( pl, BorderLayout.SOUTH );
		
		input.addActionListener( this );
		addButton.addActionListener( this );
		subButton.addActionListener( this );
	}
	
	public void actionPerformed( ActionEvent event ) {
		if( event.getSource() == addButton ) {
			sp.addOrder();
		}
		else if( event.getSource() == subButton ) {
			sp.subOrder();
		}
		input.setText( Integer.toString( sp.getOrder() ) );
	}
}