package mainApp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;
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
	
	private static final int DELAY = 1000 / 100; // time interval (ms)

	private static GameComponent gameComponet;

	
	private void runApp() {

		

		Timer t = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				handleGenerateObjects();
				handleCheckGameOver();

				gameComponet.update();
				gameComponet.repaint();
			}
		});
		
		//Starts the simulator
		t.start();


	} // runApp

	protected void handleGenerateObjects() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'handleGenerateObjects'");
	}

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
		frame.add(gameComponet, BorderLayout.CENTER);

		frame.setVisible(true); // 

		game.runApp(); // start game	
	} // main

}