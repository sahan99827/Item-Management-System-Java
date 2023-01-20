import java.util.List;
import java.util.Hashtable;
import java.util.ArrayList;

public class ItemController{

public static List<Item> get(Hashtable<String,Object> ht){
System.out.println(ht);
    List<Item> items = new ArrayList<>();
    if(ht == null){
        items =ItemDao.getAll();
        }
        else{
        String name = (String)ht.get("name");
        Brand brand = (Brand)ht.get("brand");
        SubCategory subCategory =(SubCategory)ht.get("subCategory");
       
        if(name.equals("") && brand == null && subCategory == null)
            items =ItemDao.getAll();

        if(!name.equals("") && brand == null && subCategory == null)
            items = ItemDao.getAllByName(name);

        if(name.equals("") && brand != null && subCategory == null)
            items = ItemDao.getAllByBrand(brand);
        
        if(name.equals("") && brand == null && subCategory != null)
            items = ItemDao.getAllBySubCategory(subCategory);
           
        if(!name.equals("") && brand != null && subCategory == null)
            items =ItemDao.getAllByNameAndBrand(name, brand);
        
        if(name.equals("") && brand != null && subCategory != null)
            items =ItemDao.getAllBySubCategoryAndBrand(subCategory, brand);
            
        if(!name.equals("") && brand == null && subCategory != null)
            items =ItemDao.getAllByNameAndSubCategory(name,subCategory);
          
        if(!name.equals("") && brand != null && subCategory != null)
            items =ItemDao.getAllByNameAndBrandAndSubCategory(name, brand,subCategory);
            
        }
    return items;

}
}