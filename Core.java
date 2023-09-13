package control_work_02;

import java.util.ArrayList;

public class Core {
    
    ArrayList <Product> catalog = new ArrayList<>(); 
    
    public void addProduct(String text){
        String [] prod = text.split(";");
        int count = Integer.parseInt(prod[2]);
        catalog.add(new Product(prod[0], prod[1], count));
    }

    public void getCatalog() {
        for (Product product : catalog) {
            System.out.println(product.getId()+" "+product.getName()+" "+product.getCount());
        }
    }
        /*
        ArrayList <Product> catalog =new ArrayList<>();                                                     // Создание и заполнение листа с игрушками для розыгрыша
        catalog.add(new Product(17, "Doll", 6));
        catalog.add(new Product(21, "constructor", 5));
        catalog.add(new Product(7, "soccer ball", 2));
        catalog.add(new Product(27, "basketball ball", 2));
        catalog.add(new Product(5, "badminton set", 0));
        catalog.add(new Product(14, "table tennis set", 3));
    
        PriorityQueue <Product> list_draw = new PriorityQueue<>();                                          // Создание приоритетной очереди 
        for (Product position : catalog) {
            int count = position.getCount();                                                                // где к каждому предмету
           while (count > 0) {
                int id = (int) (Math.random() * 900 + 100);                                                 // добавляется случайное трех значное число
                //System.out.println(id);
                list_draw.add(new Product(position.getId(),position.getName(),position.getCount(), id ));
                count --;
           }
        }
        if ( ! Files.isRegularFile(Path.of("result.txt"))){               // если файла нет, он его создаст
            Files.createFile(Path.of("result.txt"));
        }
        else {
            Files.delete(Path.of("result.txt"));                          // иначе удалит текущий и создаст новый
            Files.createFile(Path.of("result.txt"));
        }
        Product element;
        while((element = list_draw.poll())!= null) {                                                        // пока в приоритетной очереди есть элементы, изымается из нее с самым большим добавочным числом.
            System.out.println(element.getId() +", "+ element.getName());                                   // Показывает его артикул и название.
            Path path = Paths.get("result.txt");
            String text = element.getId()+","+element.getName()+","+element.getChance()+"\n";               // Записывает в файл артикул игрушки, 
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);                                  //её название и номер шанса выпадения
        }
        */
}
