import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 */

/**
 * @author 928018
 * Draws Icons.
 * Inherits from Picture
 */
public class ImagePicture extends Picture {

private int bounceCount;
/*
*  private data for ImagePicture
*/

private ImageIcon image;

/**
* Constructor for image only  
*/
public ImagePicture(ImageIcon img) {
super(); // calls Picture default constructor
this.image = img;
setMyWidth(img.getIconWidth());
setMyHeight(img.getIconHeight());
repaint();
}

// overloaded constructor to specify the location
public ImagePicture (ImageIcon img, int x, int y) {
super(x, y, img.getIconWidth(), img.getIconHeight());
this.image = img;
repaint();
}


// override the paint from picture

public void paint (Graphics g) {
this.image.paintIcon(this, g, getxPos(), getyPos());
}

public void setImage(ImageIcon x) {
	this.image = x;
    repaint();
} 
/**
* @param args
* Self-Testing main
*/
public static void main(String[] args) {  
// create a frame
JFrame f = new JFrame();
ImagePicture p = new ImagePicture(new ImageIcon("bb8.png"));



f.setSize(400, 350);
f.add(p);
f.setVisible(true);


JOptionPane.showMessageDialog(null,"hey");

ImagePicture p1 = new ImagePicture(new ImageIcon("r2d2.png"), 100, 200);
f.add(p1);
f.setVisible(true);

JOptionPane.showMessageDialog(null,"hey");


 p1.setImage(new ImageIcon("c3p0.png"));
p1.setxPos(300);

}

}