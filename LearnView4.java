/* LearnView4
 * Created by: Johnson Duong
 * Updated on: 2019/05/09
 * The fourth view for teaching proper typing technique
 */

import javax.swing.*;
import java.awt.*;

public class LearnView4 extends LearnPanel4
{
	//instance variables
	CustomButton next = new CustomButton("Next",160,80,40);
	JPanel invisiblePanel1 = new JPanel();
	JPanel invisiblePanel2 = new JPanel();

	private FrameModel frameModel;
	private JFrame window;

	//constructor
	public LearnView4(FrameModel model, JFrame frame)
	{
		super();
		this.frameModel = model;
		this.window = frame;
		this.layoutView();
		this.registerControllers();
	}//end constructor

	//set the initial layout of the window
	private void layoutView()
	{
		//the button
		invisiblePanel1.setPreferredSize(new Dimension(1366,582));  //places the button on at a specific location in the window
		invisiblePanel1.setOpaque(false);
		invisiblePanel2.setPreferredSize(new Dimension(900,150));
		invisiblePanel2.setOpaque(false);

		//the window
		this.add(invisiblePanel1);
		this.add(invisiblePanel2);
		this.add(next);

		window.setTitle("Learning Mode");
		window.setContentPane(this);
		window.setSize(1366,768);
		window.setVisible(true);

	}//end layoutView

	//registering the controllers
	private void registerControllers()
	{
		FrameSwitchController controllerOne = new FrameSwitchController(this.next,this.frameModel,"Learn5");
		this.next.addMouseListener(controllerOne);
	}//end registerControllers

}//ssalc
