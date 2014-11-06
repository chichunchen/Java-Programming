public class ShellSortApp {
  public static void main(String[] args)
  {
    int maxSize = 10; // array size
    ArraySh arr;
    arr = new ArraySh(maxSize); // create the array
    
    for(int j = 0; j < maxSize; j++) { 
      long n = (int)(java.lang.Math.random()*99);
      arr.insert(n);
    }
    
    arr.display(); // display unsorted array
    arr.shellSort(); // shell sort the array
    arr.display(); // display sorted array
  }
}