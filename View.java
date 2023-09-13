package control_work_02;

import java.util.Scanner;

public class View {

    Scanner scan = new Scanner(System.in);
    int command;
    String text;

    public void start(){
        Core core = new Core();
        while (true) {
            System.out.println();                                                   // интерфейсное меню 
            System.out.println("[1] Добавить товар к розыгрышу");
            System.out.println("[2] Показать список разыгрываемых товаров");
            System.out.println("[3] Перейти к розыгрышу");
            System.out.println("[0] выйти из программы");
            System.out.print("Выберите команду для работы: ");
            command = scan.nextInt();                                               // Запрос команды от пользователя
            scan.nextLine();

            if (command == 1){                                  // Запрашивает правильную строку с товаром от пользователя и добавляет товар в список розыгрыша.
                 core.addProduct(addName());
                 System.out.println("Товар успешно добавлен в список розыгрыша");
            }

            if (command == 2){                                  // Запрашивает весь введённый список с товарами для розыгрыша 
                System.out.println();
                core.getCatalog();
            }

            if (command == 3){                                  // Запускает розыгрыш
                core.file();                                    // подготавливает файл для отчета
                core.draw();                                    // Создает и заполняет приоритетную очередь товарами и их весами
                System.out.println();
                System.out.println("Нажмите любую цифру для розыгрыша следующего предмета");
                System.out.println("[0] для завершения розыгрыша");
                while (true){
                    command = scan.nextInt();                   // запрашивает команду для розыгрыша 
                    scan.nextLine();
                    if (command == 0){                          //если команда 0,  
                        core.endDraw();                         //записывает весь оставшийся товар в файл
                        break; }                                //и завершает розыгрыш
                    else {
                        String text = core.getProduct();        // производит одиночный розыгрыш
                        System.out.println(text);               // показывает выигранный товар
                        if(text.equals("Спасибо за розыгрыш\n")){    //если товаров нет
                            break;                              // завершает розыгрыш
                        }
                    }
                }
                break;                                          // Завершает работу всей программы
            }

            if (command == 0){                                  // Завершает работу всей программы
                break;
            }
        }
        scan.close();
    }

    private String addName(){                                                                 // Метод запроса разыгрываемого продукта от пользователя  
        while (true){
            System.out.println("Введите разыгрываемый товар в виде:\n Артикул товара; Название товара; количество товара");
            text = scan.nextLine();
            String [] test = text.split(";");                                           // Проверят правильность формата ввода
            if (test.length == 3){
                try {
                    Integer.parseInt(test[2]);                                                // Проверят, что кол-во товара введено цифрой  
                    if (( ! test[0].equals(""))&&( ! test[1].equals(""))){  // Проверят, что артикул и название не пустое
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
