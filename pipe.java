public class Pipe{

    Random rnd = new Random();
    private static int speed = 6;

    private int xcor;
    private int ycor;
    private Color _color;
    private int height;  

    public Pipe(){
	_color = "Green";
	xcor = 0;
	ycor = 0;
	height = 0;
    }

    public Pipe(int x, int y, int h, Color c){
	xcor = x;
	ycor = y;
	_color = "Green";
	height = h;
    }

    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    } 

    public int getHeight(){
	return height;
    }

    public string getColor(){
	return _color;
    }

    //modifier methods:
    //returns old methods

    public int setX(int x){
	int ans = _xcor;
	_xcor=x;
	return ans;
    }

    public int setY(int y){
	int ans = _ycor;
	_ycor=y;
	return ans;
    }

    public int setH(int newh){
	int ans = height;
	height = newh;
	return ans;
    }


