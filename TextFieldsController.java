import java.awt.event.*;
import javax.swing.*;

public class TextFieldsController implements ActionListener
{
  private JTextField userName;
  private JTextField password;
  private LoginModel model;
  public TextFieldsController (LoginModel loginModel, JTextField user, JTextField pass)
  {
    this.model = loginModel;
    this.userName = user;
    this.password = pass;
  }
  public void actionPerformed(ActionEvent e)
  {
      try
    {
    this.model.login(userName.getText(),password.getText());
    }
    catch(Exception ex)
    {
      
    }
  }
  
}