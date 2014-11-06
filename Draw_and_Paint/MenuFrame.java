package pack.Product;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pack.DataStructure.StackX;
import pack.Shapes.*;


public class MenuFrame extends JFrame {
  
  private Random randNum = new Random();  
  private StackX shapeStack = new StackX( 10000 );
  
  public MenuFrame() {
    super( "Draw Shapes!" );
    
    DrawShape draw = new DrawShape( shapeStack );
    add( draw );
    
    /*-----------------------------------------------*/
    
    //paint
    
    /*-----------------------------------------------*/
    
    JMenu drawMenu = new JMenu( "Draw" );
    drawMenu.setMnemonic( 'D' );
    
    JMenuItem lineItem = new JMenuItem( "Line" );
    lineItem.setMnemonic( 'L' );
    drawMenu.add( lineItem );     
    lineItem.addActionListener(
    new ActionListener() {  
      public void actionPerformed( ActionEvent event ) {
        MyLine myLine = new MyLine(randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt(256), randNum.nextInt(256), randNum.nextInt(256) );
        shapeStack.push( myLine );
        repaint();
      }
    }
    );
    
    JMenuItem ovalItem = new JMenuItem( "Oval" );
    ovalItem.setMnemonic( 'O' );
    drawMenu.add( ovalItem );     
    ovalItem.addActionListener(
    new ActionListener() {  
      public void actionPerformed( ActionEvent event ) {
        MyOval myOval = new MyOval(randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt(256), randNum.nextInt(256), randNum.nextInt(256), true );
        shapeStack.push( myOval );
        repaint();
      }
    }
    ); 
    
    JMenuItem rectItem = new JMenuItem( "Rectangle" );
    rectItem.setMnemonic( 'R' );
    drawMenu.add( rectItem );     
    rectItem.addActionListener(
    new ActionListener() {  
      public void actionPerformed( ActionEvent event ) {
        MyRectangle myRect = new MyRectangle(randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt( 500 ), randNum.nextInt(256), randNum.nextInt(256), randNum.nextInt(256), true );
        shapeStack.push( myRect );
        repaint();
      }
    }
    );
    
    JMenuBar bar = new JMenuBar();
    setJMenuBar( bar );
    bar.add( drawMenu );   
    
    
    JMenu recoverMenu = new JMenu( "Recover" );
    recoverMenu.setMnemonic( 'R' );
    
    JMenuItem undoItem = new JMenuItem( "Undo" );
    undoItem.setMnemonic( 'U' );
    recoverMenu.add( undoItem );
    undoItem.addActionListener(
    new ActionListener() {  
      public void actionPerformed( ActionEvent event ) {
        shapeStack.pop();
        repaint();
      }
    }
    ); 
    
    bar.add( recoverMenu );
  }
}