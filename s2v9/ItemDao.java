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

public  static List<Item> getAllByNameAndBrand(String name,Brand brand){
    String qry = "select * from item where name like '"+name+"%' and brand_id = "+brand.getId()+" ";
    List<Item> items =  get(qry);
    return items;
}


public  static Item getByCode(String code){
    Item item =null;
    
String qry = "select * from item where code ='"+code+"'";
try{
    ResultSet rslt = CommonDao.get(qry); 
    if(rslt!=null && rslt.next()){

    item = new Item();
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

        
    }

    }catch(SQLException e1){
        System.out.println("Can't Connect as : " + e1.getMessage());
    }

        return item;
    }

public static String save(Item item){

String msg="0";

String sql ="insert into item(name,dointroduced,brand_id,code,rop,qoh,pricepurchase,pricesale,statusitem_id,subcategory_id) Values('"+
                    item.getName()+"','"+
                    item.getDointroduced().toString()+"',"+
                    item.getBrand().getId()+",'"+
                    item.getCode()+"',"+
                    item.getRop()+","+
                    item.getQoh()+","+
                    item.getPricepurchase()+","+
                    item.getPricesale()+","+
                    item.getStatusItem().getId()+","+
                    item.getSubCategory().getId()+")";

msg = CommonDao. modify(sql);



return msg;

                }


                
public static String update(Item item){
   
    String msg="1";
    String sql = "UPDATE item set name='"+item.getName()+"', code ='"+
                                             item.getCode()+"', dointroduced ='"+
                                             item.getDointroduced()+"',rop="
                                             +item.getRop()+",qoh="
                                             +item.getQoh()+",brand_id='"
                                             +item.getBrand().getId()+"',subcategory_id="
                                             +item.getSubCategory().getId()+", statusitem_id="
                                             +item.getStatusItem().getId()+" , pricesale="
                                             +item.getPricesale()+",pricepurchase="
                                             +item.getPricepurchase()+" WHERE id="
                                             +item.getId()+"";


    msg = CommonDao.modify(sql);

        return msg;

    }
    
public static String Delete(Item item){

        String msg="1";
        String sql = "delete from item where id ="+item.getId();
        msg = CommonDao.modify(sql);

            return msg;
    
        }    



}
 
