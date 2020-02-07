import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

// Frame Switch Controller Class --> Used to implement mouse events
//For all buttons on interface, add button.addMouseListener(new FrameSwitchController(button))
// Buttons must have their background preset to yellow and font color set to black
/* For all buttons, make sure you have the following properties set
 *  button.setPreferredSize(new Dimension(300,100));
 button.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",(Choose font size)));
 button.setOpaque(true);
 button.setBackground(new Color(241,248,108));
 button.setBorderPainted(false);
 button.addMouseListener(new FrameSwitchController(button));
 button.setFocusPainted(false);
 * 
 * 
 * 
 * 
 * */
public class InputController implements MouseListener 
{
  private JTextField userName;
  private JTextField password;
  public InputController(JTextField user, JTextField pass)
    
  {
    this.userName = user;
    this.password = pass;
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
    if (userName.getText().equals("Enter Username") || userName.getText().equals("Enter Password"))
    {
      userName.setText("");
      password.setText("");
    }
    else if(userName.getText().equals("Login Failed")||userName.getText().equals("Account Corrupted.Please contact teacher"))
    {
      userName.setText("");
      userName.setFont(userName.getFont().deriveFont(50.0f));
      
      userName.setForeground(Color.BLACK);
    }
  }
}