import javax.swing.*;
import java.util.*;
import java.awt.*;

public class screensaver extends JFrame {
    int delay = 5000;
    int x = 50, y = 70, w = 300, h = 300;
    boolean r = true, up = true;
    Random rand = new Random();
    int red = rand.nextInt(255), green = rand.nextInt(255), blue = rand.nextInt(255), nextRed, nextGreen, nextBlue;
    double temp, timePerAction, movementSpeed = 2.5;

    public screensaver() {
        setUndecorated(true);
        setVisible(true);
        animate();
    }
    private void animate(){
        while(true){
            //Setting the edges of the screen, checking for collision and then changing direction, and moving the square around
            setBounds(x, y, w, h);
            //Movement speed
            if (r) x += movementSpeed; else x -= movementSpeed;
            if (up) y -= movementSpeed; else y += movementSpeed;
            //Checking bounds and changing the course of the square accordingly
            if (x <= 0) r = true;
            if (x >= (3840 - w)) r = false;
            if (y <=0 ) up = false;
            if (y>= (2160 - h)) up = true;
            //Pauses the code for 20ms
            try{
                Thread.sleep(20);
            }catch(InterruptedException e) {}
            //Re-calls the paint function(since we want to re-run it instead of making a new class)
            //Usually re-calling a function is as simple as calling it again but the paint function is special
            //It is invoking swing utilities, which is a graphics engine, and it can thus be re-called using repaint() instead of just calling it again normally
            //To be honest, I don't fully understand it, but this after I run it like this 
            repaint();
        }
    }
    public void paint (Graphics g) {
        g.setColor(new Color(red, green, blue));
        g.fillRect(0, 0, w, h);
        try{
            Thread.sleep(delay);
            //Variable that controls the amount of time is at the very top of the code
            nextRed = rand.nextInt(255);
            nextBlue = rand.nextInt(255);
            nextGreen  = rand.nextInt(255);
            while(red != nextRed){
                temp = Math.abs(nextRed - red);
                if (nextRed - red < 0){
                    //Value of the expression is negative
                } else if (nextRed - red > 0) {
                    //Value of the expression is positive
                } else {
                    //Value of the expression is zero(there is no change between the start and next values)
                }
                for(var i = 0; i < temp; i++){

                }
            }
            //Create a for loop to gently fade to and from each color(generate a new color
            //every 2 secs or so, and then fade into that color, until the next color in generated 
        }catch(InterruptedException e) {}
    }
    public static void main(String[] args) {
        new screensaver();
    }
}