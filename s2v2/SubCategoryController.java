import java.util.List;
import java.util.ArrayList;

public class SubCategoryController{

public static List<SubCategory> get(){

    List<SubCategory> subcategorys = SubCategoryDao.getAll();

    return subcategorys;

}
}