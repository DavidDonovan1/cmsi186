import java.lang.*;
public class Riemann {
	
	public static double percent = -1.0;
	static double upperBound = 0.0;
	static double lowerBound = 0.0;
	static int numRectangles = 1;
	static double height = 0.0;
	static double width = 0.0;	
	static double midpoint = 0.0;
	static double[] arguments = new double[0];
	static double sum = 0.0;
	static double tempSum = 0.0;
	static double originMid = 0.0;
	static double answer = 0.0;
	
	public Riemann() {
		
	}
	

	public static double poly(double args[]) {	
		sum = 0.0;
		height = 0.0;
		width = ((upperBound-lowerBound)/numRectangles);
		originMid = lowerBound + (((upperBound - lowerBound)/(numRectangles))/2);
		
		
		
		for (int j = numRectangles; j>0; j--) {
			height = 0.0;
			midpoint = originMid + ((numRectangles-j) * width);
			//System.out.println("number of rectangles: " + numRectangles);
			//System.out.println("\nNth rectangle: " + j + "\nMidpoint: " + midpoint);
			for (int i=0; i<args.length;i++) {
				height += (args[i]*Math.pow(midpoint, i));
			}
			sum += height * width;
			
		}
		
		numRectangles++;
		return sum;
	}
	
	
	public static double sin(double args[]) {
		sum = 0.0;
		height = 0.0;
		width = ((upperBound-lowerBound)/numRectangles);
		originMid = lowerBound + (((upperBound - lowerBound)/(numRectangles))/2);
		
		
		
		for (int j = numRectangles; j>0; j--) {
			height = 0.0;
			midpoint = originMid + ((numRectangles-j) * width);
			//System.out.println("number of rectangles: " + numRectangles);
			//System.out.println("\nNth rectangle: " + j + "\nMidpoint: " + midpoint);
			for (int i=0; i<args.length;i++) {
				height += (args[i]*Math.sin(midpoint));
			}
			sum += height * width;
			
		}
		
		numRectangles++;
		return sum;
	}
	
	public double log(String args[]) {
		return 0.0;
	}
	
	public double exp(String args[]) {
		return 0.0;
	}
	
	public double sqrt(String args[]) {
		return 0.0;
	}
	
	public static void parseArguments(String args[]) {
		System.out.println();
		if (args.length >= 3) {
			if (args[args.length-1].charAt(args[args.length-1].length()-1) == '%') {
				try {
					
					arguments = new double[args.length-3];
					for (int i=0; i<arguments.length;i++) {
						arguments[i] = Double.parseDouble(args[i+1]);
					}
					
					percent = Double.parseDouble(args[args.length-1].substring(0,args[args.length-1].length()-1));
					lowerBound = Double.parseDouble(args[args.length-3]);
					upperBound = Double.parseDouble(args[args.length-2]);
					System.out.println("Using bounds: [" +lowerBound + ", " + upperBound + "]\nUsing percent: " + percent);
				}	
				catch (Exception e) {
					System.out.println("Format \n Java Riemann functionName [additionalDescriptors] lowerBound upperBound [percent]");
					System.exit(0);
				}
			}
			else {
				try {
					
					arguments = new double[args.length-2];
					for (int i=0; i<arguments.length;i++) {
						arguments[i] = Double.parseDouble(args[i+1]);
					}
					
					percent = 1.0;
					lowerBound = Double.parseDouble(args[args.length-2]);
					upperBound = Double.parseDouble(args[args.length-1]);
					System.out.println("Using bounds: [" +lowerBound + ", " + upperBound + "]\nUsing default percent: " + percent);
				}	
				catch (Exception e) {
					System.out.println("Format \n Java Riemann functionName [additionalDescriptors] lowerBound upperBound [percent]");
					System.exit(0);
				}
			}
		}
		else { System.out.println("Please enter more arguments!"); System.exit(0); }
	}
	
	public static boolean goAgain() {
		if (((poly(arguments) - answer) / answer) * 100 <= percent) { return false; }
		return true;
	}
	
	public static boolean goSinAgain() {
		if (((sin(arguments) - answer) / answer) * 100 <= percent) { return false; }
		return true;
	}
	
	public static void testPoly() {
		System.out.println("\nTESTING POLYNOMIAL RIEMANN SUMS: \nUSING BOUNDS [0.0, 4.0] \nUSING PERCENT: 1.0");
		upperBound = 4.0; lowerBound = 0.0; percent = 1.0;
		System.out.println("Using polynomial 1+x+x^2\nTESTING 1 RECTANGLE");
		arguments = new double[]{1, 1, 1};
		numRectangles = 1; 
		System.out.println("\tMidpoint sum of polynomial: "+ poly(arguments));
		System.out.println("TESTING 2 RECTANGLE");
		numRectangles = 2;
		System.out.println("\tMidpoint sum of polynomial: "+ poly(arguments));
		System.out.println("TESTING 3 RECTANGLE");
		numRectangles = 3;
		System.out.println("\tMidpoint sum of polynomial: "+ poly(arguments));
	}
		
	
	public static void main(String args[]) {

		switch (args[0]) {
			case "poly":parseArguments(args);
						answer = poly(arguments); 
						while(goAgain()){
							answer = poly(arguments);
						}
						System.out.println("\nUsing " + (numRectangles-2) + " rectangles");
						System.out.println("\tMidpoint sum of polynomial: "+ answer);
						break;
			case "sin":	numRectangles = 0;
						parseArguments(args);		
						answer = sin(arguments); 
						while(goSinAgain()){
							answer = poly(arguments);
						}
						System.out.println("\nUsing " + (numRectangles-2) + " rectangles");
						System.out.println("\tMidpoint sum of polynomial: "+ answer);
						break;
			case "log":
			case "exp": 
			case "sqrt":
			case "testPoly": testPoly();
		}

	}
}
