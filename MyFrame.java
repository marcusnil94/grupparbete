import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {

    JButton exitBtn;
    JButton toDoBtn;
    JButton addBtn;
    JButton editBtn;
    JButton doneBtn;
    JButton historyBtn;
    JFrame frame;
    

    MyFrame(){

        addBtn = new JButton("Lägg till Todo");
        addBtn.addActionListener(e -> System.out.println("Lägger till ny ToDo"));
        exitBtn = new JButton("Avsluta");
        exitBtn.addActionListener(e -> System.out.println("Avsluta"));
        editBtn = new JButton("Edit");
        editBtn.addActionListener(e -> System.out.println("Edit"));
        doneBtn = new JButton("Done");
        doneBtn.addActionListener(e -> System.out.println("Done"));
        historyBtn = new JButton("Historik");
        historyBtn.addActionListener(this);
        historyBtn.addActionListener(e -> System.out.println("Historik")); 
        

        JPanel panelHeader = new JPanel();
        JPanel panelLeft = new JPanel(); 
        JPanel panelRight = new JPanel();
        JPanel panelBottom = new JPanel(); 

        panelHeader.setPreferredSize(new Dimension(500, 60));
        panelLeft.setPreferredSize(new Dimension(280, 380));
        panelRight.setPreferredSize(new Dimension(200, 380));
        panelBottom.setPreferredSize(new Dimension(500, 60));

        panelLeft.setBackground(Color.GREEN);
        panelHeader.setBackground(Color.GRAY);
        panelRight.setBackground(Color.red);
        panelBottom.setBackground(Color.LIGHT_GRAY);

        panelHeader.add(addBtn);
        panelBottom.add(exitBtn);
        panelRight.add(editBtn);
        panelRight.add(doneBtn);
        panelBottom.add(historyBtn);

        frame = new JFrame();
        frame.setTitle("Att göra, Grupp 4");
        frame.setLayout(new BorderLayout(10,10));
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panelHeader,BorderLayout.NORTH);
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight,BorderLayout.EAST);
        frame.add(panelBottom,BorderLayout.SOUTH);
        



}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==historyBtn) {
            System.out.println("händer jag?");
            frame.dispose();
            HaveDoneFrame haveDoneFrame = new HaveDoneFrame();
            
        }
    
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}