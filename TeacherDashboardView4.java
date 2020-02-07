/* TeacherDashboardView4
 * Created by: Johnson Duong
 * Updated on: 2019/05/29
 * Adding a new student in the class list
 */

import javax.swing.*;
import java.awt.*;

public class TeacherDashboardView4 extends JPanel
{
 //instance variables
 private JFrame window;
 private FrameModel model;

 private Teacher teacher;
 private JPanel componentsPanel = new JPanel(new GridBagLayout());
 private JLabel classListText = new JLabel("Class List");
 private JLabel prompt = new JLabel("Add new student");
 private JLabel enterUserText = new JLabel("Enter Username:");
 private JLabel enterPassText = new JLabel("Enter Password:");
 private String[] studentNames;
 private JList classList;
 private JScrollPane scrollPane;
 private JTextField usernameField = new JTextField();
 private JTextField passwordField = new JTextField();
 private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
 private CustomButton confirmButton = new CustomButton("Confirm", 160, 60, 30);

 private GridBagConstraints gbc = new GridBagConstraints();

 //constructor
 public TeacherDashboardView4(FrameModel model, JFrame frame, Teacher loggedIn)
 {
  super();
  this.window = frame;
  this.model = model;
  this.teacher=loggedIn;
  this.studentNames = this.teacher.getStudents();
  this.classList = new JList(studentNames);
  this.scrollPane = new JScrollPane(this.classList);
  this.layoutView();
  this.registerControllers();
  this.update();
 }//end constructor 

 //sets the initial layout of the view
 private void layoutView()
 {
  //the classList
  this.classListText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 42f)); 
  this.gbc.insets = new Insets(70,0,0,1040);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(classListText,gbc);

  this.classList.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 25f));
  this.classList.setSelectionBackground(new Color(241, 248, 108));
  this.classList.setSelectionForeground(Color.BLACK);
  this.classList.setFixedCellHeight(50);
  this.classList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  this.scrollPane.setPreferredSize(new Dimension(375,530));
  this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  this.gbc.insets = new Insets(20,0,0,860);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(scrollPane,gbc);

  //the buttons
  this.gbc.insets = new Insets(60,1110,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(backButton,gbc);

  this.gbc.insets = new Insets(150,0,0,245);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(confirmButton, gbc);

  //student information fields
  this.prompt.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 32f));
  this.gbc.insets = new Insets(0,0,480,180);
  componentsPanel.add(prompt,gbc);

  this.enterUserText.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 21f));
  this.gbc.insets = new Insets(0,0,320,255);
  componentsPanel.add(enterUserText,gbc);

  this.usernameField.setPreferredSize(new Dimension(new Dimension(820,70)));
  this.usernameField.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
  this.gbc.insets = new Insets(0,410,220,0);
  componentsPanel.add(usernameField,gbc);

  this.enterPassText.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 21f));
  this.gbc.insets = new Insets(0,0,100,255);
  componentsPanel.add(enterPassText,gbc);

  this.passwordField.setPreferredSize(new Dimension(new Dimension(820,70)));
  this.passwordField.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
  this.gbc.insets = new Insets(0,410,0,0);
  componentsPanel.add(passwordField,gbc);

  //the window
  componentsPanel.setOpaque(false);
  this.add(componentsPanel);
  this.setBackground(new Color(56, 183, 255));
  window.setContentPane(this);
  window.setVisible(true);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.setSize(1366, 768);

 }//end layoutView

 //registering the controllers
 private void registerControllers()
 {
  FrameSwitchController backController = new FrameSwitchController(this.backButton,this.model,"TeacherDashboard3");
  this.backButton.addMouseListener(backController);

  NewUserController addStudentController = new NewUserController(this.confirmButton,this.model,this.usernameField,this.passwordField,this.teacher);
  this.confirmButton.addMouseListener(addStudentController);
 }//end registerController

 //updates the view
 private void update()
 {
  
 }//end update
 
}//ssalc
