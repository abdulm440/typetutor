import java.awt.*;
import javax.swing.*;


public class WpmMeter extends JComponent
{
  private int wpm;
  private int reqSpeed;
 public WpmMeter(int minSpeed)
 {
   super(); 
   this.wpm=0;
   this.reqSpeed=minSpeed;
 }
 public void paintComponent(Graphics g)
 {
   super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   g2.scale(this.getWidth()/141, this.getHeight()/10);
   
   g2.setStroke(new BasicStroke(1.0f));
   g2.drawRect(0,0,141,10);
   if(this.wpm>=this.reqSpeed)
   {
   g2.setColor(Color.GREEN);
   }
   else
   {
     g2.setColor(Color.RED);
   }
   g2.fillRect(1,1,wpm-1,8);
 }
 public void setWpm(int speed)
 {
   this.wpm=speed;
   this.repaint();
 }
  
  
  
}