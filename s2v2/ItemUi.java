import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.Vector;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Hashtable;
public class ItemUi extends JFrame{

        JTable tblItem;
        JComboBox<Object> cmbSearchBrand;
        JComboBox<Object> cmbSearchSubCategory;
        JTextField textSearchName;
        Vector titles;

        ItemUi(){
        setTitle("Item");
        setLocation(300,200);
        setSize(900,400);

        Container con = getContentPane();
        FlowLayout lay1 = new FlowLayout();
        con.setLayout(lay1);

        JLabel lblSearchNmae = new JLabel("Name  : ");
        textSearchName = new JTextField(20);
        JLabel lblSearchBrand = new JLabel("Brand : ");
        cmbSearchBrand =new JComboBox();
        JLabel lblSearchSubCategory = new JLabel("SubCategory : ");
        cmbSearchSubCategory =new JComboBox();
        JButton btnSearchClear =new JButton("Clear Search");
        JButton btnSearch =new JButton("Search");
            
        con.add(lblSearchNmae);
        con.add(textSearchName);
        con.add(lblSearchBrand);
        con.add(cmbSearchBrand);
        con.add(lblSearchSubCategory);
        con.add(cmbSearchSubCategory);
        con.add(btnSearchClear);
        con.add(btnSearch);


        titles = new Vector();
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

        btnSearch.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){  btnSearchAp(e);  }  } );
        btnSearchClear.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){  btnSearchClearAp(e);  }  } );

        intitialize();


    }
public void intitialize(){

    loadView();

}
public void loadView(){
    List<Item> itmlist = ItemController.get(null);
    fillTable(itmlist);

    List<Brand> brnlist = BrandController.get();
    Vector<Object> brands = new Vector();
    brands.add("Select a Brand");

    for(Brand brd: brnlist){
      brands.add(brd);         
        
    }
    
    DefaultComboBoxModel<Object> brnModel = new DefaultComboBoxModel(brands);
    cmbSearchBrand.setModel(brnModel); 


    List<SubCategory> sublist = SubCategoryController.get();
    Vector<Object> subcategorys = new Vector();
    subcategorys.add("Select a SubCategory");

    for(SubCategory sub: sublist){
      subcategorys.add(sub);         
        
    }
    
    DefaultComboBoxModel<Object>  subModel = new DefaultComboBoxModel(subcategorys);
    cmbSearchSubCategory.setModel( subModel); 

}


public void fillTable( List<Item> item){
   // DefaultTableModel model = ( DefaultTableModel) tblItem.getModel();
           Vector data =new Vector();
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
              
                          
                data.add(r);

            }
DefaultTableModel dataModel = new DefaultTableModel(data, titles);
tblItem.setModel(dataModel);
             
}
public void btnSearchAp(ActionEvent e){
  
    String name  =textSearchName.getText();

    Object stitem = cmbSearchBrand.getSelectedItem();
    Brand brand = null;

        if(!stitem.equals("Select a Brand"))
        brand = (Brand) stitem;   
        
    Object stitem2 = cmbSearchSubCategory.getSelectedItem();
    SubCategory subCategory = null;
          if(!stitem2.equals("Select a SubCategory"))
          subCategory = (SubCategory) stitem2;  
   

  Hashtable<String,Object> ht = new Hashtable();
  ht.put("name",name);
if(brand!=null) ht.put("brand",brand);
if(subCategory!=null) ht.put("subCategory",subCategory);

  List<Item> items = ItemController.get(ht);
  fillTable(items);
  
}

public void btnSearchClearAp(ActionEvent e){

   int opt = JOptionPane.showConfirmDialog(null,"Are you sure to clear the clear");

    if(opt!=1){

    textSearchName.setText("");
    cmbSearchBrand.setSelectedIndex(0);
    cmbSearchSubCategory.setSelectedIndex(0);

  List<Item> items = ItemController.get(null);
  fillTable(items);
}
}
}