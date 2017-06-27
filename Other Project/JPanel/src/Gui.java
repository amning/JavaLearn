import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.*;
import javax.swing.*;

public class Gui implements ActionListener{//实现ActionListener方法
	JFrame frame;//创建框架
	JButton button;
public static void main(String [] args){//start main
	
	Gui g = new Gui();
	
	g.click();
	
	
}//end main
public void click(){
/*
 * UI框架设置
 */
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使用 System exit 方法退出应用程序。
	
/*
 * UI按钮设置	
 */
	JButton button = new JButton("colors");//设置按钮
	button.addActionListener(this);//设定按钮监听
	
	//MyDrawPanel draw = new MyDrawPanel();
	/*
	 * 按照指定区域放置按钮
	 */
	frame.getContentPane().add(BorderLayout.SOUTH,button);
	//frame.getContentPane().add(BorderLayout.CENTER,draw);
	
	frame.setSize(300,300);
	frame.setVisible(true);
}

public void actionPerformed(ActionEvent event) {
	button.setText("you are a good man");//用户按下按钮 即动作发生时要求frame重新绘制
	
}
 

}
