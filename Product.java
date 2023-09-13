package control_work_02;

public class Product implements Comparable <Product> {
    
    private String id;
    private String name;
    private int count;
    private int chance;

    public Product (String vendor_code, String name_product, int count, int chance){  //конструктор для игрушки с добавленным случайным числом
        this.id  = vendor_code;
        this.name = name_product;
        this.count = count;
        this.chance = chance;
    }

    public Product (String vendor_code, String name_product, int count){              // Базовый конструктор для игрушек
        this.id  = vendor_code;
        this.name = name_product;
        this.count = count;
    }
                                                                                    // Методы получения значений поля
    public String getId() {
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
                                                                                    // Метод для поиска большего добавочного значения 
    @Override                                                                       // для приоритетной очереди
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
