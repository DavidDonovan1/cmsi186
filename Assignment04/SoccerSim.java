import java.util.*;
import java.lang.*;
public class SoccerSim {
	
	public static int arguments = 0;
	public static double timeslice = 1.0;
	public static Clock clock = new Clock();
	
	public SoccerSim() {
	//maybe needs args and functionality	
	}
	
	public static void Simulation(Ball[] Balls) {
		
		System.out.println("\n\nSTARTING SIMULATION");
		System.out.println("\nCreating new Clock with timeslice " + timeslice + " . . . ");
		clock.setTimeSlice(timeslice);
		System.out.println("Done");
		
		System.out.println("\nMOVING BALLS UNTIL COLLISION DETECTED OR BALLS HAVE STOPPED");

		while (ballMoving(Balls) ) {
			clock.tick();
			System.out.println("SECONDS PASSED: " + clock.getTotalSeconds());
			for (int i=0; i<Balls.length; i++) {
				Balls[i].move(timeslice);
				System.out.println("\n" + Balls[i]);
			}
			if (collisionDetected(Balls)) {
				break;
			}
			System.out.println();
		}
		System.out.println("\nDone\n\n\n");

	}
	
	public static boolean collisionDetected(Ball[] Balls) {
		for (int i=0; i<Balls.length; i++) {
			for (int p=0; p<Balls.length; p++) {
				if (i != p) 	{
					if (Math.sqrt(Math.pow((Balls[p].getCurrentXPosition()-Balls[i].getCurrentXPosition()),2) + Math.pow((Balls[p].getCurrentYPosition()-Balls[i].getCurrentYPosition()),2)) <= 9.0) {
						System.out.println("\n\nCOLLISION DETECTED\n");
						System.out.println("Balls " + (i+1) + " and " + (p+1) + " collided at " + Arrays.toString(Balls[i].getCurrentPosition()) + " at time " + clock.getTotalSeconds() + " seconds!");
						System.out.println("\n"+Balls[i]);
						System.out.println("\n"+Balls[p]);
						System.out.println("\nDistance between Balls " + (i+1) + " and " + (p+1) + ": " +Math.sqrt(Math.pow((Balls[p].getCurrentXPosition()-Balls[i].getCurrentXPosition()),2) + Math.pow((Balls[p].getCurrentYPosition()-Balls[i].getCurrentYPosition()),2)));
						return true;
					}
				}
			}
		}
		return false;	
	}
	
	public static boolean ballMoving(Ball[] Balls) {
		for (int i=0; i<Balls.length; i++) {
			if (Balls[i].isNotMoving())
			{ System.out.println("\n\nBall " + (i+1) + " went out of bounds!\n\n");
				return false; }
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
			try { timeslice = Math.abs(Double.parseDouble(args[args.length-((args.length%4))]));
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
	