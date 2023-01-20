import java.util.List;

public class  SubCategoryController{

public static List<SubCategory> get(){

    List<SubCategory>  subCategories =  SubCategoryDao.getAll();

    return subCategories;

}
}