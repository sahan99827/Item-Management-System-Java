import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
 
import java.sql.SQLException;

public class BrandDao{
public  static Brand getById(int id){

    Brand brand =  new Brand();
    try {
       

       String qry = "select * from brand where id = " +id ;
        ResultSet rslt = CommonDao.get(qry);      

        rslt.next();
        brand.setId(rslt.getInt("id"));
        brand.setName(rslt.getObject("name").toString());
        
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return brand;
}



}