/* TeacherDashboardView8
 * Created by: Johnson Duong
 * Updated on: 2019/05/29
 * Changes the password of a student
 */

import javax.swing.*;
import java.awt.*;

public class TeacherDashboardView8 extends JPanel
{
 //instance variables
 private JFrame window;
 private FrameModel model;
 
 private Teacher teacher ;
 private int studentIndex;
 private JPanel contentPane = new JPanel();
 private JPanel componentsPanel = new JPanel(new GridBagLayout());
 private JLabel prompt = new JLabel("Enter a new password:");
 private JLabel classListText = new JLabel("Class List");
 private JTextField name = new JTextField();
 private String[] studentNames;
 private JList classList;
 private JScrollPane scrollPane;
 private JTextField passwordField = new JTextField();
 private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
 private CustomButton confirmButton = new CustomButton("Confirm", 160, 60, 30);

 private GridBagConstraints gbc = new GridBagConstraints();
 private Student selectedStudent;
 //constructor
 public TeacherDashboardView8(FrameModel model, JFrame frame, int studentIndex,Teacher loggedIn)
 {
  super();
  this.window = frame;
  this.model = model;
  this.studentIndex = studentIndex;
  this.teacher = loggedIn;
  this.studentNames = this.teacher.getStudents();
  this.classList = new JList(this.studentNames);
  //this.classList.setSelectedIndex(this.studentIndex);
  this.scrollPane = new JScrollPane(this.classList);
  this.layoutView();
  this.update();
   this.registerControllers();
 
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

  //the name and buttons
  this.name.setPreferredSize(new Dimension(new Dimension(460,55)));
  this.name.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
  this.name.setEditable(false);
  this.name.setOpaque(false);
  this.name.setBorder(null);
  this.gbc.insets = new Insets(0,45,480,0);
  componentsPanel.add(name,gbc);
  
  this.gbc.insets = new Insets(0,0,70,245);
  componentsPanel.add(confirmButton, gbc);
  
  //the password
  this.prompt.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 21f));
  this.gbc.insets = new Insets(0,0,320,200);
  componentsPanel.add(prompt,gbc);

  this.passwordField.setPreferredSize(new Dimension(new Dimension(820,70)));
  this.passwordField.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
  this.gbc.insets = new Insets(0,410,220,0);
  componentsPanel.add(passwordField,gbc);
  
  this.gbc.insets = new Insets(60,1110,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(backButton,gbc);
  
   
   
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
  FrameSwitchController backController = new FrameSwitchController(this.backButton,this.model,"TeacherDashboard6",this.studentIndex);
  this.backButton.addMouseListener(backController);
  
  SelectionController studentSelectionController = new SelectionController(this.classList, this.model, "TeacherDashboard8");
  this.classList.addListSelectionListener(studentSelectionController);
  
  ChangePasswordController confirmPasswordController = new ChangePasswordController(this.confirmButton,this.model,this.passwordField,this.selectedStudent);
  this.confirmButton.addMouseListener(confirmPasswordController);
 }//end registerControllers
 
 //updates the view
 private void update()
 {
  this.name.setText(this.studentNames[this.studentIndex]);
  this.selectedStudent= this.teacher.findStudent(this.name.getText());
  
 }//end update

}//ssalc
