import java.awt.*;
import java.awt.Font;
import java.io.*;

public class UIMethods
{
  public static Font deriveFont(String fileName, float size) 
  {
    try
    {
   Font leagueSpartan;
leagueSpartan = Font.createFont(Font.TRUETYPE_FONT, new File(fileName)).deriveFont(size); 
   GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
   ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fileName))); 
   return leagueSpartan;
    }
    catch(Exception ex)
    {
      return null;
    }
   //U can change font color using JLabel.setForeground(Color) --> To set a font, use myLabel.deriveFont(String fontpath, float font size)
  }
  
  
  
  
  
  
  
  
  
  
}