/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.ArrayList;
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;


  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */ 
   public DiceSet( int count, int sides ) {
	  if (count <= 0) {
		  throw new IllegalArgumentException("Must have more than 0 die in the set");
	  }
	  this.count = count;
	  this.sides = sides;
	  ds = new Die[ count ];
	  for(int i = 0; i<count; i++) {
		  try {ds[i] = new Die(sides);}
		  catch (IllegalArgumentException iae ) { System.out.println( "   Too few sides to creat a Dice Set" ); }
	  }
	  
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
	   int sum =0;
	   for(int i =0; i<this.count; i++) {
		   sum += ds[i].getValue();
	   }
	   return sum;
		  
   }
  /**
   *
   */

   public int getCount() {
	   return this.count;
   }

	
  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
	   for (int i = 0; i<this.count; i++) {
		   ds[i].roll();
	   }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
	   if(dieIndex > this.count) {
		   throw new IllegalArgumentException("There are not that many die in the set");
	   }
	   return ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      if(dieIndex > this.count) {
		   throw new IllegalArgumentException("There are not that many die in the set");
	   }
	   return ds[dieIndex].getValue();
   }
   
   public void setValue(int value) {
	   for(int i=0; i<this.count;i++) {
		   ds[i].individualValue(value);
	   }
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
	  String result = "";
	  for (int i = 0; i<this.count; i++) {
		   result += ("{" + ds[i].getValue() + "}");
	   }
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
  
   public static String toString( DiceSet ds ) {
      String result = "";
	  for (int i = 0; i<ds.getCount(); i++) {
		   result += ("{" + ds.getIndividual(i) + "}");
	   }
      return result;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   
   
   // FIND A WAY TO SORT THE LSITS AND IF THEY ARE EQUAL THEN YOU ARE DONE
   
   
   public boolean isIdentical( DiceSet ds ) {
	   ArrayList<Integer> firstList = new ArrayList<Integer>();
	   ArrayList<Integer> secondList = new ArrayList<Integer>();
	   
	   if ((this.sides != ds.sides) || (this.count != ds.count)){
		   return false;
	   }
	   for (int i=0; i<this.count;i++){
		   firstList.add(this.getIndividual(i));
		   secondList.add(ds.getIndividual(i));
		   //System.out.println(firstList);
		   //System.out.println(secondList);
	   }
	   
	   for(int i=0; i<(this.count/2);i++){
		   if (secondList.contains(firstList.get(i))){
			   secondList.remove(secondList.indexOf(firstList.get(i)));
			   firstList.remove(firstList.get(i));
			   //System.out.println(firstList);
			   //System.out.println(secondList);
			   
		   }
		   else
		   {
			   return false;
		   }
	   }
		
	   if (firstList.equals(secondList)) {
		   return true;
	   }
	   return false;
	  
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      
	  
   }
    
}