import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.*;
import javax.swing.*;

public class Gui implements ActionListener{//ʵ��ActionListener����
	JFrame frame;//�������
	JButton button;
public static void main(String [] args){//start main
	
	Gui g = new Gui();
	
	g.click();
	
	
}//end main
public void click(){
/*
 * UI�������
 */
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ʹ�� System exit �����˳�Ӧ�ó���
	
/*
 * UI��ť����	
 */
	JButton button = new JButton("colors");//���ð�ť
	button.addActionListener(this);//�趨��ť����
	
	//MyDrawPanel draw = new MyDrawPanel();
	/*
	 * ����ָ��������ð�ť
	 */
	frame.getContentPane().add(BorderLayout.SOUTH,button);
	//frame.getContentPane().add(BorderLayout.CENTER,draw);
	
	frame.setSize(300,300);
	frame.setVisible(true);
}

public void actionPerformed(ActionEvent event) {
	button.setText("you are a good man");//�û����°�ť ����������ʱҪ��frame���»���
	
}
 

}
