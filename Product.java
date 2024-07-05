package products;

import java.util.ArrayList;
import java.util.List;

// کلاس محصول
public class Product {
    private String name; // نام محصول
    private double price; // قیمت محصول
    private int stock; // موجودی محصول
    private String description; // توضیحات محصول
    private List<String> comments; // لیست نظرات محصول
    private String category; // دسته بندی محصول

    // سازنده کلاس Product که اطلاعات محصول را مقداردهی می‌کند
    public Product(String name, double price, int stock, String description, String category) {
        this.name = name; // مقداردهی نام محصول
        this.price = price; // مقداردهی قیمت محصول
        this.stock = stock; // مقداردهی موجودی محصول
        this.description = description; // مقداردهی توضیحات محصول
        this.category = category; // مقداردهی دسته بندی محصول
        this.comments = new ArrayList<>(); // ایجاد یک لیست خالی برای نظرات
    }

    // متد برای دریافت نام محصول
    public String getName() {
        return name;
    }

    // متد برای دریافت قیمت محصول
    public double getPrice() {
        return price;
    }

    // متد برای دریافت موجودی محصول
    public int getStock() {
        return stock;
    }

    // متد برای دریافت توضیحات محصول
    public String getDescription() {
        return description;
    }

    // متد برای تنظیم موجودی محصول
    public void setStock(int stock) {
        this.stock = stock;
    }

    // متد برای اضافه کردن یک نظر به محصول
    public void addComment(String comment) {
        comments.add(comment);
    }

    // متد برای دریافت نظرات محصول
    public List<String> getComments() {
        return comments;
    }

    // متد برای دریافت دسته بندی محصول
    public String getCategory() {
        return category;
    }

    // متد برای نمایش اطلاعات محصول به صورت رشته
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    // متد برای بررسی خالی بودن محصول
    public static boolean isEmpty(Product product) {
        return product == null || product.getName().isEmpty();
    }

    // متد برای بررسی اینکه تعداد خریداری شده بیشتر از موجودی نباشد
    public boolean canPurchase(int quantity) {
        return quantity <= stock;
    }

    public static void main(String[] args) {
        // تست کلاس Product با ایجاد یک نمونه
        Product milk = new Product("Milk", 2.0, 200, "Fresh milk", "Beverages");
        milk.addComment("Delicious and fresh!");
        milk.addComment("Best milk ever!");
        System.out.println(milk);
    }
}
