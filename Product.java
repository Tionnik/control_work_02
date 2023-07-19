package control_work_02;

public class Product {
    
    private int id;
    private String name;
    private int count;

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
}
