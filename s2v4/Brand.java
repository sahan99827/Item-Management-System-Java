public class Brand{

    private int id;
    private String name;

    Brand(){    }

    public void setId(int id){ this.id = id; }
    public int getId(){ return id; }

    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }

    public String toString(){

        return name;
      
    } 
    public boolean equals(Brand obj){

        return obj.id==this.id;
    }


}