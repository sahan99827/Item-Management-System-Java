public class SubCategory{

    private int id;
    private String name;

    SubCategory(){    }

    public void setId(int id){ this.id = id; }
    public int getId(){ return id; }

    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }
    
    public String toString(){

        return name;
      
    } 
    public boolean equals(SubCategory obj){
        
        return obj.id==this.id;
    }

}