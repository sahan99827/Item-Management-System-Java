import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;

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
import java.time.LocalDate;
public class ItemUi extends JFrame{

        JTable tblItem;
        JComboBox<Object> cmbSearchBrand;
        JTextField textSearchName;
        Vector titles;

        JTextField txtName;
        JTextField txtCode;
        JTextField txtPricepurchase;
        JTextField txtPricesale;
        JTextField txtRop;
        JTextField txtQoh;

        JComboBox<Object> cmbBrand;
        JComboBox<Object> cmblSubCategory;
        JComboBox<Object> cmbStatusItem;
        
        JComboBox<Object> cmbDoinYear;
        JComboBox<Object> cmbDoinMonth;
        JComboBox<Object> cmbDoinDay;


        JButton btnAdd;
        JButton btnClear;
        JButton btnUpdate;
        JButton btnDelet;

        Color valid;
        Color invalid;
        Color initial;

        ItemUi(){

        valid = new Color(200,255,200);
        invalid = Color.pink;
        initial = Color.white;
  
        setTitle("Item");
        setLocation(300,200);
        setSize(900,800);

        Container con = getContentPane();
        FlowLayout lay1 = new FlowLayout();
        con.setLayout(lay1);

        
        //Leble
        JLabel lblNmae = new JLabel("Name  : ");
        JLabel lblDointroduced = new JLabel("Dointroduced  : ");
        JLabel lblBrand = new JLabel("      Brand  : ");
        JLabel lblCode = new JLabel("       CODE  : ");
        JLabel lblPricepurchase= new JLabel("Pricepurchase : ");
        JLabel lblPricesale  = new JLabel("Pricesale : ");
        JLabel lblSubCategory = new JLabel("SubCategory  : ");
        JLabel lblStatus = new JLabel("    StatusItem  : ");
        JLabel lblRop = new JLabel("    ROP : ");
        JLabel lblQoh = new JLabel("    QOH : ");

       //Text Filed
       txtName = new JTextField(72);
       txtCode = new JTextField(72);
       txtPricepurchase = new JTextField(52);
       txtPricesale = new JTextField(60);
       txtRop = new JTextField(60);
       txtQoh= new JTextField(60);

        //ComboBox
        cmbBrand =new JComboBox();
        cmblSubCategory =new JComboBox();
        cmbStatusItem =new JComboBox();
        cmbDoinYear =new JComboBox();
        cmbDoinMonth =new JComboBox();
        cmbDoinDay =new JComboBox();

        //Button
        btnAdd=new JButton("Add");
        btnClear =new JButton("Clear");
        btnUpdate =new JButton("Update");
        btnDelet =new JButton("Delet");  

        JLabel lblEmpty= new JLabel("                                                                                                                                                                                                             ");

        con.add(lblNmae);
        con.add(txtName);
        con.add(lblDointroduced);
        con.add(cmbDoinYear); con.add(cmbDoinMonth); con.add(cmbDoinDay);
        con.add(lblBrand);
        con.add(cmbBrand);
        con.add(lblEmpty);
        con.add(lblCode);
        con.add(txtCode);
        con.add(lblPricepurchase);
        con.add(txtPricepurchase);
        con.add(lblPricesale);
        con.add(txtPricesale);
        con.add(lblRop);
        con.add(txtRop);
        con.add(lblQoh);
        con.add(txtQoh);
        con.add(lblSubCategory);
        con.add(cmblSubCategory);
        con.add(lblStatus);
        con.add(cmbStatusItem);

        JLabel lblfristEnd = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        con.add(lblfristEnd);

        //Button
        con.add(btnDelet);
        con.add(btnUpdate);
        con.add(btnClear);
        con.add(btnAdd);

        JLabel lblFormEnd = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        JLabel lblFormEnd2 = new JLabel("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        con.add(lblFormEnd);
        con.add(lblFormEnd2);
        

      //Search
        JLabel lblSearchNmae = new JLabel("Name  : ");
        textSearchName = new JTextField(20);
        JLabel lblSearchBrand = new JLabel("Brand : ");
        cmbSearchBrand =new JComboBox();
        JButton btnSearchClear =new JButton("Clear Search");
        JButton btnSearch =new JButton("Search");
            
        con.add(lblSearchNmae);
        con.add(textSearchName);
        con.add(lblSearchBrand);
        con.add(cmbSearchBrand);

        JLabel lblfristEnd4 = new JLabel("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        con.add(lblfristEnd4);
        
        con.add(btnSearchClear);
        con.add(btnSearch);

        JLabel lblSeconEnd = new JLabel("\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
        con.add(lblSeconEnd);
        JLabel lblSeconEnd2 = new JLabel("\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
        con.add(lblSeconEnd2);

        //Table

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

        btnAdd.addActionListener(  new ActionListener(){  public void actionPerformed(ActionEvent e){ btnAddAp(e);  }  } );

        intitialize();


    }
public void intitialize(){
    loadform();
    loadView();

}
public void loadform(){
  //Brand
    List<Brand> brnlist = BrandController.get();
    Vector<Object> brands = new Vector();
        brands.add("Select a Brand");
          
            for(Brand bn: brnlist){
                  brands.add(bn);         
                
        }
    
    DefaultComboBoxModel<Object> bnModel = new DefaultComboBoxModel(brands);
    cmbBrand.setModel(bnModel); 
  
  //SubCategory
    List<SubCategory> sclist = SubCategoryController.get();
    Vector<Object> subCategories = new Vector();
    subCategories.add("Select a SubCategory");
  
    for(SubCategory sc: sclist){
      subCategories.add(sc);         
        
     }
    
    DefaultComboBoxModel<Object> scModel = new DefaultComboBoxModel(subCategories);
    cmblSubCategory.setModel(scModel); 
  
     
  //StatusItem
  List<StatusItem> silist = StatusItemController.get();
  Vector<Object> statusItems = new Vector();
  statusItems.add("Select StatusItem");
  
  for(StatusItem si: silist){
    statusItems.add(si);         
      
  }
  DefaultComboBoxModel<Object> siModel = new DefaultComboBoxModel(statusItems);
  cmbStatusItem.setModel(siModel); 
    //Dointroduced
  
  Vector<Object> DoinDay = new Vector();
  DoinDay.add("Selec Day");
  
  for(int i=1; i<=31;i++){
    DoinDay.add(i);         
      
  }
  DefaultComboBoxModel<Object> dayModel = new DefaultComboBoxModel(DoinDay);
  cmbDoinDay.setModel(dayModel);
  
    //DobManth
  
    Vector<Object> DoinManth = new Vector();
    DoinManth.add("Select Manth");
    
    for(int i=1; i<=12; i++){
      DoinManth.add(i);         
        
    }
    DefaultComboBoxModel<Object> ManModel= new DefaultComboBoxModel(DoinManth);
    cmbDoinMonth.setModel(ManModel);
  
      //DobYear
  
      Vector<Object> DoinYear = new Vector();
      DoinYear.add("Select Year");
      
      for(int i=2005; i<=2040;i++){
        DoinYear.add(i);         
          
      }
     cmbDoinYear.setModel( new DefaultComboBoxModel(DoinYear));
  
     txtName.setText("");
     txtCode.setText("");
     txtPricepurchase.setText("");
     txtPricesale.setText("");
     txtRop.setText("");
     txtQoh.setText("");
  
      enabledButtons(true,false,false);
      setStyle(initial);
  
      }
public void setStyle(Color clr){
  
        txtName.setBackground(clr);
        txtCode.setBackground(clr);
        txtPricepurchase.setBackground(clr);
        txtPricesale.setBackground(clr);
        txtRop.setBackground(clr);
        txtQoh.setBackground(clr);
      
      
        cmblSubCategory.setBackground(clr);
        cmbStatusItem.setBackground(clr);
        cmbBrand.setBackground(clr);
      
        cmbDoinDay.setBackground(clr);
        cmbDoinMonth.setBackground(clr);
        cmbDoinYear.setBackground(clr);
      
      
      }
public void enabledButtons(boolean add, boolean upd,boolean delt){
        btnAdd.setEnabled(add);
        btnUpdate.setEnabled(upd);
        btnDelet.setEnabled(delt);
      
      }
public void fillForm(){
      
    enabledButtons(false,true,true);
    setStyle(valid);
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

  Hashtable<String,Object> ht = new Hashtable();
  ht.put("name",name);
if(brand!=null) ht.put("brand",brand);

  List<Item> items = ItemController.get(ht);
  fillTable(items);
  
}

public void btnSearchClearAp(ActionEvent e){

   int opt = JOptionPane.showConfirmDialog(null,"Are you sure to clear the clear");

    if(opt!=1){

    textSearchName.setText("");
    cmbSearchBrand.setSelectedIndex(0);

  List<Item> items = ItemController.get(null);
  fillTable(items);
}
}
public void btnAddAp(ActionEvent e){
   

  Item item = new Item();  

  String error ="";
  
  //Name
  String name = txtName.getText();
      if(name.matches("^[A-Z]\\w[A-z]*[0-9]*$"))
          {
            item.setName(name);
            txtName.setBackground(valid);
          }
      else
        {
          txtName.setBackground(invalid);
          error =error +"\n invalid Name";
        }
  
  //Code
  String code = txtCode.getText();
        if(code.matches("^\\d{1,5}$"))
          {
            item.setCode(code);
            txtCode.setBackground(valid);
          }
        else
        {
          txtCode.setBackground(invalid);
          error =error +"\n invalid Code";
        }

  //Pricepurchase
  String pricepurchase = txtPricepurchase.getText();
        if(pricepurchase.matches("^\\d{1,6}(.\\d{1,2})?$"))
          {
            item.setPricepurchase(Double.parseDouble(pricepurchase));
            txtPricepurchase.setBackground(valid);
          }
        else
        {
          txtPricepurchase.setBackground(invalid);
          error =error +"\n invalid Pricepurchase";
        }
   
  //Pricesale
  String pricesale = txtPricesale.getText();
        if(pricesale.matches("^\\d{1,6}(.\\d{1,2})?$"))
          {
            item.setPricesale(Double.parseDouble(pricesale));
            txtPricesale.setBackground(valid);
          }
        else
        {
          txtPricesale.setBackground(invalid);
          error =error +"\n invalid pricesale";
        }
 //ROP
 String rop = txtRop.getText();
      if(rop.matches("^\\d{1,5}$"))
        {
          item.setRop(Integer.parseInt(rop));
          txtRop.setBackground(valid);
        }
      else
      {
        txtRop.setBackground(invalid);
        error =error +"\n invalid ROP";
      }
//QOH
String qoh = txtQoh.getText();
if(qoh.matches("^\\d{1,5}$"))
  {
    item.setQoh(Integer.parseInt(qoh));
    txtQoh.setBackground(valid);
  }
else
{
  txtQoh.setBackground(invalid);
  error =error +"\n invalid QOH";
}

  //Brand
  int bndindex = cmbBrand.getSelectedIndex();
        if(bndindex != 0){
          cmbBrand.setBackground(valid);
          item.setBrand((Brand)cmbBrand.getSelectedItem() );
        }
        else{
          cmbBrand.setBackground(invalid);
          error =error +"\n Brand Not selected";
        }
  
  //SubCategory
  int subindex = cmblSubCategory.getSelectedIndex();
      if(subindex != 0){
        cmblSubCategory.setBackground(valid);
        item.setSubCategory((SubCategory)cmblSubCategory.getSelectedItem() );
      }
      else{
        cmblSubCategory.setBackground(invalid);
        error =error +"\n SubCategory Not selected";
      }
  // StatusItem
  int Simindex = cmbStatusItem.getSelectedIndex();
      if(Simindex != 0){
        cmbStatusItem.setBackground(valid);
        item.setStatusItem((StatusItem)cmbStatusItem.getSelectedItem() );
      }
      else{
        cmbStatusItem.setBackground(invalid);
        error =error +"\n StatusItem Not selected";
      }


  //Day,manth,year

  int dayindex = cmbDoinDay.getSelectedIndex();
  int monindex = cmbDoinMonth.getSelectedIndex();
  int yerindex = cmbDoinYear.getSelectedIndex();

  String day = "";
  String mon = "";
  String yer = "";

  if(dayindex != 0){
    cmbDoinDay.setBackground(valid);
    day = cmbDoinDay.getSelectedItem().toString();
    if(day.length()==1) day = "0" + day;
  }
  else{
    cmbDoinDay.setBackground(invalid);
  
  }
  if(monindex != 0){
    cmbDoinMonth.setBackground(valid);
    mon = cmbDoinMonth.getSelectedItem().toString();
    if(mon.length()==1) mon= "0" + mon;
  }
  else{
    cmbDoinMonth.setBackground(invalid);
  
  }
  if(yerindex != 0){
    cmbDoinYear.setBackground(valid);
    yer = cmbDoinYear.getSelectedItem().toString();
  }
  else{
    cmbDoinYear.setBackground(invalid);
  
  }




  if(dayindex != 0 && monindex !=0 && yerindex !=0 ){
    String doins = yer+"-"+mon+"-"+day;
    LocalDate doin = LocalDate.parse(doins);
    item.setDointroduced(doin);
  }
  else{
 
    error =error +"\n selecte Dointroduced";
  }


  if(error.isEmpty()){


    String cnfMsg = "Are you sure to save following Item?\n\n";
    cnfMsg = cnfMsg+"\nName :" +item.getName();
    cnfMsg = cnfMsg+"\nCode :" +item.getCode();
    cnfMsg = cnfMsg+"\nDointroduced :" +item.getDointroduced().toString();
    cnfMsg = cnfMsg+"\nBrand :" +item.getBrand().getName();
    cnfMsg = cnfMsg+"\nSubCategory :" +item.getSubCategory().getName();
    cnfMsg = cnfMsg+"\nPricesale :" +item.getPricesale();
    cnfMsg = cnfMsg+"\nPricepurchase :" +item.getPricepurchase();
    cnfMsg = cnfMsg+"\nROP :" +item.getRop();
    cnfMsg = cnfMsg+"\nQOH :" +item.getQoh();
    cnfMsg = cnfMsg+"\nStatusItem :" +item.getStatusItem().getName();

   int cof= JOptionPane.showConfirmDialog(null,cnfMsg);


        if(cof==0){
          String st= ItemController.post(item);
          if(st.equals("1")){
            loadView();
            loadform();
            JOptionPane.showMessageDialog(null,"Successfully saved");
        }else{
          JOptionPane.showMessageDialog(null,"Faild to save as \n\n" +st);
        }
      
      }
    }
  else{ 
  JOptionPane.showMessageDialog(null,error);

  }
  
}
}