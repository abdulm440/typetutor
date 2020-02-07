/* LevelSelectView
 * Created by: Johnson Duong
 * Updated on: 2019/05/22
 * The view for the level selection
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LevelSelectView 
{
 //instance variables
 private JFrame window;
 private FrameModel frameModel;
 private JPanel contentPane = new JPanel();
 private JPanel textPanel = new JPanel();
 private JPanel levelsPanel = new JPanel();
 private JLabel instruction = new JLabel("Choose a level");
 private CustomButton level1 = new CustomButton("1",160,160,95);
 private CustomButton level2 = new CustomButton("2",160,160,95);
 private CustomButton level3 = new CustomButton("3",160,160,95);
 private CustomButton level4 = new CustomButton("4",160,160,95);
 private CustomButton level5 = new CustomButton("5",160,160,95);
 private CustomButton level6 = new CustomButton("6",160,160,95);
 private CustomButton level7 = new CustomButton("7",160,160,95);
 private CustomButton level8 = new CustomButton("8",160,160,95);
 private CustomButton level9 = new CustomButton("9",160,160,95);
 private CustomButton level10 = new CustomButton("10",160,160,95);
 private CustomButton backButton = new CustomButton("Back",112, 60, 30);
 private GridBagConstraints gbc = new GridBagConstraints();
 private ArrayList<CustomButton> levelButtons = new ArrayList<CustomButton>();

 private Student loggedInUser;
 //constructor
 public LevelSelectView(FrameModel model, JFrame mainWindow, Student user) 
 {
   this.window = mainWindow;
   this.frameModel = model;
   this.loggedInUser= user;
   this.layoutView();
   this.disableButtons();
   this.registerControllers();
 }//end constructor

 private void layoutView()
 {
  //the instructions
  textPanel.setLayout(new GridBagLayout());
  textPanel.setPreferredSize(new Dimension(1366,245));
  textPanel.setBackground(new Color(56, 183, 255));
  this.instruction.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 55));
  this.gbc.insets = new Insets(0,1085,10,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;

  //the level buttons
  SpringLayout layout = new SpringLayout();
  layout.putConstraint(SpringLayout.WEST, this.level2, 100, SpringLayout.EAST, this.level1); //creates spacing between buttons
  layout.putConstraint(SpringLayout.WEST, this.level3, 100, SpringLayout.EAST, this.level2);
  layout.putConstraint(SpringLayout.WEST, this.level4, 100, SpringLayout.EAST, this.level3);
  layout.putConstraint(SpringLayout.WEST, this.level5, 100, SpringLayout.EAST, this.level4);
  layout.putConstraint(SpringLayout.NORTH, this.level6, 100, SpringLayout.SOUTH, this.level1);
  layout.putConstraint(SpringLayout.WEST, this.level7, 100, SpringLayout.EAST, this.level6);
  layout.putConstraint(SpringLayout.NORTH, this.level7, 100, SpringLayout.SOUTH, this.level2);
  layout.putConstraint(SpringLayout.WEST, this.level8, 100, SpringLayout.EAST, this.level7);
  layout.putConstraint(SpringLayout.NORTH, this.level8, 100, SpringLayout.SOUTH, this.level3);
  layout.putConstraint(SpringLayout.WEST, this.level9, 100, SpringLayout.EAST, this.level8);
  layout.putConstraint(SpringLayout.NORTH, this.level9, 100, SpringLayout.SOUTH, this.level4);
  layout.putConstraint(SpringLayout.WEST, this.level10, 100, SpringLayout.EAST, this.level9);
  layout.putConstraint(SpringLayout.NORTH, this.level10, 100, SpringLayout.SOUTH, this.level5);

  levelsPanel.setLayout(layout);
  levelsPanel.setPreferredSize(new Dimension(1200,500));
  levelsPanel.setBackground(new Color(56, 183, 255));
  
  //the window
  textPanel.add(instruction);
  textPanel.add(backButton,gbc);
  levelsPanel.add(level1);
  levelsPanel.add(level2);
  levelsPanel.add(level3);
  levelsPanel.add(level4);
  levelsPanel.add(level5);
  levelsPanel.add(level6);
  levelsPanel.add(level7);
  levelsPanel.add(level8);
  levelsPanel.add(level9);
  levelsPanel.add(level10);

  
  contentPane.add(textPanel);
  contentPane.add(levelsPanel);
  contentPane.setBackground(new Color(56, 183, 255));

  window.setTitle("Learning Mode");
  window.setContentPane(contentPane);
  window.setSize(1366, 768);
  window.setVisible(true);

 }//end layoutView

 private void registerControllers()
 {
   for(int x = 0;x<levelButtons.size();x++)
   {
     if(this.levelButtons.get(x).isEnabled()==true)
     {
    FrameSwitchController buttonController = new FrameSwitchController(levelButtons.get(x),this.frameModel,"Intro"+(x+1)); 
   this.levelButtons.get(x).addMouseListener(buttonController);
     }
   }

  FrameSwitchController backController = new FrameSwitchController(backButton,frameModel,"Menu");
  backButton.addMouseListener(backController);

 }//end registerControllers
 
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
  
  for(int x = 9;x>this.loggedInUser.getStagesUnlocked()-1;x--)
  {
   levelButtons.get(x).setEnabled(false); 
  }
   
 }
 
}//ssalc
