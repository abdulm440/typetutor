import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class LoginController implements MouseListener
{
  private JButton bt;
  private JTextField username;
  private JTextField password;
  private LoginModel model;
  public LoginController(JButton button, JTextField user, JTextField pass, LoginModel md)
  {
    this.username = user;
    this.password = pass;
    this.bt=button;
    model=md;
  }
  public void mouseEntered(MouseEvent e)
  {
    bt.setOpaque(true);
    bt.setForeground(new Color(241,248,108));
    bt.setBorderPainted(false);
    bt.setBackground(Color.BLACK);
  }
  public void mouseExited(MouseEvent e)
  {
    bt.setOpaque(true);
    bt.setBackground(new Color(241,248,108));
    bt.setBorderPainted(false);
    bt.setForeground(Color.BLACK); 
  }
  public void mouseReleased(MouseEvent e)
  {
    
  }
  public void mousePressed(MouseEvent e)
  {
    
  }
  public void mouseClicked(MouseEvent e)
  {
    
    try
    {
    this.model.login(username.getText(),password.getText());
    }
    catch(Exception ex)
    {
      
    }
  }
  
}