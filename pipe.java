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


    //sample code fro flappybird wwalls

/* Here's how this works:
*
* || || || ||
* || || --> || || --REPEAT-->
* || || || ||
* wall wall2 wall2 wall(loops back around at a different height)
*
*/
 
    public class Wall {
    
    Random rnd = new Random(); //used to generate a random height for dat gap
    int x ; //the x position of the wall, always changing (right to left)
    int y = rnd.nextInt(Game.HEIGHT - 400) + 200; //generates the y value that is the top of the bottom wall
    static int speed = - 6; //scrolling speed
    
    int WIDTH = 45; //width of a wall, it's a constant
    
    int height = Game.HEIGHT - y; //height of the wall, just the height of the window - how high the wall is
    int GAP = 200; //gap size (also a constant)
    //procures the Wall image from Imgur
    static BufferedImage img = null;{
	try {
	    img = ImageIO.read(new URL("http://i.imgur.com/4SUsUuc.png"));
	} catch (IOException e) {
	    System.out.println("WRONG WALL"); //prints "WRONG WALL" if there's trouble with Imgur
	}}
    public Wall(int i){ //allows me to differentiate the x positions of the two walls
	this.x = i;
    }
    //draws the wall
    public void paint(Graphics g){
	g.drawImage(img, x, y, null); //top part
	g.drawImage(img, x, ( -Game.HEIGHT ) + ( y - GAP), null); //bottom part
    }
    public void move(){
	x += speed; //scrolls the wall
	//These Rectanlges are used to detect collisions
	Rectangle wallBounds = new Rectangle(x, y, WIDTH, height);
	Rectangle wallBoundsTop = new Rectangle(x, 0, WIDTH, Game.HEIGHT - (height + GAP));
	//If birdman collids with a wall, he dies and the game, bird, and walls are all reset
	if ( (wallBounds.intersects(BirdMan.getBounds()) ) || (wallBoundsTop.intersects(BirdMan.getBounds()))){
	    BirdMan.reset();
	    died();
	}
	//pushes the wall back to just off screen on the right when it gets offscreen on the left (the loop)
	if (x <= 0 - WIDTH){
	    x = Game.WIDTH;
	    y = rnd.nextInt(Game.HEIGHT - 400) + 200;
	    height = Game.HEIGHT - y;
	}
    }
    
    //this is executed on death, just sets a random y value and tells Game that the bird died :(
    public void died(){
	y = rnd.nextInt(Game.HEIGHT - 400) + 200;
	height = Game.HEIGHT - y;
	Game.dead = true;