import java.awt.event.*;
import javax.swing.*;

public class Game{

    private Panda myPanda;
    private int score;
    private Map myMap;

    //initialize game components
    public Game(){
	myPanda = new Panda();
	score = 0;
	myMap = new Map();
    }

    //if panda is within pipe opening (pipe rectangle), then panda is alive
    //this function needs to be fixed
    private boolean isPandaDead(){
	int n = myMap.getPipesLen();
	for (int i = 0; i < n; i++){
	    Pipe p = myMap.getPipe(i);
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

    //move panda up
    private boolean swipeUp(){
	return myPanda.setY(50);
    }

    //move panda down
    private boolean swipeDown(){
	return myPanda.setY(50);
    }

    //start playing game
    public void play(){

	//while panda is travelling within map
	while (myPanda.getX() < myMap.getDistance()){
	    //as panda moves right, score goes up
	    score++;
	    myPanda.moveForward();
	    if (isPandaDead())
		break;
	    //mouse events swipeUp and swipeDown should go here
	    /*
	    if (e){
		if (e.getYOnScreen < myMap.getHeight())
		    swipeUp();
		else
		    swipeDown();
	    }
	    */
	}
	//at the end, some indication of what score is given
	System.out.println(score);
	
    }


    //I have no idea what everything below this comment is. Swing experimentation?
 private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public void SwingControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      SwingControlDemo swingControlDemo = new SwingControlDemo();  
      swingControlDemo.showEventDemo();       
   }
      
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        

      statusLabel.setSize(350,100);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showEventDemo(){
      headerLabel.setText("Control in action: Button"); 

      JButton okButton = new JButton("OK");
      JButton submitButton = new JButton("Submit");
      JButton cancelButton = new JButton("Cancel");

      okButton.setActionCommand("OK");
      submitButton.setActionCommand("Submit");
      cancelButton.setActionCommand("Cancel");

      okButton.addActionListener(new ButtonClickListener()); 
      submitButton.addActionListener(new ButtonClickListener()); 
      cancelButton.addActionListener(new ButtonClickListener()); 

      controlPanel.add(okButton);
      controlPanel.add(submitButton);
      controlPanel.add(cancelButton);       

      mainFrame.setVisible(true);  
   }

   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         if( command.equals( "OK" ))  {
            statusLabel.setText("Ok Button clicked.");
         }
         else if( command.equals( "Submit" ) )  {
            statusLabel.setText("Submit Button clicked."); 
         }
         else  {
            statusLabel.setText("Cancel Button clicked.");
         }  	
      }		
   }

}
