public class InToPost {
  
  private StackX theStack;
  private String input;
  private String output = " ";
  
  public InToPost( String in ) {
    input = in;
    int stackSize = input.length();
    theStack = new StackX( stackSize );
  }
  
  //do translation to postfix
  public String doTrans() {
    for( int j = 0; j < input.length(); j++ ) {
      char ch = input.charAt( j );
      theStack.displayStack( "For " + ch + " " );
      switch( ch ) {
        case '+':
        case '-':
        gotOper( ch, 1 );
        break;
        case '*':
        case '/':
        gotOper( ch, 2 );
        break;
        case '(':
        theStack.push( ch );
        break;
        case ')':
        getParen( ch );
        default:
        output = output + ch;
        break;             
      }
    } //end for
    while( !theStack.isEmpty() ) // pop remaining opers
    {
      theStack.displayStack("While "); // *diagnostic*
      output = output + theStack.pop(); // write to output
    }
    theStack.displayStack("End "); // *diagnostic*
    return output;
  }
  
  //got operator from input
  public void gotOper( char opThis, int prec1 ) {
    while( !theStack.isEmpty() ) {
      char opTop = theStack.pop();
      if( opTop == '(' ) {
        theStack.push( opTop );   //restore '('
        break;
      } 
      else {
        int prec2;
        
        if( opTop == '+' || opTop == '-' ) prec2 = 1;
        else prec2 = 2;
        
        if( prec2 < prec1 ) {     //if prec of new op less than prec of old
          theStack.push( opTop ); //save newly-popped op
          break;
        }
        else output = output + opTop; 
      } 
    }
    
    theStack.push( opThis );
  }
  
  public void getParen( char ch ) {
    while( !theStack.isEmpty() ) {
      char chx = theStack.pop();
      if( chx == '(')
          break;
      else {
        output = output + chx;
      } 
    }
  }
}