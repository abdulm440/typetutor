/* SelectionController
 * Created by: Johnson Duong
 * Updated on: 2019/06/04
 * Either switches the frame or updates the frame when a student is chosen from the JList 
 */

import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;

public class SelectionController implements ListSelectionListener
{
	//instance variables
	private FrameModel model;
	private JList studentList;
	private String switchView;
	
	//constructor
	public SelectionController(JList studentList, FrameModel model, String switchView)
	{
		this.model = model;
		this.studentList = studentList;
		this.switchView = switchView;
	}//end constructor
	
	//called whenever an item is selected
	public void valueChanged(ListSelectionEvent e)
	{
		if (!e.getValueIsAdjusting()) 
		{
			this.model.switchPanel(switchView,e.getFirstIndex());
			
		}
	}//end valueChanged

}//ssalc
