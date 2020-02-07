import java.awt.*;
import java.awt.Color.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.util.*;
import javax.swing.border.TitledBorder.*;
import javax.swing.border.*;

public class PracticeView extends TypingViewTemplate 
{  
  private FrameModel model; 
  private JFrame window;
  
  private GridLayout g1 = new GridLayout(6,1);
  
  private GridLayout g2 = new GridLayout(1,3);
  private JPanel p2 = new JPanel();
  
  private JLabel accuracy = new JLabel("Accuracy:", JLabel.CENTER);
  private JLabel title = new JLabel("Practice Mode", JLabel.CENTER);
  private JLabel time = new JLabel("Time: 1:30", JLabel.CENTER);
  
  private JPanel p3 = new JPanel();
  private FlowLayout f1 = new FlowLayout();
  private JTextField randomText = new JTextField(40);
  
  private JLabel space = new JLabel("        ");
  
  private JPanel p4 = new JPanel();
  private FlowLayout f2 = new FlowLayout();
  private JTextField userText = new JTextField(33);
  
  
  private JLabel space2 = new JLabel("        ");
  
  private JPanel p5 = new JPanel();
  private GridLayout g3 = new GridLayout(1,2);
  
  private JPanel p6 = new JPanel();
  private FlowLayout f3 = new FlowLayout();
  private JButton back = new JButton("Back");
  private JButton restart = new JButton("Restart");
  
  private TypingModel typeModel;
  private ArrayList<Object> highlights = new ArrayList<Object>();
  private Timer timer= new Timer(this);
  private ArrayList<Integer> speedOverTime = new ArrayList<Integer>();
  private Student user;
  public PracticeView(FrameModel model, JFrame main, Student student) 
  {
    super();
    this.model = model;
    this.window=main;
    this.layoutView();
    this.typeModel = new TypingModel();
    this.user = student;
    this.typeModel.setGUI(this);
    this.typeModel.setTextGenerated();
    this.registerControllers();
    this.update();
   this.updateTimer();
   this.speedOverTime.add(0);
  }
  
  private void layoutView() 
  {
    this.setBackground(new Color(56,182,255));
    this.setLayout(g1);
    
    this.p2.setBackground(new Color(56,182,255));
    this.p2.setLayout(g2);
    this.add(p2);
    this.accuracy.setFont(UIMethods.deriveFont("Barlow-Light.ttf",25f));
    this.p2.add(accuracy);
    
    this.title.setForeground(Color.BLACK);
    this.title.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",50f));
    this.p2.add(title);
    this.time.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
    this.p2.add(time);
    
    this.p3.setBackground(new Color(56,182,255));
    this.p3.setLayout(f1);
    this.add(p3);
    this.randomText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",30f));
    while(this.randomText.getText().length()==0)
    {
    this.randomText.setText(TextGenerator.generateText());
    }
    this.randomText.setBackground(new Color(198, 228, 239));
    this.randomText.setEditable(false);
    //this.randomText.setLineWrap(true);
    this.randomText.setDisabledTextColor(Color.BLACK);
   // this.randomText.setWrapStyleWord(true);
    //this.randomText.setPreferredSize(new Dimension(1250,350));
    this.randomText.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
    this.p3.add(randomText);
    
    
    this.add(space);
    
    
    this.p4.setBackground(new Color(56,182,255));
    this.p4.setLayout(f2);
    this.add(p4);
    
    this.userText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",30f));
    this.userText.setBorder(BorderFactory.createEmptyBorder(20,0,20,220));
   // this.userText.setPreferredSize(new Dimension(1250,250));
   // this.userText.setLineWrap(true);
    //this.userText.setWrapStyleWord(true);
    this.userText.setText(" Click here to start typing...");
    
    this.p4.add(userText);
    
    
    this.add(space2);
    
    
    this.p5.setBackground(new Color(56,182,255));
    this.p5.setLayout(g3);
    this.add(p5);
    
    this.p6.setBackground(new Color(56,182,255));
    this.p6.setLayout(f2);
    this.p5.add(p6);
    
    this.back.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",50f));
    this.back.setPreferredSize(new Dimension(300, 100));
    this.back.setBackground(new Color(241, 248, 108));
    this.back.setOpaque(true);
    this.back.setBorderPainted(false);
    this.p6.add(back);
    this.back.setFocusPainted(false);
    
    this.restart.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",50f));
    this.restart.setPreferredSize(new Dimension(300, 100));
    this.restart.setBackground(new Color(241, 248, 108));
    this.restart.setOpaque(true);
    this.restart.setBorderPainted(false);
    this.p6.add(restart);
    this.restart.addMouseListener(new FrameSwitchController(restart,model,"restart"));
    this.restart.setFocusPainted(false);
    
   // this.userText.setHorizontalAlignment(JTextField.CENTER);
    
    this.window.setSize(1366,768);
    this.window.setTitle("Practice View");
    this.window.setLocation(0,0);
    this.window.setContentPane(this);
    this.window.setVisible(true);
   
    this.randomText.setCaretPosition(0);
  }
  
  private void registerControllers()
  {
    this.userText.addKeyListener(new KeyListener(this.typeModel, true));
    this.back.addMouseListener(new FrameSwitchController(back,model,"Menu",this.timer));
    this.restart.addMouseListener(new FrameSwitchController(restart,model,"RestartPractice",this.timer));
    this.userText.addMouseListener(new ClearController(this,this.userText," Click here to start typing..."));
  }
  
  public void update()
  {
   
    if(typeModel.getCommand().equals("Correct"))
    {
     setPosition("Correct");
      try
      {
        Highlighter highlighter = randomText.getHighlighter();
        HighlightPainter painter = 
          new DefaultHighlighter.DefaultHighlightPainter(new Color(44,234,44));
        int p0 = typeModel.getNextCharIndex();
        int p1 = typeModel.getNextCharIndex()+1;
        highlights.add(highlighter.addHighlight(p0, p1, painter ));
        this.accuracy.setText("Accuracy: " + this.typeModel.getAccuracy()+ "%");
      }
      catch(Exception ex)
      {
        
      }
    }
    else if(typeModel.getCommand().equals("Incorrect"))
    {
      try
      {
         setPosition("Incorrect");
        Highlighter highlighter = randomText.getHighlighter();
        HighlightPainter painter = 
          new DefaultHighlighter.DefaultHighlightPainter(Color.red);
        int p0 = typeModel.getNextCharIndex();
        int p1 = typeModel.getNextCharIndex()+1;
        highlights.add(highlighter.addHighlight(p0, p1, painter ));
        this.accuracy.setText("Accuracy: " + this.typeModel.getAccuracy()+ "%");
      }
      catch(Exception ex)
      {
        
      }
    }
    else if(typeModel.getCommand().equals("Backspace"))
    {
      setPosition("Backspace");
         Highlighter highlighter = randomText.getHighlighter();
        HighlightPainter painter = 
          new DefaultHighlighter.DefaultHighlightPainter(Color.red);
        highlighter.removeHighlight(highlights.get(highlights.size()-1));
        highlights.remove(highlights.size()-1);
        this.accuracy.setText("Accuracy: " + this.typeModel.getAccuracy()+ "%");
    }
    
  }
  public void updateTimer()
  {
   
   this.time.setText(timer.getCurrentTime());
  if(this.timer.getCurrentTime().equals("1:12") || this.timer.getCurrentTime().equals("0:54") || this.timer.getCurrentTime().equals("0:36") || this.timer.getCurrentTime().equals("0:18"))
  {
    this.speedOverTime.add(this.typeModel.getRecentSpeed());
  }
   //this.typeModel.calculateWPM(timer.getSecondsPassed()); 
   if(timer.getCurrentTime().equals("0:00"))
   {
    this.userText.setEnabled(false);
    this.typeModel.calculateWPM(90);
    this.speedOverTime.add(this.typeModel.getRecentSpeed());
    System.out.println(speedOverTime);
    PracticeResultsView showResults = new PracticeResultsView(this.model,this.window,this.speedOverTime,this.user, this.typeModel.getRecentSpeed(),this.typeModel.getRecentAccuracy());
    
   }
  }
  public String getTextGenerated()
  {
   return this.randomText.getText(); 
  }
  public int getTimePassed()
  {
   return this.timer.getSecondsPassed(); 
  }
  public void setPosition(String code)
  {
    if(code.equals("Backspace"))
    {
      if(this.userText.getText().length()>15)
      {
      this.randomText.setCaretPosition(this.userText.getText().length()-15);
      }
      else
      {
        this.randomText.setCaretPosition(this.userText.getText().length()-1);
      }
    }
    else
    {
       this.randomText.setCaretPosition(this.userText.getText().length()+15);
    }
    
  }
  public void startSession()
  {
      try
    {
   Thread timerThread = new Thread(timer);
   timerThread.start();
   
    }
    catch(Exception ex)
    {
      
    }
  }
  
}