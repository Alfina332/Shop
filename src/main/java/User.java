import java.util.List;

public class User implements IntBuyer, IntSeller, IntCommodityExpert {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String buyBook() {
        return "Покупатель купил книгу \"%s\"%n";
    }

    @Override
    public String returnBook() {
        return "Покупатель вернул книгу \"%s\"%n";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sellBook() {
        return "Продавец выдал книгу \"%s\" покупателю%n";
    }

    @Override
    public String orderBook() {
        return "Продавец заказал книгу \"%s\" у поставщика%n";
    }
}