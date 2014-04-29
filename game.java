import java.awt.event

public class Game{

    private Panda myPanda;
    private int score;
    private Map myMap;

    //probably should figure out how to select a maze from the presets
    public Game(){
	myPanda = new Panda();
	score = 0;
	myMap = new Map();
    }

    //something pipes, coordinates, panda
    private boolean isPandaDead(){
	n = myMap.getPipes().length;
	for (int i = 0; i < n; i++){
	    p = myMap.getPipes()[i];
	    if (p.getX() == myPanda.getX()){
		if (p.getY() < 0){
		    if (myPanda.getY() > p.getY())
			return true;
		}
		else if (myPanda.getY() < p.getY())
		    return true;
	    }
	}
	return false;
    }

    private boolean swipeUp(){
	myPanda.moveUp();
	return true;
    }

    private boolean swipeDown(){
	myPanda.moveDown();
	return true;
    }


    public void play(){
	e = mouseClick();
	while (myPanda.getLocation < map.getLength){
	    score++;
	    myPanda.moveForward();
	    if (isPandaDead())
		break;
	    //if user tells bird to go somewhere
	    if (e){
		if (e.getYOnScreen < myMap.getHeight())
		    swipeUp();
		else
		    swipeDown();
	    }
	}
	System.out.println(score);
	
    }
    


}
