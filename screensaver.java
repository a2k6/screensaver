import javax.swing.*;
import java.util.*;
import java.awt.*;

public class screensaver extends JFrame {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int delay = 5000;
    int x = 50, y = 70, squareSize = 300;
    boolean r = true, up = true;
    Random rand = new Random();
    int red = rand.nextInt(255), green = rand.nextInt(255), blue = rand.nextInt(255), nextRed, nextGreen, nextBlue;
    double temp, timePerAction, movementSpeed = 2.5, width = size.getWidth(), height = size.getHeight();

    public screensaver() {
        setUndecorated(true);
        setVisible(true);
        animate();
    }
    private void animate(){
        setBounds(0, 0, (int)width, (int)height);
        while(true){
            //Setting the edges of the screen, checking for collision and then changing direction, and moving the square around
            //setBounds(x, y, squareSize, squareSize);
            //Movement speeds
            if (r) x += movementSpeed; else x -= movementSpeed;
            if (up) y -= movementSpeed; else y += movementSpeed;
            //Checking bounds and changing the course of the square accordingly
            if (x <= 0) r = true;
            if (x >= (width - squareSize)) r = false;
            if (y <=0 ) up = false;
            if (y>= (height - squareSize)) up = true;
            //Pauses the code for 20ms
            try{
                Thread.sleep(20);
            }catch(InterruptedException e) {}
            //Since the paint() method calls the paintBorder(), paintComponent(), and paintChildren() methods, 
            //If we just want to re-run the paint function to change some element other than the size trying to re-run the paint function(and assuming that we have not changed the size of the component, just the color), we use the repaint() method, which just updates the paint() method instead of forcing us to enter completely new parameters every time
            repaint();
        }
    }
    public void paint(Graphics g) {
        g.fillRect(0, 0, (int)width, (int)height);
        g.setColor(new Color(red, green, blue));
        g.fillRect(0, 0, squareSize, squareSize);
        try{
            Thread.sleep(delay);
            nextRed = rand.nextInt(255);
            nextBlue = rand.nextInt(255);
            nextGreen  = rand.nextInt(255);
            
            //Code that fades the red channel
            temp = Math.abs(nextRed - red);
            if (nextRed - red < 0){
                //Value of the expression is negative
            } else if (nextRed - red > 0) {
                //Value of the expression is positive
            } else {
                //Value of the expression is zero(there is no change between the start and next values)
            }
            for(var i = 0; i < temp; i++){
                //Slowly increment the colors untill the values are equal
                //Create one for loop per color
            }

            //Code that fades the blue channel
             
        }catch(InterruptedException e) {}
    }
    public static void main(String[] args) {
        new screensaver();
    }
}