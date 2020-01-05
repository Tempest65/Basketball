import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SmartMinion extends ImagePicture {
	private int stepsCount;

	//default constructor
	public SmartMinion(ImageIcon img) {
		super(img);
		repaint();
		// TODO Auto-generated constructor stub
	}



	//overloaded constructor
	public SmartMinion(ImageIcon img, int x, int y) {
		super(img, x, y);
		repaint();
	}

	public int getStepsCount() { 
		return this.stepsCount; 
	}

	public void setStepsCount(int stepsCount) { 
		this.stepsCount = stepsCount; 
	}

	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartMinion m = new SmartMinion(new ImageIcon("minion.png"));
		JFrame f = new JFrame();
		
		f.setSize(400, 350);
		f.add(m);
		f.setVisible(true);
		m.setStepsCount(0);
		JOptionPane.showMessageDialog(null, "wait");
		System.out.println(m.getStepsCount());
		m.setStepsCount(m.getStepsCount()+500);
		System.out.println(m.getStepsCount());
		m.setStepsCount(m.getStepsCount()+1000);
		System.out.println(m.getStepsCount());
		m.setxPos(300);
	}

}
