import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

public class KeyListener extends KeyAdapter
{
  private TypingModel typeModel;
  private final String SYMBOLS ="!@#$%^&*()1234567890:;\"\'<>,.?/{}[]|+=_- ";
  private boolean backspaceAllowed;
  public KeyListener(TypingModel model, boolean backSpaceEnabled)
  {
    this.typeModel = model;
    this.backspaceAllowed=backSpaceEnabled;
  }
  public void keyPressed(KeyEvent evt)
  {
    if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE && !(this.typeModel.getTextTyped().equals("")) && this.backspaceAllowed)
    {
      this.typeModel.backspace();
    }
   else if(Character.isLetter(evt.getKeyChar())||SYMBOLS.contains(Character.toString(evt.getKeyChar())))
   {
     this.typeModel.keyTyped(evt.getKeyChar());
   }
  }
}