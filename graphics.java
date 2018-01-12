import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.Scanner;


class title 

class graphics implements Runnable, KeyListener, WindowListener, MouseListener {
    public final String TITLE = "The Ragequit Game";
    public final Dimension SIZE = new Dimension(1920, 1040);
    public JFrame frame;
    private boolean isRunning, isDone;
    private Image imgBuffer;
    private boolean change;
    @SuppressWarnings("unused")
        private boolean AITurn, UserTurn;
	private BufferedImage Alien;
	private BufferedImage Nacho_Dorito, Corn_Texture;

	private boolean titleScreen, 
	//int wmx = 0;
	//int wmy = 0;
	//int hx = 800;
	//int hy = -120;
	//int bcx = -220;
	//int bcy = -190;
	//int ka1x = 860;
	//int ka1y = 460;

    public void setChange(boolean change) {
        this.change = change;
    }

    private void loadImages() {

    	try{
    		Alien = ImageIO.read(this.getClass().getResource("Alien.png"));
    		Nacho_Dorito = ImageIO.read(this.getClass().getResource("Nacho_Dorito.png"));
            //Corn_Texture = new TexturePaint(grass, new Rectangle(0, 0, 90, 60));
    		
    	}catch(Exception e){
    		
    	}
       
    }

    public graphics(){
       titleScreen = true;
       mazeOne = false;
       mazeTwo = false;
       mazeThree = false;
       mazeFour = false;
       mazeFive = false;
       mazeSix = false;
       mazeSeven = false;
       mazeEight = false;
       mazeNine = false;
        loadImages();
        frame = new JFrame();
        frame.addKeyListener(this);
        frame.addWindowListener(this);
        frame.addMouseListener(this);
        frame.setSize(SIZE);
        frame.setTitle(TITLE);
        isRunning = true;
        isDone = false;
        frame.setVisible(true);
        frame.setLayout(null);
        imgBuffer = frame.createImage(SIZE.width, SIZE.height);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Key;
        Key = e.getKeyCode();

        
        
        if(Key == KeyEvent.VK_SPACE){
        	if(titleScreen == true){
        		titleScreen = false;
        		mazeOne = true;
        	}
        	else if(mazeOne == true){
            		titleScreen = false;
            		mazeOne = false;
            		mazeTwo = true;
        	}
        	
        }
        
        if(mazeTwo == true && Key == KeyEvent.VK_RIGHT && wmx >= -800)
    	{
    		wmx -= 10;
    		mazeTwo = false;
    		mazeTwo = true;
    		
    		if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
            {
    			mazeThree = true;
    			mazeTwo = false;
            }
    		else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
            {
    			mazeFive = true;
    			mazeTwo = false;
            }
    		else if(wmy >= 40 && wmx >= 550)
            {
    			mazeFour = true;
    			mazeTwo = false;
            }
    		else
    		{
    			System.out.print(wmx);
            	System.out.print(", ");
            	System.out.print(wmy);
            	System.out.println();
    		}
    	}
        

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        frame.dispose();
        isRunning = false;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        while(true){

            if(isDone){
                System.exit(0);
            }
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void run() {
        while(isRunning){

            draw();

            if(change){
                setChange(false);

            }
            try{Thread.sleep(32);}
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        isDone = true;
    }

    private void beginning(Graphics2D g2d){
    	g2d.setColor(Color.GREEN);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	
    	g2d.setColor(Color.BLUE);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.setColor(Color.BLACK);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 10F));
    	g2d.drawString("Maize Runner", 200, 400);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .5F));
    	g2d.drawString("It's time for you to experience this amaizing journey", 204, 450);
    	g2d.drawImage(Alien, 1300, 250, null);
    	g2d.drawImage(Nacho_Dorito, 250, 250, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .1F));
    	g2d.drawString("Press Space to begin", 850, 800);
    }
    
    private void mazeOne(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(Alien, 1300, 250, null);
    	g2d.drawImage(Nacho_Dorito, 250, 250, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
       	wmy = 150;
    }
    
    private void mazeTwo(Graphics2D g2d)
    {
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(mazeTwo, wmx, wmy, null);
    	g2d.drawImage(PC, 900, 450, null);
    }
    
    private void mazeThree(Graphics2D g2d)
    {
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(House, hx, hy, null);
    	g2d.drawImage(PC, 900, 450, null);
    }
    
    private void mazeSix(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(Alien, 1300, 600, null);
    	g2d.drawImage(Nacho_Dorito, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	
    }
    
    private void Plantano(Graphics2D g2d)
    {
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
    	g2d.drawImage(Plantano, bcx, bcy, null);
    	g2d.drawImage(PC, 900, 450, null);
    }
    
    private void mazeSeven(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(Alien, 1300, 600, null);
    	g2d.drawImage(Nacho_Dorito, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	
    }
    
    private void mazeEight(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(Alien, 1300, 600, null);
    	g2d.drawImage(Nacho_Dorito, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    	
    }
    
    private void mazeNine(Graphics2D g2d){
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(350, 700, 1200, 250);
    	g2d.drawImage(fourthwall, 600, 200, null);
    	g2d.drawImage(Alien, 1300, 600, null);
    	g2d.drawImage(Nacho_Dorito, 250, 600, null);
    	g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
    	g2d.setColor(Color.YELLOW);
    
    }
    	
    	private void mazeFive(Graphics2D g2d){
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(0, 0, SIZE.width, SIZE.height);
        	g2d.drawImage(K2261, ka1x, ka1y, null);
        	g2d.drawImage(PC, 900, 450, null);
    }
    
    private void draw() {

        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
       
        if (titleScreen)
        {
        	beginning(g2d);
        }
        else if(mazeOne)
        {
        	mazeOne(g2d);
        }
        else if(mazeTwo)
        {
        	mazeTwo(g2d);
        }
        else if (mazeThree)
        {
        	mazeThree(g2d);
        }
        else if (mazeSix)
        {
        	mazeSix(g2d);
        }
        else if (mazeFour)
        {
        	Plantano(g2d);
        }
        else if (mazeSeven)
        {
        	mazeSeven(g2d);
        }
        else if (mazeEight)
        {
        	mazeEight(g2d);
        }
        else if (mazeNine)
        {
        	mazeNine(g2d);
        }
        else if (mazeFive)
        {
        	mazeFive(g2d);
        }
        
        if(isRunning)
            g2d = (Graphics2D) frame.getGraphics();
        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        g2d.dispose();
    }
}

class map
int [][] map= {
        {0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,},
        {2,1,1,1,0,0,0,0,0,0,},
        {0,0,0,1,0,0,0,1,1,2,},
        {0,0,0,1,0,0,0,1,0,0,},
        {0,0,0,1,0,0,0,1,0,0,},
        {0,0,0,1,1,1,1,1,0,0,},
        {0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,},
        {0,0,0,0,0,0,0,0,0,0,}
      };

for(int i=0;i<map.length;i++){
for(int j=0;j<map.length[0];j++){
switch(map[i][j]){
case 0:drawRect(i,j,width,height,blue);
break;
case 1:drawRect(i,j,width,height,white);
break;
case 2: drawRect(i,j,width,height,red);
break;
}
}  
}
