import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ItemDao{
public  static List<Item> get(String qry){

    List<Item>  items =  new ArrayList();

    try {
     
      // String qry = "select * from item";
       ResultSet rslt = CommonDao.get(qry);      

           while( rslt.next()) {
            Item item = new Item();
            
               item.setId(rslt.getInt("id"));
               item.setName(rslt.getObject("name").toString());
               item.setRop(rslt.getInt("rop"));
               item.setDointroduced(LocalDate.parse(rslt.getObject("dointroduced").toString() ) );
               item.setCode(rslt.getObject("code").toString());
               item.setQoh(rslt.getInt("qoh"));
               item.setPricepurchase(rslt.getDouble("pricepurchase"));
               item.setPricesale(rslt.getDouble("pricesale"));
               item.setBrand(BrandDao.getById(rslt.getInt("brand_id") ) );
               item.setSubCategory(SubCategoryDao.getById(rslt.getInt("subcategory_id") ) );
               item.setStatusItem(StatusItemDao.getById(rslt.getInt("statusitem_id") ) );
               items.add(item);
           }
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return items;
}

public  static List<Item> getAll( ){
    String qry = "select * from item";
    List<Item>  items = get(qry);
    return items;
}

public  static List<Item> getAllByName(String name ){
    String qry = "select * from item where name like '"+name+"%' ";
    List<Item>  items =  get(qry);
    return items;
}

public  static List<Item> getAllByBrand(Brand brand){
    String qry = "select * from item where brand_id = "+brand.getId()+" ";
    List<Item> items =  get(qry);
    return items;
}


public  static List<Item> getAllBySubCategory(SubCategory subCategory){
    String qry = "select * from item where subcategory_id = "+subCategory.getId()+" ";
    List<Item> items =  get(qry);
    return items;
}


public  static List<Item> getAllByNameAndBrand(String name,Brand brand){
    String qry = "select * from item where name like '"+name+"%' and brand_id = "+brand.getId()+" ";
    List<Item> items =  get(qry);
    return items;
}

public  static List<Item> getAllByNameAndSubCategory(String name,SubCategory subCategory){
    String qry = "select * from item where name like '"+name+"%' and subcategory_id = "+subCategory.getId()+" ";
    List<Item> items =  get(qry);
    return items;
}


public  static List<Item> getAllBySubCategoryAndBrand(SubCategory subCategory,Brand brand){
    String qry = "select * from item where brand_id = "+brand.getId()+" and subcategory_id = "+subCategory.getId()+" ";
    List<Item> items =  get(qry);
    return items;
}


public  static List<Item> getAllByNameAndBrandAndSubCategory(String name,Brand brand,SubCategory subCategory){
    String qry = "select * from item where name like '"+name+"%' and brand_id ="+brand.getId()+" and subcategory_id = "+subCategory.getId()+" ; ";
    List<Item> items =  get(qry);
    return items;
}



}
 
