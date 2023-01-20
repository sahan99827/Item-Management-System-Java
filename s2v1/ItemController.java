import java.util.List;

public class ItemController{

public static List<Item> get(){

    List<Item> items = ItemDao.getAll();

    return items;

}
}