import javax.swing.*;
import java.awt.*;

public class LoginPage {
    int width = 700, height = 500;
    JFrame mainJFrame;
    JPanel mainPanel, innerMainPanel[];

    public LoginPage() {
        initMainFrame();
        initMainPanel();
    }

    public void initMainFrame() {
        mainJFrame = new JFrame("Inventory Management System");
        mainJFrame.setLayout(null);
        mainJFrame.setSize(width,height);
        mainJFrame.setVisible(true);
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initMainPanel() {
        mainPanel = new JPanel(new GridLayout(3, 1));
        innerMainPanel = new JPanel[3];
        for (int i = 0; i < innerMainPanel.length ; i++) {
            innerMainPanel[i] = new JPanel();
            mainPanel.add(innerMainPanel[i]);
        }

        innerMainPanel[0].setPreferredSize(new Dimension(width - 16, 150));

        innerMainPanel[0].setLayout(new BoxLayout(innerMainPanel[0], BoxLayout.X_AXIS));
        innerMainPanel[1].setLayout(new BoxLayout(innerMainPanel[1], BoxLayout.Y_AXIS));
        innerMainPanel[2].setLayout(new GridLayout(1,1));

        innerMainPanel[0].setBackground(Util.getColor("E09540"));
        innerMainPanel[1].setBackground(Util.getColor("F7E7CE"));
        innerMainPanel[2].setBackground(Util.getColor("FF8C00"));

        mainPanel.setBackground(Util.getColor("FF0800"));
        mainPanel.setBounds(0,0,width - 16, height - 38);
        mainJFrame.add(mainPanel);
        initHeadPanel();
        initInputPanel();
        //initNavigatePanel();
        mainJFrame.repaint();
        mainJFrame.revalidate();
    }

    public void initHeadPanel() {
        JPanel[] innerHeadPanel = new JPanel[2];
        String[] color = {"9966CC", "8A2BE2"};
        for (int i = 0 ; i < innerHeadPanel.length ; i++) {
            innerHeadPanel[i] = new JPanel();
            innerHeadPanel[i].setLayout(new GridLayout(1,1));
            innerHeadPanel[i].setBackground(Util.getColor(color[i]));
            innerMainPanel[0].add(innerHeadPanel[i]);
        }
    }

    public void initInputPanel() {
        JPanel[] innerInputPanel = new JPanel[2];
        String[] color = {"00563B", "004225"};
        for (int i = 0 ; i < innerInputPanel.length ; i++) {
            innerInputPanel[i] = new JPanel();
            innerInputPanel[i].setLayout(new GridLayout(1,1));
            innerInputPanel[i].setBackground(Util.getColor(color[i]));
            innerMainPanel[1].add(innerInputPanel[i]);
        }
    }

    /*public void initInputPanel() {
        inputJPanel = new JPanel();
        inputJPanel.setLayout(new BoxLayout(inputJPanel, BoxLayout.Y_AXIS));

        JPanel[] innerInputJPanel = new JPanel[2];
        innerInputJPanel[0] = new JPanel(new GridLayout(1,1));
        innerInputJPanel[0].setBackground(Color.PINK);
        innerInputJPanel[0].setPreferredSize(new Dimension(width - 16, 100));
        inputJPanel.add(innerInputJPanel[0]);

        innerInputJPanel[1] = new JPanel(new GridLayout(1,1));
        innerInputJPanel[1].setBackground(Color.LIGHT_GRAY);
        innerInputJPanel[1].setPreferredSize(new Dimension(width - 16, 100));
        inputJPanel.add(innerInputJPanel[1]);

        inputJPanel.setBounds(0,150,width - 16, 200);
        //inputJPanel.setPreferredSize(new Dimension(width - 16, 200));
        inputJPanel.setBackground(Color.YELLOW);
        mainPanel.add(inputJPanel);
    }*/

    /**
     * public void initNavigatePanel() {
     * navigateJPanel = new JPanel();
     * navigateJPanel.setLayout(null);
     * navigateJPanel.setPreferredSize(new Dimension(width - 16, 150));
     * navigateJPanel.setBackground(Color.RED);
     * mainPanel.add(navigateJPanel);
     *}
     */
}
