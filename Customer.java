package users;

import orders.Order;
import products.Product;
import shopping.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * کلاس Customer از کلاس Account ارث‌بری می‌کند و اطلاعات مشتری را نگهداری و
 * مدیریت می‌کند.
 */
public class Customer extends Account {
    private String phoneNumber; // شماره تلفن مشتری
    private String address; // آدرس مشتری
    private ShoppingCart cart; // سبد خرید مشتری
    private List<Order> orderHistory; // تاریخچه سفارشات مشتری
    private double wallet; // موجودی کیف پول مشتری

    /**
     * کانستراکتور کلاس Customer برای ایجاد یک نمونه از مشتری با اطلاعات اولیه مشخص
     * شده.
     * 
     * @param username    نام کاربری
     * @param password    رمز عبور
     * @param email       ایمیل
     * @param phoneNumber شماره تلفن
     * @param address     آدرس
     */
    public Customer(String username, String password, String email, String phoneNumber, String address) {
        super(username, password, email);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
        this.wallet = 0.0;
    }

    // Getters and setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public double getWallet() {
        return wallet;
    }

    /**
     * اضافه کردن مبلغ به کیف پول مشتری.
     * 
     * @param amount مقدار مبلغ اضافه شده
     */
    public void addToWallet(double amount) {
        this.wallet += amount;
    }

    /**
     * کاهش مبلغ از کیف پول مشتری.
     * 
     * @param amount مقدار مبلغ کاهش یافته
     */
    public void subtractFromWallet(double amount) {
        this.wallet -= amount;
    }

    /**
     * اضافه کردن سفارش جدید به تاریخچه سفارشات مشتری.
     * 
     * @param order سفارش جدید
     */
    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    /**
     * اضافه کردن محصول به سبد خرید مشتری با تعداد مشخص.
     * 
     * @param product  محصول اضافه شده به سبد خرید
     * @param quantity تعداد محصول
     */
    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
        System.out.println("Product added to cart: " + product);
    }

    /**
     * نمایش محتویات سبد خرید مشتری.
     */
    public void viewCart() {
        System.out.println("Cart contents:");
        for (Product product : cart.getCartItems().keySet()) {
            System.out.println(product);
        }
    }

    /**
     * انجام عملیات تسویه حساب.
     * در این نسخه، فقط سبد خرید را خالی می‌کند.
     */
    public void checkout() {
        System.out.println("Checking out...");

        cart.clear();
        System.out.println("Checkout complete.");
    }
}
