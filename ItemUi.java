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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Hashtable;
import java.time.LocalDate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import com.toedter.calendar.JCalendar;

public class ItemUi extends JFrame {

  // Viwe
  JTable tblItem;
  JComboBox<Object> cmbSearchBrand;
  JTextField textSearchName;
  Vector titles;

  // TextField
  JTextField txtName;
  JTextField txtCode;
  JTextField txtPricepurchase;
  JTextField txtPricesale;
  JTextField txtRop;
  JTextField txtQoh;
  JTextField txtDate;

  // ComboBOx
  JComboBox<Object> cmbBrand;
  JComboBox<Object> cmblSubCategory;
  JComboBox<Object> cmbStatusItem;

  // Button
  JButton btnAdd;
  JButton btnClear;
  JButton btnUpdate;
  JButton btnDelet;

  // Color
  Color valid;
  Color invalid;
  Color initial;
  Color update;
  Color input;

  // Item
  Item oldItem;
  Item item;

  // list
  List<Item> itemlist;
  List<Brand> brnlist;
  List<SubCategory> sublist;
  List<StatusItem> simlist;

  // Date
  JDateChooser datDob;

  // Regex Valadition in RegexPovider
  Hashtable<String, String> rgName;
  int row;

  ItemUi() {

    valid = new Color(200, 255, 200);
    invalid = Color.pink;
    initial = Color.white;
    update = Color.yellow;
    input = Color.blue;

    setTitle("Item");
    setLocation(300, 200);
    setSize(880, 800);

    Container con = getContentPane();
    FlowLayout lay1 = new FlowLayout();
    con.setLayout(lay1);

    // Leble
    JLabel lblNmae = new JLabel("Name  : ");
    JLabel lblDointroduced = new JLabel("Dointroduced  : ");
    JLabel lblBrand = new JLabel("      Brand  : ");
    JLabel lblCode = new JLabel("       CODE  : ");
    JLabel lblPricepurchase = new JLabel("Pricepurchase : ");
    JLabel lblPricesale = new JLabel("Pricesale : ");
    JLabel lblSubCategory = new JLabel("SubCategory  : ");
    JLabel lblStatus = new JLabel("    StatusItem  : ");
    JLabel lblRop = new JLabel("    ROP : ");
    JLabel lblQoh = new JLabel("    QOH : ");

    // Text Filed
    txtName = new JTextField(72);
    txtCode = new JTextField(30);
    txtPricepurchase = new JTextField(65);
    txtPricesale = new JTextField(70);
    txtRop = new JTextField(70);
    txtQoh = new JTextField(70);

    // ComboBox
    cmbBrand = new JComboBox();
    cmblSubCategory = new JComboBox();
    cmbStatusItem = new JComboBox();
    // cmbDoinYear =new JComboBox();
    // cmbDoinMonth =new JComboBox();
    // cmbDoinDay =new JComboBox();

    // Button
    btnAdd = new JButton("Add");
    btnClear = new JButton("Clear");
    btnUpdate = new JButton("Update");
    btnDelet = new JButton("Delet");

    datDob = new JDateChooser();
    // JLabel lblEmpty= new JLabel(" ");

    con.add(lblNmae);
    con.add(txtName);
    con.add(lblDointroduced);
    con.add(datDob);
    // con.add(cmbDoinYear); con.add(cmbDoinMonth); con.add(cmbDoinDay);
    con.add(lblBrand);
    con.add(cmbBrand);
    // con.add(lblEmpty);
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

    JLabel lblfristEnd = new JLabel(
        "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    con.add(lblfristEnd);

    // Button
    con.add(btnDelet);
    con.add(btnUpdate);
    con.add(btnClear);
    con.add(btnAdd);

    JLabel lblFormEnd = new JLabel(
        "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    JLabel lblFormEnd2 = new JLabel(
        "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    con.add(lblFormEnd);
    con.add(lblFormEnd2);

    // Search
    JLabel lblSearchNmae = new JLabel("Name  : ");
    textSearchName = new JTextField(20);
    JLabel lblSearchBrand = new JLabel("Brand : ");
    cmbSearchBrand = new JComboBox();
    JButton btnSearchClear = new JButton("Clear Search");
    JButton btnSearch = new JButton("Search");

    con.add(lblSearchNmae);
    con.add(textSearchName);
    con.add(lblSearchBrand);
    con.add(cmbSearchBrand);

    JLabel lblfristEnd4 = new JLabel(
        "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    con.add(lblfristEnd4);

    con.add(btnSearchClear);
    con.add(btnSearch);

    JLabel lblSeconEnd = new JLabel(
        "\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
    con.add(lblSeconEnd);
    JLabel lblSeconEnd2 = new JLabel(
        "\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
    con.add(lblSeconEnd2);

    // Table

    titles = new Vector();
    titles.add("Name");
    titles.add("Brand");
    titles.add("SubCategory");
    titles.add("Pricepurchase");
    titles.add("Pricesale");
    titles.add("pro");
    titles.add("Qoh");
    titles.add("Rop");
    titles.add("StatusItem");
    titles.add("Dointroduced");

    Vector data = new Vector();

    DefaultTableModel dataModel = new DefaultTableModel(data, titles);
    tblItem = new JTable();

    tblItem.setModel(dataModel);

    JScrollPane jspTable = new JScrollPane();
    jspTable.setPreferredSize(new Dimension(800, 200));
    jspTable.setViewportView(tblItem);

    con.add(jspTable);

    btnSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSearchAp(e);
      }
    });
    btnSearchClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnSearchClearAp(e);
      }
    });

    txtName.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtNameKR(e);
      }
    });
    txtCode.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtCodeKR(e);
      }
    });
    txtPricepurchase.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtPricepurchaseKR(e);
      }
    });
    txtPricesale.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtPricesaleKR(e);
      }
    });
    txtRop.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtRopKR(e);
      }
    });
    txtQoh.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtQohKR(e);
      }
    });

    cmbBrand.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cmbBrandAP(e);
      }
    });
    cmblSubCategory.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cmblSubCategoryAP(e);
      }
    });
    cmbStatusItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cmbStatusItemAP(e);
      }
    });

    // cmbDoinDay.addActionListener( new ActionListener(){ public void
    // actionPerformed(ActionEvent e){ DointroducedAP(e); } } );
    // cmbDoinMonth.addActionListener( new ActionListener(){ public void
    // actionPerformed(ActionEvent e){ DointroducedAP(e); } } );
    // cmbDoinYear.addActionListener( new ActionListener(){ public void
    // actionPerformed(ActionEvent e){ DointroducedAP(e); } } );

    datDob.addPropertyChangeListener(new PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent e) {
        datDobAp(e);
      }
    });

    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddAp(e);
      }
    });
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnclearAp(e);
      }
    });
    btnUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdateAp(e);
      }
    });
    btnDelet.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDeletAp(e);
      }
    });
    tblItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        tblItemVC(e);
      }
    });
    intitialize();

  }

  // view Table

  public void intitialize() {
    rgName = RegexProvider.get();
    loadform();
    loadView();

  }

  public void loadform() {

    item = new Item();

    // Brand
    brnlist = BrandController.get();
    Vector<Object> brands = new Vector();
    brands.add("Select a Brand");

    for (Brand bn : brnlist) {
      brands.add(bn);

    }

    DefaultComboBoxModel<Object> bnModel = new DefaultComboBoxModel(brands);
    cmbBrand.setModel(bnModel);

    // SubCategory
    sublist = SubCategoryController.get();
    Vector<Object> subCategories = new Vector();
    subCategories.add("Select a SubCategory");

    for (SubCategory sc : sublist) {
      subCategories.add(sc);

    }

    DefaultComboBoxModel<Object> scModel = new DefaultComboBoxModel(subCategories);
    cmblSubCategory.setModel(scModel);

    // StatusItem
    simlist = StatusItemController.get();
    Vector<Object> statusItems = new Vector();
    statusItems.add("Select StatusItem");

    for (StatusItem si : simlist) {
      statusItems.add(si);

    }
    DefaultComboBoxModel<Object> siModel = new DefaultComboBoxModel(statusItems);
    cmbStatusItem.setModel(siModel);
    /*
     * //Dointroduced
     * 
     * Vector<Object> DoinDay = new Vector();
     * DoinDay.add("Selec Day");
     * 
     * for(int i=1; i<=31;i++){
     * DoinDay.add(i);
     * 
     * }
     * DefaultComboBoxModel<Object> dayModel = new DefaultComboBoxModel(DoinDay);
     * cmbDoinDay.setModel(dayModel);
     * 
     * //DobManth
     * 
     * Vector<Object> DoinManth = new Vector();
     * DoinManth.add("Select Manth");
     * 
     * for(int i=1; i<=12; i++){
     * DoinManth.add(i);
     * 
     * }
     * DefaultComboBoxModel<Object> ManModel= new DefaultComboBoxModel(DoinManth);
     * cmbDoinMonth.setModel(ManModel);
     * 
     * //DobYear
     * 
     * Vector<Object> DoinYear = new Vector();
     * DoinYear.add("Select Year");
     * 
     * for(int i=2005; i<=2040;i++){
     * DoinYear.add(i);
     * 
     * }
     * cmbDoinYear.setModel( new DefaultComboBoxModel(DoinYear));
     */
    txtName.setText("");
    txtCode.setText("");
    txtPricepurchase.setText("");
    txtPricesale.setText("");
    txtRop.setText("");
    txtQoh.setText("");

    txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
    txtDate.setText("");

    enabledButtons(true, false, false);
    setStyle(initial);

  }

  public void setStyle(Color clr) {

    txtName.setBackground(clr);
    txtCode.setBackground(clr);
    txtPricepurchase.setBackground(clr);
    txtPricesale.setBackground(clr);
    txtRop.setBackground(clr);
    txtQoh.setBackground(clr);

    cmblSubCategory.setBackground(clr);
    cmbStatusItem.setBackground(clr);
    cmbBrand.setBackground(clr);

    txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
    txtDate.setBackground(clr);

  }

  public void enabledButtons(boolean add, boolean upd, boolean delt) {

    btnAdd.setEnabled(add);
    btnUpdate.setEnabled(upd);
    btnDelet.setEnabled(delt);

  }

  public void fillForm() {
    enabledButtons(false, true, true);
    setStyle(valid);
  }

  public void loadView() {
    
    itemlist = ItemController.get(null);
    fillTable(itemlist);

    brnlist = BrandController.get();
    Vector<Object> brands = new Vector();
    brands.add("Select a Brand");

    for (Brand brd : brnlist) {
      brands.add(brd);

    }

    DefaultComboBoxModel<Object> brnModel = new DefaultComboBoxModel(brands);
    cmbSearchBrand.setModel(brnModel);

  }

  public void fillTable(List<Item> item) {

    Vector data = new Vector();
    for (Item itm : item) {
      Vector r = new Vector();
      r.add(itm.getName());
      r.add(itm.getBrand().getName());
      r.add(itm.getSubCategory().getName());
      r.add(itm.getPricepurchase());
      r.add(itm.getPricesale());
      r.add(itm.getPricesale() - itm.getPricepurchase());
      r.add(itm.getRop());
      r.add(itm.getQoh());
      r.add(itm.getStatusItem().getName());
      r.add(itm.getDointroduced().toString());

      data.add(r);

    }
    DefaultTableModel dataModel = new DefaultTableModel(data, titles);
    tblItem.setModel(dataModel);

  }

  public void btnSearchAp(ActionEvent e) {

    String name = textSearchName.getText();

    Object stitem = cmbSearchBrand.getSelectedItem();
    Brand brand = null;

    if (!stitem.equals("Select a Brand"))
      brand = (Brand) stitem;
    Hashtable<String, Object> ht = new Hashtable();
    ht.put("name", name);
    if (brand != null)
      ht.put("brand", brand);
    itemlist = ItemController.get(ht);
    fillTable(itemlist);

  }

  public void btnSearchClearAp(ActionEvent e) {

    int opt = JOptionPane.showConfirmDialog(null, "Are you sure to clear the clear");

    if (opt != 1) {

      textSearchName.setText("");
      cmbSearchBrand.setSelectedIndex(0);

      itemlist = ItemController.get(null);
      fillTable(itemlist);
    }
  }

  // binding and validation
  public void txtNameKR(KeyEvent e) {

    String name = txtName.getText();
    if (name.matches(rgName.get("name"))) {
      item.setName(name);
      txtName.setBackground(valid);
      if (oldItem != null) {
        if (!item.getName().equals(oldItem.getName()))
          txtName.setBackground(update);
      }
      // txtName.setBackground(valid);
    } else {
      txtName.setBackground(invalid);
      item.setName(null);
    }
  }

  public void txtCodeKR(KeyEvent e) {

    String code = txtCode.getText();
    if (code.matches(rgName.get("code"))) {
      item.setCode(code);
      txtCode.setBackground(valid);
      if (oldItem != null) {
        if (!item.getCode().equals(oldItem.getCode()))
          txtCode.setBackground(update);
      }
      // txtCode.setBackground(valid);
    } else {
      txtCode.setBackground(invalid);
      item.setCode(null);
    }
  }

  public void txtPricepurchaseKR(KeyEvent e) {

    String pricepurchase = txtPricepurchase.getText();
    if (pricepurchase.matches(rgName.get("pricepurchase"))) {
      item.setPricepurchase(Double.parseDouble(pricepurchase));
      txtPricepurchase.setBackground(valid);
      if (oldItem != null) {
        if (item.getPricepurchase() != oldItem.getPricepurchase())
          txtPricepurchase.setBackground(update);
      }
      // txtPricepurchase.setBackground(valid);
    } else {
      txtPricepurchase.setBackground(invalid);
      item.setPricepurchase(0.0);
    }
  }

  public void txtPricesaleKR(KeyEvent e) {

    // Pricesale
    String pricesale = txtPricesale.getText();
    if (pricesale.matches(rgName.get("pricesale"))) {
      item.setPricesale(Double.parseDouble(pricesale));
      txtPricesale.setBackground(valid);
      if (oldItem != null) {
        if (item.getPricesale() != oldItem.getPricesale())
          txtPricesale.setBackground(update);
      }
      // txtPricesale.setBackground(valid);
    } else {
      txtPricesale.setBackground(invalid);
      item.setPricesale(0.0);
    }
  }

  public void txtRopKR(KeyEvent e) {

    String rop = txtRop.getText();
    if (rop.matches(rgName.get("rop"))) {
      item.setRop(Integer.parseInt(rop));
      txtRop.setBackground(valid);
      if (oldItem != null) {
        if (item.getRop() != oldItem.getRop())
          txtRop.setBackground(update);
      }
      // txtRop.setBackground(valid);
    } else {
      txtRop.setBackground(invalid);
      item.setRop(0);
    }
  }

  public void txtQohKR(KeyEvent e) {

    String qoh = txtQoh.getText();
    if (qoh.matches(rgName.get("qoh"))) {
      item.setQoh(Integer.parseInt(qoh));
      txtQoh.setBackground(valid);
      if (oldItem != null) {
        if (item.getQoh() != oldItem.getQoh())
          txtQoh.setBackground(update);
      }
      // txtQoh.setBackground(valid);
    } else {
      txtQoh.setBackground(invalid);
      item.setQoh(0);
    }
  }

  public void cmbBrandAP(ActionEvent e) {
    int bndindex = cmbBrand.getSelectedIndex();
    if (bndindex != 0) {
      cmbBrand.setBackground(valid);
      item.setBrand((Brand) cmbBrand.getSelectedItem());
      if (oldItem != null) {
        if (!item.getBrand().equals(oldItem.getBrand()))
          cmbBrand.setBackground(update);
      }
      // cmbBrand.setBackground(valid);
    } else {
      cmbBrand.setBackground(invalid);
      item.setBrand(null);
    }
  }

  public void cmblSubCategoryAP(ActionEvent e) {
    int subindex = cmblSubCategory.getSelectedIndex();
    if (subindex != 0) {
      cmblSubCategory.setBackground(valid);
      item.setSubCategory((SubCategory) cmblSubCategory.getSelectedItem());
      if (oldItem != null) {
        if (!item.getSubCategory().equals(oldItem.getSubCategory()))
          cmblSubCategory.setBackground(update);
      }
      // cmblSubCategory.setBackground(valid);
    } else {
      cmblSubCategory.setBackground(invalid);
      item.setSubCategory(null);
    }
  }

  public void cmbStatusItemAP(ActionEvent e) {
    int Simindex = cmbStatusItem.getSelectedIndex();
    if (Simindex != 0) {
      cmbStatusItem.setBackground(valid);
      item.setStatusItem((StatusItem) cmbStatusItem.getSelectedItem());
      if (oldItem != null) {
        if (!item.getStatusItem().equals(oldItem.getStatusItem()))
          cmbStatusItem.setBackground(update);
      }
      // cmbStatusItem.setBackground(valid);
    } else {
      cmbStatusItem.setBackground(invalid);
      item.setStatusItem(null);
    }
  }

  public void datDobAp(PropertyChangeEvent e) {
    // Day,manth,year

    Date dt = datDob.getDate();
    if (dt != null) {
      LocalDate doin = LocalDate.of(dt.getYear() + 1900, dt.getMonth() + 1, dt.getDate());
      LocalDate today = LocalDate.now();

      txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
      if (today.getYear() >= doin.getYear()) {
        item.setDointroduced(doin);
        txtDate.setBackground(valid);
        if (oldItem != null) {
          if (today.getYear() >= doin.getYear() && !item.getDointroduced().equals(oldItem.getDointroduced()))
            txtDate.setBackground(update);
        }
        // txtDate.setBackground(valid);
      } else {
        item.setDointroduced(null);
        txtDate.setBackground(invalid);
      }

    }

  }

  // Form Hadaling
  public String getErrors() {
    String errors = "";
    if (item.getName() == null)
      errors = errors + "\n invalid Name";
    if (item.getCode() == null)
      errors = errors + "\n invalid Code";
    ;
    if (item.getPricepurchase() == 0.0)
      errors = errors + "\n invalid Pricepurchase";
    if (item.getPricesale() == 0.0)
      errors = errors + "\n invalid pricesale";
    if (item.getRop() == 0)
      errors = errors + "\n invalid ROP";
    if (item.getQoh() == 0)
      errors = errors + "\n invalid QOH";
    if (item.getBrand() == null)
      errors = errors + "\n Brand Not selected";
    if (item.getSubCategory() == null)
      errors = errors + "\n SubCategory Not selected";
    if (item.getStatusItem() == null)
      errors = errors + "\n StatusItem Not selected";
    if (item.getDointroduced() == null)
      errors = errors + "\n selecte Dointroduced";
    return errors;

  }

  public void btnAddAp(ActionEvent e) {

    // Item item = new Item();

    String error = getErrors();

    if (error.isEmpty()) {

      String cnfMsg = "Are you sure to save following Item?\n\n";
      cnfMsg = cnfMsg + "\nName :" + item.getName();
      cnfMsg = cnfMsg + "\nCode :" + item.getCode();
      cnfMsg = cnfMsg + "\nDointroduced :" + item.getDointroduced().toString();
      cnfMsg = cnfMsg + "\nBrand :" + item.getBrand().getName();
      cnfMsg = cnfMsg + "\nSubCategory :" + item.getSubCategory().getName();
      cnfMsg = cnfMsg + "\nPricesale :" + item.getPricesale();
      cnfMsg = cnfMsg + "\nPricepurchase :" + item.getPricepurchase();
      cnfMsg = cnfMsg + "\nROP :" + item.getRop();
      cnfMsg = cnfMsg + "\nQOH :" + item.getQoh();
      cnfMsg = cnfMsg + "\nStatusItem :" + item.getStatusItem().getName();

      int cof = JOptionPane.showConfirmDialog(null, cnfMsg);

      if (cof == 0) {
        String st = ItemController.post(item);
        if (st.equals("1")) {

          loadView();
          loadform();

          JOptionPane.showMessageDialog(null, "Successfully saved");
        } else {
          JOptionPane.showMessageDialog(null, "Faild to save as \n\n" + st);
        }

      }
    } else {
      JOptionPane.showMessageDialog(null, error);

    }

  }

  public void tblItemVC(ListSelectionEvent e) {

    int row = tblItem.getSelectedRow();
    if (row > -1) {
      Item it = itemlist.get(row);
      fillForm(it);
    }
  }

  public void fillForm(Item itm) {

    oldItem = itm;
    item = new Item();

    item.setName(itm.getName());
    item.setCode(itm.getCode());
    item.setPricepurchase(itm.getPricepurchase());
    item.setPricesale(itm.getPricesale());
    item.setRop(itm.getRop());
    item.setQoh(itm.getQoh());
    item.setBrand(itm.getBrand());
    item.setStatusItem(itm.getStatusItem());
    item.setSubCategory(itm.getSubCategory());
    item.setDointroduced(itm.getDointroduced());

    txtName.setText(itm.getName());
    txtCode.setText(itm.getCode());
    txtPricepurchase.setText(Double.toString(itm.getPricepurchase()));
    txtPricesale.setText(Double.toString(itm.getPricesale()));
    txtRop.setText(Integer.toString(itm.getRop()));
    txtQoh.setText(Integer.toString(itm.getQoh()));

    int a = 0;
    for (Brand bn : brnlist) {

      a++;

      if (bn.getId() == itm.getBrand().getId()) {
        // cmbBrand.setSelectedItem(bn);
        break;
      }

    }
    cmbBrand.setSelectedIndex(a);

    for (SubCategory sub : sublist) {
      if (sub.getId() == itm.getSubCategory().getId()) {
        cmblSubCategory.setSelectedItem(sub);
        break;
      }

    }

    for (StatusItem sim : simlist) {
      if (sim.getId() == itm.getStatusItem().getId()) {
        cmbStatusItem.setSelectedItem(sim);
        break;
      }

    }

    datDob.setDate(new java.util.Date(itm.getDointroduced().toEpochDay()));
    int year = itm.getDointroduced().getYear();
    int month = itm.getDointroduced().getMonthValue();
    int day = itm.getDointroduced().getDayOfMonth();

    java.util.Date datdob = new java.util.Date(year - 1900, month - 1, day);
    datDob.setDate(datdob);
    datDob.updateUI();
    // cmbDoinDay.setSelectedItem(item.getDointroduced().getDayOfMonth());
    // cmbDoinMonth.setSelectedItem(item.getDointroduced().getMonthValue());
    // cmbDoinYear.setSelectedItem(item.getDointroduced().getYear());

    enabledButtons(false, true, true);
    setStyle(valid);
  }

  public void btnclearAp(ActionEvent e) {
    int con = JOptionPane.showConfirmDialog(null, "Are sure to clear the form");

    if (con == 0) {
      loadform();
      oldItem = null;
    }

  }

  public String getUpdates() {
    String updates = "";

    // Name
    if (!item.getName().equals(oldItem.getName())) {
      updates = updates + "\n Name Updated" + "-" + item.getName();
    }
    // Code
    if (!item.getCode().equals(oldItem.getCode())) {
      updates = updates + "\n Code Updated" + "-" + item.getCode();
    }
    // Pricepurchas
    if (item.getPricepurchase() != oldItem.getPricepurchase()) {
      updates = updates + "\nPricepurchase Updated" + "-" + item.getPricepurchase();
    }
    // Pricesale
    if (item.getPricesale() != oldItem.getPricesale()) {
      updates = updates + "\n Pricesale Updated" + "-" + item.getPricesale();
    }
    // ROP
    if (item.getRop() != oldItem.getRop()) {
      updates = updates + "\n Rop Updated" + "-" + item.getRop();
    }
    // QOH
    if (item.getQoh() != oldItem.getQoh()) {
      updates = updates + "\n Qoh Updated" + "-" + item.getQoh();
    }
    // Brand
    if (!item.getBrand().equals(oldItem.getBrand())) {
      cmbBrand.setBackground(update);
      updates = updates + "\n Brand Updated" + "-" + item.getBrand();
    }
    // SubCategory
    if (!item.getSubCategory().equals(oldItem.getSubCategory())) {
      updates = updates + "\nSubCategory Updated" + "-" + item.getSubCategory();
    }
    // StatusItem
    if (!item.getStatusItem().equals(oldItem.getStatusItem())) {
      updates = updates + "\n StasusItem Updated" + "-" + item.getStatusItem();
    }
    // Dointroduced
    Date dt = datDob.getDate();
    if (dt != null) {
      LocalDate doin = LocalDate.of(dt.getYear() + 1900, dt.getMonth() + 1, dt.getDate());
      LocalDate today = LocalDate.now();
      txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
      if (today.getYear() >= doin.getYear() && !item.getDointroduced().equals(oldItem.getDointroduced())) {
        updates = updates + "\n Bith Day Updated" + "-" + item.getDointroduced();
      }
    }

    return updates;
  }

  public void btnUpdateAp(ActionEvent e) {

    // Item item = new Item();
    item.setId(oldItem.getId());
    String error = getErrors();

    if (error.isEmpty()) {
      String updates = getUpdates();
      if (!updates.isEmpty()) {
        int resp = JOptionPane.showConfirmDialog(null, "you have following Updates\n\n" + updates);

        if (resp == 0) {
          String status = ItemController.put(item);

          if (status.equals("1")) {
            int lsrow = tblItem.getSelectedRow();
            // loadform();
            loadView();
            tblItem.setRowSelectionInterval(lsrow, lsrow);
            loadform();
            oldItem = null;
            JOptionPane.showMessageDialog(null, "Successfully Updated");

          } else {
            JOptionPane.showMessageDialog(null, "Faild to Updated as\n\n" + updates);
          }

        }
      } else {
        JOptionPane.showMessageDialog(null, "Nothing to be Update");
      }

    } else {
      JOptionPane.showMessageDialog(null, "you have following data Error\n\n" + error);
    }

  }

  public void btnDeletAp(ActionEvent e) {

    int resp = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete following Employee\n\n" + oldItem.getName());

    if (resp == 0) {
      String status = ItemController.Delete(oldItem);

      if (status.equals("1")) {

        loadform();
        loadView();
        oldItem = null;

        JOptionPane.showMessageDialog(null, "Successfully Deleted");

      } else {
        JOptionPane.showMessageDialog(null, "Faild to Deleted as\n\n" + status);
      }

    }

  }

}