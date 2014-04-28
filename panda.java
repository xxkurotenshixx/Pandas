//trying to remember how to write classes
public class Panda{

    private int xcor;
    private int ycor;
    //anything else we need

    public Panda(){
	//temporary until we start coding game
	xcor=0;
	ycor=0;
    }

    //this is just me guessing what methods we'll use
    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    }

    //panda enters new map, restore beginning position
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

    
