import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ClearController implements MouseListener
{
  private JTextField input;
  private String textToClear;
  private TypingViewTemplate view;
  public ClearController(TypingViewTemplate tv,JTextField inputField, String defaultText)
  {
    this.input= inputField;
    this.textToClear = defaultText;
    this.view = tv;
  }


  public void mouseEntered(MouseEvent e)
  {
    
  }
  public void mouseExited(MouseEvent e) 
  {
    
    
    
  }
  public void mouseReleased(MouseEvent e)
  {
    
  }
  public void mousePressed(MouseEvent e)
  {
    
  }
  public void mouseClicked(MouseEvent e) 
  {
    if(this.input.getText().equals(this.textToClear))
    {
     this.input.setText("");
     
     this.view.startSession();
    }
  }
  
}