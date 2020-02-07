import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class ChangePasswordController implements MouseListener
{
 private Teacher loggedInTeacher;
 private Student selectedStudent;
 
 private JTextField newPassword;
 
 private JButton bt;
 private FrameModel model;
 public ChangePasswordController(JButton button, FrameModel md, JTextField passwordField, Teacher currentTeacher)
 {
  this.bt=button;
  this.model=md;
  this.loggedInTeacher=currentTeacher;
  this.newPassword = passwordField;
 }
 public ChangePasswordController(JButton button, FrameModel md, JTextField passwordField, Student currentStudent)
 {
  this.bt=button;
  this.model=md;
  this.selectedStudent=currentStudent;
  this.newPassword = passwordField;
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
  if(this.newPassword.getText()!="" && this.loggedInTeacher!=null)
  {
   this.loggedInTeacher.setTeacherPassword(this.newPassword.getText());
   this.newPassword.setText("Password Changed!");
   this.newPassword.setForeground(Color.GREEN);
  }
  else if (this.newPassword.getText()!="")
  {
    this.selectedStudent.changePassword(this.newPassword.getText());
    this.newPassword.setText("Password Changed!");
   this.newPassword.setForeground(Color.GREEN);
  }
 }
 
 

}