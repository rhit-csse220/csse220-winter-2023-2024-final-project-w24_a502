package mainApp;

import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class GameViewer extends JPanel {


	//

	public static final int WIDTH = 1280; // 
	public static final int HEIGHT = 720; // 

	private int state;
	private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;
	
	private Timer timer; 
	private int intervel = 1000 / 100; // time interval (ms)

	private static Component gameComponet;

	
	private void runApp() {

		timer = new Timer(); //timer
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (state == RUNNING) { //state

					handleCheckGameOver();
					
				}
				gameComponet.repaint(); // 
			}

		}, intervel, intervel);


	} // runApp

	protected void handleCheckGameOver() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'handleCheckGameOver'");
	}

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Game");
		GameViewer game = new GameViewer(); 
		frame.add(game); //add jframe
		frame.setSize(WIDTH, HEIGHT); // set size
		frame.setAlwaysOnTop(true); // set on top
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 
		frame.setLocationRelativeTo(null); // set location

		gameComponet=new GameComponent();
		frame.add(gameComponet);

		frame.setVisible(true); // 

		game.runApp() ; // start game	
	} // main

}