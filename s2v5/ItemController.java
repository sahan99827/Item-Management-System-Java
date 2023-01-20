import java.util.List;
import java.util.Hashtable;
import java.util.ArrayList;

public class ItemController{

public static List<Item> get(Hashtable<String,Object> ht){

    List<Item> items = new ArrayList<>();
    if(ht == null){
        items =ItemDao.getAll();
        }
        else{
         String name = (String)ht.get("name");
         Brand brand = (Brand)ht.get("brand");
        
            if(brand== null)
            items = ItemDao.getAllByName(name);
            else if(name== null)
            items = ItemDao.getAllByBrand(brand);
            else{
            items =ItemDao.getAllByNameAndBrand(name, brand);
            }
        }
    return items;

}
public static String post(Item item){
    
    String msg ="";
    String err ="";

  
    Item itmCode =ItemDao.getByCode(item.getCode());

        if(itmCode!=null) err =err +"\nCode Exists";

        if(err.isEmpty())
        {

            String dberr = ItemDao.save(item);
            if(dberr.equals("1"))
            msg ="1";
            else            
            msg ="DB error as: "+ dberr;

        }else{
            msg= "Data Errors: \n" + err;
        }

    
        return msg;
            } 

            
public static String put(Item item){
                String msg ="";
                    String err ="";
            
                   
                        Item itmCode =ItemDao.getByCode(item.getCode());
            
                        if(itmCode!=null &&  itmCode.getId() != item.getId()) err =err +"\nCODE Exists";
            
                        if(err.isEmpty())
                        {
            
                            String dberr = ItemDao.update(item);
                            if(dberr.equals("1"))
                            msg ="1";
                            else            
                            msg ="DB error as: "+ dberr;
            
                        }else{
                            msg= "Validation Errors: \n" + err;
                        }
            
                    
                        return msg;
                        }

public static String Delete(Item item){
                            String msg ="";               
                              String dberr = ItemDao.Delete(item);
                                if(dberr.equals("1"))
                                      msg ="1";
                                else            
                                      msg ="DB error as: "+ dberr;
                                
                                
                                                  
                            return msg;
                        }           
                      
}