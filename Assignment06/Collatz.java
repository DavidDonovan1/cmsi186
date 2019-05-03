public class Collatz {
	
	public static final BrobInt ZERO = new BrobInt("0");
	public static final BrobInt ONE = new BrobInt("1");
	public static final BrobInt TWO = new BrobInt("2");
	public static final BrobInt THREE = new BrobInt("3");
	
	public BrobInt result = new BrobInt("0");
	public BrobInt iterations = ONE;
	
	public Collatz(BrobInt value) {
		this.result = value;
		while( this.result.compareTo(ONE) != 0) {
			//System.out.println(this.result.remainder(TWO).equals(ONE) ? "ODD" : "EVEN");
			if (this.result.remainder(TWO).equals(ONE)) { 
				//System.out.print("3("+result.toString()+") + 1 = ");
				this.result = this.result.multiply(THREE);
				this.result = this.result.add(ONE);
				//System.out.print(result.toString() + "\n");
			}
			else {
				//System.out.print(this.result.toString() + "/2 =");
				this.result = this.result.divide(TWO);
				//System.out.println(this.result.toString());
			}
			this.iterations = this.iterations.add(ONE);
		}
		System.out.println("\tIt took " + this.iterations.toString() + " iterations to sequence " + value.toString() + " to one.");
		
	}
	
	public static void main(String args[]) {
		try { BrobInt value = new BrobInt(args[0]); System.out.println("\nStarting the Collatz Sequence on the starting value of " + args[0]); Collatz sequence = new Collatz(value);}
		catch (Exception e) { System.out.println("That is not a valid number");}
	}
}