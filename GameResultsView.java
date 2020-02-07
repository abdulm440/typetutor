import javax.swing.*;
import java.awt.*;

public class GameResultsView extends WallPaperPanel
{
  private JPanel firstRow = new JPanel(); //Holds title
  private JPanel secondRow = new JPanel(); //Holds WPM results
  private JPanel thirdRow = new JPanel(); //Holds accuracy results
  private JPanel fourthRow = new JPanel(); //Holds status (pass/fail)
  private JPanel fifthRow = new JPanel(); // Holds next button
  
  private JLabel resultsLabel = new JLabel();
  private JLabel wpmLabel = new JLabel();
  private JLabel accuracyLabel = new JLabel();
  private JLabel statusLabel = new JLabel();
  private CustomButton next = new CustomButton("Next",300,80,50f);
  
  private FrameModel frameModel;
  private JFrame window;
  private Student currentStudent;
  private int minSpeed;
  private int minAccuracy;
  private int speed;
  private int accuracy;
    
  private BoxLayout mainLayout = new BoxLayout(this,BoxLayout.Y_AXIS);
  public GameResultsView(FrameModel model, JFrame frame,Student user, int reqSpeed, int reqAccuracy, int actualSpeed, int actualAccuracy)
  {
    super();
    this.frameModel = model;
    this.window = frame;
    this.currentStudent = user;
    this.minSpeed=reqSpeed;
    this.minAccuracy = reqAccuracy;
    this.speed=actualSpeed;
    this.accuracy = actualAccuracy;
    
    this.layoutView();
    this.registerControllers();
  }
  
   public void layoutView()
   {
     this.setLayout(mainLayout);
     this.resultsLabel.setText("Results");
     this.resultsLabel.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",50f));
     this.resultsLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
     
     if(this.speed<this.minSpeed)
     {
      this.wpmLabel.setForeground(Color.RED); 
     }
     this.wpmLabel.setText("Typing Speed: "+this.speed+" WPM (Required "+ this.minSpeed +" WPM)");
     this.wpmLabel.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
     
     if(this.accuracy<this.minAccuracy)
     {
      this.accuracyLabel.setForeground(Color.RED); 
     }
     this.accuracyLabel.setText("Accuracy: "+this.accuracy+"% (Required "+this.minAccuracy+"%)");
     this.accuracyLabel.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
     
     this.statusLabel.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
     if(this.accuracy<this.minAccuracy || this.speed<this.minSpeed)
     {
       this.statusLabel.setText("Level Failed");
       this.statusLabel.setForeground(Color.RED);
     }
     else
     {
       this.statusLabel.setForeground(Color.GREEN);
       this.statusLabel.setText("Level Completed");
       this.currentStudent.unlockNextStage();
     }
     
     firstRow.add(resultsLabel);
     firstRow.setOpaque(false);
     
     secondRow.add(wpmLabel);
     secondRow.setOpaque(false);
     
     thirdRow.add(accuracyLabel);
     thirdRow.setOpaque(false);
     
     fourthRow.add(statusLabel);
     fourthRow.setOpaque(false);
     
     fifthRow.add(next);
     fifthRow.setOpaque(false);
     
     this.add(firstRow);
     this.add(secondRow);
     this.add(thirdRow);
     this.add(fourthRow);
     this.add(fifthRow);
       
     this.window.setSize(1366,768);
    this.window.setTitle("Results");
    this.window.setLocation(0,0);
    this.window.setContentPane(this);
    this.window.setVisible(true);
   }
   public void registerControllers()
   {
     FrameSwitchController backToSelection = new FrameSwitchController(this.next,this.frameModel,"Play");
     next.addMouseListener(backToSelection);
   }
  
  
  
  
  
}