/* TeacherDashboardView10
 * Created by: Shahzaib Saleem
 * Updated on: 2019/05/29
 * Shows options for the student
 */

import javax.swing.*;
import java.awt.*;

public class TeacherDashboardView10 extends JPanel
{
  //instance variables
  private JFrame window;
  private FrameModel model;
  
  private Teacher teacher;
  private JPanel componentsPanel = new JPanel(new GridBagLayout());
  private JLabel classListText = new JLabel("Class List");
  private int studentIndex;
  private JTextField name = new JTextField();
  private String[] studentNames;
  private JList classList;
  private JScrollPane scrollPane= new JScrollPane(classList);
  private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
  private JLabel speed = new JLabel("Top Speed: 89 wpm");
  private JLabel accuracy = new JLabel("Avg Accuracy: 95%");
  private GridBagConstraints gbc = new GridBagConstraints();
  
  private Graph graph = new Graph();
  private Student selectedStudent;
  //constructor
  public TeacherDashboardView10(FrameModel model, JFrame frame, int studentIndex, Teacher loggedIn)
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
    
 
  }//end constructor
  
  //sets the initial layout of the view
  private void layoutView()
  {
    this.setBackground(new Color(56,182,255));
    componentsPanel.setBackground(new Color(56,182,255));
    this.add(componentsPanel);
    
    graph.setBackground(Color.WHITE);
    graph.setPreferredSize(new Dimension(683,400));
    
    classListText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 42f)); 
    gbc.insets = new Insets(70,0,0,1040);
    gbc.gridx = 0;
    gbc.gridy = 0;
    componentsPanel.add(classListText,gbc);
    
    
    
    classList.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 25f));
    classList.setSelectionBackground(new Color(241, 248, 108));
    classList.setSelectionForeground(Color.BLACK);
    classList.setFixedCellHeight(50);
    classList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scrollPane.setPreferredSize(new Dimension(375,530));
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    gbc.insets = new Insets(20,0,0,860);
    gbc.gridx = 0;
    gbc.gridy = 1;
    componentsPanel.add(scrollPane,gbc);
    
    //buttons and text
    this.name.setPreferredSize(new Dimension(new Dimension(460,55)));
    this.name.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
    this.name.setEditable(false);
    this.name.setOpaque(false);
    this.name.setBorder(null);
    this.gbc.insets = new Insets(0,230,480,200);
    componentsPanel.add(name,gbc);
    
    this.gbc.insets = new Insets(60,1110,0,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 0;
    componentsPanel.add(backButton,gbc);
    
    this.speed.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 32f));
    this.gbc.insets = new Insets(50,75,350,140);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    componentsPanel.add(speed,gbc);
    
    this.accuracy.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 32f));
    this.gbc.insets = new Insets(50,700,350,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    componentsPanel.add(accuracy,gbc);
    
    
    this.gbc.insets = new Insets(180,290,0,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    componentsPanel.add(graph,gbc);
    
    
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
    
    SelectionController studentSelectionController = new SelectionController(this.classList, this.model, "TeacherDashboard10");
    this.classList.addListSelectionListener(studentSelectionController);
    
  }//end registerControllers
  
  //updates the view
  public void update()
  {
    this.name.setText(this.studentNames[this.studentIndex]);
       selectedStudent= this.teacher.findStudent(this.name.getText());
    this.speed.setText("Top Typing Speed: " +Integer.toString(selectedStudent.getTopTypeSpeed()) + " WPM");
    this.accuracy.setText("Average Accuracy: " + Float.toString(selectedStudent.getAccuracy()) +"%");
    this.graph.setSpeeds(this.selectedStudent.getTypeSpeedArray(),"Last 5 Typing Speeds in Practice Mode (WPM)");
  }//end update
  
}//ssalc