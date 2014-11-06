import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
  private int pointCount = 0;
  private Point[] points = new Point[ 10000 ];
  
  public PaintPanel() {
    addMouseMotionListener(
      new MouseMotionAdapter() {
        public void mouseDragged( MouseEvent event ) {
          if( pointCount < points.length ) {
            points[ pointCount ] = event.getPoint();  //find point
            ++pointCount;
            repaint();
          }
        }
      }
    );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    
    for( int i = 0; i < pointCount; i++ ) {                  //pointCount為panel上的點的總數
      g.fillOval( (int)points[i].getX(), (int)points[i].getY(), 5, 5 );
    }
  }
}