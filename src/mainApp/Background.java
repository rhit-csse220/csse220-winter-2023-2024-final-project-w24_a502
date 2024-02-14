package mainApp;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Background {
    //private double movespeed;
    public ImageIcon icon,start,pause,over;
    public int height,width;
    private double x;

    public Background (){
        //movespeed=GameViewer.getGameSpeed();
        icon=new ImageIcon("background.png");
        start=new ImageIcon("start.png");
        pause=new ImageIcon("pause.png");
        over=new ImageIcon("over.png");
        
        
        height=GameViewer.HEIGHT;
        width=GameViewer.WIDTH;
        x=(double) GameViewer.WIDTH;
    }

    public void drawOn(Graphics2D g2){
        switch (GameViewer.getState()) {
            case 0:
                g2.drawImage(start.getImage(),0,0,width, height, null);

                break;
            case 1:
                g2.drawImage(icon.getImage(),(int)x,0,width, height, null);
                g2.drawImage(icon.getImage(),(int)x-(int)GameViewer.WIDTH,0,width, height, null);
                break;
            case 2:
                g2.drawImage(icon.getImage(),(int)x,0,width, height, null);
                g2.drawImage(icon.getImage(),(int)x-(int)GameViewer.WIDTH,0,width, height, null);
                g2.drawImage(pause.getImage(),290,280,pause.getIconWidth(), pause.getIconHeight(), null);
                break;
            case 3:
                g2.drawImage(over.getImage(),0,0,width, height, null);
                break;
        
            default:
                break;
        }
        
    }
    public void update(){
        x+=GameViewer.getGameSpeed();
        if (x<0) {
            x=(double) GameViewer.WIDTH;
        }
    }
    
}
