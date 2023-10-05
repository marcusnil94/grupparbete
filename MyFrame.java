import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

    JTextField textField;
    JButton exitBtn;
    JButton toDoBtn;
    JButton addBtn;
    JButton editBtn;
    JButton doneBtn;
    JButton historyBtn;
    JButton editTodoBtn;
    JPanel panelLeft;
    JFrame frame;
    JPanel panelRight;
    JTextField editTextField;
    public static JList<String> todoList;
    public static DefaultListModel<String> todoListModel;

    // Ikoner till funktioner och frame
    ImageIcon frameIcon = new ImageIcon("ikoner/grupp4Icon.png");
    ImageIcon addIcon = new ImageIcon("ikoner/addIcon.png");
    ImageIcon doneIcon = new ImageIcon("ikoner/doneIcon.png");
    ImageIcon editIcon = new ImageIcon("ikoner/editIcon.png");
    ImageIcon historyIcon = new ImageIcon("ikoner/historyIcon.png");
    ImageIcon exitIcon = new ImageIcon("ikoner/exitIcon.png");

    MyFrame() {

        textField = new JTextField(20); // Textinmatning komponent
        // textArea = new JTextArea(32, 15); // //Visnings komponent av texten
        todoListModel = Lista.getMyFrameListModel();
        todoList = new JList<>(todoListModel);
        JScrollPane scroll = new JScrollPane(todoList);
        scroll.setPreferredSize(new Dimension(270, 540));

        addBtn = new JButton("Lägg till Todo");
        addBtn.addActionListener(this);
        

        exitBtn = new JButton("Avsluta");
        exitBtn.addActionListener(e -> System.out.println("Avsluta"));
        exitBtn.addActionListener(e -> System.exit(0));
        
        editBtn = new JButton("Edit");
        editBtn.addActionListener(this);
        editBtn.setPreferredSize(new Dimension(190, 200));
      

        doneBtn = new JButton("Done");
        doneBtn.addActionListener(this);
        doneBtn.setPreferredSize(new Dimension(190, 200));
       

        historyBtn = new JButton("Historik");
        historyBtn.addActionListener(this);
        historyBtn.setFocusable(false);
        // historyBtn.addActionListener(e -> System.out.println("Historik"));

        editTodoBtn = new JButton("Edit");
        editTodoBtn.addActionListener(this);
        editBtn.setFocusable(false);
        // editTodoBtn.addActionListener(e -> System.out.println("edit Todo"));

        JPanel panelHeader = new JPanel();
        panelLeft = new JPanel();

        panelRight = new JPanel();
        JPanel panelBottom = new JPanel();

        panelHeader.setPreferredSize(new Dimension(500, 60));
        panelLeft.setPreferredSize(new Dimension(280, 380));
        panelRight.setPreferredSize(new Dimension(220, 380));
        panelBottom.setPreferredSize(new Dimension(500, 60));
        panelBottom.setLayout(new FlowLayout(FlowLayout.TRAILING));

        panelLeft.setBackground(Color.white);
        panelHeader.setBackground(new Color(196,220,202));
        panelRight.setBackground(new Color(235,240,228));
        panelBottom.setBackground(new Color(196,220,202));

        panelHeader.add(addBtn);
        panelRight.add(editBtn);
        panelRight.add(doneBtn);
        panelBottom.add(historyBtn);
        panelBottom.add(exitBtn);
        panelHeader.add(textField);
        panelLeft.add(scroll);

        // Adderar ikoner
        addBtn.setIcon(addIcon);
        doneBtn.setIcon(doneIcon);
        editBtn.setIcon(editIcon);
        exitBtn.setIcon(exitIcon);
        historyBtn.setIcon(historyIcon);

        frame = new JFrame();
        frame.setTitle("Att göra, Grupp 4");
        frame.setLayout(new BorderLayout(0, 0));
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panelHeader, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.setIconImage(frameIcon.getImage());

        // Sätter frame till mitten av skärmen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
    // ********KNAPPFUNKTIONER*******/

    @Override
    public void actionPerformed(ActionEvent e) {

        // historyBtn för att byta till HaveDoneFrame
        if (e.getSource() == historyBtn) {
            System.out.println("HaveDoneFrame");
            frame.dispose();
            HaveDoneFrame haveDoneFrame = new HaveDoneFrame();
        }
        // addBtn för att lägga till ny Todo som ett element i "myFrameListModel" i
        // klassen Lista.
        else if (e.getSource() == addBtn) {
            Lista.myFrameListModel.addElement(textField.getText());
            textField.setText(""); // Rensar textfält efter man har lagt en ny to do.
        }
        // doneBtn för att flytta Todo från MyFrame till HaveDoneFrame.
        // När ett index är markerat och 0 eller över kallar man på metoden i klassen
        // Lista.
        else if (e.getSource() == doneBtn) {
            int selectedIndex = todoList.getSelectedIndex();
            if (selectedIndex != -1) {
                System.out.println("Flytta Att Göra Nr : " + (selectedIndex) + " Till Historik");
                Lista.moveToHaveDoneFrame(todoList);
            } else {
                System.out.println("inget index");
            }
        }
        /*
         * editBtn för att redigera Todos. Samma princip som föregående och här läggs
         * även
         * TextFielden "editTextField" och knappen "editTodoBtn" till i panelRight.
         * 
         */
        else if (e.getSource() == editBtn) {
            int selectedIndexTodo = todoList.getSelectedIndex();
            if (editTextField != null) {
                panelRight.remove(editTextField);
            }
            if (selectedIndexTodo != -1) {
                editTextField = new JTextField(10);
                panelRight.add(editTextField);
                panelRight.add(editTodoBtn);
                editTodoBtn.addActionListener(this);// behövs en Actionlistener för den nya knappen
                // Uppdaterar ädringar i panelen
                panelRight.revalidate();
                panelRight.repaint();
                System.out.println("Edit Att Göra Nr : " + (selectedIndexTodo));
            }
        }
        /*
         * Samma princip som övriga knappar som läser av index sen en ytterligare if som
         * kollar så inte
         * textFieldet är empty. Kanske vill vi ha en else del här? och/eller en avbryt
         * funktion?
         */
        else if (e.getSource() == editTodoBtn) {
            int selectedIndexTodo = todoList.getSelectedIndex();
            if (selectedIndexTodo != -1) {
                String edit = editTextField.getText();
                if (!edit.isEmpty()) {
                    todoListModel.setElementAt(edit, selectedIndexTodo);
                    editTextField.setText("");
                    // tar bort de tillagda funktionerna och uppdaterar panelRight efter redigerad
                    // todo
                    panelRight.remove(editTextField);
                    panelRight.remove(editTodoBtn);
                    panelRight.revalidate();
                    panelRight.repaint();
                    System.out.println("Confirm Edit Att Göra Nr : " + (selectedIndexTodo));
                }
            }
        }
    }
}

// throw new UnsupportedOperationException("Unimplemented method
// 'actionPerformed'");
