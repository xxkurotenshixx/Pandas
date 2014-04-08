public class Game{

    private panda myPanda;
    private int score;

    public Game(){
	myPanda = Panda();
	score = 0;
    }



    public void play(){
	while (myPanda.getLocation < map.getLength){
	    score++;
	    if (myPanda.isDead())
		break;
	}
	System.out.println(score);
	
    }
    


}