public class LinkStackApp {
  public static void main( String[] args ) {
    LinkStack theStack = new LinkStack();
    
    theStack.push(20); // push items
    theStack.push(40);
    
    theStack.displayStack(); // display stack
    
    theStack.push(60); // push items
    theStack.push(80);
    
    theStack.displayStack(); // display stack
    
    theStack.pop(); // pop items
    theStack.pop();
    
    theStack.displayStack(); // display stack
  }
}