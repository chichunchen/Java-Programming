import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderFrame extends JFrame {
	private JSlider diameterJSlider;
	private OvalPanel myPanel;

	public SliderFrame() {
		super("Slider Demo");

		myPanel = new OvalPanel();
		myPanel.setBackground( Color.YELLOW );

		diameterJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 200, 10 );
		diameterJSlider.setMajorTickSpacing( 10 );	//create tick every 10
		diameterJSlider.setPaintTicks( true );	//paint ticks on slider

		diameterJSlider.addChangeListener(

			new ChangeListener() {
				public void stateChanged( ChangeEvent e ) {
					myPanel.setDiameter( diameterJSlider.getValue() );
				}
			}
		);

		add( diameterJSlider, BorderLayout.SOUTH );
		add( myPanel, BorderLayout.CENTER );
	}
}