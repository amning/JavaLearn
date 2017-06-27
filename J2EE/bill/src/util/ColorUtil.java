package util;

import java.awt.*;

/**
 * Created by 王宁 on 2017/5/1.
 */
public class ColorUtil {

    public static Color blueColor = Color.decode("#3399FF");//淡蓝色
    public static Color grayColor = Color.decode("#999999");//灰色
    public static Color backgroundColor = Color.decode("#eeeeee");//背景色
    public static Color warningColor = Color.decode("#FF3333");//警告红色

    /*
    根据不同进度显示不同颜色
    当接近0时显示绿色，当接近100时显示红色
    并在不同的颜色间进行过渡
    - -此函数没看懂
     */
    public static Color getByPercentage(int per) {
        if (per > 100)
            per = 100;
        int r = 51;
        int g = 255;
        int b = 51;
        float rate = per / 100f;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        Color color = new Color(r, g, b);
        return color;
    }
}
