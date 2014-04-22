public class Game{

    private panda myPanda;
    private int score;
    private maze myMaze;

    //probably should figure out how to select a maze from the presets
    public Game(){
	myPanda = Panda();
	score = 0;
	myMaze = maze();
    }

    //something pipes, cordinates, panda
    private boolean isPandaDead(){
	return false;
    }

    public void play(){
	while (myPanda.getLocation < map.getLength){
	    score++;
	    if (isPandaDead())
		break;
	}
	System.out.println(score);
	
    }
    


}
