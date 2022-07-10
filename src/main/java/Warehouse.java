import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    String name;

    private List<Book> listOfBooksInStock = new ArrayList();

    public Warehouse(String name) {
        this.name = name;
    }

    public void receiptOfBooks(List<Book> shoppingList) {
        for (int i = 0; i < shoppingList.size(); i++) { //принцип избегания магических чисел
            listOfBooksInStock.add(shoppingList.get(i));
        }
    }

    public void saleOfBooks(List<Book> shoppingList) {
        for (int i = 0; i < shoppingList.size(); i++) {//принцип избегания магических чисел
            listOfBooksInStock.remove(shoppingList.get(i));
        }
    }

    public void booksInStock() {
        for (int i = 0; i < listOfBooksInStock.size(); i++) {//принцип избегания магических чисел
            System.out.println(i + ". " + listOfBooksInStock.get(i).toString());
        }
    }

    public Book findABook(int index) {
        return listOfBooksInStock.get(index);
    }
}
