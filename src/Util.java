import javax.swing.*;
import java.awt.*;
import static java.awt.Toolkit.getDefaultToolkit;

public class Util {
    public static Dimension getScreenDimension() {
        GraphicsDevice[] screens = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        Insets insets = getDefaultToolkit().getScreenInsets(screens[0].getDefaultConfiguration());
        return new Dimension(getDefaultToolkit().getScreenSize().width - insets.left - insets.right, getDefaultToolkit().getScreenSize().height - insets.top - insets.bottom);
    }

    public static Color getColor(String hexValue) {
        return new Color(Integer.parseInt(hexValue, 16));
    }

    public static void innerLeftBottomPanel(JPanel target, JPanel[] source) {
        String[] colorString = {"A52A2A", "9F8170", "F5F5DC", "3D2B1F", "3D0C02", "3B3C36", "79443B", "FFBF00"};
        for (int i = 0; i < source.length ; i++) {
            source[i] = new JPanel(new GridLayout(1,1));
            source[i].setBackground(Util.getColor(colorString[i]));
            target.add(source[i]);
        }
    }


}
