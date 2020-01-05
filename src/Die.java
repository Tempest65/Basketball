import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Sarthak Singh
 * Date: October 1, 2019 
 * Description: This class represents a regular play die 
 * 
 *
 */
public class Die {
	/**
	 * The attributes or data of my class 
	 */
	private int faces; 
	private int value;



	/**
	 * This is the default constructor of my class 
	 */
	public Die() {
		this.faces = 6; 
		rollDie();
	}

	//method that checks if 2 die values are the same
	public boolean compare(Die d) {
		int value1 = d.getValue();
		int value2 = this.getValue();
		if(value1==value2) 
			return true;
		else 
			return false;		
	}
	/*
	 * overloaded constructor
	 */
	public Die(int faces) {
		this.faces = faces;
		rollDie();
	}





	/**
	 * Instance methods or behavior  
	 */
	public void rollDie() {
		this.value = (int) (Math.random()*this.faces + 1);
	}

	public int getValue () {
		return this.value;
	}

	
	/**
	 * @param args
	 * Self-testing main method 
	 */
	public static void main(String[] args) {
		// declare and create a die object


		//self-testing
		Die d1,d2,d3,d4;


		d1 = new Die(12);

		System.out.println(d1.getValue());

		d2 = new Die();
		d3 = new Die();
		d4 = new Die();
		System.out.println(d2.getValue());
		if(d3.compare(d4)==false)System.out.println("Die values are not equal");

		do {
			d3.rollDie();
			d4.rollDie();
			if(d3.compare(d4)==true) System.out.println("Die values are equal");
		}while(d3.compare(d4)==false);


	}

}
