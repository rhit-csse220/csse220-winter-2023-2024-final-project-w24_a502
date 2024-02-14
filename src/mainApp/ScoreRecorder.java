package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;

public class ScoreRecorder {

    private int score; 
	private static int level;
    private int distance;
    private int numberCoins;

    

    
    
    public ScoreRecorder(){
        score=0;
        level=1;
        distance=0;
        numberCoins=0;
    }

    public void drawOn(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.drawString(  "score:"+score+"  "+
                        "level:"+level+"  "+
                        "distance:"+(int)(distance)+"m  "+
                        "speed: "+(int)(-GameViewer.getGameSpeed())+"   "+
                        "life: "+Player.getLife()+"  "+
                        "numberCoins:"+numberCoins+"  ", 
                        50, 20);
        
    }
    public void reset(){
        score=0;
        distance=0;
        numberCoins=0;
        level=1;
    }

    



    public void levelUp() {
        level+=1;
        if (level>5) {
            level=5;
            System.out.println("You are alreay at highest level");
        }
    }

    public void levelDown() {
        level-=1;
        if (level<1) {
            level=1;
            System.out.println("You are alreay at lowest level");
        }
    }

    public static int getLevel() {
        return level;
    }

    public void update() {
        distance+=1;
        score=(int) (distance*10*-GameViewer.getGameSpeed()+numberCoins*1000);
    }

    public void addCoin() {
        numberCoins++;
    }


    
}
