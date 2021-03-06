/* Student
 * Created by: Johnson Duong
 * Updated on: 2019/05/21
 * The Student Account class
 */

import java.io.*;
import java.util.*;

public class Student
{
 //instance variables
 private String username;
 private String password;
 private String teacherPath;
 private int stagesUnlocked;
 private float accuracy;
 private int topTypeSpeed;
 private ArrayList<Integer> typeSpeedArray = new ArrayList<Integer>();
  
 //first constructor for the creation of a new Student
 public Student(String username, String password, String teacher)
 {
  this.username = username;  
  this.password = password;
  this.teacherPath = teacher+"Class//"+username+".tta";
  this.stagesUnlocked = 1;
  this.accuracy = 0;
  this.topTypeSpeed = 0;
  this.typeSpeedArray.add(0);
  this.createAccount();
  
 }//end first constructor
 
 //second constructor for an existing Student
 public Student(String username, String password, int stagesUnlocked, float accuracy, int topTypeSpeed, ArrayList<Integer> typeSpeedArray, String teacherName)
 {
  this.username = username;  
  this.password = password;  
  this.stagesUnlocked = stagesUnlocked;
  this.accuracy = accuracy;
  this.topTypeSpeed = topTypeSpeed;
  this.typeSpeedArray = typeSpeedArray;
  this.teacherPath = teacherName;
  System.out.println(teacherPath);
 }//end second constructor
 
 //accessor method to get password
 public String getPassword()
 {
  return this.password;
  
 }//end getPassword
 
 //accessor method to get the number of unlocked stages
 public int getStagesUnlocked()
 {
  return this.stagesUnlocked;
  
 }//end getStagesUnlocked
 
 //accessor method to get the user's accuracy
 public float getAccuracy()
 {
  return this.accuracy;
  
 }//end getAccuracy
 
 //accessor method to get the top type speed
 public int getTopTypeSpeed()
 {
  return this.topTypeSpeed;
  
 }//end getTopTypeSpeed
 
 //accessor method to get the list of type speeds
 public ArrayList<Integer> getTypeSpeedArray()
 {
  return this.typeSpeedArray;
  
 }//end getTypeSpeedArray
 
 //gets input from a model and changes the password
 public void changePassword(String newPassword) 
 {
  this.password = newPassword;
  
  //outputs updated information to the Student account file
  this.createAccount();
  
 }//end changePassword
 
 //gets a type speed from a model and adds it into the Student account's file
 public void addTypeSpeed(int typeSpeed) 
 {
  this.typeSpeedArray.add(typeSpeed);
  
  //replaces the current top type speed with the new speed if it is faster
  if(typeSpeed > topTypeSpeed)
  {
   this.topTypeSpeed = typeSpeed; 
  }//fi
  
  //outputs updated information to the Student account file
  this.createAccount();
  
 }//end addTypeSpeed

 //creates a Student Account file containing the user's data
 private void createAccount()
 {

  try
  {
  File studentFile = new File(this.teacherPath);//CHANGE PATH 
  PrintWriter out = new PrintWriter(studentFile);
    
  //outputs Student information into a text file in the following order
  out.println(this.password);
  out.println(this.stagesUnlocked);
  out.println(this.accuracy);
  out.println(this.topTypeSpeed);
  for(Integer i : this.typeSpeedArray)
  {
   out.print(i + " ");
  }//rof
  out.close();
  }
  catch(FileNotFoundException ex)
  {
    System.out.println("NOT DONE");
  }
 }//end createAccount
 

 
 public String getUserName()
 {
  return this.username; 
 }
 public void unlockNextStage()
 {
  if(this.stagesUnlocked<10)
  {
   this.stagesUnlocked++;
   this.createAccount();
  }
 }
 public void addAccuracy(int accuracyToAdd)
 {
  int sessions = this.typeSpeedArray.size();
  float newAccuracy = ((this.accuracy*(sessions-2))+accuracyToAdd)/(float)((sessions-1)*1.0);
  this.accuracy=newAccuracy;
 }
  
}//ssalc