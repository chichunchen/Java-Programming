import java.util.Scanner;

public class GradeBook {
	
	private String courseName;
	
	//constructor
	public GradeBook( String name ) {
		courseName = name;
	} 

	public void setCourseName( String name ) {
		courseName = name;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void displayMessage() {
		System.out.printf( "Welcome to the grade book for\n%s!\n", getCourseName() );
	}
	
	public void determineClassAverage() {
		Scanner input = new Scanner( System.in );

		int total;
		int gradeCounter;
		int grade;
		int average;
		
		//initialize phase
		total = 0;
		gradeCounter = 0;
			
		System.out.print( "Enter grade: " );
		while( input.hasNext() ) {
			System.out.print( "Enter grade: " );
			grade = input.nextInt();
			total += grade;
			gradeCounter++;
		}
		
		average = total / ( gradeCounter );
		
		System.out.printf( "\nTotal of all %d grades is %d\n", gradeCounter, total );
		System.out.printf( "Class average is %d\n", average );
	}
	
}