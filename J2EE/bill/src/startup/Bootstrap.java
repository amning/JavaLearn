package startup;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import sun.applet.Main;
import util.GUIUtil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 王宁 on 2017/5/1.
 */
public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIUtil.useLNF();
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {

                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);

            }
        });
    }

}
