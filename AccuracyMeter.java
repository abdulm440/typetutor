import java.awt.*;
import javax.swing.*;

public class AccuracyMeter extends JComponent
{
   private int accuracy=0;
   private int reqAccuracy;
  private String accuracyText = "0%";
  public AccuracyMeter(int minAccuracy)
  {
    super();
     this.reqAccuracy=minAccuracy;
  }
  public void paintComponent(Graphics g)
  {
  
    super.paintComponent(g);
   
    Graphics2D g2 = (Graphics2D) g;
    g2.scale(this.getWidth()/100,this.getHeight()/100);
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(5.0f));
    g2.drawOval(1,1,99,99);
    if(this.accuracy<reqAccuracy)
    {
    g2.setColor(Color.RED);
    }
    else
    {
      g2.setColor(Color.GREEN);
    }
    
   g2.drawArc(1,1,99,99,0,(360*accuracy)/100);
   g2.setColor(Color.BLACK);
   g2.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",25f));
   g2.drawString(accuracyText,20,60);
  }
  public void setAccuracy(double percent)
  {
   this.accuracy=(int)Math.round(percent);
   this.accuracyText=this.accuracy+"%";
   this.repaint();
  }
 
  
  
  
  
}