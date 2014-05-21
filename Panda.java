import javax.swing.*;

public class Panda{

    private int xcor;
    private int ycor;
    //xcor and ycor indicate top left corner of panda shape

    public Panda(){
	//temporary until we start coding game
	xcor=0;
	ycor=0;
    }

    public int getX(){
	return xcor;
    }
    public int getY(){
	return ycor;
    }
    public boolean setX(int x){
	xcor=x;
	return true;
    }
    public boolean setY(int y){
	ycor=y;
	return true;
    }

    //panda resets its original position because it is starting a new game at a new map
    public void newMap(int[] newloc){
	xcor = newloc[0];
	ycor = newloc[1];
    }

    public void moveUp(){
	ycor += 10;
    }

    public void moveDown(){
	ycor -= 10;
    }

    public void moveForward(){
	xcor++;
    }

}

    
