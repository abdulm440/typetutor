import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import java.io.*;

public class LoginView extends JPanel 
{  
  private LoginModel model; 
  private JFrame window;
  
  private JPanel mainPanel = new JPanel();
  private JPanel newPanel = new JPanel();
  private LogoPanel logo = new LogoPanel();
  private boolean LogoDisplayed=true;
  
  private JPanel panel = new JPanel(new GridBagLayout());
  
  
  private GridBagConstraints gbc = new GridBagConstraints();
  
  private JLabel title = new JLabel("Type Tutor",JLabel.CENTER);
  private JTextField userName = new JTextField(15);
  private JTextField password = new JTextField(15);
  CustomButton loginButton = new CustomButton("Login",220,80,40f);
  private JButton teacher = new JButton("New Teacher");
  
  
  public LoginView(LoginModel lm, JFrame frame)
  {
    super();
    this.model=lm;
    this.window=frame;
    this.layoutView();
    this.registerControllers();
    this.model.setGUI(this);
  }
  private void layoutView()
  {
    this.setSize(1366,768);
    this.setBackground(new Color(56,182,255));
    
    mainPanel.setBackground(new Color(56,182,255));
    panel.setBackground(new Color(56,182,255));
    mainPanel.add(panel);
    this.add(mainPanel);
    
    
    this.title.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",100f));
    
    this.userName.setText("Enter Username");
    this.userName.setHorizontalAlignment(JTextField.CENTER);
    this.userName.setFont(UIMethods.deriveFont("Barlow-Light.ttf",50f));
    
    this.password.setText("Enter Password");
    this.password.setHorizontalAlignment(JTextField.CENTER);
    this.password.setFont(UIMethods.deriveFont("Barlow-Light.ttf",50f));
    
    
     
    
    
    this.teacher.setFont(UIMethods.deriveFont("Barlow-Light.ttf",20f));
    
    
    
    if(LogoDisplayed==true)
    {
      logo.setPreferredSize(new Dimension(1000,150));
      this.gbc.insets = new Insets(0,0,100,0);
      this.gbc.gridx = 0;
      this.gbc.gridy = 0;
      panel.add(logo,gbc);
      
      
    }
    else{
      newPanel.setBackground(new Color(56,182,255));
      panel.add(newPanel);
      
    }
    
    this.gbc.insets = new Insets(0,0,75,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    panel.add(userName,gbc);
    
    this.gbc.insets = new Insets(0,0,105,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    panel.add(password,gbc);
    
    
    
    this.gbc.insets = new Insets(0,0,20,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 4;
    panel.add(loginButton,gbc);
    
    this.gbc.insets = new Insets(0,0,20,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 5;
    panel.add(teacher,gbc);
     teacher.setFocusPainted(false);
  teacher.setOpaque(true);
  teacher.setBorder(BorderFactory.createRaisedBevelBorder());
  teacher.setBackground(new Color(56, 182, 255));
 
    teacher.setBorderPainted(false);
    
    
    this.window.setSize(1366,768);
    this.window.setTitle("Login View");
    this.window.setLocation(0,0);
    this.window.setContentPane(this);
    this.window.setVisible(true);
    
  }
  
  private void registerControllers()
  {
    LoginController controllerOne = new LoginController(loginButton,userName,password,model);
    loginButton.addMouseListener(controllerOne);
    
    InputController controllerTwo = new InputController(userName, password);
    userName.addMouseListener(controllerTwo);
    
    InputController controllerThree = new InputController(userName,password);
    password.addMouseListener(controllerThree);
    
    TextFieldsController controllerFour = new TextFieldsController(model,userName,password);
    userName.addActionListener(controllerFour);
    
    TextFieldsController controllerFive = new TextFieldsController(model,userName,password);
    password.addActionListener(controllerFive);
    
    FrameSwitchController newTeacher = new FrameSwitchController(this.teacher,new FrameModel(this.window,this.model),"NewTeacher");
    this.teacher.addMouseListener(newTeacher);
  }
  
  public void update()
  {
    if(!this.model.getStatus().equals(""))
    {
      this.userName.setFont(userName.getFont().deriveFont(30f));
      this.userName.setForeground(Color.RED);
      this.userName.setText(this.model.getStatus()); 
      this.password.setText("");
    }
    
  }
  
  
}