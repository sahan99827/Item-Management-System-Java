import java.util.List;

public class BrandController{

public static List<Brand> get(){

    List<Brand> brands =BrandDao.getAll();

    return brands;

}
}