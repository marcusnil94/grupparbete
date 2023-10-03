import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

    JTextField textField;
    JTextArea textArea;
    JButton exitBtn;
    JButton toDoBtn;
    JButton addBtn;
    JButton editBtn;
    JButton doneBtn;
    JButton historyBtn;
    JFrame frame;
    

    MyFrame(){
        textField = new JTextField(20); // Textinmatning komponent
        textArea = new JTextArea(32, 15); // //Visnings komponent av texten



        addBtn = new JButton("Lägg till Todo");
        addBtn.addActionListener(e -> {
            String todoText = textField.getText();
            textArea.append(todoText);
            textField.setText(""); // Rensar textfält efter man har lagt en ny to do.
        });
        exitBtn = new JButton("Avsluta");
        exitBtn.addActionListener(e -> System.out.println("Avsluta"));
        exitBtn.addActionListener(e -> System.exit(0));
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
        panelHeader.add(textField);
        panelLeft.add(textArea);


        frame = new JFrame();
        frame.setTitle("Att göra, Grupp 4");
        frame.setLayout(new BorderLayout(10,10));
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panelHeader,BorderLayout.NORTH);
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight,BorderLayout.EAST);
        frame.add(panelBottom,BorderLayout.SOUTH);
        frame.setVisible(true);
        



}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==historyBtn) {
            System.out.println("händer jag?");
            frame.dispose();
            HaveDoneFrame haveDoneFrame = new HaveDoneFrame();
            
        }
        
        //Flyttar markerat element från MyFrame till Listan i lista och tar bort det
        /*if (e.getSource() == doneBtn) {
            int selectedIndex = list1.getSelectedIndex();
            if (selectedIndex != -1) {
                System.out.println("Flytta Att Göra Nr : " + (selectedIndex+1));
                Lista.moveToHaveDoneFrame(list1);
            } else {
                System.out.println("inget index");
            }
            
        }*/
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
