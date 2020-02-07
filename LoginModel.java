import java.io.*;
import javax.swing.*;
import java.util.*;

public class LoginModel
{
  private LoginView view;
  private String status;
  private JFrame window;
  public LoginModel(JFrame frame)
  {
    window=frame;
  }
  public void setGUI(LoginView gui)
  {
    this.view= gui;
    this.status="";
  }
  
  public void login(String username, String password) throws java.io.FileNotFoundException, java.io.IOException
  {
    if(checkAccountExists("Teacher Accounts\\"+username+".tta"))
    {
      File accountFile = new File("Teacher Accounts\\"+username+".tta");
      Scanner in = new Scanner(accountFile);
      String realPassword = in.nextLine();
      
      if(realPassword.equals(password))
      {
        
        Teacher loggedInTeacher = new Teacher(username,password,false);
        
        FrameModel model = new FrameModel(window, this,loggedInTeacher);
        
        model.switchPanel("TeacherDashboard1");
      }
      else
      {
        status = "Login Failed";
        this.update();
      }
    }
    else if(checkForStudentAccount(username)!="")
    {
      File accountFile = new File(checkForStudentAccount(username));
      Scanner in = new Scanner(accountFile);
      if(in.nextLine().equals(password))
      {
        try
        {
          
          int stagesUnlocked = Integer.parseInt(in.nextLine());
          
          float accuracy = Float.parseFloat(in.nextLine());
          int topTypingSpeed = Integer.parseInt(in.nextLine());
          StringTokenizer speeds = new StringTokenizer(in.nextLine());
          in.close();
          
         String path = checkForStudentAccount(username);
         
          ArrayList<Integer> typingSpeeds = generateArrayList(speeds);
          Student user = new Student(username,password,stagesUnlocked,accuracy,topTypingSpeed,typingSpeeds,path);
          FrameModel model = new FrameModel(window, this,user);
          model.switchPanel("Menu");
         
        }
        catch(Exception ex)
        {
          status="Account Corrupted.Please contact teacher";
          this.update();
        }
      }
      else
      {
        status = "Login Failed";
        this.update();
      }
    }
    else
    {
      status = "Login Failed";
      this.update();
    }
  }
  
  private boolean checkAccountExists(String username)
  {
    File accountName = new File(username);
    if(accountName.exists())
    {
      return true; 
    }
    return false;
  }
  private void update()
  {
    this.view.update(); 
  }
  public String getStatus()
  {
    return status; 
  }
  private ArrayList<Integer> generateArrayList(StringTokenizer speeds)
  {
    ArrayList<Integer> generatedList = new ArrayList<Integer>();
    while(speeds.hasMoreTokens())
    {
      generatedList.add(Integer.parseInt(speeds.nextToken()));
    }
    return generatedList;
  }
  public String checkForStudentAccount(String username)
  {
    File teacherAccountsFolder = new File("Teacher Accounts");
    File[] teachers =  teacherAccountsFolder.listFiles();
  
    String[] teacherNames = new String[teachers.length];
    
    for(int x = 0;x<teachers.length;x++)
    {
      teacherNames[x] = teachers[x].getName().substring(0,teachers[x].getName().length()-4);
    
    }
    String studentAccount="";
    for(String teacherFolder : teacherNames)
    {
      File teacherFolderName = new File(teacherFolder+"Class");
      for(File studentFiles : teacherFolderName.listFiles())
      {
       
        if(username.equals(studentFiles.getName().substring(0,studentFiles.getName().length()-4)))
        {
          studentAccount = teacherFolderName.getName()+"\\"+ username+".tta";
             return studentAccount;
        }
        
      }
      
    }

  return studentAccount;
  }
}