package control_work_02;

import java.util.Scanner;

public class View {

    Scanner scan = new Scanner(System.in);
    int command;
    String text;

    public void start(){
        Core core = new Core();
        while (true) {
            System.out.println();
            System.out.println("[1] Добавить товар к розыгрышу");
            System.out.println("[2] Показать список разыгрываемых товаров");
            System.out.println("[3] Перейти к розыгрышу");
            System.out.println("[0] выйти из программы");
            System.out.print("Выберите команду для работы: ");
            command = scan.nextInt();
            scan.nextLine();

            if (command == 1){
                 core.addProduct(addName());
                 System.out.println("Товар успешно добавлен в список розыгрыша");
            }
            if (command == 2){
                System.out.println();
                core.getCatalog();
            }
            if (command == 3){
                break;
            }
            if (command == 0){
                break;
            }
        }
        scan.close();
    }

    private String addName(){
        while (true){
            System.out.println("Введите разыгрываемый товар в виде:\n Артикул товара; Название товара; количество товара");
            text = scan.nextLine();
            String [] test = text.split(";");
            if (test.length == 3){
                try {
                    Integer.parseInt(test[2]);
                    if (( ! test[0].equals(""))&&( ! test[1].equals(""))){
                        return text;
                    }
                    else {System.out.println("Не заполнено Артикул или название товара");}
                } catch (Exception e) {
                    System.out.println("На позиции числа, должно быть целое число");
                }
                
            }
            else {System.out.println("Формат ввода неверен");}
        }
    }
}
