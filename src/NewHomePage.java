import javax.swing.*;
import java.awt.*;

public class NewHomePage {
    int width = 1000, height = 630;
    JFrame frame;
    JPanel panel, leftPanel, rightPanel;
    JPanel leftTopPanel, leftBottomPanel, rightTopPanel, rightCenterPanel, rightBottomPanel;

    public NewHomePage() {
        initMainFrame();
        initMainPanel();
    }

    public void initMainFrame() {
        frame = new JFrame("New Home Page");
        frame.setLayout(new GridLayout(1,1));
        frame.setVisible(true);
        frame.setSize(width + 16, height + 37);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void initMainPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        initLeftPanel();
        initRightPanel();
        panel.setBackground(Util.getColor("3D0C02"));
        frame.add(panel);
    }

    public void initLeftPanel() {
        leftPanel = new JPanel();
        //leftPanel.setLayout(new GridLayout(2,1));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        initLeftTopPanel();
        initLeftBottomPanel();
        leftPanel.setPreferredSize(new Dimension(200, height));
        leftPanel.setBackground(Util.getColor("EFDECD"));
        panel.add(leftPanel);
    }

    public void initRightPanel() {
        rightPanel = new JPanel(new GridLayout(1,1));
        initRightTopPanel();
        initRightCenterPanel();
        initRightBottomPanel();
        rightPanel.setPreferredSize(new Dimension(800, height));
        rightPanel.setBackground(Util.getColor("9F8170"));
        panel.add(rightPanel);
    }

    public void initLeftTopPanel() {
        leftTopPanel = new JPanel(new GridLayout(1,1));
        leftTopPanel.setPreferredSize(new Dimension(200,70));
        leftTopPanel.setBackground(Util.getColor("3D2B1F"));
        leftPanel.add(leftTopPanel);
    }

    public void initLeftBottomPanel() {
        leftBottomPanel = new JPanel(new GridLayout(1,1));
        leftBottomPanel.setPreferredSize(new Dimension(200, 560));
        leftBottomPanel.setBackground(Util.getColor("3D0C02"));
        leftPanel.add(leftBottomPanel);
    }

    public void initRightTopPanel() {
        
    }
    
    public void initRightCenterPanel() {

    }

    public void initRightBottomPanel() {

    }

}
