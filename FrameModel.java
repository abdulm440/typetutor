import javax.swing.*;

public class FrameModel
{
  private JFrame window;
  private LoginModel loginModel;
  private Student user;
  private Teacher teacher;
  public FrameModel(JFrame frame, LoginModel model, Student loggedInUser)
  {
    this.window=frame;
    this.loginModel = model;
    this.user=loggedInUser;
     
  }
  
  public FrameModel(JFrame frame, LoginModel model, Teacher loggedInTeacher)
  {
    this.window=frame;
    this.loginModel = model;
    this.teacher=loggedInTeacher;
    
  }
   public FrameModel(JFrame frame, LoginModel model)
  {
     this.window=frame;
     this.loginModel = model;
     
  }
  
  public void switchPanel(String code)
  {
    
    if(code.equals("Menu"))
    {
      displayMenu();
    }
    
    if(code.equals("TeacherDashboard1"))
    {
      displayTeacher(1); 
    }
    
    else if(code.equals("TeacherDashboard2"))
    {
      displayTeacher(2); 
    }
    
    else if(code.equals("TeacherDashboard3"))
    {
      displayTeacher(3); 
    }
    
    else if(code.equals("TeacherDashboard4"))
    {
      displayTeacher(4); 
    }
    
    else if(code.equals("Logout"))
    {
      logOut();
    }
    else if(code.equals("Learn1"))
    {
      displayLearnView(1);
    }
    else if(code.equals("Learn2"))
    {
      displayLearnView(2);
    }
    else if(code.equals("Learn3"))
    {
      displayLearnView(3);
    }
    else if(code.equals("Learn4"))
    {
      displayLearnView(4);
    }
    else if(code.equals("Learn5"))
    {
      displayLearnView(5);
    }
    else if(code.equals("Practice"))
    {
      displayPractice();
    }
    else if(code.equals("Play"))
    {
      displayLevelSelection();
    }
    
    else if(code.equals("Intro1"))
    {
      
      displayGameIntro(1); 
    }
    else if(code.equals("Intro2"))
    {
      
      displayGameIntro(2); 
    }
    else if(code.equals("Intro3"))
    {
      
      displayGameIntro(3); 
    }
    else if(code.equals("Intro4"))
    {
      
      displayGameIntro(4); 
    }
    else if(code.equals("Intro5"))
    {
      
      displayGameIntro(5); 
    }
    else if(code.equals("Intro6"))
    {
      
      displayGameIntro(6); 
    }
    else if(code.equals("Intro7"))
    {
      
      displayGameIntro(7); 
    }
    else if(code.equals("Intro8"))
    {
      
      displayGameIntro(8); 
    }
    else if(code.equals("Intro9"))
    {
      
      displayGameIntro(9); 
    }
    else if(code.equals("Intro10"))
    {
      
      displayGameIntro(10); 
    }
    else if(code.equals("level1"))
    {
      displayLevel(1);
    }
    else if(code.equals("level2"))
    {
      displayLevel(2);
    }
    else if(code.equals("level3"))
    {
      displayLevel(3);
    }
    else if(code.equals("level4"))
    {
      displayLevel(4);
    }
    else if(code.equals("level5"))
    {
      displayLevel(5);
    }
    else if(code.equals("level6"))
    {
      displayLevel(6);
    }
    else if(code.equals("level7"))
    {
      displayLevel(7);
    }
    else if(code.equals("level8"))
    {
      displayLevel(8);
    }
    else if(code.equals("level9"))
    {
      displayLevel(9);
    }
    else if(code.equals("level10"))
    {
      displayLevel(10);
    }
    
    else if(code.equals("RestartPractice"))
    {
      displayPractice();
    }
    else if(code.equals("NewTeacher"))
    {
     displayNewTeacherPanel(); 
    }
  }
  
  public void switchPanel(String code, int studentIndex)
  { 
    if(code.equals("TeacherDashboard5"))
    {
      displayTeacher(5,studentIndex); 
    }
    
    else if(code.equals("TeacherDashboard6"))
    {
      displayTeacher(6,studentIndex); 
    }
    
    else if(code.equals("TeacherDashboard7"))
    {
      displayTeacher(7,studentIndex); 
    }
    
    else if(code.equals("TeacherDashboard8"))
    {
      displayTeacher(8,studentIndex); 
    }
    
    else if(code.equals("TeacherDashboard9"))
    {
      displayTeacher(9,studentIndex); 
    }
    
    else if(code.equals("TeacherDashboard10"))
    {
      displayTeacher(10,studentIndex); 
    }
  }
  
  private void displayPractice()
  {
    PracticeView newPractice = new PracticeView(this,window, this.user); 
  }
  
  private void displayLevel(int level)
  {
    switch(level)
    {
      case 1: GameView newView1 = new GameView(this.user,this,this.window,1,20,75,true);break; 
      case 2: GameView newView2 = new GameView(this.user,this,this.window,2,30,85,true);break; 
      case 3: GameView newView3 = new GameView(this.user,this,this.window,3,40,90,true);break; 
      case 4: GameView newView4 = new GameView(this.user,this,this.window,4,50,95,true);break; 
      case 5: GameView newView5 = new GameView(this.user,this,this.window,5,60,98,true);break; 
      case 6: GameView newView6 = new GameView(this.user,this,this.window,6,25,90,false);break; 
      case 7: GameView newView7 = new GameView(this.user,this,this.window,7,30,92,false);break; 
      case 8: GameView newView8 = new GameView(this.user,this,this.window,8,40,95,false);break; 
      case 9: GameView newView9 = new GameView(this.user,this,this.window,9,50,98,false);break; 
      case 10: GameView newView10 = new GameView(this.user,this,this.window,10,75,98,false);break; 
    }
  }
  
  private void displayLearnView(int number)
  {
    if(number==1)
    {  
      LearnView1 newLearnView = new LearnView1(this,window);
    }
    else if(number==2)
    {
      LearnView2 newLearnView = new LearnView2(this,window);
    }
    else if(number==3)
    {
      LearnView3 newLearnView = new LearnView3(this,window);
    }
    else if(number==4)
    {
      LearnView4 newLearnView = new LearnView4(this,window);
    }
    else if(number==5)
    {
      LearnView5 newLearnView = new LearnView5(this,window);
    }
    
  }
  private void displayMenu()
  {
    MenuView newMenuView = new MenuView(window,this,this.user);
  }
  
  private void logOut()
  {
    LoginView newMenuView = new LoginView(loginModel,window);
  }
  
  private void displayLevelSelection()
  {
    LevelSelectView newLevelSelectView = new LevelSelectView(this,window,this.user); 
  }
  
  private void displayTeacher(int number)
  {
    if(number==1)
    {
      TeacherDashboardView1 newDashboard = new TeacherDashboardView1(this,window,this.teacher); 
    }
    
    else if(number==2)
    {
      TeacherDashboardView2 newDashboard = new TeacherDashboardView2(this,window,this.teacher); 
    }
    
    else if(number==3)
    {
      TeacherDashboardView3 newDashboard = new TeacherDashboardView3(this,window,this.teacher);
      
    }
    
    else if(number==4)
    {
      TeacherDashboardView4 newDashboard = new TeacherDashboardView4(this,window,this.teacher); 
    }
    
    
  }//end displayTeacher
  
  private void displayTeacher(int number, int studentIndex)
  {  
    if(number==5)
    {
      TeacherDashboardView5 newDashboard = new TeacherDashboardView5(this,window,studentIndex,this.teacher); 
    }
    
    
    else if(number==6)
    {
      TeacherDashboardView6 newDashboard = new TeacherDashboardView6(this,window,studentIndex,this.teacher); 
    }
    
    else if(number==7)
    {
      TeacherDashboardView7 newDashboard = new TeacherDashboardView7(this,window,studentIndex,this.teacher); 
    }
    
    else if(number==8)
    {
      TeacherDashboardView8 newDashboard = new TeacherDashboardView8(this,window,studentIndex, this.teacher); 
    }
    else if(number==9)
    {
      TeacherDashboardView9 newDashboard = new TeacherDashboardView9(this,window,studentIndex, this.teacher); 
    }
    else if(number==10)
    {
      TeacherDashboardView10 newDashboard = new TeacherDashboardView10(this,window,studentIndex, this.teacher); 
    }
    
  }//end displayTeacher
  
  private void displayGameIntro(int level)
  {
    switch(level)
    {
      case 1: IntroGameView newView1 = new IntroGameView(this,window,1,20,75,true);break; 
      case 2: IntroGameView newView2 = new IntroGameView(this,window,2,30,85,true);break; 
      case 3: IntroGameView newView3 = new IntroGameView(this,window,3,40,90,true);break; 
      case 4: IntroGameView newView4 = new IntroGameView(this,window,4,50,95,true);break; 
      case 5: IntroGameView newView5 = new IntroGameView(this,window,5,60,98,true);break; 
      case 6: IntroGameView newView6 = new IntroGameView(this,window,6,25,90,false);break; 
      case 7: IntroGameView newView7 = new IntroGameView(this,window,7,30,92,false);break; 
      case 8: IntroGameView newView8 = new IntroGameView(this,window,8,40,95,false);break; 
      case 9: IntroGameView newView9 = new IntroGameView(this,window,9,50,98,false);break; 
      case 10: IntroGameView newView10 = new IntroGameView(this,window,10,75,98,false);break; 
    }
    
  }
  public void displayNewTeacherPanel()
  {
   NewTeacherView newTeacher = new NewTeacherView(this,this.window); 
    
  }
  
  
}