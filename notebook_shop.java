/*
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, 
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, 
то программа начинает работать некорректно
 */


import java.util.LinkedHashSet;
import java.util.Scanner;


public class notebook_shop 
{
    public static void main(String[] args) 
    {
        LinkedHashSet<notebook> nots = new LinkedHashSet<>();
        notebook not1 = new notebook();
        not1.prodName = "Asus";
        not1.memoryFlash = 800;
        not1.memoryRam = 8;
        not1.operationSystem = "Windows";
        not1.colors = "gray";

        notebook not2 = new notebook();
        not2.prodName = "Acer";
        not2.memoryFlash = 600;
        not2.memoryRam = 6;
        not2.operationSystem = "Windows";
        not2.colors = "black";

        notebook not3 = new notebook();
        not3.prodName = "Lenovo";
        not3.memoryFlash = 500;
        not3.memoryRam = 8;
        not3.operationSystem = "Linux";
        not3.colors = "white";

        notebook not4 = new notebook();
        not4.prodName = "Hp";
        not4.memoryFlash = 900;
        not4.memoryRam = 12;
        not4.operationSystem = "Linux";
        not4.colors = "red";

        notebook not5 = new notebook();
        not5.prodName = "Asus";
        not5.memoryFlash = 1000;
        not5.memoryRam = 16;
        not5.operationSystem = "Linux";
        not5.colors = "blue";

        notebook not6 = new notebook();
        not6.prodName = "Asus";
        not6.memoryFlash = 1000;
        not6.memoryRam = 16;
        not6.operationSystem = "Linux";
        not6.colors = "black";


        nots.add(not1);
        nots.add(not2);
        nots.add(not3);
        nots.add(not4);
        nots.add(not5);
        nots.add(not6);

        // System.out.println(nots);
        // printSet(nots);
        printSet(choice(nots));
        // choice(nots);
    }

    static void printSet(LinkedHashSet<notebook> nots) 
    {
        for (notebook not: nots) 
        {
            System.out.println(not);
        }
        
    }

    static LinkedHashSet<notebook> choice (LinkedHashSet<notebook> nots) 
    {
        LinkedHashSet<notebook> res = new LinkedHashSet<>();

        String[] menu = { "Введите номер признака для сортировки:  ", "1 - ОЗУ", "2 - Объем ЖД", "3 - Операционная система", "4 - Цвет", "Или 0 для вывода доступных ноутбуков"};
        for (int i = 0; i < menu.length; i++) 
        {
            System.out.println(menu[i]);
        }

        Scanner s = new Scanner(System.in);
        
        int c = s.nextInt();
        if (c == 1) {
            System.out.println("Выберите доступный вариант(Gb): 6, 8, 12, 16");
            int ram = s.nextInt();
            for (notebook not: nots) 
            {
                if (not.memoryRam >= ram) 
                {
                    res.add(not);
                }
            }           
        }
        else if (c == 2) {
            System.out.println("Выберите доступный вариант(Gb): 500, 600, 800, 900, 1000");
            int memory = s.nextInt();
            for (notebook not: nots) 
            {
                if (not.memoryFlash >= memory) 
                {
                    res.add(not);
                }
            }
            
        }
        else if (c == 3) {
            System.out.println("Выберите доступный вариант: 1 - Windows, 2 - Linux");
            String os = "";
            int sys = s.nextInt();
            switch (sys) {
                case 1:
                    os = "Windows";
                    break;
                case 2:
                    os = "Linux";
                    break;
            
                default:
                    System.out.println("Нет данных. Измените параметры поиска");
                    break;
            }
            for (notebook not: nots) 
            {
                if (not.operationSystem == os) 
                {
                    res.add(not);
                }
            }
            
        }
        else if (c == 4) {
            System.out.println("Выберите доступный вариант: 1 = red, 2 = white, 3 = black, 4 = gray, 5 = blue");
            String color = "";
            int col = s.nextInt();
            switch (col) {
                case 1:
                    color = "red";
                    break;
                case 2:
                    color = "white";
                    break;
                case 3:
                    color = "black";
                    break;
                case 4:
                    color = "gray";
                    break;
                case 5:
                    color = "blue";
                    break;
                default:
                    System.out.println("Нет данных. Измените параметры поиска");
                    break;
            }
            for (notebook not: nots) 
            {
                if (not.colors == color) 
                {
                    res.add(not);
                }
            }
        }
        // else if (c == 0) {
        //     printSet(res);
        // }    
        
        else {
            System.out.println("Некорректный ввод");
        }
        return res;
    }
}        