public class LinkStack {
  
  private FirstLastList theList;
  
  public LinkStack() {
    theList = new FirstLastList();
  }
  
  public void push( long dd ) {
    theList.insertFirst( dd );
  }
  
  public long pop() {
    return theList.deleteFirst();
  }
  
  public boolean isEmpty() {
    return theList.isEmpty();
  }
  
  public void displayStack() {
    System.out.print( "Stack ( top --> bottom ): " );
    theList.displayList();
  }
}