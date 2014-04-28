//trying to remember how to write classes
public class Panda{

    private int xcord;
    private int ycord;
    //anything else we need

    public Panda(){
	//temporary until we start coding game
	xcord=0;
	ycord=0;
    }

    //this is just me guessing what methods we'll use
    public list getLocation(){
	int[] loc = new int[]{xcord,ycord};
	return loc;
    }

    //panda enters new map, restore beginning position
    public void newMap(int[] newloc){
	xcord = newloc[0];
	ycord = newloc[1];
    }

    public void moveUp(){
	ycord += 10;
    }

    public void moveDown(){
	ycord -= 10;
    }

    public void moveForward(){
	xcord++;
    }

}

    
