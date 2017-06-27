import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Calcculator {
	public void Jp(){JPanel pan = new JPanel();
    pan.setLayout(new GridLayout(4, 4, 5, 5));
    pan.add(button7);
    pan.add(button8);
    pan.add(button9);
    pan.add(button_chu);
    pan.add(button4);
    pan.add(button5);
    pan.add(button6);
    pan.add(button_cheng);
    pan.add(button1);
    pan.add(button2);
    pan.add(button3);
    pan.add(button_jian);
    pan.add(button0);
    pan.add(button_Dian);
    pan.add(button_dy);
    pan.add(button_jia);
    pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    JPanel pan2 = new JPanel();
    pan2.setLayout(new BorderLayout());
    pan2.add(result_TextField, BorderLayout.WEST);
    pan2.add(clear_Button, BorderLayout.EAST);
	}
}
