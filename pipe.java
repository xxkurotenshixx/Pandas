public class Pipe{

    private int xcor;
    private int ycor;
    //I was thinking we could do negative height for pipes dropping down from the ceiling or something
    private int height;

    public Pipe(){
	xcor = 0;
	ycor = 0;
	height = 0;
    }

    public Pipe(x,y,h){
	xcor = x;
	ycor = y;
	height = h;
    }

    public int[] getLoc(){
	return [xcor,ycor];
    }

    public int getHeight(){
	return height;
    }

}
