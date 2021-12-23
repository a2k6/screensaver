import javax.swing.*;
import java.util.*;
import java.awt.*;

public class screensaver extends JFrame {
    int x = 50, y = 70, winW = 300, winH = 300;
    boolean r = true, up = true;
    Random rand = new Random();

    public screensaver() {
        setUndecorated(true);
        setVisible(true);
        animate();
    }
    private void animate(){
        while(true){

            setBounds(x, y, winW, winH);
            if (r) x+=5; else x-=5;
            if (up) y-=5; else y+=5;
            if (x <= 0) r = true;
            if (x >= 3840) r = false;
            if (y <=0 ) up = false;
            if (y>= 2160) up = true;

            try{
                Thread.sleep(10);
            }catch(InterruptedException e) {}
            repaint();
        }
    }
    public void paint (Graphics g) {
        g.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
        g.fillRect(0, 0, winW, winH);
    }
    public static void main(String[] args) {
        new screensaver();
    }
}