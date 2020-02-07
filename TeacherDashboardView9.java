/* TeacherDashboardView9
 * Created by: Shahzaib Saleem
 * Updated on: 2019/05/29
 * Shows options for the student
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TeacherDashboardView9 extends JPanel
{
 //instance variables
 private JFrame window;
 private FrameModel model;

 private Teacher teacher;
 private int studentIndex;
 private JPanel componentsPanel = new JPanel(new GridBagLayout());
 private JLabel classListText = new JLabel("Class List");
 private JTextField name = new JTextField();
 private String[] studentNames;
 private JList classList;
 private JScrollPane scrollPane;
 private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
 private CustomButton level1 = new CustomButton("1",120,120,85);
 private CustomButton level2 = new CustomButton("2",120,120,85);
 private CustomButton level3 = new CustomButton("3",120,120,85);
 private CustomButton level4 = new CustomButton("4",120,120,85);
 private CustomButton level5 = new CustomButton("5",120,120,85);
 private CustomButton level6 = new CustomButton("6",120,120,85);
 private CustomButton level7 = new CustomButton("7",120,120,85);
 private CustomButton level8 = new CustomButton("8",120,120,85);
 private CustomButton level9 = new CustomButton("9",120,120,85);
 private CustomButton level10 = new CustomButton("10",120,120,85);
 private GridBagConstraints gbc = new GridBagConstraints();
 
 private ArrayList<CustomButton> levelButtons = new ArrayList<CustomButton>();

 //constructor
 public TeacherDashboardView9(FrameModel model, JFrame frame, int studentIndex, Teacher loggedIn)
 {
  super();
  this.window = frame;
  this.model = model;
  this.teacher=loggedIn;
  this.studentIndex = studentIndex;
  this.studentNames = this.teacher.getStudents();
  this.classList = new JList(this.studentNames);
  this.scrollPane = new JScrollPane(this.classList);
  this.layoutView();
  this.registerControllers();
  this.update();
  
  this.disableButtons();
 }//end constructor

 //sets the initial layout of the view
 private void layoutView()
 {
  this.setBackground(new Color(56,182,255));
  componentsPanel.setBackground(new Color(56,182,255));
  this.add(componentsPanel);
  this.classListText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 42f)); 
  this.gbc.insets = new Insets(70,0,0,1040);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(classListText,gbc);
  
  this.name.setPreferredSize(new Dimension(new Dimension(460,55)));
  this.name.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
  this.name.setEditable(false);
  this.name.setOpaque(false);
  this.name.setBorder(null);
  this.gbc.insets = new Insets(0,45,480,0);
  componentsPanel.add(name,gbc);

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

  //buttons and text
  this.name.setPreferredSize(new Dimension(new Dimension(460,55)));
  this.name.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
  this.name.setEditable(false);
  this.name.setOpaque(false);
  this.name.setBorder(null);
  this.gbc.insets = new Insets(0,45,480,0);
  componentsPanel.add(name,gbc);

  this.gbc.insets = new Insets(60,1110,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(backButton,gbc);


  this.gbc.insets = new Insets(85,0,300,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level1,gbc);


  this.gbc.insets = new Insets(85,330,300,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level2,gbc);

  this.gbc.insets = new Insets(85,680,300,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level3,gbc);

  this.gbc.insets = new Insets(85,1000,300,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level4,gbc);

  this.gbc.insets = new Insets(85,1320,300,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level5,gbc);

  this.gbc.insets = new Insets(200,0,100,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level6,gbc);

  this.gbc.insets = new Insets(200,330,100,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level7,gbc);

  this.gbc.insets = new Insets(200,680,100,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level8,gbc);

  this.gbc.insets = new Insets(200,1000,100,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level9,gbc);

  this.gbc.insets = new Insets(200,1320,100,220);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(level10,gbc);


  //the window
  componentsPanel.setOpaque(false);

  window.setBackground(new Color(56, 183, 255));
  window.setContentPane(this);
  window.setVisible(true);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.setSize(1366, 768);

 }//end layoutView

 private void registerControllers()
 {
  FrameSwitchController backController = new FrameSwitchController(this.backButton,this.model,"TeacherDashboard6");
  this.backButton.addMouseListener(backController);

  SelectionController studentSelectionController = new SelectionController(this.classList, this.model, "TeacherDashboard9");
  this.classList.addListSelectionListener(studentSelectionController);

 }//end registerControllers

 //updates the view
 public void update()
 {
  this.name.setText(this.studentNames[this.studentIndex]);

 }//end update
  private void disableButtons()
 {
   levelButtons.add(level1);
  levelButtons.add(level2);
  levelButtons.add(level3);
  levelButtons.add(level4);
  levelButtons.add(level5);
  levelButtons.add(level6);
  levelButtons.add(level7);
  levelButtons.add(level8);
  levelButtons.add(level9);
  levelButtons.add(level10);
  
  for(int x = 9;x>this.teacher.getStagesUnlocked(this.name.getText())-1;x--)
  {
   levelButtons.get(x).setEnabled(false); 
  }
   
 }

}//ssalc