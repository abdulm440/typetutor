import java.awt.*;
import javax.swing.*;


public class NewTeacherView extends JPanel
{
  private FrameModel model;
  private JFrame window;
  
  private JLabel newTeacherLabel = new JLabel("Create New Teacher Account");
  
  private JLabel usernameLabel = new JLabel("Username: ");
  private JLabel passwordLabel = new JLabel("Password: ");
  
  private JTextField usernameField = new JTextField(30);
  private JTextField passwordField = new JTextField(30);
  
  private CustomButton createAccount = new CustomButton("Create Account",300,100,30f);
  private CustomButton back = new CustomButton("Back",300,100,35f);
  
  private BoxLayout mainLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
  
  private JPanel titlePanel = new JPanel();
  private JPanel usernamePanel = new JPanel();
  private JPanel passwordPanel = new JPanel();
  private JPanel buttonsPanel = new JPanel();
  
  
  public NewTeacherView(FrameModel md, JFrame frame)
  {
    this.model = md;
    this.window = frame;
    
    this.layoutView();
    this.registerControllers();
    //this.update();
  }
  
  private void layoutView()
  {
   this.setLayout(mainLayout);
    this.setBackground(new Color(56,182,255));
    
    this.newTeacherLabel.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",45f));
    this.newTeacherLabel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
    this.newTeacherLabel.setForeground(Color.BLACK);
    this.titlePanel.add(newTeacherLabel);
    this.titlePanel.setOpaque(false);
    
    
    this.usernameLabel.setFont(UIMethods.deriveFont("Barlow-Light.ttf",35f));
    this.usernameField.setFont(UIMethods.deriveFont("Barlow-Light.ttf",35f));
    this.usernameField.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    this.usernamePanel.add(usernameLabel);
    this.usernamePanel.add(usernameField);
    this.usernamePanel.setOpaque(false);
    
    this.passwordLabel.setFont(UIMethods.deriveFont("Barlow-Light.ttf",35f));
    this.passwordField.setFont(UIMethods.deriveFont("Barlow-Light.ttf",35f));
     this.passwordField.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    this.passwordPanel.add(passwordLabel);
    this.passwordPanel.add(passwordField);
    this.passwordPanel.setOpaque(false);
    
    
    this.buttonsPanel.setOpaque(false);
    this.buttonsPanel.add(createAccount);
    this.buttonsPanel.add(back);
    
    this.add(titlePanel);
    this.add(usernamePanel);
    this.add(passwordPanel);
    this.add(buttonsPanel);
    
    this.window.setSize(1366,768);
    this.window.setTitle("Create Teacher Account");
    this.window.setLocation(0,0);
    this.window.setContentPane(this);
    this.window.setVisible(true);
  }
  
  private void registerControllers()
  {
   FrameSwitchController backController = new FrameSwitchController(this.back,this.model,"Logout"); 
    this.back.addMouseListener(backController);
    
    NewUserController newTeacher = new NewUserController(this.createAccount,this.model,this.usernameField,this.passwordField);
    this.createAccount.addMouseListener(newTeacher);
  }
  
}