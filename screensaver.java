import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.math.*;

public class screensaver extends JFrame {
    int delay = 5000;
    int x = 50, y = 70, w = 300, h = 300;
    boolean r = true, up = true;
    Random rand = new Random();
    int red = rand.nextInt(255), green = rand.nextInt(255), blue = rand.nextInt(255), nextRed, nextGreen, nextBlue;

    public screensaver() {
        setUndecorated(true);
        setVisible(true);
        animate();
    }
    private void animate(){
        while(true){

            setBounds(x, y, w, h);
            if (r) x+=2.5; else x-=2.5;
            if (up) y-=2.5; else y+=2.5;
            if (x <= 0) r = true;
            if (x >= (3840 - w)) r = false;
            if (y <=0 ) up = false;
            if (y>= (2160 - h)) up = true;
            try{
                Thread.sleep(20);
            }catch(InterruptedException e) {}
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
                
            }
            //Create a for loop to gently fade to and from each color(generate a new color
            //every 2 secs or so, and then fade into that color, until the next color in generated 
        }catch(InterruptedException e) {}
    }
    public static void main(String[] args) {
        new screensaver();
    }
}