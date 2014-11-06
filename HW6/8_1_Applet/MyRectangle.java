package classData.ch08;

import java.awt.*;

public class MyRectangle {
	
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color color;
	private boolean fill;

	public MyRectangle() {

		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.BLACK;
		fill = false;
	}

	public MyRectangle( int x1, int y1, int x2, int y2, Color color, boolean fill ) {

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.fill = fill;
	}

	public void draw( Graphics g ) {

		if( fill == true ) {
			g.setColor( getColor() );
			g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		}
		else {
			g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		}
	}

	public int getUpperLeftX() {

		if( x1 < x2 )
			return x1;
		else 
			return x2;
	}

	public int getUpperLeftY() {

		if( y1 < y2 )
			return y1;
		else
			return y2;
	}

	public int getWidth() {
		return Math.abs( x1 - x2 );
	}

	public int getHeight() {
		return Math.abs( y1 - y2 );
	}

	public Color getColor() {
		return color;
	}

	public boolean getFill() {
		return fill;
	}

	public void setX1( int x1 ) {
		this.x1 = x1;
	}

	public void setY1( int y1 ) {
		this.y1 = y1;
	}

	public void setX2( int x2 ) {
		this.x2 = x2;
	}

	public void setY2( int y2 ) {
		this.y2 = y2;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}
}