import java.util.ArrayList;

public class Map{
    
    private int dist, height;
    private ArrayList pipes;

    public Map(){
	dist = 0;
	//should probably take a set pipe maze from game in Map
	pipes = new ArrayList();
	height = 100;
    }

    public int getHeight(){
	return height;
    }

    public int getDistance(){
	return dist;
    }

    public void addPipe(int x, int y, int h){
	pipes.add(new Pipe(x, y, h));
    }

    public ArrayList getPipes(){
	return pipes;
    }
    public int getPipesLen(){
	return pipes.size();
    }
    public Pipe retPipe(int i){
	return pipes.get(i);
    }
}
