public class Echoer {
   public static void main( String args[] ) {
      if( args.length == 0 ) {
         System.out.println( "\n  Run me again, with some command line arguments....\n" );
         System.exit( 0 );
      }
      for( int i = 0; i < args.length; i++ ) {
         System.out.println( "  args[" + i + "] is: " + args[i] );
      }
   }
}