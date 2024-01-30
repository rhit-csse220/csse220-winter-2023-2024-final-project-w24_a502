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


    public GameComponent(){
        //create objects here
        player=new Player();
        collideableObjects.add(player);

        this.scoreRecorder=new ScoreRecorder();
        this.background=new Background();

    }

    public void addObjects(CollideableObject object){
        collideableObjects.add(object);
    }


    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        background.drawOn(g2);

		for (CollideableObject collideableObject : collideableObjects) {
			collideableObject.drawOn(g2);
		}

        scoreRecorder.drawOn(g2);
        
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
