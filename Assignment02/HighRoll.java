/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  MainProgLoopDemo.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-14
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 
Implement a Textual User Interface (TUI) on the command line. This will display a list of options to the user, and will prompt for input. 
	Based on that input your program will do what the user selected, then will display the results, a blank line or two, and then re-display the options.
Option 1 in the list must be: ROLL ALL THE DICE
Option 2 in the list must be: ROLL A SINGLE DIE
Option 3 in the list must be: CALCULATE THE SCORE FOR THIS SET
Option 4 in the list must be: SAVE THIS SCORE AS HIGH SCORE
Option 5 in the list must be: DISPLAY THE HIGH SCORE
Option 6 in the list must be: ENTER Q TO QUIT THE PROGRAM
For option 2 you may present a second prompt to get the number of the die to roll, or you may handle it as two numbers on the entry. 
An example of the first method would be to enter a 2 at the prompt, then display a new prompt such as which die? and read the user input. 
An example of the second method would be to read 2 5 to re-roll only die number 5; this method means you must parse the input to get the die index.
To run the program, you can do one of two things: EITHER start the program using…
java HighRoll <number of dice> <number of sides> …OR
java HighRoll and prompt the user for the parameters.
See the notes below.
 
 
 
 */
 
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class HighRoll{

   public static void main( String args[] ) {
	  int HIGH_SCORE = 0;
	  int sides = 4;
	  int die = 3;
	  DiceSet highRoll = new DiceSet(die, sides); 
	  
	   
      System.out.println( "\n   Welcome to the HighRoll!!\n" );
      System.out.println( "     Type \"QUIT\" to quit." );
	  System.out.println( "     Type \"help\" to see a list of commands." );
	  System.out.println( "\n" + highRoll.toString());

      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
		 System.out.println("----------------------------------------------------------------------------------------------------------------------");
         System.out.print( ">>" );
         String inputLine = null;
		 try {
            inputLine = input.readLine();
			
            if( 0 == inputLine.length() ) {System.out.println("Enter some text!");}
			else{System.out.println( "   You typed: " + inputLine );}
			
			//QUIT THE PROGRAM	
            try{ if( 'q' == inputLine.charAt(0) || "quit".equals(inputLine.substring(0,4)) || "QUIT".equals(inputLine.substring(0,4))) {
				break;}}
			catch(IndexOutOfBoundsException e ) {
            System.out.println( "" );}
			
			//PRINT THE HELP METHOD
			try{ if( "help".equals(inputLine.substring(0,4)) || "HELP".equals(inputLine.substring(0,4))) {
				printOptions();}}
			catch(IndexOutOfBoundsException e ) {
            System.out.println( "" );}
			
			//CHANGE THE NUMBER OF DICE
			try{  if( "die".equals(inputLine.substring(0,3))) {
				try { 
					try {die = Integer.parseInt(inputLine.substring(4));}
					catch (NumberFormatException ne) { System.out.println("\n\ndie [#] \n"); continue;}	
				if (die > 0) {
					System.out.println("\nChanged the number of die to " + die + "\n");
					highRoll = new DiceSet(die, sides);
					System.out.println(highRoll);}
				else{
					System.out.println("\nYou must have more than 0 die in a DiceSet!");
					continue;}
				}
				catch (IndexOutOfBoundsException e) {System.out.println("\ndie [#] \n");}
				}
			}
			catch(IndexOutOfBoundsException e ) {
            System.out.println( "" );}
			
			//CHANGE THE NUMBER OF SIDES
			try{  if("sides".equals(inputLine.substring(0,5))) {
				try { 
					try {sides = Integer.parseInt(inputLine.substring(6));}
					catch (NumberFormatException ne) { System.out.println("\nsides [#] \n"); continue;}	
				if (sides > 3) {
					System.out.println("\nChanged the number of sides to " + sides + "\n");
					highRoll = new DiceSet(die, sides);
					System.out.println(highRoll);}
				else{
					System.out.println("\nYour die must have more than 3 sides!");
					continue;}
				}
				catch (IndexOutOfBoundsException e) {System.out.println("\nsides [#] \n");}
				}
			}
			catch(IndexOutOfBoundsException e ) {
            System.out.println( "" );}
			
			//ROLL ALL DICE
			try{ 
			if("roll".equals(inputLine)) {
				try { highRoll.roll();
					System.out.println(highRoll);}
				catch (IndexOutOfBoundsException e ) {System.out.println("There are no die in the Dice Set!");}
			}
			}
			catch (IndexOutOfBoundsException e ) {
			System.out.println( "" ); }
			
			//ROLL A SINGLE DIE
			try{
			if ("roll ".equals(inputLine.substring(0,5))) {
				try {highRoll.rollIndividual(Integer.parseInt(inputLine.substring(5))-1);}
				catch (NumberFormatException ne) { System.out.println("\n roll [#] \n"); continue;}	
				System.out.println(highRoll);
			}
			}
			catch (IndexOutOfBoundsException e ) {
			System.out.println( "" ); }
					
			//PRINT THE TOTAL SCORE
			try{
			if ("score".equals(inputLine)){
				try{ int sum = highRoll.sum(); 
				System.out.println(highRoll + " = " + sum);}
				catch (IndexOutOfBoundsException e) { System.out.println(""); }
			}
			}
			catch (IndexOutOfBoundsException e ) {
			System.out.println( "" ); }
				
			//PRINT THE TOTAL DICE SET	
			try{
				if ("print".equals(inputLine)) {
				System.out.println("\n" +highRoll); }
			}
			catch (IndexOutOfBoundsException e ) {
			System.out.println( "" ); }
			
			//SAVE THE HIGH SCORE
			try { 
			if ("save".equals(inputLine)) {
				if (highRoll.sum() <= HIGH_SCORE) { System.out.println("This is not a high score!");
				continue; }
				HIGH_SCORE = highRoll.sum();
				System.out.println("The new high score is: " + HIGH_SCORE +"!");
			} }
			catch (IndexOutOfBoundsException e ) {
			System.out.println( "" ); }
				
			//PRINT THE HIGH SCORE
			try {
			if ("hs".equals(inputLine) || "highscore".equals(inputLine)) {
			System.out.println("The High Score is: " + HIGH_SCORE); }
			}
			catch (IndexOutOfBoundsException e ) {
			System.out.println( "" ); }
					 
		}
         catch( IOException ioe ) {
            System.out.println( "" );
         }
      }
	  
	  
   }
   
   
   
   public static void printOptions(){
   System.out.println("\n Command: \t Result: \n roll \t\t ROLL ALL THE DICE \n roll [#] \t ROLL A SINGLE DIE \n score \t\t CALCULATE THE SCORE FOR THIS SET \n save \t\t SAVE THIS SCORE AS HIGH SCORE \n highscore \t DISPLAY THE HIGH SCORE \n hs \t\t DISPLAY THE HIGH SCORE \n q \t\t QUIT THE PROGRAM \n quit \t\t QUIT THE PROGRAM \n print \t\t PRINT THE CURRENT SET \n die [#] \t\t CHANGE THE NUMBER OF DIE IN THE SET \n sides [#] \t\t CHANGE THE NUMBER OF SIDES ON THE DIE IN THE SET");
   }

   
}