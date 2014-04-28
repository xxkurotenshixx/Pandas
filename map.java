public class Map{
    
    private int dist;
    private pipes[] pipes;

    public Map(){
	dist = 0;
	//should probably take a set pipe maze from game in Map
	pipes = [];
    }

    public int getDistance(){
	return dist;
    }

    public void addPipe(int x, int y, int h, Color c){
	pipes.add(new Pipe(x, y, h, c));
    }

    public int getPipes(){
	return pipes.length;
    }



}
