import java.util.*;
public class TypingModel
{
  private int nextCharIndex;
  private char nextChar; 
  private boolean correctTyped;
  private String textGenerated;
  private String textTyped;
  private String command;
  private TypingViewTemplate gui;
  private int correctChars;
  private double accuracy;
  private String characterCorrections="";
  private int mostRecentAccuracy;
  private int mostRecentSpeed;
  public TypingModel()
  {
    this.command="";
  }
  public void setGUI(TypingViewTemplate view)
  {
    this.gui= view; 
  }
  public void setTextGenerated()
  {
    this.textGenerated = this.gui.getTextGenerated(); 
    nextCharIndex=0;
    nextChar = textGenerated.charAt(nextCharIndex);
    correctChars = 0;
    textTyped="";
  }
  public String getTextGenerated()
  {
    return textGenerated; 
  }
  public String getTextTyped()
  {
    return textTyped; 
  }
  public void keyTyped(char keyPressed)
  {
    
    
    if(keyPressed==this.nextChar && keyPressed==' ')
    {
      
      this.command="Correct";
      correctChars++;
      textTyped=textTyped+keyPressed;
      
      
      this.gui.update();
      this.characterCorrections=characterCorrections+"c";
      nextCharIndex++;
      nextChar=textGenerated.charAt(nextCharIndex);
      this.calculateWPM(this.gui.getTimePassed());
    }
    else if(keyPressed==this.nextChar)
    {
      this.command="Correct";
      correctChars++;
      textTyped=textTyped+keyPressed;
     
      
      this.gui.update();
       this.characterCorrections=characterCorrections+"c";
      nextCharIndex++;
      nextChar=textGenerated.charAt(nextCharIndex);
    }
    else
    {
      this.command="Incorrect";
      textTyped=textTyped+keyPressed;
      this.gui.update();
      nextCharIndex++;
      nextChar=textGenerated.charAt(nextCharIndex);
      this.characterCorrections=characterCorrections+"i";
    }
    
  }
  public void backspace()
  {
    textTyped=textTyped.substring(0,textTyped.length()-1);
    nextCharIndex--;
    nextChar = textGenerated.charAt(nextCharIndex);
    this.command="Backspace";
    if(this.characterCorrections.charAt(characterCorrections.length()-1)=='c')
    {
      this.correctChars--; 
      characterCorrections = characterCorrections.substring(0,characterCorrections.length()-1);
      
    }
    else
    {
      characterCorrections = characterCorrections.substring(0,characterCorrections.length()-1);
      
    }
    this.gui.update();
  }
  public int getNextCharIndex()
  {
    return this.nextCharIndex; 
  }
  public String getCommand()
  {
    return this.command; 
  }
  public String getAccuracy()
  {
    if(!(this.textTyped.length()==0))
    {
      this.accuracy = (this.correctChars/(this.textTyped.length()*1.0));
      String accuracyPercentage = String.format("%.2f",(this.correctChars/(this.textTyped.length()*1.0))*100.0);
      this.mostRecentAccuracy=Math.round(Float.parseFloat(accuracyPercentage));
      return accuracyPercentage;
    }
    else
    {
      return "0"; 
    }
  }
  public void calculateWPM(int secondsPassed)
  {
    StringTokenizer correctText = new StringTokenizer(this.textGenerated.substring(0,this.textTyped.length()));
    StringTokenizer userText = new StringTokenizer(this.textTyped);
    int wordsTyped = 0;
    int totalWords = correctText.countTokens();
    
    for(int x = 0;x<totalWords;x++)
    {
      try{
      if(correctText.nextToken().equals(userText.nextToken()))
      {
        wordsTyped++; 
      }
      }
      catch(Exception ex)
      {
        continue;
      }
    }
   
    double wpm = (wordsTyped/(secondsPassed*1.0))*60;
    this.gui.showSpeed(Math.round((int)wpm));
    this.mostRecentSpeed = Math.round((int)wpm);
   
  }
  public char getNextChar()
  {
    if(this.command.equals("Backspace"))
         {
   return this.textGenerated.charAt(nextCharIndex); 
    }
       else
         {
         return this.textGenerated.charAt(nextCharIndex+1);
       }
  }
  public int getRecentSpeed()
  {
   return this.mostRecentSpeed; 
  }
  public int getRecentAccuracy()
  {
   return this.mostRecentAccuracy; 
  }
}