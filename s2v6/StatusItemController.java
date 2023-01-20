import java.util.List;

public class StatusItemController{

public static List<StatusItem> get(){

    List<StatusItem> statusItems = StatusItemDao.getAll();

    return statusItems;

}
}