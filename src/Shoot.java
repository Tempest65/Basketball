import javax.swing.*;

public class Shoot {
	
	
	public static double distance(int velocity, double angle){
		//variables for distance, time (constant) and velocity
		double calcDistance = 0;
		double radAngle = 0;
		double horVel = 0;
		final int time = 2;
		final int Distance = 10;	
				
		//determining the vertical velocity of the projectile
			radAngle = Math.toRadians(angle);
			
			horVel = (Math.cos(radAngle))*velocity;
				
		//calculate the distance
			calcDistance = Math.round(horVel*time);
				
		
			
			return calcDistance;
			
	}

	
	
	//main method
		public static void main(String[] args) { 

		}
}
