import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Graph extends JComponent
{
  private ArrayList<Integer> speeds = new ArrayList<Integer>();
  private int speedOne;
  private int speedTwo;
  private int speedThree;
  private int speedFour;
  private int speedFive;
  private boolean sufficientData;
  private String graphTitle;
  public Graph(ArrayList<Integer> userSpeeds, String title)
  {
    super();
   this.speeds=userSpeeds; 
   this.graphTitle=title;
   this.sufficientData=true;
   if(userSpeeds.size()>=6)
   {
   this.speedOne=userSpeeds.get(userSpeeds.size()-5);
   this.speedTwo=userSpeeds.get(userSpeeds.size()-4);
   this.speedThree=userSpeeds.get(userSpeeds.size()-3);
   this.speedFour=userSpeeds.get(userSpeeds.size()-2);
   this.speedFive=userSpeeds.get(userSpeeds.size()-1);
   }
   else
   {
     this.sufficientData=false;
   }
   
  }

  public Graph()
  {
   super(); 
  }
  
  public void setSpeeds(ArrayList<Integer> userSpeeds, String title)
  {
   this.speeds=userSpeeds; 
   this.graphTitle=title;
   this.sufficientData=true;
   if(userSpeeds.size()>=6)
   {
   this.speedOne=userSpeeds.get(userSpeeds.size()-5);
   this.speedTwo=userSpeeds.get(userSpeeds.size()-4);
   this.speedThree=userSpeeds.get(userSpeeds.size()-3);
   this.speedFour=userSpeeds.get(userSpeeds.size()-2);
   this.speedFive=userSpeeds.get(userSpeeds.size()-1);
   }
   else
   {
     this.sufficientData=false;
   }
  }
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   g2.scale(this.getWidth()/120,this.getHeight()/160);
    g2.drawLine(10,0,10,140);
    g2.drawLine(10,140,120,140);
    if(this.sufficientData==true)
    {
    g2.setColor(Color.GREEN);
    g2.fillRect(20,(140-speedOne),10,speedOne);
    g2.setColor(Color.MAGENTA);
    g2.fillRect(40,(140-speedTwo),10,speedTwo);
    g2.setColor(Color.RED);
    g2.fillRect(60,(140-speedThree),10,speedThree);
    g2.setColor(Color.BLUE);
    g2.fillRect(80,(140-speedFour),10,speedFour);
    g2.setColor(Color.WHITE);
    g2.fillRect(100,(140-speedFive),10,speedFive);
    }
    else
    {
      if(!(this.speeds.size()==4))
      {
       g2.setFont(UIMethods.deriveFont("FTY DELIRIUM NCV.ttf",10f));
       g2.drawString("Complete at least 5 Practice Sessions",20,40);
       g2.drawString("to View Graph",45,65);
      
    }
    }
   g2.setFont(UIMethods.deriveFont("FTY DELIRIUM NCV.ttf",7.5f));
    g2.setColor(Color.BLACK);
    g2.drawString(this.graphTitle,25,152);
     g2.setFont(UIMethods.deriveFont("FTY DELIRIUM NCV.ttf",6.5f));
    g2.drawString("140",5,5);
    g2.drawString("120",5,25);
    g2.drawString("100",5,45);
    g2.drawString(" 80",5,65);
    g2.drawString(" 60",5,85);
    g2.drawString(" 40",5,105);
    g2.drawString(" 20",5,125);
  }
  
}
