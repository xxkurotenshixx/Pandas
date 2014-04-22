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

    public void move(int[] newloc){
	xcord = newloc[0];
	ycord = newloc[1];
    }

}

    
