import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
 
import java.sql.SQLException;

public class StatusItemDao{
public  static StatusItem getById(int id){

    StatusItem statusItem =  new StatusItem();
    try {
     
       String qry = "select * from statusItem where id = " +id ;
       ResultSet rslt = CommonDao.get(qry);      


            rslt.next();
            statusItem.setId(rslt.getInt("id"));
            statusItem.setName(rslt.getObject("name").toString());
        
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return statusItem;
}



}