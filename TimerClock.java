import java.awt.*;
import javax.swing.*;

public class TimerClock extends JComponent
{
  private int seconds;
  private int arcLength=0;;
  private String currentTime = "0:00";
  public TimerClock(int time)
  {
    super();
     
    this.seconds = time;
  }
  public void paintComponent(Graphics g)
  {
  
    super.paintComponent(g);
  
   
    Graphics2D g2 = (Graphics2D) g;
    g2.scale(this.getWidth()/100,this.getHeight()/100);
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(5.0f));
    g2.drawOval(1,1,99,99);
    g2.setColor(Color.YELLOW);
    
   g2.drawArc(1,1,99,99,0,arcLength);
   g2.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",25f));
   g2.drawString(currentTime,20,60);
  }
  public void increaseTime()
  {
   arcLength+=4; 
  
   this.repaint();
  }
  public void setTime(String time)
  {
   this.currentTime=time; 
  }
  
  
}