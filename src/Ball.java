import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ball extends ImagePicture {
	private char type;
	private int velocity;
	private double angle;
	


	private Die d;
	
	public Ball(char type,int velocity,ImageIcon img) {
		super(img);
		this.type = type;
		this.velocity = velocity;
		d = new Die(3);
		if(type == 'g') {
			if(d.getValue()==1)
				this.setImage(new ImageIcon("Lays wrapper.png"));
			else if (d.getValue()==2)
				this.setImage(new ImageIcon("Spoons.png"));
			else
				this.setImage(new ImageIcon("Wrapper Food.png"));
		}
		else if(type == 'o') {
			if(d.getValue()==1)
				this.setImage(new ImageIcon("Apple.png"));
			else if (d.getValue()==2)
				this.setImage(new ImageIcon("Banana.png"));
			else
				this.setImage(new ImageIcon("coffee.png"));
		}
		else if(type == 'r') {
			if(d.getValue()==1)
				this.setImage(new ImageIcon("can.png"));
			else if (d.getValue()==2)
				this.setImage(new ImageIcon("box.png"));
			else
				this.setImage(new ImageIcon("Redbull.png"));
		}
		repaint();
	}
	
	 public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
		d = new Die(3);
		if(type == 'g') {
			if(d.getValue()==1)
				this.setImage(new ImageIcon("Lays wrapper.png"));
			else if (d.getValue()==2)
				this.setImage(new ImageIcon("Spoons.png"));
			else
				this.setImage(new ImageIcon("Wrapper Food.png"));
		}
		else if(type == 'o') {
			if(d.getValue()==1)
				this.setImage(new ImageIcon("Apple.png"));
			else if (d.getValue()==2)
				this.setImage(new ImageIcon("Banana.png"));
			else
				this.setImage(new ImageIcon("coffee.png"));
		}
		else if(type == 'r') {
			if(d.getValue()==1)
				this.setImage(new ImageIcon("can.png"));
			else if (d.getValue()==2)
				this.setImage(new ImageIcon("box.png"));
			else
				this.setImage(new ImageIcon("Redbull.png"));
		}
		repaint();
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	
	public static void main(String[] args) { 
		Die d = new Die(3);
		d.rollDie();
		System.out.println(d.getValue());
		Frame f = new JFrame();
		f.setSize(400, 350);
		Ball x = new Ball('g',0,new ImageIcon("box.png"));
		f.add(x);
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "wait");
		x.setxPos(200);
	}
	

}
