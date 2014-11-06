public class LinkList {
  private Link first;
  
  public LinkList() {
    first = null;             // ref to first link on list
  }
  
  public boolean isEmpty() {
    return ( first == null );
  }
  
  public void insertFirst( int id, double dd ) {
    Link newLink = new Link( id, dd );
    newLink.next = first;    //newLink --> old first
    first = newLink;         //first -->newLink
  } 
  
  public Link deleteFirst() {
    Link temp = first;
    first = first.next;
    return temp;            //return deleted link
  } 
  
  public void displayList() {
    System.out.print("List (first-->last): ");
    Link current = first;     // start at beginning of list
    while(current != null) {
      current.displayLink();  // print data
      current = current.next; // move to next link
    }
    System.out.println(" ");
  }
  
  public Link find( int key ) {
    Link current  = first;
    while( current.iData != key ) {   //find
      if( current.next == null ) break;
      else
      current = current.next;
    }
    return current;
  }
  
  public Link delete( int key ) {
    Link current = first;
    Link previous = first;
    while( current.iData != key ) {
      if( current.next == null ) 
          return null;           //didn't find it
      else {
        previous = current;
        current = current.next;
      } 
    }
    if( current == first )
        first = first.next;
    else
        previous.next = current.next;
    return current;     //傳回被刪掉的link    
  }
  
}







