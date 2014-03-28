//trying to remember how to write classes
public class Panda{

    private int xcord;
    private int ycord;
    //anything else we need
    //are we putting scores here or making a user in the main?

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

    public void move(int[] newloc){
	xcord = newloc[0];
	ycord = newloc[1];
    }

    //forgot whether it would be better to code this here or in the game file
    public boolean isDead(){
	return true;
    }

    
