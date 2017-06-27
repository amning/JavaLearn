import javax.swing.*;
import java.awt.*;
public class An {
	static int x=70;
	static int y = 70;
	static public void main(String[] args){
		An a = new An();
		a.go();
	}
		public void go() {
			JFrame frame = new JFrame("clor");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			MyDrawPanel draw =new  MyDrawPanel();
			
			frame.getContentPane().add(draw);
			frame.setSize(300, 300);
			frame.setVisible(true);
			
			for(int i =50;i<100;i++){
				x++;
			y+=2;
				
				draw.repaint();
				
				try{
					Thread.sleep(50);
					
				}catch(Exception ex){ }
								
			}
			
		}
		 class MyDrawPanel extends JPanel {
				public void paintComponent(Graphics g){
					g.setColor(Color.WHITE);
					g.fillRect(0, 0, getWidth(), this.getHeight());
					
					g.setColor(Color.orange);
					g.fillOval(x, y, 10, 10);
				}

			
	}
	
	
	

}
