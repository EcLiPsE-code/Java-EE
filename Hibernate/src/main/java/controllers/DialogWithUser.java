package controllers;

public class DialogWithUser {

    public static void menuReader(){
        System.out.println("-------------MENU----------------");
        System.out.println("| 1) Добавить читателя          |");
        System.out.println("| 2) Удалить читателя           |");
        System.out.println("| 3) Изменить данные о читателе |");
        System.out.println("| 4) Поиск читателя             |");
        System.out.println("| 5) Вывод всех читателей       |");
        System.out.println("| 6) ЗАКАЗЫ                     |");
        System.out.println("| 7) КНИГИ                      |");
        System.out.println("| 8) Выход                      |");
        System.out.println("---------------------------------");
        System.out.print("Выберите пункт меню -> ");
    }

    public static void menuBook(){
        System.out.println("--------------MENU-------------------");
        System.out.println("| 1) Добавить книгу                 |");
        System.out.println("| 2) Удалить книгу                  |");
        System.out.println("| 3) Найти книгу                    |");
        System.out.println("| 4) Все книги                      |");
        System.out.println("| 5) Выход                          |");
        System.out.println("-------------------------------------");
        System.out.print("Выберите пункт меню -> ");
    }



    public static void menuOrder(){
        System.out.println("--------------MENU------------------");
        System.out.println("| 1) Сделать заказ                 |");
        System.out.println("| 2) Вывод всех заказов            |");
        System.out.println("| 3) Вывод всех заказов читателя   |");
        System.out.println("| 4) Выход                         |");
        System.out.println("------------------------------------");
        System.out.print("Выберите пункт меню -> ");
    }

    public static void menuEditDataReader(){
        System.out.println("--------------------MENU--------------");
        System.out.println("| 1) Редактировать имя               |");
        System.out.println("| 2) Редактировать фамилию           |");
        System.out.println("| 3) Редактировать отчество          |");
        System.out.println("| 4) Редактироавть возраст           |");
        System.out.println("| 5) Выход                           |");
        System.out.println("--------------------------------------");
        System.out.print("Выберите пункт меню -> ");
    }
}
