/* LearnPanel2
 * Created by: Johnson Duong
 * Updated on: 2019/05/10
 * The second page of the LearnView
 */

import javax.swing.*;
import java.awt.*;

public class LearnPanel2 extends JPanel
{
	ImageIcon image;

	//constructor
	public LearnPanel2()
	{
		super();
		image = new ImageIcon("LearnView2.png");
		this.setPreferredSize(new Dimension(image.getImage().getWidth(null),image.getImage().getHeight(null)));
	}//end constructor

	//overriding the paintComponent method
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Image pic = image.getImage();
		g.drawImage(pic,0,0,null);
	}//end paintComponent

}//ssalc
