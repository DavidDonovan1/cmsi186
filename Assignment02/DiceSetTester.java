public class DiceSetTester {
	public static void main(String args[]){
	  DiceSet d = new DiceSet(3, 4);
	  DiceSet e = new DiceSet(3, 4);
	  System.out.println(e + "     E (3 die, 4 sides)");
	  System.out.println(d + "     D (3 die, 4 sides)");
	  System.out.println("Testing isIdentical: " + e.isIdentical(d));
	  d.rollIndividual(1);
	  System.out.println();
	  System.out.println("Rolling die[1] of D: ");
	  System.out.println(d + "     D");
	  System.out.println("Testing isIdentical: " +e.isIdentical(d));
	  d.roll();
	  System.out.println();
	  System.out.println("Rolling all of D");
	  System.out.println(d + "     D");
	  System.out.println();
	  
	  DiceSet a = new DiceSet(3, 5);
	  DiceSet b = new DiceSet(3, 4);
	  System.out.println(a + "     A (3 die, 5 sides)");
	  System.out.println(b + "     B (3 die, 4 sides)");
	  System.out.println();
	  System.out.println("Testing isIdentical: " + a.isIdentical(b));
	  System.out.println();
	  a.setValue(4);
	  System.out.println();
	  System.out.println("Setting value of all die in A to 4");
	  System.out.println(a + "     A (3 die, 5 sides)");
	  System.out.println(b + "     B (3 die, 4 sides)");
	  System.out.println("Testing isIdentical: " + a.isIdentical(b));
	  System.out.println();
	  
	  DiceSet f = new DiceSet(5, 4);
	  DiceSet g = new DiceSet(3, 4);
	  System.out.println();
	  System.out.println(f + "     F (5 die, 4 sides)");
	  System.out.println(g + "     G (3 die, 4 sides)");
	  System.out.println("Testing isIdentical: " + f.isIdentical(g));
	  
	  DiceSet h = new DiceSet(5, 4);
	  DiceSet i = new DiceSet(5, 4);
	  System.out.println();
	  System.out.println(h + "     H (5 die, 4 sides)");
	  System.out.println(i + "     I (5 die, 4 sides)");
	  System.out.println("Testing isIdentical: " + h.isIdentical(i));
	}
}