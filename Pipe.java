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

    private static int speed = 6; //scrolling speed
    private static int width = 40; //width of the pipes are static 
    private static int gap = 25; //gap where panda can travel through is constant
    private int xcor;
    private int ycor;
    //xcor and ycor indicate top left corner of the gap


    public Pipe(){
	xcor = 0;
	ycor = (int)(Math.random() * (height - 400)) + 200;;
    }

    public Pipe(int x, int y, int g){
	xcor = x;
	ycor = y;
	gap = g;
    }

    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    }

    public int getGap(){
	return gap;
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

    public int setGap(int g){
	int ans = gap;
	gap = g;
	return ans;
    }
 
    //I have no idea what below stuff is
    /*
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
*/
}