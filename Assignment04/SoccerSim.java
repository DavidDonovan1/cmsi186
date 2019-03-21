public class SoccerSim {
	
	public static int arguments = 0;
	public static double timeslice = 1.0;
	
	public SoccerSim() {
	//maybe needs args and functionality	
	}
	
	public static void Simulation(Ball[] Balls) {
		//for each ball move them unil no balls are moving
		
		//tick - move - ball.isStillMoving()
		
		//while(ballMoving(Balls)) {}
			
		
	}
	
	public static boolean ballMoving(Ball[] Balls) {
		for (int i=0; i<Balls.length; i++) {
			if (!Balls[i].isStillMoving())
			{ return false; }
		}
		return true;
	}
	
	
	public static void main(String args[]) {
		if ( args.length < 4 ) { 
			System.out.println("Not Enough Arguments\n");
			System.exit(0);
		}
		
		//CREATING THE BALLS
		Ball[] Balls = new Ball[(int) args.length/4];
		System.out.println("\n\n\nCreatingCreating " + Balls.length + " balls on a 1000x1000 square foot field . . .");
		for (int i=0; i<Balls.length; i++) {
			try {Balls[i] = new Ball(Double.parseDouble(args[arguments]),Double.parseDouble(args[arguments+1]),Double.parseDouble(args[arguments+2]),Double.parseDouble(args[arguments+3]));}
			catch (Exception e) {System.out.println("\nEnter a multiple of 4 numbers followed by a timeslice!"); System.exit(0);}
			arguments += 4;
		}
		System.out.println("Done\n");
		for (int q=0; q<Balls.length; q++) {
			System.out.println("\nBall " + (q+1) + ": " + Balls[q]);
		}
		
		//LOOKING FOR TIMESLICE
		System.out.println("");
		if (args.length% 4 != 0) {
			if (args.length %4 > 1) {
				for (int p=0; p<(args.length%4)-1; p++) {
					System.out.println("Ignoring argument at SoccerSim " + (args.length - p) + ": " + args[args.length - p - 1]);
				}
			}
			try { timeslice = Double.parseDouble(args[args.length-((args.length%4))]);
			System.out.println("\nUsing Timeslice value at SoccerSim " + (args.length - (args.length%4 -1)) + ": " + args[args.length-((args.length%4))]); }
			catch (Exception e) { System.out.println("\nInvalid timeslice \nUsing default timeslice value of 1.0 Seconds"); }

		}
		else {
			System.out.println("\n Using default timeslice value of 1.0 second(s)");
		}
		
		
		
		System.out.println("\n\n\nTesting ballMoving");
		System.out.println(ballMoving(Balls));
		
		//START MOVING
		Simulation(Balls);
	}
}
	