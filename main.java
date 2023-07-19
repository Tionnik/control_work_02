package control_work_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) throws IOException {
        ArrayList <Product> catalog =new ArrayList<>();
        catalog.add(new Product(17, "Doll", 6));
        catalog.add(new Product(21, "constructor", 5));
        catalog.add(new Product(7, "soccer ball", 2));
        catalog.add(new Product(27, "basketball ball", 2));
        catalog.add(new Product(5, "badminton set", 0));
        catalog.add(new Product(14, "table tennis set", 3));
    
        PriorityQueue <Product> list_draw = new PriorityQueue<>();      
        for (Product position : catalog) {
            int count = position.getCount();
           while (count > 0) {
                int id = (int) (Math.random() * 900 + 100);
                System.out.println(id);
                list_draw.add(new Product(position.getId(),position.getName(),position.getCount(), id ));
                count --;
           }
        }
        if ( ! Files.isRegularFile(Path.of("C:\\New\\dz\\control_work_02\\result.txt"))){
            Files.createFile(Path.of("C:\\New\\dz\\control_work_02\\result.txt"));
        }
        else {
            Files.delete(Path.of("C:\\New\\dz\\control_work_02\\result.txt"));
            Files.createFile(Path.of("C:\\New\\dz\\control_work_02\\result.txt"));
        }
        Product element;
        while((element = list_draw.poll())!= null) { 
            System.out.println(element.getId() +", "+ element.getName());
            Path path = Paths.get("C:\\New\\dz\\control_work_02\\result.txt");
            String text = element.getId()+","+element.getName()+","+element.getChance()+"\n";
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        }

    }
}
