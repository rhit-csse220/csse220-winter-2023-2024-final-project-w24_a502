package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class ScoreRecorder {

    private int score; 
	private int level;
    private int distance;
    private int numberCoins;

    

    
    
    public ScoreRecorder(){
        score=0;
        level=1;
        distance=0;
        numberCoins=0;
    }

    public void drawOn(Graphics2D g2){
        g2.drawString(  "score:"+score+"\n"+
                        "level:"+level+"\n"+
                        "distance:"+distance+"\n"+
                        "numberCoins:"+numberCoins+"\n", 
                        0, 0);
        
    }



    public void levelUp() {
        level+=1;
        if (level>2) {
            level=2;
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


    
}
