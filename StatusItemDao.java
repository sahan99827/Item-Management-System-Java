import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

public class StatusItemDao{
public  static StatusItem getById(int id){

    StatusItem statusItem =  new StatusItem();
    try {
     
       String qry = "select * from statusitem where id = " +id ;
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


public  static List<StatusItem> getAll(){

    List<StatusItem> statusItems =  new ArrayList();

    try {
     
        String qry = "select * from statusitem";
        ResultSet rslt = CommonDao.get(qry);      

            while( rslt.next()) {
                StatusItem statusItem = new StatusItem();

                statusItem.setId(rslt.getInt("id"));
                statusItem.setName(rslt.getObject("name").toString());
                

                statusItems.add(statusItem);
            }
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return statusItems;
}


}