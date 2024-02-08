package mainApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
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

    private ArrayList<toAddObject> ObjectsToAdd=new ArrayList<toAddObject>();
    

    private static final int Electrified_Barrier = 0;
	private static final int Non_Electric_Barrier = 1;
	private static final int Coin = 2;
	private static final int Tracking_Missile = 3;
	private static final int Speed_Missile = 4;

    private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;
	private static final int RANDOM_OBJECT_DELAY_START = 1500;

    public GameComponent(){
        //create objects here
        player=new Player(500, 300, 30, 40);
       
        this.scoreRecorder=new ScoreRecorder();
        this.background=new Background();
        

    }

    public void addObjects(CollideableObject object){
        collideableObjects.add(object);
    }

    public void loadLevel(int level) throws InvalidLevelFormatException{
        String filename="Level"+level+".txt";

		try {
			loadFile(filename);
			System.out.println();
		} catch(FileNotFoundException e) {
			System.err.println("File " + filename + " not found.");
		} catch(IOException e) {
			System.err.println("Error closing file.");
		}
    }

    public void loadFile(String filename) throws FileNotFoundException, IOException, InvalidLevelFormatException{
        FileReader file = new FileReader(filename);
		BufferedReader reader = new BufferedReader(file);
        System.out.println("file loaded");

        String line;
        try {
            
            while ((line = reader.readLine()) != null) {
                
                try {
                        loadObject(line);
                        
                        
                    
                } catch (InvalidLevelFormatException e) {
                    System.err.println(e.getMessage()+" Skipped");
                
                } 
            }
        }catch(IOException e){
            System.err.println("I don't know what's happening");
        }
        
        reader.close();
		file.close();

    }

    @SuppressWarnings("resource")
    private void loadObject(String line) throws InvalidLevelFormatException,InputMismatchException{
        Scanner s1 = new Scanner(line);
        try {
            int time=s1.nextInt();
            if (time<0) {throw new InvalidLevelFormatException(line);}
            

            int name=s1.nextInt();
            if (name<0||name>3) {throw new InvalidLevelFormatException(line);}
            

            int pos=s1.nextInt();
            if (pos<0||pos>720) {throw new InvalidLevelFormatException(line);}
            

            int size=s1.nextInt();
            if (size<0||size>200) {throw new InvalidLevelFormatException(line);}
            

            int angle=s1.nextInt();
            if (angle<-90||angle>90) {throw new InvalidLevelFormatException(line);}

            ObjectsToAdd.add(new toAddObject(time, name, size, pos, angle));
            

            System.err.println(ObjectsToAdd.size()+"th Object loaded");
            
        } catch (InputMismatchException e) {
            System.err.println("Invalid format: "+line+ "  does not follow standard format rules(TIME NAME Y-POSITION SIZE ANGLE). Skipped.");
        } catch(NoSuchElementException e){
            System.err.println("Invalid format: "+line+ "  does not follow standard format rules(TIME NAME Y-POSITION SIZE ANGLE). Skipped.");
        }finally{
            

        }
        


        s1.close();
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
		player.drawOn(g2);

        scoreRecorder.drawOn(g2);
    }

    private void drawStart(Graphics2D g2) {
        g2.drawString("Press any key to start", 50, 50);
    }

    public void update(){
        for (CollideableObject collideableObject : collideableObjects) {
            collideableObject.update();
        }
        player.update();
        //System.out.println("hi");
        handleGenerateObjects();
        if(GameViewer.getTime()>RANDOM_OBJECT_DELAY_START) {
        handleGenerateObjectsRandomly();
        }
        
    }
    private void handleGenerateObjects() {
        if (ObjectsToAdd.isEmpty()) {
            return;
        }
        toAddObject obj=ObjectsToAdd.get(0);
        if (Math.abs(obj.timeToAdd-GameViewer.getTime())<10) {
            switch (obj.ObjectToAdd) {
                case Electrified_Barrier:
                    collideableObjects.add(
                        new Barrier(
                            GameViewer.WIDTH, 
                            obj.positionOfObject, 
                            obj.sizeOfObject, 
                            obj.angleOfObject,
                            true));
                    break;
                case Non_Electric_Barrier:
                    collideableObjects.add(
                        new Barrier(
                            GameViewer.WIDTH, 
                            obj.positionOfObject, 
                            obj.sizeOfObject, 
                            obj.angleOfObject,
                            false));
                
                    break;
                case Coin:
                    collideableObjects.add(
                        new coin(
                            GameViewer.WIDTH, 
                            obj.positionOfObject, 
                            0, 0));
                    break;   
                
            
                default:
                    break;
            }
            ObjectsToAdd.remove(0);
            
        }
    }

    public void handleGenerateObjectsRandomly() {
    	// System.out.println(GameViewer.random(20));
		if(GameViewer.random(30)==2) {
			collideableObjects.add(new Barrier(GameViewer.WIDTH+600,GameViewer.random(GameViewer.HEIGHT),100+ GameViewer.random(100), GameViewer.random(180)-90, GameViewer.random(100)>50));
		}
		if(GameViewer.random(20)==2) {
			collideableObjects.add(new coin(GameViewer.WIDTH+600,GameViewer.random(GameViewer.HEIGHT), 0, 0));
		}
		if(GameViewer.random(20)==2) {
			collideableObjects.add(new TrackingMissile(GameViewer.WIDTH));
		}
		if(GameViewer.random(20)==2) {
			collideableObjects.add(new Speed_Missle(GameViewer.WIDTH));
		}
		
	}
    public void handleDeleteOffScreenObjects() {
    	ArrayList<CollideableObject> objectsToRemove = new ArrayList<CollideableObject>();
    	for(CollideableObject o:collideableObjects) {
    		if(o.isOffScreen()) {
    			objectsToRemove.add(o);
    		}
    	}
    	for(CollideableObject o:objectsToRemove) {
    		collideableObjects.remove(o);
    	}
    }//Removes off screen objects from updating order
    public CollideableObject findObjectPlayerContact() {
    	Shape p = player.shape();
    	for(CollideableObject o:collideableObjects) {
    		if(o.isOverLapping(p)) {
    			return o;
    		}
    	}
    	return null;
    }
    public void handleObjectPlayerContact() {
    	CollideableObject contact =this.findObjectPlayerContact();
    	if(contact==null) {
    		return;
    	}
    	if(contact.isDeath()) {
    		//todo result after death
    		// loses a life only game over if no lives left
    		System.out.println("DEAD!!!!!!!!!!!!!");//temp
    		return;
    	}//checks for objects that kill the player
    	
    	
    }

    public void restartGame() {
        collideableObjects.clear();
        ObjectsToAdd.clear();
        
    }

    public void changeIsFlying(boolean b) {
        player.changeIsFlying(b);
    }


    

}
