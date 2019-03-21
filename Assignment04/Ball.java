import java.util.*;
import java.lang.*;
public class Ball {

	double xPosition;
	double yPosition;
	double xVelocity;
	double yVelocity;
	static double currentSpeed[] = new double[2];
	static double currentPosition[] = new double[2];
	boolean isInBounds;
	
	public Ball(double xPos, double yPos, double xVel, double yVel) {
		xPosition = xPos; yPosition = yPos;
		xVelocity = xVel; yVelocity = yVel;
		isInBounds = true;
	}
	
	public double[] getCurrentSpeed() {
		currentSpeed[0] = xVelocity;
		currentSpeed[1] = yVelocity;
		return currentSpeed;
	}
	
	public double getCurrentXPosition() {
		return xPosition;
	}
	
	public double getCurrentYPosition() {
		return yPosition;
	}
	
	public double[] getCurrentPosition() {
		currentPosition[0] = xPosition;
		currentPosition[1] = yPosition;
		return currentPosition;
	}
	
	public boolean isNotMoving() {
		if (Math.abs(xVelocity)*12.0 <= 1.0 && Math.abs(yVelocity)*12.0 <= 1.0)
		{ return true; }
		return false;
	}
	
	public boolean setBallOutOfBounds (int fieldWidth, int fieldHeight) {
		if (xPosition >= fieldWidth/2 || yPosition >= fieldHeight/2 || xPosition <= (-fieldWidth/2) || yPosition <= (-fieldHeight/2))
		{ isInBounds = false; xVelocity = 0.0; yVelocity = 0.0; return false; }
		return true;
	}
	
	public double updateXSpeed(double timeslice) {
		xVelocity *= Math.pow(0.99,timeslice);
		return xVelocity;
	}
	
	public double updateYSpeed(double timeslice) {
		yVelocity *= Math.pow(0.99,timeslice);
		return yVelocity;
	}	
	
	public void move(double timeslice) {
		xPosition += updateXSpeed(timeslice);
		yPosition += updateYSpeed(timeslice);
	}
	
	public String toString() {
		return ("Position: " + Arrays.toString(getCurrentPosition()) + "\nSpeed: " + Arrays.toString(getCurrentSpeed()) + "\nAt Rest? " + isNotMoving() + "\nIn Bounds? " + setBallOutOfBounds(1000,1000));
	}
	
	public static void main( String args[]) {
		System.out.println("\nCreating new ball: Ball 1");
		Ball b1 = new Ball(0,0,250,-100);
		System.out.println(b1);
		System.out.println("\nTesting move() on Ball 1");
		b1.move(1);
		System.out.println(b1);
		System.out.println("\nTesting move() on Ball 1");
		b1.move(1);
		System.out.println(b1);
		System.out.println("\nTesting move() on Ball 1");
		b1.move(1);
		System.out.println(b1);

	}
}
