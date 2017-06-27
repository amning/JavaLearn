import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TwoButtons {
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args){
		
	}
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("change Lable");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton  = new JButton("change circle");
		labelButton.addActionListener(new ColorListener());
		
		label = new JLabel("i'am a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
	}
	
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			label.setText("oh");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed((ActionEvent event){
			frame.repaint();
		}
	}
}
