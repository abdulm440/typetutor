import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class FrameSwitchController implements MouseListener
{
 private JComponent bt;
 private FrameModel model;
 private String switchCode;
 private int studentIndex;
 private Timer timer;
 private Color ogFontColor;
 private Color ogBackgroundColor;
 
 public FrameSwitchController(JComponent button, FrameModel md, String code)
 {
  this.bt=button;
  this.model=md;
  this.switchCode=code;
  this.ogFontColor=this.bt.getForeground();
  this.ogBackgroundColor=this.bt.getBackground();
 }
 public FrameSwitchController(JComponent button, FrameModel md, String code, Timer stopTimer)
 {
  this.bt=button;
  this.model=md;
  this.switchCode=code;
  this.timer = stopTimer;
  this.ogFontColor=this.bt.getForeground();
  this.ogBackgroundColor=this.bt.getBackground();
 }
 
 public FrameSwitchController(JComponent button, FrameModel md, String code, int studentIndex)
 {
  this.bt=button;
  this.model=md;
  this.switchCode=code;
  this.studentIndex=studentIndex;
  this.ogFontColor=this.bt.getForeground();
  this.ogBackgroundColor=this.bt.getBackground();
 }
 
 public void mouseEntered(MouseEvent e)
 {
  bt.setOpaque(true);
  bt.setForeground(new Color(241, 248, 108));
  //bt.setBorder(BorderFactory.createRaisedBevelBorder());
  bt.setBackground(Color.BLACK);
 }
 public void mouseExited(MouseEvent e)
 {
  bt.setOpaque(true);
  bt.setBackground(this.ogBackgroundColor);
 // bt.setBorder(BorderFactory.createRaisedBevelBorder());
  bt.setForeground(this.ogFontColor); 
 }
 public void mouseReleased(MouseEvent e)
 {

 }
 public void mousePressed(MouseEvent e)
 {

 }
 public void mouseClicked(MouseEvent e)
 {
   try
   {
    this.timer.stopTimerDecreasing(); 
   }
   catch(Exception ex)
   {
     
   }
  if(this.switchCode.equals("TeacherDashboard5"))
  {
   this.model.switchPanel(this.switchCode,this.studentIndex);
   this.model.switchPanel(this.switchCode);
  }
  
  else if(this.switchCode.equals("TeacherDashboard6"))
  {
   this.model.switchPanel(this.switchCode,this.studentIndex);
   this.model.switchPanel(this.switchCode);
  }
  
  else if(this.switchCode.equals("TeacherDashboard7"))
  {
   this.model.switchPanel(this.switchCode,this.studentIndex);
  }
  
  else if(this.switchCode.equals("TeacherDashboard8"))
  {
   this.model.switchPanel(this.switchCode,this.studentIndex);
  }
  
  else if(this.switchCode.equals("TeacherDashboard9"))
  {
   this.model.switchPanel(this.switchCode,this.studentIndex);
  }
  
  else if(this.switchCode.equals("TeacherDashboard10"))
  {
   this.model.switchPanel(this.switchCode,this.studentIndex);
  }
  
  else 
  {
   this.model.switchPanel(this.switchCode);
  }
 }
 
 

}