import javax.swing.*;
import java.util.*;
import java.awt.*;

public class screensaver extends JFrame {
    int x = 50, y = 70, w = 300, h = 300;
    boolean r = true, up = true;
    Random rand = new Random();
    int red = rand.nextInt(255), green = rand.nextInt(255), blue = rand.nextInt(255);

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
        red++;
        green++;
        blue++;
        if (red == 255)
        red = 0;
        if (green == 255)
        green = 0;
        if (blue == 255)
        blue = 0;
    }
    public static void main(String[] args) {
        new screensaver();
    }
}