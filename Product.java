package control_work_02;

public class Product implements Comparable <Product> {
    
    private int id;
    private String name;
    private int count;
    private int chance;

    public Product (int vendor_code, String name_product, int count, int chance){
        this.id  = vendor_code;
        this.name = name_product;
        this.count = count;
        this.chance = chance;
    }

    public Product (int vendor_code, String name_product, int count){
        this.id  = vendor_code;
        this.name = name_product;
        this.count = count;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public int getChance() {
        return chance;
    }

    @Override
    public int compareTo(Product other) {
        if (other == null) {
            return -1; 
        }
        int delta = this.chance - other.chance;
        if (delta != 0) {
            return - delta;
        }  
        return this.name.compareTo(other.name);
    }
}
