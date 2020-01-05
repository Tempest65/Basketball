import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.Label;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;




public class BasketballGUI extends JFrame implements ActionListener {
	//declare private variables
	private JPanel drawingPanel;
	private JPanel controlPanel;
	private JButton btnShoot;
	private MediaPlayer mediaPlayer;
	private Ball x,y,z;
	private int xPos,yPos=400,xVel,yVel,max;
	private Timer timer;
	private int width;
	private int height;
	private Die d1,d2,d3,d4;
	private Border blackline, raisedetched, loweredetched,raisedbevel, loweredbevel, empty;
	private int counter = 0;
	private JLabel organic;
	private JLabel trash;
	private int turnCounter  = 0;
	private JSpinner spinner;
	private JLabel lblNewLabel;
	private JLabel lblPowerControl;
	private JSpinner spinner2;
	double horDis = 0;
	double horVel = 0;
	double verVel = 0;
	double verDis = 0;
	double radAngle = 0;
	final int time = 2;
	boolean fix = true;
	final int Distance = 10;	
	private JButton Restart;
	private JButton Exit;
	private JLabel lblScore;
	private int score =0;

	/**
	 * Creates a new instance of AnimationExample.
	 */
	public BasketballGUI() {
		super("Recycle Basketball");
		getContentPane().setBackground(Color.RED);
		getContentPane().setForeground(Color.RED);


		//initialize the height and width of the frame
		width = 1000;
		height = 1000;

		d3 = new Die();

		//sets layout 
		getContentPane().setLayout(null);
		drawingPanel = new JPanel();
		drawingPanel.setBackground(Color.DARK_GRAY);
		drawingPanel.setBounds(0, 40, 986, 981);

		drawingPanel.setLayout(null);

		Border compound;
		//creates components of compound border
		Border line = BorderFactory.createLineBorder(Color.BLACK);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		//This creates a neat frame
		compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

		//Adds an outline to the frame and other components.
		compound = BorderFactory.createCompoundBorder(line, compound);
		getRootPane().setBorder(compound);
		getRootPane().setBackground(Color.red);
		getRootPane().setBorder(compound);
		getContentPane().add(drawingPanel);

		JLabel recycle = new JLabel(new ImageIcon ("recycle bin.png"));
		recycle.setBounds(660, 400, 150, 184);
		drawingPanel.add(recycle);

		organic = new JLabel(new ImageIcon("organic bin.png"));
		organic.setBounds(790, 240, 200, 264);
		drawingPanel.add(organic);

		trash = new JLabel(new ImageIcon("trash.png"));
		trash.setBounds(510, 500, 150, 195);
		drawingPanel.add(trash);

		controlPanel = new JPanel();
		controlPanel.setBounds(0, 737, 990, 70);
		drawingPanel.add(controlPanel);

		
		btnShoot = new JButton("Shoot");
		btnShoot.setBounds(406, 10, 70, 23);

		

		controlPanel.setBackground(Color.WHITE);
		controlPanel.setLayout(null);
		controlPanel.add(btnShoot);
		btnShoot.setBackground(Color.red);
		btnShoot.setForeground(Color.white);
		btnShoot.setBorder(compound);
		final JFXPanel fxPanel = new JFXPanel();
		spinner = new JSpinner();
		spinner.setFont(new Font("Arial Black", Font.BOLD, 12));
		spinner.setModel(new SpinnerNumberModel(5.0, 5.0, 100.0, 5.0));
		spinner.setBounds(137, 7, 44, 32);
		controlPanel.add(spinner);

		lblNewLabel = new JLabel("Angle control:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setBounds(25, 5, 150, 37);
		controlPanel.add(lblNewLabel);

		lblPowerControl = new JLabel("Power Control:");
		lblPowerControl.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPowerControl.setBounds(194, 5, 132, 37);
		controlPanel.add(lblPowerControl);

		spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(5, 5, 60, 5));
		spinner2.setFont(new Font("Arial Black", Font.BOLD, 12));
		spinner2.setBounds(308, 7, 44, 32);
		controlPanel.add(spinner2);

		Restart = new JButton("Restart");
		Restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new BasketballGUI();
			}
		});
		Restart.setForeground(Color.WHITE);
		Restart.setBackground(Color.RED);
		Restart.setBounds(526, 10, 93, 23);
		controlPanel.add(Restart);

		Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Exit.setForeground(Color.WHITE);
		Exit.setBackground(Color.RED);
		Exit.setBounds(657, 11, 70, 23);
		controlPanel.add(Exit);

		


		x = new Ball('g',0,new ImageIcon("box.png"));
		x.setBounds(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
		x.setyPos(400);
		drawingPanel.add(x);
		
		lblScore = new JLabel("Score:");
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblScore.setBounds(471, 76, 465, 53);
		drawingPanel.add(lblScore);

		d1 = new Die(drawingPanel.getWidth() - x.getMyWidth());
		d2 = new Die(drawingPanel.getHeight() - x.getMyHeight());

		//adds action listener
		btnShoot.addActionListener(this);

		timer = new Timer(100, this);
		timer.setInitialDelay(5);
		timer.addActionListener(this);



		setSize(width, height);
		setLocation(100, 0);
		String name = "kuroko.mp3";
		Media play = new Media(new File(name).toURI().toString());
		mediaPlayer = new MediaPlayer(play);
		mediaPlayer.play();
		setVisible(true);

		setDefaultCloseOperation(3);

	}

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

		//compare the entered distance and the calculated distance
		if (calcDistance >= (Distance-10) && calcDistance<=(Distance+10)) {
			JOptionPane.showMessageDialog(null, "Congratulations! You made a basket.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Hard Luck! You almost made it.");
		}

		return calcDistance;

	}

	//methods for action performed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnShoot) {
			
			int velocity = (int) spinner2.getValue();
			double angle = (double) spinner.getValue();

			//determining the vertical velocity of the projectile
			radAngle = Math.toRadians(angle);

			verVel = (Math.sin(radAngle))*velocity;
			horVel = (Math.cos(radAngle))*velocity;

			//calculate the distance
			verDis = (Math.pow(velocity, 2)*Math.pow(Math.sin(radAngle), 2))/2*9.8;

			horDis = (Math.pow(velocity, 2)*Math.sin(2*radAngle))/9.8;
			timer.start();
			
			
		}
		else if (e.getSource() == timer) {
			xPos+= horVel;
			yPos-= verVel;
			x.setxPos(xPos);
			x.setyPos(yPos);
			
			if (x.getxPos()>horDis+200&&counter == 0) {
				verVel*=-1;
				counter++;
			}


			if(x.getxPos()>horDis+500) {	
				timer.stop();
				try {
					score();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		}
	}

	public void score() throws InterruptedException {
		System.out.println(turnCounter);
		//	basket = Shoot.distance(velocity, angle);
		if ( x.getxPos() >=horDis+450&&x.getxPos() <=horDis+550&&x.getyPos() >=400&&x.getyPos() <=450) {
			if(x.getType()=='g' ) {
			score = score + 5;
			lblScore.setText("Score: " + score);
			
			}
			else {
				score-=2;
				lblScore.setText("Incorrect Bin! -2 points, Score: " + score);
			}
			
		 }
		else if ( x.getxPos()>=550 && x.getxPos()<=700 && x.getyPos() >=300 && x.getyPos() <=370) {
			if(x.getType()=='r' ) {
				if(fix) {
			score = score + 5;
			fix = false;
				}
			
			lblScore.setText("Score: " + score);
			
			}
			else {
				score-=2;
				lblScore.setText("Incorrect Bin! -2 points, Score: " + score);
			}
			
		}
		else if ( x.getxPos() >=720&&x.getxPos() <=870&&x.getyPos() >=200&&x.getyPos() <=270) {
			if(x.getType()=='o' ) {
			score = score + 5;
			lblScore.setText("Score: " + score);
			
			}
			else {
				score-=2;
				lblScore.setText("Incorrect Bin! -2 points, Score: " + score);
				lblScore.setText("Score: " + score);
			}
			
		}
		else {
			lblScore.setText("You missed");
			score = score - 2;
		}
		if(turnCounter==3) {
			lblScore.setText("Game Over, Score:" + score);
		}
		turnCounter+=1;
		timerX.start();
		timerX.setRepeats(false);
		
	}
	Timer timerX = new Timer( 3000, new ActionListener(){
	    @Override
	    public void actionPerformed( ActionEvent e ){
	    	x.setxPos(0);
			x.setyPos(400);
			
			xPos = 0;
			yPos = 400;
			counter = 0;
			if(turnCounter==1) {
				x.setType('r');
			}
			else if(turnCounter==2||turnCounter==3) {
				x.setType('o');
			}
			else if(turnCounter==4) {
				btnShoot.setEnabled(false);
			}
			timerX.stop();
	    }} );

	//main method
	public static void main(String[] args) { 
		BasketballGUI animation = new BasketballGUI(); 
	}
}
