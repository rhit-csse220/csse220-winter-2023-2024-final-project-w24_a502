package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int ceiling =0;
	private static int time=1;
	private static final int MAX_SPEED=30;
	public static final int WIDTH = 1280; // 
	public static final int HEIGHT = 720; // 

	private static int state;
	private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;
	

	private static final int DELAY = 1000 /100; // time interval (ms)
	private static final double MIDPOINT = 10000;
	private static final double GROWTH = 1/10000.0;

	private static GameComponent gameComponet;
	

	
	private void runApp() {
		Timer t = new Timer(DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			
				//handleCheckGameOver();
				time++;
				if(gameComponet.update()){
					state=GAME_OVER;
					
				}
				gameComponet.repaint();
				
			}
		});
		
		//Starts the simulator
		
		this.setFocusable(true);
		this.requestFocusInWindow(); 
		state=START;
		t.stop();

		KeyListener key = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				switch (state) {
					case START: //start game
						if (e.getKeyCode()==32) {
							state = RUNNING; // 
							t.start();time=0;
							System.out.println("Game Start");
							try {
								gameComponet.loadLevel(ScoreRecorder.getLevel());
							} catch (InvalidLevelFormatException e1) {
								System.err.println(e1.getMessage()+" Skipped");;
						}
						}
						
						break;
					case GAME_OVER: //reset all and start a new game
						gameComponet.restartGame(true);
						state = START;
						gameComponet.repaint();
						
						t.stop();time=0;
						System.out.println("New Game");
						break;
					case PAUSE://continue the game
						state = RUNNING;
					 	t.start();
						System.out.println("Game Continue");
						break;
					case RUNNING:
						if (e.getKeyCode()==80 ) {//'P'=80
							state=PAUSE;
							gameComponet.repaint();
							t.stop();

						}else if (e.getKeyCode()==38) {//UP=38
							gameComponet.levelUp();
							gameComponet.restartGame(false);
							state=START;
							t.stop();time=0;
							gameComponet.repaint();
						}else if (e.getKeyCode()==40) {//Down=40
							gameComponet.levelDown();
							gameComponet.restartGame(false);
							state=START;
							t.stop();time=0;
							gameComponet.repaint();
						}else if (e.getKeyCode()==32) {//Spacebar=32
							gameComponet.changeIsFlying(true);
							
						}
			
						break;
					default://will not use if there is no error
						System.out.println("state wrong!");
						state=START;
				}
				

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==32) {//Spacebar=32
					gameComponet.changeIsFlying(false);
				}
			}
			
		};
		this.addKeyListener(key);
		
		


	} // runApp

	public static int getState() {
		return state;
	}
	public static double getGameSpeed() {
	//	System.out.println("time   "+time+" speed "+GROWTH +"   "+(-(MAX_SPEED)*(1/(1+Math.pow(Math.E,(-(GROWTH)*(time-MIDPOINT)))))+" power  "+1+Math.pow(Math.E,(-(GROWTH)*(time-MIDPOINT)))));
		return -10-ScoreRecorder.distance*0.001;
	}
	// public static double getDistance() {
	// 	return -3*time-(MAX_SPEED-3)*Math.log((1+Math.pow(Math.E,(-(GROWTH)*(time-MIDPOINT)))))+(MAX_SPEED-3)*Math.log((1+Math.pow(Math.E,(-(GROWTH)*(0-MIDPOINT)))));
	// }
	public static int getFloor() {
		return HEIGHT;
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

	public static int getCeiling() {
		// TODO Auto-generated method stub
		return ceiling;
	}
	public static int random(int upperBound) {
		Random rand = new Random();
		return rand.nextInt(upperBound);
	}

	public static Integer getTime() {
		return time;
	}

	public static void setTime() {
		time=-200;
	}

}