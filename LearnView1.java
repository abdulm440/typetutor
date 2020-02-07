/* LearnView1
 * Created by: Johnson Duong
 * Updated on: 2019/05/09
 * The first view for teaching proper typing technique
 */

import javax.swing.*;
import java.awt.*;

public class LearnView1 extends LearnPanel1
{
	//instance variables
	private JPanel invisiblePanel = new JPanel();
	private CustomButton next = new CustomButton("Next",160,80,40);
	private JFrame window;
	private FrameModel frameModel;

	//constructor
	public LearnView1( FrameModel model, JFrame mainWindow) 
	{
		super();
		this.window=mainWindow;
		this.frameModel = model;
		this.layoutView();
		this.registerControllers();

	}//end constructor

	//set the initial view of the window
	private void layoutView() 
	{
		//the button
		invisiblePanel.setPreferredSize(new Dimension(1366,595));  //places the button on at a specific location in the window
		invisiblePanel.setOpaque(false);

		//the window
		this.setPreferredSize(new Dimension(1366,768));
		this.add(invisiblePanel);
		this.add(next);
		window.setTitle("Learning Mode");
		window.setContentPane(this);
		window.setSize(1366,768);
		window.setVisible(true);

	}//end layoutView

	//registering the controllers
	private void registerControllers()
	{
		FrameSwitchController controllerOne = new FrameSwitchController(this.next,this.frameModel,"Learn2");
		this.next.addMouseListener(controllerOne);
	}//end registerControllers

}//ssalc
