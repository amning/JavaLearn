import java.awt.*;

import javax.swing.*;

public class MyDrawPanel extends JPanel {
	public void paintomCponent(Graphics g){
		/*
		 * gΪGraphics���� ����Ҫʵ�ֵķ���������Grphics2D�ķ��� 
		 * ����Ҫǿ��ת����Graphics2D����
		 */
	Graphics2D g2d = (Graphics2D) g;
	
	
	int red = (int)(Math.random()*225);
	int blue = (int)(Math.random()*225);
	int green = (int)(Math.random()*225);	
	Color startColor = new Color (red,green,blue);
	
	 red = (int)(Math.random()*225);
	 blue = (int)(Math.random()*225);
	 green = (int)(Math.random()*225);
	 Color endColor = new Color (red,green,blue);
	 
	 GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
	 g2d.setPaint(gradient);
	 g2d.fillOval(70, 70, 100, 100);
	}

}

	

