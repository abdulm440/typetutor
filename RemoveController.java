import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class RemoveController implements MouseListener
{
 private Teacher loggedInTeacher;
 
 private String studentToRemove;
 
 private JButton bt;
 private FrameModel model;
 public RemoveController(JButton button, FrameModel md, String name, Teacher currentTeacher)
 {
  this.bt=button;
  this.model=md;
  this.loggedInTeacher=currentTeacher;
  this.studentToRemove = name;
 }
 
 public void mouseEntered(MouseEvent e)
 {
  bt.setOpaque(true);
  bt.setForeground(new Color(241,248,108));
  bt.setBorder(BorderFactory.createRaisedBevelBorder());
  bt.setBackground(Color.BLACK);
 }
 public void mouseExited(MouseEvent e)
 {
  bt.setOpaque(true);
  bt.setBackground(new Color(241,248,108));
  bt.setBorder(BorderFactory.createRaisedBevelBorder());
  bt.setForeground(Color.BLACK); 
 }
 public void mouseReleased(MouseEvent e)
 {

 }
 public void mousePressed(MouseEvent e)
 {

 }
 public void mouseClicked(MouseEvent e) 
 {
  this.loggedInTeacher.removeStudent(this.studentToRemove);
  this.model.switchPanel("TeacherDashboard3");
 }
 
 

}