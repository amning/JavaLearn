import java.awt.Button;
import java.awt.event.*;
import javax.swing.*;
public class Gui implements ActionListener{
	JButton button;
public static void main(String [] args){
	Gui gui = new Gui();
	gui.click();
	
	
}
public void click(){

	JFrame frame = new JFrame();
	button = new JButton("click me");
	
	button.addActionListener(this);//°´Å¥×¢²á
			
	frame.getContentPane().add(button);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(100,100);
	frame.setVisible(true);
}
 
public void actionPerformed(ActionEvent event){
	button.setText("ksdjfkji");
}
}
