import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import java.lang.Math.*;

public class Pipe{
    //we are doing spacing between the bars instead of two separate bars -cx
    private static int speed = 6; //scrolling speed
    private static int width = 40; //width of the pipes are static 
    private static int gap = 25; //gap between pipes are constant
    private int xcor;
    private int ycor;
    //private Color _color;
    private int height;  


    public Pipe(){
	//_color = "Green";
	xcor = 0;
	ycor = (int)(Math.random() * (height - 400)) + 200;;
	height = 0;
    }

    public Pipe(int x, int y, int h){
	xcor = x;
	ycor = y;
	//_color = "Green";
	height = h;
    }

    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    }

    public int getHeight(){
	return height;
    }

    //modifier methods:
    //returns old methods

    public int setX(int x){
	int ans = xcor;
	xcor=x;
	return ans;
    }

    public int setY(int y){
	int ans = ycor;
	ycor=y;
	return ans;
    }

    public int setH(int newh){
	int ans = height;
	height = newh;
	return ans;
    }

    //sourcehelp:
    //sample code from flappybird walls
    // https://gist.github.com/anonymous/8900751
    
  
    int GAP = 200; //gap size (also a constant)
    //procures the Wall image from Imgur
    static BufferedImage img = null;{
	try {
	    img = ImageIO.read(new URL("http://i.imgur.com/4SUsUuc.png"));
	} catch (IOException e) {
	    System.out.println("WRONG WALL"); //prints "WRONG WALL" if there's trouble with Imgur
	}}
 
    //draws the wall
    public void paint(Graphics g){
	g.drawImage(img, xcor, ycor, null); //top part
	g.drawImage(img, xcor, height + ( ycor - GAP), null); //bottom part
    }
}