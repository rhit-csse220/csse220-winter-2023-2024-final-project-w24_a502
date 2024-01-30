package mainApp;

import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Graphics2D;


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
        player=new Player();
        collideableObjects.add(player);

        this.scoreRecorder=new ScoreRecorder();
        this.background=new Background();
        this.game=game;

    }

    public void addObjects(CollideableObject object){
        collideableObjects.add(object);
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

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void restartGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'restartGame'");
    }

    public void playerAction() {
        player.action();
    }

    

}
