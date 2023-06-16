import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class NewHomePage implements ActionListener {
    static final int width = 1200, height = 630;
    static int panelIndex = 0;

    public static int getPanelIndex() {
        return panelIndex;
    }

    public static void setPanelIndex(int panelIndex) {
        NewHomePage.panelIndex = panelIndex;
    }

    String companyName = "Brahmasmi Inc.", userName = "Chiranjeev kashyap";
    String darkPurple = "8A2BE2", lightBlue = "89CFF0";
    JFrame frame;
    JPanel panel, leftPanel, rightPanel;
    JPanel leftTopPanel, leftBottomPanel, rightTopPanel, rightCenterPanel, rightBottomPanel;
    JPanel[] innerRightTopPanel, innerRightBottomPanel;
    JButton[] leftBottomButton, rightTopButton;
    JLabel panelLabel;

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
        frame.add(panel);
    }

    public void initLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        initLeftTopPanel();
        initLeftBottomPanel();
        leftPanel.setPreferredSize(new Dimension(200, height));
        panel.add(leftPanel);
    }

    public void initRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        initRightTopPanel();
        initRightCenterPanel();
        initRightBottomPanel();
        rightPanel.setPreferredSize(new Dimension(1000, height));
        panel.add(rightPanel);
    }

    public void initLeftTopPanel() {
        leftTopPanel = new JPanel(new GridLayout(1,1));
        setLogoOnPanel(leftTopPanel, companyName);
        leftTopPanel.setPreferredSize(new Dimension(200,70));
        leftTopPanel.setBackground(Util.getColor(darkPurple));
        leftPanel.add(leftTopPanel);
    }

    public void initLeftBottomPanel() {
        leftBottomPanel = new JPanel();
        leftBottomPanel.setLayout(null);
        initLeftBottomPanelComponents();
        leftBottomPanel.setPreferredSize(new Dimension(200, 560));
        leftBottomPanel.setBackground(Util.getColor(darkPurple));
        leftPanel.add(leftBottomPanel);
    }

    public void initRightTopPanel() {
        rightTopPanel = new JPanel();
        rightTopPanel.setLayout(null);
        initRightTopPanelComponents();
        rightTopPanel.setPreferredSize(new Dimension(800, 70));
        rightTopPanel.setBackground(Util.getColor(darkPurple));
        rightPanel.add(rightTopPanel);
    }
    
    public void initRightCenterPanel() {
        rightCenterPanel = new JPanel(new GridLayout(1,1));
        rightCenterPanel.setPreferredSize(new Dimension(800, 490));
        rightCenterPanel.setBackground(Util.getColor(lightBlue));
        rightPanel.add(rightCenterPanel);
    }

    public void initRightBottomPanel() {
        rightBottomPanel = new JPanel(new GridLayout(1,1));
        innerRightBottomPanel();
        rightBottomPanel.setPreferredSize(new Dimension(800, 70));
        rightBottomPanel.setBackground(Util.getColor(darkPurple));
        rightPanel.add(rightBottomPanel);
    }

    public void innerRightBottomPanel() {
        innerRightBottomPanel = new JPanel[4];
        for (int i = 0 ; i < innerRightBottomPanel.length ; i++) {
            innerRightBottomPanel[i] = new JPanel(new GridLayout(1,1));
            innerRightBottomPanel[i].setBackground(Util.getColor(darkPurple));
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
        Util.setPadding(logoText, 0, 0, 0, 0);
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
        setLogoOnPanel(innerRightBottomPanel[0], userName);
        setDateOnPanel(innerRightBottomPanel[1]);
        setTimeOnPanel();
        setLogoOnPanel(innerRightBottomPanel[3], companyName);
    }

    public void initLeftBottomPanelComponents() {
        initLeftBottomButtons();
    }

    public void initLeftBottomButtons() {
        leftBottomButton = new JButton[8];
        String[] buttonString = {"Purchase", "Sales", "Customer", "Invoice", "Demand", "Stock", "Report", "Log Out"};
        int y = 10;
        for (int i = 0 ; i < leftBottomButton.length ; i++) {
            leftBottomButton[i] = new JButton(buttonString[i]);
            leftBottomButton[i].setBounds(10,y,180,55);
            leftBottomButton[i].addActionListener(this);
            leftBottomPanel.add(leftBottomButton[i]);
            y += 69;
        }
        setDecorationOnButton(leftBottomButton);
    }

    public void initRightTopPanelComponents() {
        rightTopButton = new JButton[4];
        panelLabel = new JLabel(leftBottomButton[getPanelIndex()].getText() + " Panel");
        String[] buttonString = {"Add", "Update", "Delete", "View"};
        int x = 10;
        for (int i = 0 ; i < rightTopButton.length ; i++) {
            rightTopButton[i] = new JButton(buttonString[i]);
            rightTopButton[i].addActionListener(this);
            rightTopButton[i].setBounds(x,10,160,50);
            rightTopPanel.add(rightTopButton[i]);
            x += 200;
            x += i == 1 ? 210 : 0;
        }
        panelLabel.setBounds(380, 10, 230, 50);
        panelLabel.setBackground(Util.getColor(darkPurple));
        panelLabel.setForeground(Color.WHITE);
        panelLabel.setOpaque(true);
        panelLabel.setVerticalAlignment(JLabel.CENTER);
        panelLabel.setHorizontalAlignment(JLabel.CENTER);
        panelLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        rightTopPanel.add(panelLabel);
        setDecorationOnButton(rightTopButton);
    }

    public void setDecorationOnButton(JButton[] button) {
        for (JButton jButton : button) {
            jButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            jButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        }
    }

    public void purchasePanel() {

    }

    public void salePanel() {

    }

    public void customerPanel() {

    }

    public void invoicePanel() {
        
    }

    public void demandPanel() {

    }

    public void stockPanel() {
        
    }

    public void reportPanel() {

    }

    public void logOutPanel() {

    }

    public void selectPanelByIndex(int panelIndex) {
        switch (panelIndex) {
            case 0 -> {
                rightCenterPanel.removeAll();
                purchasePanel();
                frame.revalidate();
            }
            case 1 -> {
                rightCenterPanel.removeAll();
                salePanel();
                frame.revalidate();
            }
            case 2 -> {
                rightCenterPanel.removeAll();
                customerPanel();
                frame.revalidate();
            }
            case 3 -> {
                rightCenterPanel.removeAll();
                invoicePanel();
                frame.revalidate();
            }
            case 4 -> {
                rightCenterPanel.removeAll();
                demandPanel();
                frame.revalidate();
            }
            case 5 -> {
                rightCenterPanel.removeAll();
                stockPanel();
                frame.revalidate();
            }
            case 6 -> {
                rightCenterPanel.removeAll();
                reportPanel();
                frame.revalidate();
            }
            case 7 -> {
                rightCenterPanel.removeAll();
                logOutPanel();
                frame.revalidate();
            }
            default -> {
                rightCenterPanel.removeAll();
                rightCenterPanel.add(new JLabel("Un Recognised panel"));
                frame.revalidate();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < leftBottomButton.length; i++) {
            if (e.getSource() == leftBottomButton[i]) {
                panelIndex = i;
                panelLabel.setText(leftBottomButton[i].getText() + " Panel");
                selectPanelByIndex(panelIndex);
            }
        }

        for (JButton jButton : rightTopButton) {
            if (e.getSource() == jButton)
                System.out.println(jButton.getText() + " Selected Panel Index: " + panelIndex);
        }
    }
}
