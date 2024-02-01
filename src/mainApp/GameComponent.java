package mainApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComponent;

public class GameComponent extends JComponent{

    private ArrayList<CollideableObject> collideableObjects = new ArrayList<CollideableObject>();
    private ScoreRecorder scoreRecorder;
    private Background background;
    private Player player;
    GameViewer game;

    private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;


    public GameComponent(GameViewer game){
        //create objects here
        player=new Player(20, 300, 30, 40);
        collideableObjects.add(player);

        this.scoreRecorder=new ScoreRecorder();
        this.background=new Background();
        this.game=game;

    }

    public void addObjects(CollideableObject object){
        collideableObjects.add(object);
    }

    public void findGame(int level){
        String filename="Level"+level+".txt";

		try {
			loadGame(filename);
			System.out.println();
		} catch(FileNotFoundException e) {
			System.err.println("File " + filename + " not found.  Exiting.");
		} catch(IOException e) {
			System.err.println("Error closing file.");
		}
    }

    public void loadGame(String filename) throws FileNotFoundException, IOException{
        FileReader file = new FileReader(filename);
		Scanner s = new Scanner(file);

		while(s.hasNext()) {
			try {
                String check=s.next();
                if (true) {
                    
                }
                int objectIndex = s.nextInt();
                /* coin=1
                 * non eletrical barrier=2
                 * electrical barrier=3
                 * 
                 */
                switch (objectIndex) {
                    case 1:
                        
                        break;
                
                    default:
                        break;
                }
			    
				
				
			} catch (InputMismatchException e) {
				String nonNumber = s.next();
				System.err.println("Non-number " + nonNumber + " found.  Ignoring.");
			}
		}
        s.close();
		file.close();

    }

    public void levelDown(){
        scoreRecorder.levelDown();
    }
    public void levelUp(){
        scoreRecorder.levelUp();
    }






    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

        switch (game.getState()) {//draw according to state
            case START:
                drawStart(g2);
                break;
            case RUNNING:
                drawRuning(g2);
                break;
            case PAUSE:
                drawPause(g2);
                break;
            case GAME_OVER:
                drawGameOver(g2);
                break;
        
            default:
                break;
        }
        
	}



    private void drawGameOver(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawGameOver'");
    }

    private void drawPause(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawPause'");
    }

    private void drawRuning(Graphics2D g2) {
        background.drawOn(g2);

		for (CollideableObject collideableObject : collideableObjects) {
			collideableObject.drawOn(g2);
		}

        scoreRecorder.drawOn(g2);
    }

    private void drawStart(Graphics2D g2) {
        throw new UnsupportedOperationException("Unimplemented method 'drawStart'");
    }

    public void update(){
        for (CollideableObject collideableObject : collideableObjects) {
            collideableObject.update();
        }
        
    }

    public void restartGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'restartGame'");
    }

    public void playerGoUp() {
        player.goUp();
    }


    

}
