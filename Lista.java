import javax.swing.DefaultListModel;
import javax.swing.JList;


public class Lista {

    // Spara modellen för listorna i denna klassen(eller någon annan förutom HaveDoneFrame eller MyFrame), 
    // annars blev det problem när man ritade om fönstren.
    
    //model för HaveDoneFrame listan
    public static DefaultListModel<String> haveDoneFrameListModel = new DefaultListModel<>();

    //model för MyFrame listan
    public static DefaultListModel<String> myFrameListModel = new DefaultListModel <>();
    
    
    /******Metod för att flytta element från en lista till en annan lista*****
    Är index över 0 läggs det markerade indexet till i Stringen element och sedan som ett nytt "element" i "haveDoneFrameListModel"
    och tar också bort det markerade elementet från den gamla listan.*/

    public static void moveToHaveDoneFrame (JList list){
        String selectedElement = "";
        int selectedIndex = list.getSelectedIndex();
         
        if (list.getSelectedIndex() != -1) {
            selectedElement = (String)list.getSelectedValue();
            DefaultListModel<String> model = myFrameListModel; //Väljer model för listan
            //Tar bort det markerade indexet från "myFrameListModel" och lägger till i "haveDoneFrameListModel"
            model.remove(selectedIndex);
            haveDoneFrameListModel.addElement(selectedElement);
        } else
        System.out.println("No element");
    }

    //denna metod för att få rätt list model till HasDoneFrame listan
    public static DefaultListModel<String> getHaveDoneFrameListModel() {
    return haveDoneFrameListModel;
    }
    //kalla på denna metod som model för MyFrame listan
    public static DefaultListModel<String> getMyFrameListModel() {
    return myFrameListModel;
    }

    /*public static void addToHistoryList (String element) {
        haveDoneFrameListModel.addElement(element);

    }*/

}




