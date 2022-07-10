import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //создан отдельный класс для пользователей User, склада Warehouse, книг Book - Single Responsibility Principle

        //для пользователей созданы интерфейсы для покупателя, продавца, товароведа
        //в них реализованы принципы:
        // Dependency inversion principle - логика зависит от абстракции процессов в интерфейсе
        // Open Closed Principle - в классах можно добавлять новые методы
        // Interface segregation principle - для каждой роли отдельны интерфейс

        Warehouse warehouse = new Warehouse("Основной");

        User buyer = new User("BuyerUser");
        User seller = new User("SellerUser");

        List<Book> shoppingList = new ArrayList();

        List<Book> inStock = new ArrayList();

        inStock.add(new Book("Стрелок"));
        inStock.add(new Book("Извлечение троих"));

        warehouse.receiptOfBooks(inStock);

        while (true) {
            System.out.println();
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить книги в корзину");
            System.out.println("2. Вернуть книги");
            System.out.println("3. Заказать книги");
            System.out.println("0. Выход");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            try {
                int intInput = Integer.parseInt(input);
                if (intInput == 0) {
                    System.out.println("Покупки завершены");
                    break;
                } else {
                    switch (intInput) {
                        case 1: {
                            System.out.println("Список книг в наличии: ");
                            warehouse.booksInStock();
                            while (true) {
                                System.out.println("Введите номер книги или введите end для завершения покупок: ");
                                Scanner inputTask = new Scanner(System.in);
                                String task = inputTask.nextLine();
                                if (task.equals("end")) {
                                    warehouse.saleOfBooks(shoppingList);
                                    traversingTheList(shoppingList,buyer.buyBook());
                                    traversingTheList(shoppingList,seller.sellBook());
                                    break;
                                } else {
                                    shoppingList.add(warehouse.findABook(Integer.parseInt(task)));
                                }
                            }
                        }
                        break;
                        case 2: {
                            while (true) {
                                System.out.println("Введите название книги или введите end для завершения возврата:");
                                Scanner inputTask = new Scanner(System.in);
                                String task = inputTask.nextLine();
                                if (task.equals("end")) {
                                    warehouse.receiptOfBooks(shoppingList);
                                    traversingTheList(shoppingList,buyer.returnBook());
                                    break;
                                } else {
                                    shoppingList.add(new Book(task));
                                }
                            }
                        }
                        break;
                        case 3: {
                            while (true) {
                                System.out.println("Введите название книги или введите end для завершения заказа:");
                                Scanner inputTask = new Scanner(System.in);
                                String task = inputTask.nextLine();
                                if (task.equals("end")) {
                                    traversingTheList(shoppingList,seller.orderBook());
                                    break;
                                } else {
                                    Book book = new Book(task);
                                    shoppingList.add(book);
                                }
                            }
                        }
                        break;
                        default: {
                            System.out.println("Такого пункта нет в меню!");
                        }
                    }
                }
            } catch (NumberFormatException numberFormat) {
                System.out.println("Данные введены некорректно! " + numberFormat.getMessage());
            }
        }
    }

    //принцип Don’t Repeat Yourself для обхода списка
    static void traversingTheList(List<Book> shoppingList,String massage) {
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.printf(massage, shoppingList.get(i).toString());
        }
    }
}