import java.awt.*;
import java.io.*;
import java.util.*; 
import java.io.File;

public class Teacher
{
  private String teacherUsername;
  private String teacherPassword;
  
  private File teacherFile = new File("Teachers");
  
  
  private ArrayList<Student> studentList = new ArrayList<Student>();
  
  private String name;
  
  private File[] listOfStudents;
  
  private String selectedStudent;

  public Teacher(String userName,String password, boolean newAccount) throws java.io.IOException
  {
     
      if(newAccount==true)
      {
        teacherFile.mkdir();
        teacherUsername = userName;
        teacherPassword = password;
        String path = "Teacher Accounts//"+userName+".tta";//CHANGE PATH
        File f = new File(path);
        
        
        if (f.createNewFile())
        {
          System.out.println("File is created!");
        } else {
          System.out.println("File already exists.");
        }
        
        File dir = new File(userName+"Class");
        dir.mkdir();
        
      }
      else 
      {
        teacherUsername = userName;
        teacherPassword = password;
        
        File folder = new File(userName+"Class");
       
        listOfStudents = folder.listFiles();
        
        for (File file : listOfStudents) {
          
            name = file.getName();
            
           
            Scanner in = new Scanner(new File(folder+"//"+name));
            String studentPassword = in.nextLine();
            
            int stagesUnlocked = Integer.parseInt(in.nextLine());
            
            float accuracy = Float.parseFloat(in.nextLine());
            int topTypingSpeed = Integer.parseInt(in.nextLine());
            StringTokenizer speeds = new StringTokenizer(in.nextLine());
            in.close();
            
            ArrayList<Integer> typingSpeeds = generateArrayList(speeds);
            Student user = new Student(name.substring(0,name.length()-4),studentPassword,stagesUnlocked,accuracy,topTypingSpeed,typingSpeeds,this.teacherUsername+"Class/" + name);
            studentList.add(user);
            
        }
      }
      
   
  }
  
  
  
  public void newStudent(String username, String password)
  {
    
    studentList.add(new Student(username,password,this.teacherUsername));
    //Collections.sort(studentList);
    
    
    
    
    
  }
  
  
  public void removeStudent(String username)
  {
    studentList.remove(findStudent(username));
    String path = (teacherUsername+"Class/"+username+".tta");
    File file = new File(path); //CHANGE PATH
    
    
    if(file.delete()) 
    { 
      System.out.println("File deleted successfully"); 
    } 
    else
    { 
      System.out.println("Failed to delete the file"); 
    }
    
    
    
  }
  
  
  public String getTeacherUsername()
  {
    return teacherUsername;
    
  }
  
  public String getTeacherPassword()
  {
    return teacherPassword;
    
  }
  
  public void setTeacherPassword( String newPassword)
  {
   
    try
    {
      File teacher = new File("Teacher Accounts//"+this.teacherUsername+".tta");

      FileWriter writer = new FileWriter(teacher);
      
     
      teacherPassword=newPassword;
      writer.write(this.teacherPassword);
      writer.close();
    }
    catch(Exception ex)
    {
      
    }
      
    
    
  }
  
  
  public String[] getStudents()
  {
    String[] studentNames = new String[studentList.size()];
    for(int x = 0;x<studentList.size();x++)
    {
     studentNames[x] = studentList.get(x).getUserName(); 
    }
    return studentNames;
    
    
    
    
  }
  
  public void changeStudentPassword(String username, String newPassword) throws java.io.FileNotFoundException
  {
   Student selectedStudent = findStudent(username);
      selectedStudent.changePassword(newPassword);
    }
    
     public String getStudentPassword(String username)
  {
   Student selectedStudent = findStudent(username);
      return selectedStudent.getPassword();
    }
  
  
  public Student findStudent(String userName)
  {
    Student foundStudent;
    
    for(Student tempStudent:studentList)
    {
 
      if(tempStudent.getUserName().equals(userName))
      {
         
        foundStudent=tempStudent;
        return foundStudent;
      }
      
    }
    
    return null;
   
  }
  
  
  
  public int getStagesUnlocked(String userName)
  {
    Student currentStudent = findStudent(userName);
    return currentStudent.getStagesUnlocked();
    
    
    
    
  }
  
  public float getAccuracy(String userName)
  {
    Student currentStudent = findStudent(userName);
    return currentStudent.getAccuracy();
    
    
  }
  
  public ArrayList getTypingSpeeds(String userName)
  {
    Student currentStudent = findStudent(userName);
    return currentStudent.getTypeSpeedArray();
    
    
  }
  
  public int getTopTypingSpeeds(String userName)
  {
    Student currentStudent = findStudent(userName);
    return currentStudent.getTopTypeSpeed();
    
    
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
}