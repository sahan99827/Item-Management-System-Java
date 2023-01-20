import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
//simport java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class RegexProvider {

    public static Hashtable<String, String> get() {

        Item itm = new Item();
        Hashtable<String, String> htregexes = new Hashtable();

        Field fs[] = itm.getClass().getFields();

        
        for (Field f : fs) {
            Patern a = f.getAnnotation(Patern.class);
            if (a != null) {
                htregexes.put(f.getName(), a.regexp());
            }
        }
        return htregexes;

    }
}

// }
/*
 * public static String get1(){
 * 
 * Employee emp = new Employee();
 * String regexname = "";
 * 
 * try{
 * 
 * Method setName = emp.getClass().getMethod("setName", String.class);
 * Patern name = setName.getAnnotation(Patern.class);
 * 
 * regexname= name.regexp();
 * 
 * }
 * catch(NoSuchMethodException e){
 * System.out.println("No method");
 * }
 * return regexname;
 * }
 */
/*
 * Method setName = emp.getClass().getMethod("setName", String.class);
 * Patern name = setName.getAnnotation(Patern.class);
 * 
 * Method setNic = emp.getClass().getMethod("setNic", String.class);
 * Patern nic = setNic.getAnnotation(Patern.class);
 * 
 * 
 * htregexes.put("name", name.regexp());
 * htregexes.put("nic", nic.regexp());
 * 
 * }
 * catch(NoSuchMethodException e){
 * System.out.println("No method");
 * }
 * public static Hashtable<String,String> get(){
 * 
 * Employee emp = new Employee();
 * 
 * Hashtable<String,String> htregexes =new Hashtable();
 * 
 * Method ms[] =emp.getClass().getMethods();
 * for (Method m : ms){
 * Patern a =m.getAnnotation(Patern.class);
 * if(a != null){
 * htregexes.put(m.getName().substring(3).toLowerCase(), a.regexp());
 * }
 * }
 * return htregexes;
 * 
 * 
 * }}
 */
