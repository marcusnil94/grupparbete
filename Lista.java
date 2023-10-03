import javax.swing.DefaultListModel;
import javax.swing.JList;


public class Lista {

    //random hittepålista
    public static JList addList(JList list,DefaultListModel model) {
        
        DefaultListModel <String> listModel = new DefaultListModel<>();
        JList <String> list1 = new JList (listModel);

        listModel.addElement("Attgöra1");
        listModel.addElement("Attgöra2");
        listModel.addElement("Attgöra3");
        listModel.addElement("Attgöra4");
        listModel.addElement("Attgöra5");
    
    return list1;
    }
    
    /******Metod för att flytta element från en lista till en annan lista*****
    Är index över 0 läggs det markerade indexet till i element och sedan i "historyListModel"
    och tar också bort det från den gamla listan.*/

    public static void moveToHaveDoneFrame (JList list){
        String element = "";
        int selectedIndex = list.getSelectedIndex();
         
        if (list.getSelectedIndex() != -1) {
            element = "Element: " + list.getSelectedValue();
            DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
            model.remove(selectedIndex);
            historyListModel.addElement(element);
            
        } else
        System.out.println("No element");
    }

    //historiklistan
    private static DefaultListModel<String> historyListModel = new DefaultListModel<>();
    
    //denna metod för att få rätt list model till HasDoneFrame
    public static DefaultListModel<String> getHistoryListModel() {
    return historyListModel;
    }

    /*public static void addToHistoryList (String element) {
        historyListModel.addElement(element);

    }*/

}




