package mainApp;

import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComponent;

public class GameComponent extends JComponent{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<CollideableObject> collideableObjects = new ArrayList<CollideableObject>();
    private ScoreRecorder scoreRecorder;
    private Background background;
    private Player player;
    GameViewer game;

    private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;


    public GameComponent(){
        //create objects here
        player=new Player(20, 300, 30, 40);
        collideableObjects.add(player);

        this.scoreRecorder=new ScoreRecorder();
        this.background=new Background();
        

    }

    public void addObjects(CollideableObject object){
        collideableObjects.add(object);
    }

    public void findLevel(int level){
        String filename="Level"+level+".txt";

		try {
			loadFile(filename);
			System.out.println();
		} catch(FileNotFoundException e) {
			System.err.println("File " + filename + " not found.  Exiting.");
		} catch(IOException e) {
			System.err.println("Error closing file.");
		}
    }

    public void loadFile(String filename) throws FileNotFoundException, IOException{
        FileReader file = new FileReader(filename);
		BufferedReader reader = new BufferedReader(file);

        String line;
        while ((line = reader.readLine()) != null) {
			loadGame(line);
		}
        reader.close();
		file.close();

    }

    private void loadGame(String line) {
        line.indexOf(',');
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'loadGame'");
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

        switch (GameViewer.getState()) {//draw according to state
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
        g2.drawString("Game Over!", 50, 50);
    }

    private void drawPause(Graphics2D g2) {
        g2.drawString("Game Paused", 50, 50);
    }

    private void drawRuning(Graphics2D g2) {
        background.drawOn(g2);

		for (CollideableObject collideableObject : collideableObjects) {
			collideableObject.drawOn(g2);
		}

        scoreRecorder.drawOn(g2);
    }

    private void drawStart(Graphics2D g2) {
        g2.drawString("Press any key to start", 50, 50);
    }

    public void update(){
        for (CollideableObject collideableObject : collideableObjects) {
            collideableObject.update();
        }
        //System.out.println("hi");
        handleGenerateObjects();
        
        
    }
    public void handleGenerateObjects() {
    	// System.out.println(GameViewer.random(20));
		if(GameViewer.random(20)==2) {
			collideableObjects.add(new Barrier(GameViewer.WIDTH+600,GameViewer.random(GameViewer.HEIGHT), GameViewer.random(200), GameViewer.random(180)-90, GameViewer.random(100)>50));
		}
		if(GameViewer.random(4)==2) {
			collideableObjects.add(new coin(GameViewer.WIDTH+600,500+GameViewer.random(GameViewer.HEIGHT), 0, 0));
		}
		collideableObjects.add(new coin(30,600, 0, 0));
		
	}

    public void restartGame() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'restartGame'");
    }

    public void playerGoUp() {
        player.goUp();
    }


    

}
