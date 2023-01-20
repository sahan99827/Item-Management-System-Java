import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

public class SubCategoryDao{
public  static  SubCategory getById(int id){

    SubCategory  subCategory=  new  SubCategory();
    try {
     
       String qry = "select * from subcategory where id = " +id ;
       ResultSet rslt = CommonDao.get(qry);      


            rslt.next();
            subCategory.setId(rslt.getInt("id"));
            subCategory.setName(rslt.getObject("name").toString());
        
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return subCategory;
}

public  static List<SubCategory> getAll(){

    List<SubCategory> subCategories =  new ArrayList();

    try {
     
       String qry = "select * from subcategory;";
       ResultSet rslt = CommonDao.get(qry);      

            while( rslt.next()) {
                SubCategory subCategory = new SubCategory();

                subCategory.setId(rslt.getInt("id"));
                subCategory.setName(rslt.getObject("name").toString());
                

                subCategories.add(subCategory);
            }
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return subCategories;
}


}