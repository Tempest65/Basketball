import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 */

/**
 * @author sarthak Singh    
 * Description: It represents Picture Objects
 */
public class Picture extends JComponent {
/*
 * Private Instance data
 */
private Color c;
private int xPos, yPos, myWidth, myHeight;

/**
* The default constructor
*/
public Picture() {
//Initialize data for a basic picture
this.c = Color.RED;
this.xPos = 0;
this.yPos = 0;
this.myWidth = 50;
this.myHeight = 25;
repaint();
}

// overloaded constructor to specify position and size
public Picture (int x, int y, int w, int h) {
this.c = Color.RED;
this.xPos = x;
this.yPos = y;
this.myWidth = w;
this.myHeight = h;
repaint();
}



// paint method
public void paint(Graphics g) {
g.setColor(this.c);
g.drawRect(this.xPos + 100, this.yPos + 110, this.myWidth + 150, this.myHeight + 25);
g.drawOval(this.xPos + 100, this.yPos + 110, this.myWidth + 150, this.myHeight + 25);
g.fillOval(this.xPos + 175, this.yPos + 110, this.myWidth, this.myHeight + 25);

}

// getters and setters
public Color getC() {
return c;
}

// setter for color
public void setC(Color c) {
this.c = c;
}

// overloaded setC
public void setC(int r, int g, int b) {
this.c = new Color(r, g, b);
}

public int getxPos() {
return xPos;
}

public void setxPos(int xPos) {
this.xPos = xPos;
repaint();
}

public int getyPos() {
return yPos;
}

public void setyPos(int yPos) {
this.yPos = yPos;
repaint();
}

public int getMyWidth() {
return myWidth;
}

public void setMyWidth(int myWidth) {
this.myWidth = myWidth;
}

public int getMyHeight() {
return myHeight;
}

public void setMyHeight(int myHeight) {
this.myHeight = myHeight;
}

/**
* @param args
* self-testing main
*/
public static void main(String[] args) {

JFrame f = new JFrame("Testing Frame");

// create picture object
Picture p = new Picture();

f.setSize(800, 500);
f.add(p);   // add my object to the frame
f.setVisible(true);

//create a picture at a specified position and size
Picture p1  = new Picture (200, 50, 100, 50);
f.add(p1);
f.setVisible(true);

JOptionPane.showMessageDialog(null, "Wait");

p.setC(Color.BLUE);
p.repaint();

JOptionPane.showMessageDialog(null, "Wait");
p.setxPos(250);
p.repaint();

JOptionPane.showMessageDialog(null, "Wait");
int y = p1.getyPos();
y = y * 2;
p1.setyPos(y);
p1.repaint();

JOptionPane.showMessageDialog(null, "Wait");
p1.setC(245, 156, 255);
p1.repaint();

}

}