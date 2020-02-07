/* CustomButton
 * Created by: Johnson Duong
 * Updated on: 2019/05/22
 * A Custom Button that extends JButton
 */

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton
{
	//constructor
	public CustomButton(String text, int width, int height, float fontSize)
	{
		this.setText(text);
		this.setPreferredSize(new Dimension(width, height));
		this.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", fontSize));
		this.setFocusPainted(false);
		this.setOpaque(true);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setBackground(new Color(241, 248, 108));

	}//end constructor


}//ssalc
