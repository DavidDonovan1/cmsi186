/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.lang.Math;
public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   double minuteHandDegree;
   double hourHandDegree;
   double timeSlice;

  /**
   *  Constructor goes here
   */
   public Clock() {
		minuteHandDegree = 0.0;
		hourHandDegree = 0.0;
		timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
	   if ((this.minuteHandDegree + (timeSlice * MINUTE_HAND_DEGREES_PER_SECOND)) >= 360.0)
	   {this.minuteHandDegree -= 360.0; }
	   if ((this.hourHandDegree + (timeSlice * HOUR_HAND_DEGREES_PER_SECOND)) >= 360.0)
	   {this.hourHandDegree -= 360.0; }
   
	  this.minuteHandDegree += (timeSlice * MINUTE_HAND_DEGREES_PER_SECOND);
	  this.hourHandDegree += (timeSlice * HOUR_HAND_DEGREES_PER_SECOND);
      
	  
	  return minuteHandDegree/MINUTE_HAND_DEGREES_PER_SECOND;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public static double validateAngleArg( String argValue ) throws NumberFormatException {
      try {if(Double.parseDouble(argValue) >= 360) { return -1.0; } }
	  catch (NumberFormatException ne) {System.out.println("Must be a number");}
	  
	  return 0.0;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public static double validateTimeSliceArg( String argValue ) {
      try {if(Double.parseDouble(argValue) >= 1800) { return -1; } }
	  catch (NumberFormatException ne) {System.out.println("Must be a number");}
	  
	  return 0;
   }
   
   public void setTimeSlice(double Slice){
	   this.timeSlice = Slice;
   }
   
   public double getTimeSlice() {
	   return this.timeSlice;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      return this.hourHandDegree;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      return this.minuteHandDegree;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
	  return Math.round(Math.abs(hourHandDegree - minuteHandDegree));
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
	   return( Math.round(this.hourHandDegree / HOUR_HAND_DEGREES_PER_SECOND));
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
   return ("     "+Math.round(this.getHourHandAngle()/30.0)+":" +Math.round(this.getMinuteHandAngle()/6.0));
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? "\n - got 0.0" : "\n - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  
	  System.out.println("     Testing tick; Test 1 of 3");
	  try { System.out.println( (60.0 == clock.tick()) ? " - got 60.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  System.out.println("     Testing tick; Test 2 of 3");
	  try { System.out.println( (120.0 == clock.tick()) ? " - got 120.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  System.out.println("     Testing tick; Test 3 of 3");
	  try { System.out.println( (180.0 == clock.tick()) ? " - got 180.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  
	  System.out.println("     Testing getHandAngle()");
	  try { System.out.println( (16.4988 == clock.getHandAngle()) ? " - got 16.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  
	  System.out.println("     Testing getMinuteHandAngle()");
	  try { System.out.println( (18.0 == clock.getMinuteHandAngle()) ? " - got 18.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

	  System.out.println("     Testing getHourHandAngle()");
	  try { System.out.println( ((clock.getHourHandAngle()) == clock.getHourHandAngle()) ? " - got 1.5" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

	  System.out.println("");
	  System.out.println("     Testing getTotalSeconds()");
	  try { System.out.println( (( Math.round(clock.hourHandDegree / HOUR_HAND_DEGREES_PER_SECOND)) == clock.getTotalSeconds()) ? (" - got " + Math.round(clock.hourHandDegree / HOUR_HAND_DEGREES_PER_SECOND)) : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  
	  
	  System.out.println("     Validate 60 ");
	  try { System.out.println( (0.0 == clock.validateTimeSliceArg("60")) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  
	  
	  System.out.println("     Validate 2000");
	  try { System.out.println( (-1.0 == clock.validateTimeSliceArg("2000")) ? " - got -1.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	  
	  System.out.println(clock);
	  }
}
