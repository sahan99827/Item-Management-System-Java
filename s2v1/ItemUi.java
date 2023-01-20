import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.Vector;
import java.util.List;
public class ItemUi extends JFrame{

        JTable tblItem;
        ItemUi(){
        setTitle("Item");
        setLocation(300,200);
        setSize(900,400);

        Container con = getContentPane();
        FlowLayout lay1 = new FlowLayout();
        con.setLayout(lay1);

        
        Vector titles = new Vector();
        titles.add("Brand");
        titles.add("Name");
        titles.add("SubCategory");
        titles.add("Pricepurchase");
        titles.add("Pricesale");
        titles.add("Qoh");
        titles.add("Rop");
        titles.add("StatusItem");
        titles.add("Dointroduced");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data,titles);
        tblItem = new JTable();

        tblItem.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize( new Dimension(800,200));
        jspTable.setViewportView(tblItem);

        con.add(jspTable);

        intitialize();


    }
public void intitialize(){

    loadView();

}
public void loadView(){
    List<Item> itmlist = ItemController.get();
    fillTable(itmlist);
}


public void fillTable( List<Item> item){
    DefaultTableModel model = ( DefaultTableModel) tblItem.getModel();
            for(Item itm: item){
                Vector r = new Vector();
                r.add(itm.getBrand().getName());
                r.add(itm.getName());
                r.add(itm.getSubCategory().getName());
                r.add(itm.getPricepurchase());
                r.add(itm.getPricesale());
                r.add(itm.getRop());
                r.add(itm.getQoh());
                r.add(itm.getStatusItem().getName());
                r.add(itm.getDointroduced().toString());
              
                          
                model.addRow(r);

            }
 
}
}