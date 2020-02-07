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

public class GameView extends TypingViewTemplate
{
  private FrameModel frameModel;
  private JFrame window;
  private JLabel title = new JLabel();
  private JLabel nextChar= new JLabel();
  private JPanel topRow= new JPanel();
  private JPanel userTextPanel= new JPanel();
  private JPanel randomTextPanel= new JPanel();
  private JPanel buttonRow = new JPanel();
  private JPanel wpmPanel = new JPanel();
  private BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
  private BoxLayout firstRow = new BoxLayout(topRow, BoxLayout.X_AXIS);
  private Timer timer = new Timer(this);
  private TimerClock clock = new TimerClock(90);
  private AccuracyMeter meter ;
  private JLabel wordsPerMinute = new JLabel("WPM : 0");
  private WpmMeter words;
  
  private JTextField randomText = new JTextField(40);
  private JTextField userText = new JTextField(33);
  
  private CustomButton back = new CustomButton("Back",300,100,50f);
  private CustomButton restart = new CustomButton("Restart",300,100,50f);
  
  private TypingModel typeModel = new TypingModel();
  private ArrayList<Object> highlights = new ArrayList<Object>();
  
  private int reqSpeed;
  private int reqAccuracy;
  private boolean backSpace;
  private int level;
  private Student user;
  

  
  public GameView(Student currentUser,FrameModel model, JFrame main, int curLevel,int wpm, int accuracy,  boolean backspace)
  {
    this.frameModel =model;
    this.window=main;
    this.user=currentUser;
    this.level=curLevel;
    this.reqSpeed=wpm;
    this.reqAccuracy=accuracy;
    this.backSpace=backspace;
    this.layoutView();
    this.typeModel.setGUI(this);
    this.registerControllers();
    this.typeModel.setTextGenerated();
  }
  private void layoutView()
  {
    this.setBackground(new Color(56,182,255));
    this.setLayout(layout);
    this.words=new WpmMeter(this.reqSpeed);
    this.meter = new AccuracyMeter(this.reqAccuracy);
    topRow.setBackground(new Color(56,182,255));
    wpmPanel.setBackground(new Color(56,182,255));
    randomTextPanel.setBackground(new Color(56,182,255));
    userTextPanel.setBackground(new Color(56,182,255));
    buttonRow.setBackground(new Color(56,182,255));
    topRow.setLayout(firstRow);
    this.nextChar.setText("Next Character: ' '");
    this.nextChar.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",30f));
    this.nextChar.setBorder(BorderFactory.createEmptyBorder(0,20,0,40));
    this.title.setText("Level "+this.level);
    this.title.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",50f));
    this.title.setBorder(BorderFactory.createEmptyBorder(0,200,0,250));
    topRow.add(nextChar);
    topRow.add(title);
    clock.setPreferredSize(new Dimension(40,40));
    
    meter.setPreferredSize(new Dimension(40,40));
    topRow.add(clock);
    
    topRow.add(meter);
    //topRow.setPreferredSize(new Dimension(1344,100));
    wpmPanel.setPreferredSize(new Dimension(1344,150));
    
    words.setPreferredSize(new Dimension(800,75));
    wordsPerMinute.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",30f));
    wordsPerMinute.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
    wpmPanel.add(wordsPerMinute);
    wpmPanel.add(words);
    wpmPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
    this.add(new JLabel("       "));
    this.add(topRow);
    this.add(wpmPanel);
    this.randomText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",30f));
    while(this.randomText.getText().length()==0)
    {
      this.randomText.setText(TextGenerator.generateText());
    }
    this.randomText.setBackground(new Color(198, 228, 239));
    this.randomText.setEditable(false);

    this.randomText.setDisabledTextColor(Color.BLACK);
    this.randomText.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
    randomTextPanel.add(this.randomText);
    this.add(randomTextPanel);
    this.userText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",30f));
    this.userText.setBorder(BorderFactory.createEmptyBorder(20,0,20,220));
    this.userText.setText(" Click here to start typing...");
    if(this.backSpace==false)
    {
     userText.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "none"); 
    }
    userTextPanel.add(this.userText);
    this.add(userTextPanel);
    this.add(randomTextPanel);
    this.add(userTextPanel);
    
    this.buttonRow.add(back);
    this.buttonRow.add(restart);
    this.add(buttonRow);
    this.randomText.setCaretPosition(0);
    
    this.window.setSize(1366,768);
    this.window.setTitle("Game View");
    this.window.setLocation(0,0);
    this.window.setContentPane(this);
    this.window.setVisible(true);
  }
  private void registerControllers()
  {
    this.userText.addMouseListener(new ClearController(this,this.userText," Click here to start typing..."));
    this.userText.addKeyListener(new KeyListener(this.typeModel, this.backSpace));
    this.back.addMouseListener(new FrameSwitchController(this.back,this.frameModel,"Play", this.timer));
    this.restart.addMouseListener(new FrameSwitchController(this.restart,this.frameModel,"level"+this.level, this.timer));
    }
 
  public void update()
  {
    this.nextChar.setText("Next Character: \'"+ this.typeModel.getNextChar()+"\'");
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
        this.meter.setAccuracy(Double.parseDouble(this.typeModel.getAccuracy()));
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
        this.meter.setAccuracy(Double.parseDouble(this.typeModel.getAccuracy()));
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
      this.meter.setAccuracy(Double.parseDouble(this.typeModel.getAccuracy()));
    }
    
  }
  public void updateTimer()
  {
    
    this.clock.setTime(timer.getCurrentTime());
    this.clock.increaseTime();
    
    //this.typeModel.calculateWPM(timer.getSecondsPassed()); 
    if(timer.getCurrentTime().equals("0:00"))
    {
      this.userText.setEnabled(false);
      this.typeModel.calculateWPM(this.timer.getSecondsPassed());
      GameResultsView showResults = new GameResultsView(this.frameModel,this.window,this.user,this.reqSpeed, this.reqAccuracy, this.typeModel.getRecentSpeed(),this.typeModel.getRecentAccuracy());
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
  public void showSpeed(int speed)
  {
    this.wordsPerMinute.setText("WPM : " + speed);
    this.words.setWpm(speed);
   
  }
  
  }
