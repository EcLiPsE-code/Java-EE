package runner;

import controllers.DialogWithUser;
import controllers.LibraryService;
import helpers.DataConverter;
import models.entities.Book;
import models.entities.Order;
import models.entities.Reader;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        try{
            LibraryService service = new LibraryService();
            LibraryService.BookService bookService = service.new BookService();
            LibraryService.OrderService orderService = service.new OrderService();
            LibraryService.ReaderService readerService = service.new ReaderService();
            DataConverter dataConverter = new DataConverter();

            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while(flag){
                DialogWithUser.menuReader();
                String answer = scanner.nextLine();
                switch (answer){
                    case "1":
                        System.out.print("Введите фамилию: ");
                        String surname = scanner.nextLine();
                        System.out.print("Введите имя: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите отчество: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Введите возраст: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        readerService.addReader(new Reader(name, surname, lastName, age));
                        break;
                    case "2":
                        System.out.print("Введите фамилию: ");
                        String surnameDelete = scanner.nextLine();
                        System.out.print("Введите имя: ");
                        String nameDelete = scanner.nextLine();
                        System.out.print("Введите отчество: ");
                        String lastNameDelete = scanner.nextLine();
                        System.out.print("Введите возраст: ");
                        int ageDelete = Integer.parseInt(scanner.nextLine());
                        Reader findReader = readerService.getReader(new Reader(nameDelete, surnameDelete, lastNameDelete, ageDelete));
                        if (findReader == null){
                            System.out.println("Такого читателя нет");
                        }else{
                            readerService.deleteReader(findReader);
                            System.out.println("Читатель " + findReader + " успешно удален");
                        }
                        break;
                    case "3":
                        System.out.print("Введите фамилию: ");
                        String surnameEdit = scanner.nextLine();
                        System.out.print("Введите имя: ");
                        String nameEdit = scanner.nextLine();
                        System.out.print("Введите отчество: ");
                        String lastNameEdit = scanner.nextLine();
                        System.out.print("Введите возраст: ");
                        int ageEdit = Integer.parseInt(scanner.nextLine());
                        Reader findReader2 = readerService.getReader(new Reader(nameEdit, surnameEdit, lastNameEdit, ageEdit));
                        if (findReader2 == null){
                            System.out.println("Такого читателя нет");
                            break;
                        }else{
                            boolean flag2 = true;
                            while(flag2){
                            DialogWithUser.menuEditDataReader();
                            String answer2 = scanner.nextLine();
                                switch (answer2){
                                    case "1":
                                        System.out.print("Введите новое имя читателя: ");
                                        String newNameReader = scanner.nextLine();
                                        findReader2.setName(newNameReader);
                                        readerService.updateReader(findReader2);
                                        System.out.println("Имя успешно обновлено");
                                        break;
                                    case "2":
                                        System.out.print("Введите новую фамилию читателя: ");
                                        String newSurnameReader = scanner.nextLine();
                                        findReader2.setSurname(newSurnameReader);
                                        readerService.updateReader(findReader2);
                                        System.out.println("Фамилия успешна обновлена");
                                        break;
                                    case "3":
                                        System.out.print("Введите новое отчество читателя: ");
                                        String newLastNameReader = scanner.nextLine();
                                        findReader2.setLastName(newLastNameReader);
                                        readerService.updateReader(findReader2);
                                        System.out.println("Отчество успешно обновлено");
                                        break;
                                    case "4":
                                        System.out.print("Введите новый возраст читателя: ");
                                        String newAgeReader = scanner.nextLine();
                                        findReader2.setAge(Integer.parseInt(newAgeReader));
                                        readerService.updateReader(findReader2);
                                        System.out.println("Возраст успешно обновлен");
                                        break;
                                    case "5":
                                        flag2 = false;
                                        break;
                                    default:
                                        System.out.println("Такого пункта нет!");
                                }
                            }
                        }
                        break;
                    case "4":
                        System.out.print("Введите фамилию: ");
                        String surnameSearch = scanner.nextLine();
                        System.out.print("Введите имя: ");
                        String nameSearch = scanner.nextLine();
                        System.out.print("Введите отчество: ");
                        String lastNameSearch = scanner.nextLine();
                        System.out.print("Введите возраст: ");
                        int ageSearch = Integer.parseInt(scanner.nextLine());
                        Reader findReader1 = readerService.getReader(new Reader(nameSearch, surnameSearch, lastNameSearch, ageSearch));
                        if (findReader1 == null){
                            System.out.println("Такого читателя нет!");
                        }else{
                            System.out.println(findReader1);
                        }
                        break;
                    case "5":
                        List<Reader> readers = readerService.getReaders();
                        for(Reader item : readers){
                            System.out.println(item);
                        }
                        break;
                    case "6":
                        boolean flag3 = true;
                        while(flag3){
                            DialogWithUser.menuOrder();
                            String answer3 = scanner.nextLine();
                            switch (answer3){
                                case "1":
                                    System.out.print("Введите фамилию: ");
                                    String surname2 = scanner.nextLine();
                                    System.out.print("Введите имя: ");
                                    String name2 = scanner.nextLine();
                                    System.out.print("Введите отчество: ");
                                    String lastName2 = scanner.nextLine();
                                    System.out.print("Введите возраст: ");
                                    int age2 = Integer.parseInt(scanner.nextLine());
                                    Reader findReader3 = readerService.getReader(new Reader(name2, surname2, lastName2, age2));
                                    if(findReader3 == null){
                                        System.out.println("Добавляем читателя в БД...");
                                        Reader newReader = new Reader(name2, surname2, lastName2, age2);
                                        readerService.addReader(newReader);
                                        System.out.println("Создаем заказ...");
                                        System.out.print("Введите название книги: ");
                                        String nameBook = scanner.nextLine();
                                        System.out.print("Введите автора книги: ");
                                        String authorBook = scanner.nextLine();
                                        Book findBook = bookService.getBookByNameAndAuthor(nameBook, authorBook);
                                        if (findBook == null){
                                            System.out.println("Такой книги в библиотеке нет");
                                        }else{
                                            System.out.println("Введите дату выдачи: ");
                                            String dateOfIssueStr = scanner.nextLine();
                                            Date dateOfIssue = dataConverter.convertToDatabaseColumn(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfIssueStr).getTime()).toLocalDate());
                                            System.out.println("Введите срок выдачи: ");
                                            int countDay = Integer.parseInt(scanner.nextLine());
                                            System.out.println("Введите дату сдачи книги: ");
                                            String dateOfCompletionStr = scanner.nextLine();
                                            Date dateOfCompletion = dataConverter.convertToDatabaseColumn(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfCompletionStr).getTime()).toLocalDate());
                                            System.out.println("Введите тип выдачи книги (true - абонемент, false - читальный зал): ");
                                            boolean typeOfIssue = Boolean.parseBoolean(scanner.nextLine());
                                            Order order = new Order(dateOfIssue, countDay, dateOfCompletion, typeOfIssue);
                                            order.addBook(findBook);
                                            order.setReader(findReader3);
                                            orderService.addOrder(order);
                                            System.out.println("Заказ успешно завершен");
                                        }
                                    }
                                    else{
                                        System.out.print("Введите название книги: ");
                                        String nameBook = scanner.nextLine();
                                        System.out.print("Введите автора книги: ");
                                        String authorBook = scanner.nextLine();
                                        Book findBook = bookService.getBookByNameAndAuthor(nameBook, authorBook);
                                        if (findBook == null){
                                            System.out.println("Такой книги в библиотеке нет");
                                        }else{
                                            System.out.println("Введите дату выдачи: ");
                                            String dateOfIssueStr = scanner.nextLine();
                                            Date dateOfIssue = dataConverter.convertToDatabaseColumn(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfIssueStr).getTime()).toLocalDate());
                                            System.out.println("Введите срок выдачи: ");
                                            int countDay = Integer.parseInt(scanner.nextLine());
                                            System.out.println("Введите дату сдачи книги: ");
                                            String dateOfCompletionStr = scanner.nextLine();
                                            Date dateOfCompletion = dataConverter.convertToDatabaseColumn(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfCompletionStr).getTime()).toLocalDate());
                                            System.out.println("Введите тип выдачи книги (true - абонемент, false - читальный зал): ");
                                            boolean typeOfIssue = Boolean.parseBoolean(scanner.nextLine());
                                            Order order = new Order(dateOfIssue, countDay, dateOfCompletion, typeOfIssue);
                                            order.addBook(findBook);
                                            order.setReader(findReader3);
                                            orderService.addOrder(order);
                                            System.out.println("Заказ успешно завершен");
                                        }
                                    }
                                    break;
                                case "2":
                                    List<Order> orders = orderService.getOrders();
                                    for (Order order : orders){
                                        System.out.println(order);
                                    }
                                    break;
                                case "3":
                                    System.out.print("Введите фамилию: ");
                                    String surname3 = scanner.nextLine();
                                    System.out.print("Введите имя: ");
                                    String name3 = scanner.nextLine();
                                    System.out.print("Введите отчество: ");
                                    String lastName3 = scanner.nextLine();
                                    System.out.print("Введите возраст: ");
                                    int age3 = Integer.parseInt(scanner.nextLine());
                                    Reader reader4 = new Reader(name3, surname3, lastName3, age3);
                                    Reader findReader4 = readerService.getReader(reader4);
                                    if (findReader4 == null){
                                        System.out.println("Такого читателя нет");
                                    }else{
                                        List<Order> orders1 = orderService.getOrder(findReader4);
                                        if (orders1 == null && orders1.size() == 0){
                                            System.out.println("У читателя " +findReader4+ " нет заказов");
                                        }else{
                                            for (Order order : orders1){
                                                System.out.println(order);
                                            }
                                        }
                                    }
                                    break;
                                case "4":
                                    flag3 = false;
                                    break;
                                default:
                                    System.out.println("Такого пункта нет!");
                            }
                        }
                        break;
                    case "7":
                        boolean flag4 = true;
                        while(flag4){
                            DialogWithUser.menuBook();
                            String answerBook = scanner.nextLine();
                            switch (answerBook){
                                case "1":
                                    System.out.print("Введите название книги: ");
                                    String nameBook = scanner.nextLine();
                                    System.out.println("Введите автора книги: ");
                                    String authorBook = scanner.nextLine();
                                    System.out.println("Введите количество страниц в книге: ");
                                    int countPages = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Введите количество копий книг: ");
                                    int countCopies = Integer.parseInt(scanner.nextLine());
                                    bookService.addBook(new Book(nameBook, authorBook, countPages, countCopies));
                                    break;
                                case "2":
                                    System.out.print("Введите название книги: ");
                                    String nameBookDelete = scanner.nextLine();
                                    System.out.println("Введите автора книги: ");
                                    String authorBookDelete = scanner.nextLine();
                                    System.out.println("Введите количество страниц в книге: ");
                                    int countPagesDelete = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Введите количество копий книг: ");
                                    int countCopiesDelete = Integer.parseInt(scanner.nextLine());
                                    bookService.deleteBook(new Book(nameBookDelete, authorBookDelete, countPagesDelete, countCopiesDelete));
                                    break;
                                case "3":
                                    System.out.print("Введите название книги: ");
                                    String nameBookSearch = scanner.nextLine();
                                    System.out.println("Введите автора книги: ");
                                    String authorBookSearch = scanner.nextLine();
                                    Book findBook = bookService.getBookByNameAndAuthor(nameBookSearch, authorBookSearch);
                                    if (findBook == null){
                                        System.out.println("Такой книги в библиотеке нет!");
                                    }
                                    else{
                                        System.out.println(findBook);
                                    }
                                    break;
                                case "4":
                                    List<Book> books = bookService.getBooks();
                                    for (Book book : books){
                                        System.out.println(book);
                                    }
                                    break;
                                case "5":
                                    flag4 = false;
                                    break;
                                default:
                                    System.out.println("Такого пункта меню нет");
                            }
                        }
                        break;
                    case "8":
                        flag = false;
                        break;
                    default:
                        System.out.println("Такого пункта меню нет!");
                }
            }
        }catch (IllegalArgumentException | ParseException e){
            System.out.println(e);
        }
    }
}
