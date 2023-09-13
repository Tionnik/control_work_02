package control_work_02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Core {
    
    private ArrayList <Product> catalog = new ArrayList<>();                    // поле с листом разыгрываемыми товарами 
    private PriorityQueue <Product> list_draw = new PriorityQueue<>();          //поле с товарами в приоритетной очереди 
    
    public void addProduct(String text){                                        // Метод добавления товара в лист с разыгрываемыми товарами
        String [] prod = text.split(";");
        int count = Integer.parseInt(prod[2]);
        catalog.add(new Product(prod[0], prod[1], count));
    }

    public void getCatalog() {                                                  // Показывает все товары в листе товаров
        for (Product product : catalog) {
            System.out.println(product.getId()+" "+product.getName()+" "+product.getCount());
        }
    }

    public void draw(){                                                                                     // Создание приоритетной очереди
        for (Product position : catalog) {                                                                  // Переберает весь лист товаров
            int count = position.getCount();                                                                // где к каждому предмету
            while (count > 0) {
                int id = (int) (Math.random() * 900 + 100);                                                 // добавляется случайное трех значное число
                list_draw.add(new Product(position.getId(),position.getName(),position.getCount(), id ));   // и вносится товар в приоритетную очередь 
                count --;
           }
        }
    }

    public void file(){                                                             // Подготовит файл для отчета по розыгрышу
        try {
            if ( ! Files.isRegularFile(Path.of("result.txt"))){               // если файла нет, он его создаст
                Files.createFile(Path.of("result.txt"));}
            else {
                Files.delete(Path.of("result.txt"));                          // иначе удалит текущий
                Files.createFile(Path.of("result.txt"));}                     // и создаст новый
        } catch (Exception e) {
            System.out.println("Ошибра при работе с файлом: "+e.getMessage());      // покажет ошибку при работе с файлом
        }
    }

    public void endDraw(){                                                                                  // допишет весь не разыгранный товар в файл
        Product element;
        Path path = Paths.get("result.txt");
        try {                                                                                               // допишет в файл строку разделения разыгранного и не разыгранного товара
            String text0 = "\nНе разыгранный товар \n";
            Files.write(path, text0.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("Запись в файл была с ошибкой: "+e.getMessage());
        }
        while((element = list_draw.poll())!= null) {                                                        // пока в приоритетной очереди есть элементы, изымается из нее с самым большим добавочным числом.
            String text = element.getId()+","+element.getName()+","+element.getChance()+"\n";               // Записывает в файл артикул игрушки, её название и номер шанса выпадения
            try {
                Files.write(path, text.getBytes(), StandardOpenOption.APPEND);                              
            } catch (Exception e) {
                System.out.println("Запись в файл была с ошибкой: "+e.getMessage());
            } 
        } 
    }

    public String getProduct(){                                                                             // Разыгрывает позицию и записывает её в файл 
        Product element = list_draw.poll();
        if(element!= null){
            Path path = Paths.get("result.txt");
            String text = element.getId()+","+element.getName()+","+element.getChance()+"\n";               // Записывает в файл артикул игрушки,
            try {
                Files.write(path, text.getBytes(), StandardOpenOption.APPEND);                              //её название и номер шанса выпадения
                return (element.getId() +", "+ element.getName());
            } catch (Exception e) {
                return ("Запись в файл была с ошибкой: "+e.getMessage());
            } 
        }
        else { return "Спасибо за розыгрыш\n"; }
    }
}