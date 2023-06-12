import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class NewHomePage implements ActionListener {
    static final int width = 1000, height = 630;
    JFrame frame;
    JPanel panel, leftPanel, rightPanel;
    JPanel leftTopPanel, leftBottomPanel, rightTopPanel, rightCenterPanel, rightBottomPanel;
    JPanel[] innerLeftBottomPanel, innerRightTopPanel, innerRightBottomPanel;
    JButton[] leftBottomButton, rightTopButton;

    public NewHomePage() {
        initMainFrame();
        initMainPanel();
        frame.revalidate();
    }

    public void initMainFrame() {
        frame = new JFrame("New Home Page");
        frame.setLayout(new GridLayout(1,1));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(width + 16, height + 39);
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
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        initLeftTopPanel();
        initLeftBottomPanel();
        leftPanel.setPreferredSize(new Dimension(200, height));
        leftPanel.setBackground(Util.getColor("EFDECD"));
        panel.add(leftPanel);
    }

    public void initRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        initRightTopPanel();
        initRightCenterPanel();
        initRightBottomPanel();
        rightPanel.setPreferredSize(new Dimension(800, height));
        rightPanel.setBackground(Util.getColor("9F8170"));
        panel.add(rightPanel);
    }

    public void initLeftTopPanel() {
        leftTopPanel = new JPanel(new GridLayout(1,1));
        setLogoOnPanel(leftTopPanel, "Brahmasmi INC.");
        leftTopPanel.setPreferredSize(new Dimension(200,70));
        leftTopPanel.setBackground(Util.getColor("8A2BE2"));
        leftPanel.add(leftTopPanel);
    }

    public void initLeftBottomPanel() {
        leftBottomPanel = new JPanel(new GridLayout(8,1));
        innerLeftBottomPanel();
        leftBottomPanel.setPreferredSize(new Dimension(200, 560));
        leftBottomPanel.setBackground(Util.getColor("3D0C02"));
        leftPanel.add(leftBottomPanel);
    }

    public void initRightTopPanel() {
        rightTopPanel = new JPanel(new GridLayout(1,4));
        innerRightTopPanel();
        rightTopPanel.setPreferredSize(new Dimension(800, 70));
        rightTopPanel.setBackground(Util.getColor("C51E3A"));
        rightPanel.add(rightTopPanel);
    }
    
    public void initRightCenterPanel() {
        rightCenterPanel = new JPanel(new GridLayout(1,1));
        rightCenterPanel.setPreferredSize(new Dimension(800, 490));
        rightCenterPanel.setBackground(Util.getColor("F2C1D1"));
        rightPanel.add(rightCenterPanel);
    }

    public void initRightBottomPanel() {
        rightBottomPanel = new JPanel(new GridLayout(1,1));
        innerRightBottomPanel();
        rightBottomPanel.setPreferredSize(new Dimension(800, 70));
        rightBottomPanel.setBackground(Util.getColor("9400D3"));
        rightPanel.add(rightBottomPanel);
    }

    public void innerLeftBottomPanel() {
        innerLeftBottomPanel = new JPanel[8];
        for (int i = 0 ; i < innerLeftBottomPanel.length ; i++) {
            innerLeftBottomPanel[i] = new JPanel(new GridLayout(1,1));
            innerLeftBottomPanel[i].setBackground(Util.getColor("9966CC"));
            leftBottomPanel.add(innerLeftBottomPanel[i]);
        }
        initLeftBottomPanelComponents();
    }

    public void innerRightTopPanel() {
        innerRightTopPanel = new JPanel[4];
        for (int i = 0 ; i < innerRightTopPanel.length ; i++) {
            innerRightTopPanel[i] = new JPanel(new GridLayout(1,1));
            innerRightTopPanel[i].setBackground(Util.getColor("9966CC"));
            rightTopPanel.add(innerRightTopPanel[i]);
        }
        initRightTopPanelComponents();
    }

    public void innerRightBottomPanel() {
        innerRightBottomPanel = new JPanel[4];
        for (int i = 0 ; i < innerRightBottomPanel.length ; i++) {
            innerRightBottomPanel[i] = new JPanel(new GridLayout(1,1));
            innerRightBottomPanel[i].setBackground(Util.getColor("9966CC"));
            rightBottomPanel.add(innerRightBottomPanel[i]);
        }
        initRightBottomPanelComponents();
    }

    public void setLogoOnPanel(JPanel panel, String text) {
        JLabel logoText = new JLabel(text);
        logoText.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        logoText.setForeground(Color.BLACK);
        logoText.setVerticalAlignment(JLabel.CENTER);
        logoText.setHorizontalAlignment(JLabel.CENTER);
        //logoText.setBorder(new EmptyBorder(0,10,0,0));
        panel.add(logoText);
    }

    public void setDateOnPanel(JPanel panel) {
        JLabel date = new JLabel(String.valueOf(LocalDate.now()));
        date.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        date.setForeground(Color.BLACK);
        date.setVerticalAlignment(JLabel.CENTER);
        date.setHorizontalAlignment(JLabel.CENTER);
        //date.setBorder(new EmptyBorder(0,10,0,0));
        panel.add(date);
    }

    public void setTimeOnPanel() {

    }
    
    public void initRightBottomPanelComponents() {
        setLogoOnPanel(innerRightBottomPanel[0], "Chiranjeev Kashyap");
        setDateOnPanel(innerRightBottomPanel[1]);
        setTimeOnPanel();
        setLogoOnPanel(innerRightBottomPanel[3], "Brahmasmi INC.");
    }

    public void initLeftBottomPanelComponents() {
        leftBottomButton = new JButton[8];
        String[] buttonString = {"Purchase", "Sales", "Customer", "Invoice", "Demand", "Stock", "Report", "Log Out"};
        for (int i = 0 ; i < leftBottomButton.length ; i++) {
            leftBottomButton[i] = new JButton(buttonString[i]);
            leftBottomButton[i].addActionListener(this);
            innerLeftBottomPanel[i].add(leftBottomButton[i]);
        }
        setDecorationOnButton(leftBottomButton);
    }

    public void initRightTopPanelComponents() {
        rightTopButton = new JButton[4];
        String[] buttonString = {"Add", "Update", "Delete", "View"};
        for (int i = 0 ; i < rightTopButton.length ; i++) {
            rightTopButton[i] = new JButton(buttonString[i]);
            rightTopButton[i].addActionListener(this);
            innerRightTopPanel[i].add(rightTopButton[i]);
        }
        setDecorationOnButton(rightTopButton);
    }

    public void setDecorationOnButton(JButton[] button) {
        for (int i = 0 ; i < button.length ; i++) {
            button[i].setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            button[i].setBorder(new EmptyBorder(0,10,0,0));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : leftBottomButton) {
            if (e.getSource() == button)
                System.out.println(button.getText());
        }

        for (JButton jButton : rightTopButton) {
            if (e.getSource() == jButton)
                System.out.println(jButton.getText());
        }
    }
}
