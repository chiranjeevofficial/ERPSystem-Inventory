import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomePage {
    JFrame frame;
    JPanel mainPanel, leftPanel, rightPanel, logoPanel;
    JPanel leftBottomPanel, rightTopPanel;
    JPanel[] innerRightTopPanel, innerLeftBottomPanel;

    public HomePage() {
        initMainFrame();
        initMainPanel();
        frame.revalidate();
    }

    public void initMainFrame() {
        frame = new JFrame("Home Page");
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(1016, 668);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void initMainPanel() {
        mainPanel = new JPanel(null);
        mainPanel.setBounds(0,0,1000,600);
        initLeftPanel();
        initRightPanel();
        mainPanel.setBackground(Util.getColor("7DF9FF"));
        frame.add(mainPanel);
    }

    public void initLeftPanel() {
        leftPanel = new JPanel(null);
        initLogoPanel();
        initLeftBottomPanel();
        leftPanel.setBounds(0,0,200,600);
        leftPanel.setBackground(Util.getColor("15F4EE"));
        mainPanel.add(leftPanel);
    }

    public void initRightPanel() {
        rightPanel = new JPanel(null);
        initRightTopPanel();
        initRightCenterPanel();
        initRightBottomPanel();
        rightPanel.setBounds(200,0,800,600);
        rightPanel.setBackground(Util.getColor("3AA8C1"));
        mainPanel.add(rightPanel);
    }

    public void initLogoPanel() {
        logoPanel = new JPanel(new GridLayout(1,1));
        setLogoOnLeftPanel("Brahmasmi INC.");
        logoPanel.setBounds(0,0,200,70);
        logoPanel.setBackground(Util.getColor("E0FFFF"));
        leftPanel.add(logoPanel);
    }

    public void initLeftBottomPanel() {
        leftBottomPanel = new JPanel(new GridLayout(7,1));
        innerLeftBottomPanel = new JPanel[7];
        initInnerLeftBottomComponents();
        leftBottomPanel.setBounds(0,70,200,530);
        leftBottomPanel.setBackground(Util.getColor("00FF7F"));
        leftPanel.add(leftBottomPanel);
    }

    public void initRightTopPanel() {
        rightTopPanel = new JPanel(new GridLayout(1,4));
        innerRightTopPanel = new JPanel[4];
        initInnerRightTopComponents();
        rightTopPanel.setBackground(Util.getColor("3AA8C1"));
        rightTopPanel.setBounds(0,0,800,70);
        rightPanel.add(rightTopPanel);
    }

    public void initRightCenterPanel() {
        JPanel rightCenterPanel = new JPanel(null);
        rightCenterPanel.setBounds(0,70, 800, 460);
        rightCenterPanel.setBackground(Util.getColor("00B7EB"));
        rightPanel.add(rightCenterPanel);
    }

    public void initRightBottomPanel() {
        JPanel rightBottomPanel = new JPanel(null);
        rightBottomPanel.setBounds(0,530,800,70);
        rightBottomPanel.setBackground(Util.getColor("81D8D0"));
        rightPanel.add(rightBottomPanel);
    }

    public void setLogoOnLeftPanel(String text) {
        JLabel logoText = new JLabel(text);
        logoText.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        logoText.setForeground(Color.BLACK);
        logoText.setOpaque(true);
        logoText.setVerticalAlignment(JLabel.CENTER);
        logoText.setBorder(new EmptyBorder(0,10,0,0));
        logoPanel.add(logoText);
    }

    public void initInnerRightTopComponents() {
        String[] colorString = {"AB274F", "7C0902", "FE6F5E", "BF4F51"};
        for (int i = 0 ; i < innerRightTopPanel.length ; i++) {
            innerRightTopPanel[i] = new JPanel(new GridLayout(1,1));
            innerRightTopPanel[i].setBackground(Util.getColor(colorString[i]));
            rightTopPanel.add(innerRightTopPanel[i]);
        }
    }

    public void initInnerLeftBottomComponents() {
        String[] colorString = {"A52A2A", "9F8170", "F5F5DC", "3D2B1F", "3D0C02", "3B3C36", "79443B"};
        for (int i = 0 ; i < innerLeftBottomPanel.length ; i++) {
            innerLeftBottomPanel[i] = new JPanel(new GridLayout(1,1));
            innerLeftBottomPanel[i].setBackground(Util.getColor(colorString[i]));
            leftBottomPanel.add(innerLeftBottomPanel[i]);
        }
    }

}
