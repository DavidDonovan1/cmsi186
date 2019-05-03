/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobIntTester.java
 * Purpose    :  Test Harness for the BrobInt java class
 * @author    :  B.J. Johnson
 * Date       :  2017-04-05
 * Description:  
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-05  B.J. Johnson  Initial writing and release
 *  1.1.0  2017-04-13  B.J. Johnson  Added new BrobInt instances to check addition; refactored to
 *                                     check the new versions of compareTo and equals; verified that all
 *                                     additions work for both small and large numbers, as well as for
 *                                     values of different lengths and including same-sign negative value
 *                                     additions; ready to start subtractByte and subtractInt methods
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BrobIntTester {

   private static String g01String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g02String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g03String = "144127909719710664015092431502440849849506284108982076191826176553";
   private static String g04String = "14412790971971066401509243150244084984950628410898207";
   private static String g05String = "0";
   private static String g06String = "1";
   private static String g07String = "10";
   private static String g11String = "10";
   private static String g12String = "20";
   private static String g13String = "234567";
   private static String g14String = "-234567";
   private static String g15String = "-10";
   private static String g16String = "-999999";
   private static String g17String = "765";
   private static String g18String = "23";
   private static String g19String = "56789";
   private static String g20String = "37";
   private static String g21String = "11111-11111";
   private static String g22String = "Hello";
   private static String g23String = "";
   private static String g24String = "";
   private static String g25String = "";
   private static String g26String = "";

   private static BrobInt g1 = null;
   private static BrobInt g2 = null;
   private static BrobInt g3 = null;
   private static BrobInt g4 = null;
   private static BrobInt g5 = null;
   private static BrobInt g6 = null;
   private static BrobInt g7 = null;
   private static BrobInt g8 = null;
   private static BrobInt g9 = null;
   private static BrobInt g10 = null;
   private static BrobInt g11 = null;
   private static BrobInt g12 = null;
   private static BrobInt g13 = null;
   private static BrobInt g14 = null;
   private static BrobInt g15 = null;
   private static BrobInt g16 = null;
   private static BrobInt g17 = null;
   private static BrobInt g18 = null;
   private static BrobInt g19 = null;
   private static BrobInt g20 = null;
   private static BrobInt g21 = null;
   private static BrobInt g22 = null;
   private static BrobInt g23 = null;
   private static BrobInt g24 = null;
   private static BrobInt g25 = null;
   private static BrobInt g26 = null;
   
   private static BrobInt d1 = null;
   private static BrobInt d2 = null;
   private static BrobInt d3 = null;
   private static BrobInt d4 = null;
   private static BrobInt d5 = null;
   private static BrobInt d6 = null;
   private static BrobInt d7 = null;
   private static BrobInt d8 = null;
   private static BrobInt d9 = null;
   private static BrobInt d10 = null;
   private static BrobInt d11 = null;
   private static BrobInt d12 = null;
   private static BrobInt d13 = null;
   private static BrobInt d14 = null;
   private static BrobInt d15 = null;
   private static BrobInt d16 = null;
   private static BrobInt d17 = null;
   private static BrobInt d18 = null;
   private static BrobInt d19 = null;
   private static BrobInt d20 = null;
   private static BrobInt d21 = null;
   private static BrobInt d22 = null;
   private static BrobInt d23 = null;
   private static BrobInt d24 = null;
   private static BrobInt d25 = null;
   private static BrobInt d26 = null;
   


   public BrobIntTester() {
      super();
   }

   public static void main( String[] args ) {
      BrobIntTester git = new BrobIntTester();

      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );

      System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                          "    ==================================" );
      try {
         System.out.println( "    Test 001: Making a new BrobInt: " );
         g1 = new BrobInt( g01String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + g01String + "\n" +
                             "        and got: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 002: Making a second new BrobInt [same as first]: " );
      try {
         g2 = new BrobInt( g02String );
         System.out.println( "      expecting: " + g02String + "\n" +
                             "        and got: " + g2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 003: Comparing equality of g1 and g2 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + g1.equals( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 004: Making a third new BrobInt [differs at position 47    |]: " +
                             "\n           [position indicated by down arrow]                  v   " );
         g3 = new BrobInt( g03String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g03String + "\n" +
                             "        and got: " + g3.toString() );
         System.out.println( "          g1 is: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 005: Comparing equality of g1 and g3 [detect different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 006: Making a fourth new BrobInt [same as g3 but truncated]: "  );
         g4 = new BrobInt( g04String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g04String + "\n" +
                             "        and got: " + g4.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 007: Comparing equality of g3 and g4 [detect different length prior to detecting different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g3.equals( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 008: Making a fifth new BrobInt, checking BrobInt.ZERO: "  );
         g5 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ZERO + "\n" +
                             "        and got: " + g5.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 009: Making a sixth new BrobInt, checking BrobInt.ONE: "  );
         g6 = new BrobInt( "1" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ONE + "\n" +
                             "        and got: " + g6.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 010: Making a seventh new BrobInt, checking BrobInt.TEN: "  );
         g7 = new BrobInt( g07String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.TEN + "\n" +
                             "        and got: " + g7.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING VALUEOF( LONG ) METHOD:\n" +
                          "    ===============================" );
      System.out.println( "\n    Test 011: Creating several long type values to check the 'valueOf()' method: " );
      long long01 = Long.MAX_VALUE;
      long long02 = Long.MIN_VALUE;
      long long03 = 1234567890;
      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + long01 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + long02 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 012: Now testing 'valueOf()' method: " );
         g8  = BrobInt.valueOf( long01 );
         g9  = BrobInt.valueOf( long02 );
         g10 = BrobInt.valueOf( long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + g8.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + g9.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + g10.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING ADD() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "\n    Test 013: Making an eleventh and twelfth new BrobInt, calling add method: "  );
         g11 = new BrobInt( g11String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 10\n" +
                             "        and got: " + g11.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g12 = new BrobInt( g12String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g12.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014: Adding g11 and g12: " );
         System.out.println( "      expecting: 30 and got " + g11.add( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 015: Making a thirteenth new BrobInt, calling add methods: "  );
      try {
         g13 = new BrobInt( g13String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 234567\n" +
                             "        and got: " + g13.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016: Adding g11 and g13 [10 + 234567] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g11.add( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 017: Adding g13 and g11 [234567 + 10] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g13.add( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 018: Making a fourteenth new BrobInt, calling add methods: "  );
      try {
         g14 = new BrobInt( g14String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -234567\n" +
                             "        and got: " + g14.toString() );
         System.out.println( "\n    Test 019: Making a fifteenth new BrobInt, calling add methods: "  );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g15 = new BrobInt( g15String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -10\n" +
                             "        and got: " + g15.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 020: Adding g14 and g15 [-234567 + -10] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g14.add( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 021: Adding g15 and g14 [-10 + -234567] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g15.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 022: Making a sixteenth new BrobInt, calling add methods: "  );
      try {
         g16 = new BrobInt( g16String );
         System.out.println( "      expecting: -999999\n" +
                             "        and got: " + g16.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 023: Adding g14 and g16 [-234567 + -999999] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g14.add( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 024: Adding g16 and g14 [-999999 + -234567] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g16.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n      Test 025: Adding g1 and g4 using bytes: " );
         System.out.println( "      expecting: 144127909719725076806064402568842359092656528233967026820237074760\n" +
                             "        and got: " + g1.add( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING COMPARETO() METHOD:\n" +
                          "    ===========================\n" +
                          "    NOTE: this.compareTo(that) returns: -1 if this < that\n" +
                          "                               returns: +1 if this > that\n" +
                          "                               returns:  0 if this = that" );
      try {
         System.out.println( "\n    Test 026: Checking compareTo() method on g1.compareTo g2: "  );
         System.out.println( "      expecting: 0 and got: " + g1.compareTo( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 027: Checking compareTo() method on g2.compareTo g1: "  );
         System.out.println( "      expecting: 0 and got: " + g2.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 028: Checking compareTo() method on g1.compareTo g3: "  );
         System.out.println( "      expecting: positive value and got: " + g1.compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 029: Checking compareTo() method on g3.compareTo g1: "  );
         System.out.println( "      expecting: negative value and got: " + g3.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030: Checking compareTo() method on g3.compareTo g4: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030a: Checking compareTo() method on 123456789.compareTo 234: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("123456789").compareTo( new BrobInt("234"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030b: Checking compareTo() method on 123.compareTo 123456789: "  );
         System.out.println( "      expecting: ngative value and got: " + (new BrobInt("123").compareTo( new BrobInt("123456789"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030c: Checking compareTo() method on g3.compareTo 999: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( new BrobInt( "999" ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030d: Checking compareTo() method on 1234.compareTo -999: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("1234").compareTo( new BrobInt( "-999" ) ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030e: Checking compareTo() method on -999.compareTo G3: "  );
         System.out.println( "      expecting: negative value and got: " + new BrobInt( "-999" ).compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING SUBTRACTBYTE() METHOD:\n" +
                          "    ==============================" );
      System.out.println( "\n      Test 031: Subtracting g13 take away g11 [234567 - 10] using bytes: " );
      try {
         System.out.println( "      expecting: 234557\n" +
                             "        and got: " + g13.subtract( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 032: Subtracting g11 take away g13 [10 - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234557\n" +
                             "        and got: " + g11.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 033: Subtracting g13 take away g15 [234567 - (-10)] using bytes: " );
      try {
         System.out.println( "      expecting: 234577\n" +
                             "        and got: " + g13.subtract( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 034: Subtracting g15 take away g13 [(-10) - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234577\n" +
                             "        and got: " + g15.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 035: Subtracting g14 take away g16 [(-234567) - (-999999)] using bytes: " );
      try {
         System.out.println( "      expecting: 765432\n" +
                             "        and got: " + g14.subtract( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 036: Subtracting g16 take away g14 [(-999999) - (-234567)] using bytes: " );
      try {
         System.out.println( "      expecting: -765432\n" +
                             "        and got: " + g16.subtract( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e ); }

      System.out.println( "\n      Test 037: Subtracting g1 take away g1 [too long to list] using bytes: " );
      try {
         System.out.println( "      expecting: 000000000000000000000000000000000000000000000000000000000000000000\n" +
                             "        and got: " + g1.subtract( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING MULTIPLY() METHOD:\n" +
                          "    ==========================" );
      System.out.println( "\n      Test 038: Multiplying g7 by g12 [10 * 20]: " );
      try {
         System.out.println( "      expecting: 200\n" +
                             "        and got: " + g7.multiply( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Test 039: Making a seventeenth new BrobInt: "  );
      try {
         g17 = new BrobInt( g17String );
         System.out.println( "      expecting: 765\n" +
                             "        and got: " + g17.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 040: Making a eightteenth new BrobInt: "  );
      try {
         g18 = new BrobInt( g18String );
         System.out.println( "      expecting: 23\n" +
                             "        and got: " + g18.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 041: Making a nineteenth new BrobInt: "  );
      try {
         g19 = new BrobInt( g19String );
         System.out.println( "      expecting: 56789\n" +
                             "        and got: " + g19.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 042: Making a twentieth new BrobInt: "  );
      try {
         g20 = new BrobInt( g20String );
         System.out.println( "      expecting: 37\n" +
                             "        and got: " + g20.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 043: Multiplying g17 by g18 [765 * 23]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g17.multiply( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 044: Multiplying g18 by g20 [23 * 37]: " );
      try {
         System.out.println( "      expecting: 851\n" +
                             "        and got: " + g18.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 045: Multiplying g19 by g20 [56789 * 37]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g19.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 046: Multiplying g18 by g17 [23 * 765]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g18.multiply( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 047: Multiplying g17 by g19 [765 * 56789]: " );
      try {
         System.out.println( "      expecting: 43443585\n" +
                             "        and got: " + g17.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048: Multiplying g20 by g19 [37 * 56789]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g20.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n\n    TESTING DIVIDE() METHOD:\n" +
                          "    ========================" );
      System.out.println( "\n      Test 049: Dividing g19 by g20 [56789 / 37]: " );
      try {
         System.out.println( "      expecting: 1534\n" +
                             "        and got: " + g19.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050: Dividing g17 by g20 [765 / 37]: " );
      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g17.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n\n    TESTING REMAINDER() METHOD:\n" +
                          "    ===========================" );
      System.out.println( "\n      Test 051: Modding g17 by g18 [765 % 23]: " );
      try {
         System.out.println( "      expecting: 6\n" +
                             "        and got: " + g17.remainder( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052: Modding g19 by g20 [56789 % 37]: " );
      try {
         System.out.println( "      expecting: 31\n" +
                             "        and got: " + g19.remainder( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

//----------------------------------------------------------------------------------------------------------------------------
	  
	  System.out.println("\n\nSTARTING PERSONAL TESTING \n ========================================================================================================\n");
	  System.out.println( "\n\n    TESTING SPECIAL CASES:\n" +
                          "    ===========================" );




//--------------------------------------------------------------------------------------------------------------------------
	  System.out.println( "\n\n    TESTING CONSTRUCTOR AND EQUALS() METHODS:\n" +
                          "    ==========================" );
						  
    BrobInt d1 = null;
    BrobInt d2 = null;
    BrobInt d3 = null;
    BrobInt d4 = null;
    BrobInt d5 = null;
	BrobInt d6 = null;
    BrobInt d7 = null;
    BrobInt d8 = null;
    BrobInt d9 = null;
    BrobInt d10 = null;
	BrobInt d11 = null;
    BrobInt d12 = null;
   
   
   String d01String = "1234512345";
   String d02String = "1234512345";
   String d03String = "1234512345";
   String d04String = "-1234512345";
   String d05String = "-1234512345";
   String d06String = "-1234512345";
   String d07String = "-0";
   String d08String = "0";
   String d09String = "111";
   String d10String = "1111";
   String d11String = "000001";
   String d12String = "000001";

   
	try {
         System.out.println( "    Test 001: Making a new BrobInt: " );
         d1 = new BrobInt(d01String);
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + d01String + "\n" +
                             "        and got: " + d1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 002: Making a second new BrobInt: " );
      try {
         d2 = new BrobInt( d02String );
         System.out.println( "      expecting: " + d02String + "\n" +
                             "        and got: " + d2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 003: Comparing equality of d1 and d2 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + d1.equals( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      


   
	try {
         System.out.println( "\n    Test 004: Making a new BrobInt: " );
         d3 = new BrobInt(d03String);
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + d03String + "\n" +
                             "        and got: " + d3.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 005: Making a second new BrobInt: " );
      try {
         d4 = new BrobInt( d04String );
         System.out.println( "      expecting: " + d04String + "\n" +
                             "        and got: " + d4.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 006: Comparing equality of d3 and d4 with 'equals()': " );
         System.out.println( "      expecting: false\n" + "        and got: " + d3.equals( d4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

          

   
	try {
         System.out.println( "\n    Test 007: Making a new BrobInt: " );
         d5 = new BrobInt(d05String);
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + d05String + "\n" +
                             "        and got: " + d5.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 008: Making a second new BrobInt: " );
      try {
         d6 = new BrobInt( d06String );
         System.out.println( "      expecting: " + d06String + "\n" +
                             "        and got: " + d6.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 009: Comparing equality of d5 and d6 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: true");
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
	  
	try {
         System.out.println( "\n    Test 010: Making a new BrobInt: " );
         d7 = new BrobInt(d07String);
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + d07String + "\n" +
                             "        and got: " + d7.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 011: Making a second new BrobInt: " );
      try {
         d8 = new BrobInt( d08String );
         System.out.println( "      expecting: " + d08String + "\n" +
                             "        and got: " + d8.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 012: Comparing equality of d7 and d8 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + d7.equals( d8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

	try {
         System.out.println( "\n    Test 013: Making a new BrobInt: " );
         d9 = new BrobInt(d09String);
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + d09String + "\n" +
                             "        and got: " + d9.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 014: Making a second new BrobInt: " );
      try {
         d10 = new BrobInt( d10String );
         System.out.println( "      expecting: " + d10String + "\n" +
                             "        and got: " + d10.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 015: Comparing equality of d9 and d10 with 'equals()': " );
         System.out.println( "      expecting: false\n" + "        and got: " + d9.equals( d10 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      

	try {
         System.out.println( "\n    Test 016: Making a new BrobInt: " );
         d11 = new BrobInt(d11String);
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + d11String + "\n" +
                             "        and got: " + d11.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 017: Making a second new BrobInt: " );
      try {
         d12 = new BrobInt( d12String );
         System.out.println( "      expecting: " + d12String + "\n" +
                             "        and got: " + d12.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 018: Comparing equality of d11 and d12 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + d7.equals( d8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

//------------------------------------------------------------------------------------------------------------------------------------------------
	   System.out.println( "\n\n    TESTING ADD() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "      Test 01:"  );
         d1 = new BrobInt( "-999" );
		 d2 = new BrobInt( "1" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "             testing -999+1:       expecting: -998\n" +
                             "                                     and got: " + d1.add( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      Test 02:"  );
         d1 = new BrobInt( "0" );
		 d2 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "                testing 0+0:       expecting: 0\n" +
                             "                                     and got: " + d1.add( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

	  
      try {
         System.out.println( "      Test 03:"  );
         d1 = new BrobInt( "-10" );
		 d2 = new BrobInt( "-10" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "          testing -10 + -10:       expecting: -20\n" +
                             "                                     and got: " + d1.add( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
	  
	  try {
         System.out.println( "      Test 04:"  );
         d1 = new BrobInt( "" );
		 d2 = new BrobInt( "" );
      }
      catch( Exception e ) { System.out.println( "          testing null + null:       expecting: Excpetion thrown: " ); }     

      try {
         System.out.println( "          testing null + null:       expecting: -20\n" +
                             "                                     and got: " + d1.add(null) );
      }
      catch( Exception e ) { System.out.println( "                                       and got: Exception thrown: " ); }
	  
      try {
         System.out.println( "      Test 05:"  );
         d1 = new BrobInt( "999999999999999999999999" );
		 d2 = new BrobInt( "999999999999999999999999" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "                                   expecting: "+d1.add( d2 )+"\n" +
                             "                                     and got: " + d1.add( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }	

      try {
         System.out.println( "      Test 06:"  );
         d1 = new BrobInt( "-1000" );
		 d2 = new BrobInt( "999" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try { BrobInt result = d1.add(d2);
         System.out.println( "          testing -1000 + 999:       expecting: -1\n" +
                             "                                       and got: " + result.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }	

      
//--------------------------------------------------------------------------------------------------------------------------
	  System.out.println( "\n\n    TESTING SUBTRACT() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "      Test 01:"  );
         d1 = new BrobInt( "1" );
		 d2 = new BrobInt( "10" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 1-10:     expecting: -9\n" +
                             "                                   and got: " + d1.subtract( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      Test 02:"  );
         d1 = new BrobInt( "0" );
		 d2 = new BrobInt( "10" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 0-10:     expecting: -10\n" +
                             "                                   and got: " + d1.subtract( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

	  
      try {
         System.out.println( "      Test 03:"  );
         d1 = new BrobInt( "-10" );
		 d2 = new BrobInt( "10" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "             testing -10-10:     expecting: -20\n" +
                             "                                   and got: " + d1.subtract( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 04:"  );
         d1 = new BrobInt( "10" );
		 d2 = new BrobInt( "-100" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "          testing 10-(-100):     expecting: 110\n" +
                             "                                   and got: " + d1.subtract( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }


      try {
         System.out.println( "      Test 05:"  );
         d1 = new BrobInt( "-9999" );
		 d2 = new BrobInt( "-9999" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "      testing -9999-(-9999):     expecting: 0\n" +
                             "                                   and got: " + d1.subtract( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 06:"  );
         d1 = new BrobInt( "-123456789" );
		 d2 = new BrobInt( "987654321" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "                                 expecting: -1111111110\n" +
                             "                                   and got: " + d1.subtract( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
	  



	  
//--------------------------------------------------------------------------------------------------------------------------
	  System.out.println( "\n\n    TESTING DIVIDE() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "      Test 01:"  );
         d1 = new BrobInt( "1000" );
		 d2 = new BrobInt( "5" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 1000/5:   expecting: 200\n" +
                             "                                   and got: " + d1.divide( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      Test 02:"  );
         d1 = new BrobInt( "999" );
		 d2 = new BrobInt( "5" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 1000/5:   expecting: 199\n" +
                             "                                   and got: " + d1.divide( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

	  
      try {
         System.out.println( "      Test 03:"  );
         d1 = new BrobInt( "-10" );
		 d2 = new BrobInt( "2" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing -10/2:    expecting: -5\n" +
                             "                                   and got: " + d1.divide( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 04:"  );
         d1 = new BrobInt( "10" );
		 d2 = new BrobInt( "-2" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 10/-2:    expecting: -5\n" +
                             "                                   and got: " + d1.divide( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }


      try {
         System.out.println( "      Test 05:"  );
         d1 = new BrobInt( "-10" );
		 d2 = new BrobInt( "-2" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing -10/-2:   expecting: 5\n" +
                             "                                   and got: " + d1.divide( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 06:"  );
         d1 = new BrobInt( "0" );
		 d2 = new BrobInt( "10" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 0/10:     expecting: 0\n" +
                             "                                   and got: " + d1.divide( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 07:"  );
         d1 = new BrobInt( "10" );
		 d2 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 10/0:     expecting: Exception Thrown: " );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
	  try {
		 System.out.println("                                   and got: " + d1.divide( d2 ) ); }
	  catch (Exception e) { System.out.println("                                   and got: Exception Thrown: " );}
	  
	  
	  
//--------------------------------------------------------------------------------------------------------------------------
	  System.out.println( "\n\n    TESTING MULTIPLY() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "      Test 01:"  );
         d1 = new BrobInt( "1000" );
		 d2 = new BrobInt( "1" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "             testing 1000*1:     expecting: 1000\n" +
                             "                                   and got: " + d1.multiply( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      Test 02:"  );
         d1 = new BrobInt( "999" );
		 d2 = new BrobInt( "999" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "            testing 999*999:     expecting: 998001\n" +
                             "                                   and got: " + d1.multiply( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

	  
      try {
         System.out.println( "      Test 03:"  );
         d1 = new BrobInt( "-10" );
		 d2 = new BrobInt( "5" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing -10*5:    expecting: -50\n" +
                             "                                   and got: " + d1.multiply( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 04:"  );
         d1 = new BrobInt( "10" );
		 d2 = new BrobInt( "-5" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 10*-5:    expecting: -50\n" +
                             "                                   and got: " + d1.multiply( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }


      try {
         System.out.println( "      Test 05:"  );
         d1 = new BrobInt( "0" );
		 d2 = new BrobInt( "10" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 0*10:     expecting: 0\n" +
                             "                                   and got: " + d1.multiply( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 06:"  );
         d1 = new BrobInt( "10" );
		 d2 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 10*0:     expecting: 0\n" +
                             "                                   and got: " + d1.multiply( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      Test 07:"  );
         d1 = new BrobInt( "0" );
		 d2 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "               testing 0*0:      expecting: 0\n" +
                             "                                   and got: " + d1.multiply( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
	  
//--------------------------------------------------------------------------------------------------------------------------
	  System.out.println( "\n\n    TESTING REMAINDER() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "      Test 01:"  );
         d1 = new BrobInt( "100" );
		 d2 = new BrobInt( "99" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "             testing 100/99:     expecting: 1\n" +
                             "                                   and got: " + d1.remainder( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      Test 02:"  );
         d1 = new BrobInt( "100" );
		 d2 = new BrobInt( "1" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "              testing 100/1:     expecting: 0\n" +
                             "                                   and got: " + d1.remainder( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

	  
      try {
         System.out.println( "      Test 03:"  );
         d1 = new BrobInt( "1" );
		 d2 = new BrobInt( "100" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }     

      try {
         System.out.println( "             testing 1/100:      expecting: 1\n" +
                             "                                   and got: " + d1.remainder( d2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }


System.out.println("END OF PERSONAL TESTING");
      System.exit( 0 );

   }
}