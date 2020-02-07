import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class NewUserController implements MouseListener
{
 private Teacher loggedInTeacher;
 
 private JTextField username;
 private JTextField password;
 
 private JButton bt;
 private FrameModel model;
 
 private String controllerType;
 public NewUserController(JButton button, FrameModel md, JTextField usernameField, JTextField passwordField, Teacher currentTeacher)
 {
  this.bt=button;
  this.model=md;
  this.loggedInTeacher=currentTeacher;
  this.password = passwordField;
  this.username = usernameField;
  this.controllerType="NewStudent";
 }
 public NewUserController(JButton button, FrameModel md, JTextField usernameField,JTextField passwordField)
 {
  this.bt=button;
  this.model=md;
  this.password = passwordField;
  this.username = usernameField;
  this.controllerType="NewTeacher";
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
  if(this.controllerType.equals("NewStudent")&& !(this.username.getText().equals("")) && !(this.password.getText().equals("")))
  {
    this.loggedInTeacher.newStudent(this.username.getText(),this.password.getText());
    this.model.switchPanel("TeacherDashboard3");
  }
  else if(this.controllerType.equals("NewTeacher")&& !(this.username.getText().equals("")) && !(this.password.getText().equals("")))
  {
    this.createTeacher();
    this.model.switchPanel("Logout");
  }
 }
 
 private void createTeacher()
 {
   try
  {
     File teacherAccounts = new File("Teacher Accounts");
     teacherAccounts.mkdir();
  File teacherFile = new File("Teacher Accounts//"+this.username.getText()+".tta");
  PrintWriter out = new PrintWriter(teacherFile);
  out.println(this.password.getText());
  out.close();
  
  File teacherFolder = new File(this.username.getText()+"Class");
  teacherFolder.mkdir();
   }
   catch(Exception ex)
   {
     
   }
 }
 

}