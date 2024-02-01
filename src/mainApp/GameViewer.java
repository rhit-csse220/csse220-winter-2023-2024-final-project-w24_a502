package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
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
	private static int speed=1;
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

		state=START;
		

		KeyListener key = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()=='p'&&state==RUNNING) {
					state=PAUSE;//pause if 'p' pressed
					System.out.println("Game Paused");
				}else{
					switch (state) {
						case START: //start game
							state = RUNNING; // 
							System.out.println("Game Start");
							break;
						case GAME_OVER: //reset all and start a new game
							gameComponet.restartGame();
							state = RUNNING;
							System.out.println("New Game");
							break;
						case PAUSE://continue the game
							state = RUNNING;
							System.out.println("Game Continue");
							break;
						case RUNNING:
							gameComponet.playerAction();
							break;
						default://will not use if there is no error
							System.out.println("state wrong!");
							state=START;
					}
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				}
			
		};
		this.addKeyListener(key);
		Timer t = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				handleGenerateObjects();
				handleCheckGameOver();
				speed++;
				gameComponet.update();
				gameComponet.repaint();
			}
		});
		
		//Starts the simulator
		t.start();


	} // runApp

	public int getState() {
		return state;
	}
	public static int getGameSpeed() {
		return speed;
	}
	public static int getFloor() {
		return HEIGHT;
	}
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

		gameComponet=new GameComponent(game);
		frame.add(gameComponet, BorderLayout.CENTER);

		frame.setVisible(true); // 

		game.runApp(); // start game	
	} // main

}