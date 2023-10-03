import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class HaveDoneFrame extends JFrame implements ActionListener {
   
    JButton exitBtn;
    JButton toDoBtn;
    JFrame frame;

    static DefaultListModel <String>historyListModel;
    JList <String> historyList;

    HaveDoneFrame() {

        //Plockar modellen till listan från listan i lista för att få rätt element.
        /*historyListModel = Lista.getHistoryListModel();
        historyList = new JList<>(historyListModel);*/

        // Skapar knappar
        toDoBtn = new JButton("To Do");
        toDoBtn.addActionListener(e -> System.out.println("Sker To Do?"));
        toDoBtn.addActionListener(this);
        exitBtn = new JButton("Avsluta");
        exitBtn.addActionListener(e -> System.out.println("Sker Avsluta?"));
        exitBtn.addActionListener(this);

        // Skapar paneler
        JPanel panelHeader = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelBottom = new JPanel();

        //lägger till upddaterade listan i panelLeft och uppdaterar fönstret
        /*panelLeft.add(historyList);
        panelLeft.revalidate();
        panelLeft.repaint();*/

        // Bestämmer storlek på panelerna
        panelHeader.setPreferredSize(new Dimension(500, 60));
        panelLeft.setPreferredSize(new Dimension(500, 380));
        panelBottom.setPreferredSize(new Dimension(500, 60));

        // Bestämmer färger på panels
        panelLeft.setBackground(Color.GREEN);
        panelHeader.setBackground(Color.GRAY);
        panelBottom.setBackground(Color.LIGHT_GRAY);

        // Tar bort markering runt knappen
        toDoBtn.setFocusable(false);
        exitBtn.setFocusable(false);

        // Sätter knapparna till höger
        panelBottom.setLayout(new FlowLayout(FlowLayout.TRAILING));

        // Lägger till knappar till panelBottom
        panelBottom.add(toDoBtn);
        panelBottom.add(exitBtn);

        // Ritar ut frame
        frame = new JFrame();
        frame.setTitle("Har Gjort, Grupp 4");
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(500, 700);
        frame.setResizable(false);

        // Avslutar med X(windows) Röd knapp(mac)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ritar ut panels i frame
        frame.add(panelHeader, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelBottom, BorderLayout.SOUTH);

        // Gör frame synlig
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Anropar Dennis MyFrame
        if (e.getSource() == toDoBtn) {
            System.out.println("händer jag?");
            frame.dispose();
            MyFrame newMyFrame = new MyFrame();
            
        }
        // Anrop för att avsluta. Ej klar. ****TEST*****
        if (e.getSource() == exitBtn) {
            System.out.println("Händer jag då?");
            System.exit(0);
        }
    }
}