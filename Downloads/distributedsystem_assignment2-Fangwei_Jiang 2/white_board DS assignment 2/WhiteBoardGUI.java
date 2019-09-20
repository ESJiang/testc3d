/* ************************************************************************************
 * Group Name: Friday615
 * Group Members: Chih-chi Chou, Fangwei Jiang, Pei-chun kao, Yixuan Tang, Ruiyan Wang
 * Description: This program is designed to create a whiteboard for users to draw, write 
 *				and other things if he/she obtained the permission by manager.
 ************************************************************************************ */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class WhiteBoardGUI
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Dynamic User table");
		JTextArea area = new JTextArea();
		frame.setDefaultCloseOperation(0);
		frame.setBounds(1300,200,300,500);
		frame.setVisible(true);
		area.setColumns(20);
		area.setRows(10);
		area.setFont(new Font("Times new Roman", Font.PLAIN,20));
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout());
		frame.setContentPane(c);
		//c.add(jScrollPane);
		c.validate();


		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e) 
			{
				int n = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm", 1);
				if (n == 0) 
				{
					System.exit(0);
				}
			}
		});
	}
}
