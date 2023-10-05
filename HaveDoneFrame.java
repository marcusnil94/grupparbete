import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HaveDoneFrame extends JFrame implements ActionListener {

    JButton exitBtn;
    JButton toDoBtn;
    JFrame frame;
    JLabel historyTitle;

    ImageIcon frameIcon = new ImageIcon("ikoner/grupp4Icon.png");
    ImageIcon homeIcon = new ImageIcon("ikoner/homeIcon.png");
    ImageIcon exitIcon = new ImageIcon("ikoner/exitIcon.png");

    public static DefaultListModel<String> historyListModel;
    public static JList<String> historyList;

    HaveDoneFrame() {

        // Plockar modellen till listan från listan i lista för att få rätt element.
        historyListModel = Lista.getHaveDoneFrameListModel();
        historyList = new JList<>(historyListModel);
        JScrollPane scrollHistory = new JScrollPane(historyList);
        scrollHistory.setPreferredSize(new Dimension(400, 510));
        scrollHistory.setBorder(null);
        historyList.setFont(new Font("sans serif", Font.BOLD, 17));

        // Skapar knappar
        toDoBtn = new JButton("Hem");
        // toDoBtn.addActionListener(e -> System.out.println("Skapar Ny Todo"));
        toDoBtn.addActionListener(this);

        exitBtn = new JButton("Avsluta");
        // exitBtn.addActionListener(e -> System.out.println("Sker Avsluta?"));
        exitBtn.addActionListener(this);

        // Skapar paneler
        JPanel panelHeader = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelBottom = new JPanel();

        // Text för header
        historyTitle = new JLabel("Avklarade uppgifter");
        historyTitle.setFont(new Font("serif", Font.PLAIN, 33));
        panelHeader.add(historyTitle);

        // lägger till upddaterade listan i panelLeft och uppdaterar fönstret
        panelLeft.add(scrollHistory);
        panelLeft.revalidate();
        panelLeft.repaint();

        // Bestämmer storlek på panelerna
        panelHeader.setPreferredSize(new Dimension(500, 60));
        panelLeft.setPreferredSize(new Dimension(500, 380));
        panelBottom.setPreferredSize(new Dimension(500, 60));

        // Bestämmer färger på panels
        panelLeft.setBackground(new Color(235, 240, 228));
        panelHeader.setBackground(new Color(196, 220, 202));
        panelBottom.setBackground(new Color(196, 220, 202));

        // Tar bort markering runt knappen
        toDoBtn.setFocusable(false);
        exitBtn.setFocusable(false);

        // Sätter knapparna till höger
        panelBottom.setLayout(new FlowLayout(FlowLayout.TRAILING));

        // Lägger till knappar till panelBottom
        panelBottom.add(toDoBtn);
        panelBottom.add(exitBtn);

        // Lägger till ikoner
        toDoBtn.setIcon(homeIcon);
        exitBtn.setIcon(exitIcon);

        // Ritar ut frame
        frame = new JFrame();
        frame.setTitle("Har Gjort, Grupp 4");
        frame.setLayout(new BorderLayout(0, 0));
        frame.setSize(500, 700);
        frame.setResizable(false);
        frame.setIconImage(frameIcon.getImage());

        // Avslutar med X(windows) Röd knapp(mac)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ritar ut panels i frame
        frame.add(panelHeader, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelBottom, BorderLayout.SOUTH);

        // Sätter frame till mitten av skärmen
        frame.setLocationRelativeTo(null);

        // Gör frame synlig
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Anropar Dennis MyFrame
        if (e.getSource() == toDoBtn) {
            // System.out.println("MyFrame");
            frame.dispose();
            MyFrame newMyFrame = new MyFrame();

        }
        // Anrop för att avsluta. Ej klar. ****TEST*****
        if (e.getSource() == exitBtn) {
            // System.out.println("Händer jag då?");
            System.exit(0);
        }
    }
}