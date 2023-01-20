import java.time.LocalDate;

public class Item{

    private int id;
    private String name;
    private LocalDate dointroduced;
    private SubCategory subCategory;
    private int rop;
    private String code;
    private int qoh;
    private Brand  brand;
    private StatusItem statusItem;
    private double pricepurchase;
    private double pricesale;


    Item(){    }

    public void setId(int id){ this.id = id; }
    public int getId(){ return id; }

    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }

    public void setDointroduced(LocalDate dointroduced){ this.dointroduced =dointroduced; }
    public LocalDate getDointroduced(){ return dointroduced; }
    
    public void setSubCategory(SubCategory subCategory){ this.subCategory =subCategory; }
    public  SubCategory getSubCategory(){ return subCategory; }
    
    public void setRop(int rop){ this.rop = rop; }
    public int  getRop(){ return rop; }
    
    public void setCode(String code){ this.code = code; }
    public String  getCode(){ return code; }

    public void setQoh(int qoh){ this.qoh = qoh; }
    public int getQoh(){ return qoh; }
    
    public void setBrand(Brand brand){ this.brand =brand; }
    public Brand getBrand(){ return brand; }
    
    public void setStatusItem(StatusItem statusItem){ this.statusItem = statusItem; }
    public StatusItem getStatusItem(){ return  statusItem; }

    public void setPricepurchase(double pricepurchase){ this.pricepurchase = pricepurchase; }
    public double getPricepurchase(){ return pricepurchase; }

    public void setPricesale(double pricesale){ this.pricesale = pricesale; }
    public double getPricesale(){ return pricesale; }


}