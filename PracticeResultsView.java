import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PracticeResultsView extends JPanel
{
  private FrameModel frameModel;
  private JFrame window;
  private ArrayList<Integer> graphSpeeds;
  private Student user;
  private int finalAccuracy;
  private int finalSpeed;
  
  private Graph timeSpeeds;
  private JLabel resultsLabel = new JLabel("Practice Results");
  private JLabel speedLabel = new JLabel();
  private JLabel accuracyLabel = new JLabel();
  private CustomButton next = new CustomButton("Next",300,100,50f);
  
  private JPanel titlePanel = new JPanel();
  private JPanel speedPanel = new JPanel();
  private JPanel accuracyPanel = new JPanel();
  private JPanel graphPanel = new JPanel();
  private JPanel buttonPanel = new JPanel();
  private BoxLayout mainLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
  
  public PracticeResultsView(FrameModel model, JFrame frame, ArrayList<Integer> speedsOverTime, Student currentUser, int speed, int accuracy)
  {
    this.frameModel = model;
    this.window = frame;
    this.graphSpeeds = speedsOverTime;
    this.user=currentUser;
    this.finalSpeed = speed;
    this.finalAccuracy = accuracy;
     
    
    this.layoutView();
    this.registerControllers();
    
    this.user.addTypeSpeed(this.finalSpeed);
    this.user.addAccuracy(this.finalAccuracy);
  }
  
  private void layoutView()
  {
    this.setLayout(mainLayout);
    this.setBackground(new Color(56,182,255));
    
    this.resultsLabel.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",50f));
    this.resultsLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
    
    this.speedLabel.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
    this.accuracyLabel.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
    
    this.speedLabel.setText("Session Speed: " + this.finalSpeed + " WPM");
    this.accuracyLabel.setText("Session Accuracy: " + this.finalAccuracy + "%");
    
    this.timeSpeeds = new Graph(this.graphSpeeds,"Speed Over Time in Practice Session (WPM)");
    this.timeSpeeds.setPreferredSize(new Dimension(650,450));
    
    this.buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
    
    this.titlePanel.add(resultsLabel);
    this.titlePanel.setOpaque(false);
   
    this.speedPanel.add(speedLabel);
    this.speedPanel.setOpaque(false);
 
    this.accuracyPanel.add(accuracyLabel);
    this.accuracyPanel.setOpaque(false);
  
    this.graphPanel.add(timeSpeeds);
    this.graphPanel.setOpaque(false);
  
    this.buttonPanel.add(next);
    this.buttonPanel.setOpaque(false);
   
    
    this.add(titlePanel);
    this.add(speedPanel);
    this.add(accuracyLabel);
    this.add(graphPanel);
    this.add(buttonPanel);
    
    
     this.window.setSize(1366,768);
    this.window.setTitle("Practice Results");
    this.window.setLocation(0,0);
    this.window.setContentPane(this);
    this.window.setVisible(true);
    
  }
  private void registerControllers()
  {
    FrameSwitchController showMenu = new FrameSwitchController(this.next,this.frameModel,"Menu");
    this.next.addMouseListener(showMenu);
    
  }
}