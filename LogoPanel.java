/* LearnPanel1
 * Created by: Johnson Duong
 * Updated on: 2019/05/10
 * The first page of the LearnView
 */

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel
{
 ImageIcon image;
 
 //constructor
 public LogoPanel()
 {
  super();
  image = new ImageIcon("TypeTutor Logo.png");
  this.setPreferredSize(new Dimension(image.getImage().getWidth(null),image.getImage().getHeight(null)));
 }//end constructor
 
 //overriding the paintComponent method
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
   this.setBackground(new Color(56,182,255));
  Image pic = image.getImage();
  g.drawImage(pic,this.getWidth()/4,0,this.getWidth()/2,this.getHeight(),null);
  System.out.println(this.getWidth()+" " + this.getHeight());
 }//end paintComponent
 
}//ssalc
