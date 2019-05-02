/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  David Donovan
 * Date       :  2019-5-01
 * Description:  
 * Notes      :  
 * Warnings   :  
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class BrobInt {

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   
   public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public  String internalValue = "";        // internal String representation of this BrobInt
   private byte   sign          = 0;         // "0" is positive, "1" is negative
   //private String reversed      = "";        // the backwards version of the internal String representation
   //private byte[] byteVersion   = null;      // byte array for storing the string values; uses the reversed string

    public String initialValue = "";
	public byte[] initialArray = new byte[0];
	public String reversedValue = "";
	public byte[] reversedArray = new byte[0];
   

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
		
		for (int i=1; i<value.length(); i++) {
			if(!Character.isDigit(value.charAt(i))) { throw new IllegalArgumentException( "That is not a valid number" ); }
		}
		
		if(Character.toString(value.charAt(0)).equals("-")) {
			this.sign = 1;
			this.initialArray = new byte[value.length()-1];
			this.reversedArray = new byte[value.length()-1];
			for(int i=0; i<value.length()-1;i++) {
				this.initialValue += value.charAt(i+1);
			}
			for(int i=0; i<value.length()-1;i++) {
				this.initialArray[i] = Byte.parseByte(Character.toString(value.charAt(i+1)));
			}
			for(int i=0; i<value.length()-1;i++) {
				this.reversedArray[i] = this.initialArray[(value.length()-i) -2];
			}		
			for(int i=0; i<value.length()-1;i++) {
				this.reversedValue += reversedArray[i];
			}		
		}
		else{
			this.sign = 0;
			this.initialValue = value;
			this.initialArray = new byte[value.length()];
			this.reversedArray = new byte[value.length()];
			for(int i=0; i<value.length();i++) {
				this.initialArray[i] = Byte.parseByte(Character.toString(value.charAt(i)));
			}
			for(int i=0; i<value.length();i++) {
				this.reversedArray[i] = Byte.parseByte(Character.toString(value.charAt((value.length()-1)-i)));
			}		
			for(int i=0; i<value.length();i++) {
				this.reversedValue += reversedArray[i];
			}		
		}

   }




 
  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public boolean validateDigits() {
		
       throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt reverser() {
		return null;
    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  bint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public static BrobInt reverser( BrobInt bint ) {
       throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobInt passed as argument to this BrobInt using byte array
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt add( BrobInt bint ) {
		byte[] sumArray = new byte[this.initialValue.length() > bint.initialValue.length() ? this.initialValue.length() : bint.initialValue.length()];
		BrobInt sum = ZERO;
		String result = "";
		if (this.sign == 1 && bint.sign == 1) {result = "-";}
		if((this.sign == 0 && bint.sign == 0) || (this.sign == 1 && bint.sign == 1)) {
		for (int i=0; i< (this.initialValue.length() > bint.initialValue.length() ? this.initialValue.length() : bint.initialValue.length()); i++) {
			if (this.initialValue.length() > bint.initialValue.length()) {
				if(i<bint.initialValue.length()) {
					sumArray[i] = (byte)(this.reversedArray[i] + bint.reversedArray[i]);
				}
				else { sumArray[i] = this.reversedArray[i]; }
			}
			else {
				if(i<this.initialValue.length()) {
					sumArray[i] = (byte)(this.reversedArray[i] + bint.reversedArray[i]);
				}
				else { sumArray[i] = bint.reversedArray[i]; }
			}
		}
		for(int i=0; i< sumArray.length-1; i++){
			if (sumArray[i] >= 10) {
				sumArray[i] -= 10;
				sumArray[i+1]++;
			}		
		}
		for(int i=0; i< sumArray.length; i++){
			result += sumArray[sumArray.length - i - 1];	
		}
		
		sum = new BrobInt(result);
		return sum;
		}
		
		
		else { 
		BrobInt abs1 = new BrobInt(this.initialValue);
		BrobInt abs2 = new BrobInt(bint.initialValue);
		return abs1.subtract(abs2);
		}
		
		
		//return sum;
    }  

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using bytes
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtract( BrobInt bint ) {
		byte[] sumArray = new byte[this.initialValue.length() > bint.initialValue.length() ? this.initialValue.length() : bint.initialValue.length()];
		BrobInt sum = ZERO;
		String result = "";
		if (this.compareTo(bint) == 0) {return sum;}
		
		else if (this.sign == 0 && bint.sign == 1) { BrobInt s2 = new BrobInt(bint.initialValue); sum = this.add(s2); return sum; }
		else if (this.sign == 1 && bint.sign == 0) { BrobInt s2 = new BrobInt(this.initialValue); sum = bint.add(s2); sum.sign = 1; return sum; }
		
		else if (this.sign == 0 && bint.sign == 0) { 
			result = (this.compareTo(bint) == -1 ? "-":"");

			if(this.compareTo(bint) == 1) {
				for (int i=0; i< (this.initialValue.length() > bint.initialValue.length() ? this.initialValue.length() : bint.initialValue.length()); i++) {
					if(i<bint.initialValue.length()) {
					sumArray[i] = (byte)(this.reversedArray[i] - bint.reversedArray[i]);
					}
					else { sumArray[i] = this.reversedArray[i]; }
				}
				for (int i=0; i< (this.initialValue.length() > bint.initialValue.length() ? this.initialValue.length() : bint.initialValue.length()); i++) {
					if (sumArray[i] < 0) { sumArray[i]+=10; sumArray[i+1]--; System.out.println("THIS RUNS");}
				}
			}
			else {
				for (int i=0; i< (this.initialValue.length() > bint.initialValue.length() ? this.initialValue.length() : bint.initialValue.length()); i++) {
					if(i<this.initialValue.length()) {
					sumArray[i] = (byte)(bint.reversedArray[i] - this.reversedArray[i]);
					}
					else { sumArray[i] = bint.reversedArray[i]; }
				}
				for (int i=0; i< (this.initialValue.length() > bint.initialValue.length() ? this.initialValue.length() : bint.initialValue.length()); i++) {
					if (sumArray[i] < 0) { sumArray[i]+=10; sumArray[i+1]--;}
				}
			}
			
		}
		
		else if (this.sign == 1 && bint.sign == 1) {
			result = (this.compareTo(bint) == -1 ? "":"-");
			
			if(this.compareTo(bint) == -1) {
				BrobInt v1 = new BrobInt(this.initialValue);
				BrobInt v2 = new BrobInt(bint.initialValue);
				BrobInt answer = ZERO;
				try{answer = v2.subtract(v1);}
				catch (Exception e) {System.out.println("ERROR HERE NOT IN TESTER" +e);}
				result += answer.initialValue;
				sum = new BrobInt(result);
				return sum;

			}
			else {
				BrobInt v1 = new BrobInt(this.initialValue);
				BrobInt v2 = new BrobInt(bint.initialValue);
				BrobInt answer = ZERO;
				try{answer = v1.subtract(v2);}
				catch (Exception e) {System.out.println("ERROR HERE NOT IN TESTER" +e);}
				result += answer.initialValue;
				sum = new BrobInt(result);
				return sum;

			}
		}
		
		
		else if (this.compareTo(bint) == -1) { result = "-10"; }
		
		
		
		
		
		for(int i=0; i< sumArray.length; i++){
			result += sumArray[sumArray.length - i - 1];	
		}


		sum = new BrobInt(result);
		return sum;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply this by
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt bint ) {
	   BrobInt result = ZERO;
	   for (BrobInt i = ZERO; i.compareTo(bint)== -1; i = i.add(ONE)) {

			result = result.add(this);
	   }
	   return result;
	   
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to add to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
   *        It takes into account the length of the two numbers, and if that isn't enough it does a
   *        character by character comparison to determine
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt bint ) {

     // handle the signs here
      if( 1 == sign && 0 == bint.sign ) {
         return -1;
      } else if( 0 == sign && 1 == bint.sign ) {
         return 1;
      }

     // the signs are the same at this point
     // check the length and return the appropriate value
     //   1 means this is longer than bint, hence larger
     //  -1 means bint is longer than this, hence larger
      if( initialValue.length() > bint.initialValue.length() ) {
         return 1;
      } else if( initialValue.length() < bint.initialValue.length() ) {
         return (-1);

     // otherwise, they are the same length, so compare absolute values
      } else {
         for( int i = 0; i < initialValue.length(); i++ ) {
            Character a = Character.valueOf( initialValue.charAt(i) );
            Character b = Character.valueOf( bint.initialValue.charAt(i) );
            if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
               return 1;
            } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
               return (-1);
            }
         }
      }
      return 0;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" using the
   *        java String "equals()" method -- THAT was easy..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt bint ) {
      return (initialValue.equals( bint.toString() ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
	  String result = (this.sign == 0 ? "" : "-");
	  
	  if(this.initialValue.length() != 1) {
		  for(int i=0; i<this.initialValue.length(); i++) {
			if(Character.toString(this.initialValue.charAt(0)).equals("0") && i==0) {
				for (int j=0; j<this.initialValue.length(); j++) {
					if(Character.toString(this.initialValue.charAt(j)).equals("0")) { i++; }
					else { break; }
				}
			}
			result += Character.toString(this.initialValue.charAt(i));
		  }
	  }
	  else { result += this.initialValue; }
		  
      return result;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Helper method to display an Array representation of this BrobInt as its bytes
   *  @param  d  byte array to represent
   *  @see https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html
   *  NOTE: the java.utils.Arrays class contains a toString() method which is overridden to take quite a
   *        few different array data types as arguments.  To use this with your code, simply change the
   *        data type for the argument to match the data type of the array you want represented.  For
   *        example, change "byte[]" to "int[]" to make this method hand int arrays.
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( byte[] d ) {
      System.out.println( Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
	   
	   
	   //System.out.println(Long.valueOf( Long.MIN_VALUE ).toString() );
	   
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );
      BrobInt variable = new BrobInt(args[0]);
	  BrobInt variable1 = new BrobInt("999999");
	  
	 
	  
	  System.out.println(variable.sign);
	  
	  
	  System.out.println(variable);
	  
	  System.out.println("TESTING ADD ---------------");
	  System.out.println("Should get " + (Integer.parseInt(args[0]) + 99999));
	  System.out.println(variable1.add(variable).toString());
	  
	  
	  System.out.println("TESTING Subtract ---------------");
	  System.out.println("Should get " + (Integer.parseInt(args[0]) - 999999));
	  System.out.println(variable.subtract(variable1).toString());
	  
	  

   }
}