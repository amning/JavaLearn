import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnnerButton {

	JFrame frame;
	
	JTextField f = new JTextField(20);
	JTextField g = new JTextField("your name");
	public static void main(String []  args){
		InnnerButton gui = new InnnerButton();
		gui.go();
		
	}
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel A = new JPanel();
		
		A.setBackground(Color.ORANGE);
		
		A.setLayout(new BoxLayout(A,BoxLayout.Y_AXIS));
		JButton B = new JButton("A");
		JButton c = new JButton("B");
		
		A.add(B);
				A.add(c);
				
				frame.getContentPane().add(BorderLayout.EAST,A);
		
		
		
		//b.addActionListener(new BListener());

		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}	
		
		
	class BListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(b.getText().equals("A")){
				b.setText("B");
				
			}else{
				b.setText("A");
				
			}
		} 
	}		
	
}
