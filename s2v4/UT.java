import java.util.List;
import java.time.LocalDate;
public class UT{

public static void main(String[] args) {

        Brand b1 = BrandDao.getById(1);
        Brand b2 = BrandDao.getById(2);
        Brand b3 = BrandDao.getById(3);
        Brand b4 = BrandDao.getById(4);
        Brand b5 = BrandDao.getById(5);
        Brand b6 = BrandDao.getById(6);


        System.out.println(b1.getName());
        System.out.println(b2.getName());
        System.out.println(b3.getName());
        System.out.println(b4.getName());
        System.out.println(b5.getName());
        System.out.println(b6.getName());
        System.out.println("----------------------------------------------------------------------");

        SubCategory s1 = SubCategoryDao.getById(1);
        SubCategory s2 = SubCategoryDao.getById(2);
        SubCategory s3 = SubCategoryDao.getById(3);
        SubCategory s4 = SubCategoryDao.getById(4);
        SubCategory s5 = SubCategoryDao.getById(5);
      

        System.out.println(s1.getName());
        System.out.println(s2.getName());
        System.out.println(s3.getName());
        System.out.println(s4.getName());
        System.out.println(s5.getName());


        System.out.println("----------------------------------------------------------------------");
        StatusItem si1 = StatusItemDao.getById(1);
        StatusItem si2 = StatusItemDao.getById(2);
        StatusItem si3 = StatusItemDao.getById(3);
        StatusItem si4 = StatusItemDao.getById(4);

        System.out.println(si1.getName());
        System.out.println(si2.getName());
        System.out.println(si3.getName());
        System.out.println(si4.getName());

        System.out.println("----------------------------------------------------------------------");
        List<Item> itmlist =ItemDao.getAll();
        
        for(Item imp: itmlist){
           
           System.out.println(imp.getName()+"\t"+imp.getCode() +"\t" +imp.getSubCategory().getId()+"("+imp.getSubCategory().getName()+")" );

         }
         System.out.println("----------------------------------------------------------------------");
         List<Item> itmlist2 = ItemController.get();

         for(Item imp: itmlist2){
            
            System.out.println(imp.getName()+"\t"+imp.getCode() +"\t" +imp.getSubCategory().getId()+"("+imp.getSubCategory().getName()+")" );

         }
         
    }
}