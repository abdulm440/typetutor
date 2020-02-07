/* LearnPanel1
 * Created by: Johnson Duong
 * Updated on: 2019/05/10
 * The first page of the LearnView
 */

import javax.swing.*;
import java.awt.*;

public class LearnPanel1 extends JPanel
{
	ImageIcon image;

	//constructor
	public LearnPanel1()
	{
		super();
		image = new ImageIcon("LearnView1.png");
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
