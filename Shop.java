package shop;

import java.util.List;
import java.util.ArrayList;
import orders.Order;
import products.Product;
import users.Account;
import users.Seller;

/**
 * کلاس زیر برای مدیریت اطلاعات و عملیات مرتبط با یک فروشگاه طراحی شده است و شامل ویژگی‌های اصلی فروشگاه:
 * نام، وب‌سایت، شماره پشتیبانی، حساب‌های کاربری، محصولات، سفارشات، سود کل.
 */
public class Shop { 
    private String name; // نام فروشگاه
    private String website; // وب‌سایت فروشگاه
    private String supportNumber; // شماره پشتیبانی فروشگاه
    private List<Seller> sellers; // لیست فروشندگان
    private List<Product> products; // لیست محصولات
    private List<Order> orders; // لیست سفارشات
    private double totalProfit; // سود کل فروشگاه
    private List<Account> Account;

    /**
     * کانستراکتور کلاس Shop سه ورودی (name، website، و supportNumber) می‌گیرد و آن‌ها را به متغیرهای خصوصی کلاس اختصاص می‌دهد.
     *
     * @param name نام فروشگاه
     * @param website وب‌سایت فروشگاه
     * @param supportNumber شماره پشتیبانی فروشگاه
     */
    public Shop(String name, String website, String supportNumber) { 
        this.name = name; // مقداردهی نام فروشگاه
        this.website = website; // مقداردهی وب‌سایت فروشگاه
        this.supportNumber = supportNumber; // مقداردهی شماره پشتیبانی فروشگاه
        this.sellers = new ArrayList<>(); // مقداردهی لیست فروشندگان
        this.products = new ArrayList<>(); // مقداردهی لیست محصولات
        this.orders = new ArrayList<>(); // مقداردهی لیست سفارشات
        this.totalProfit = 0.0; // مقداردهی سود کل فروشگاه
        this.Account = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name; // برگرداندن نام فروشگاه
    }

    public void setName(String name) {
        this.name = name; // تنظیم نام فروشگاه
    }

    public String getWebsite() {
        return website; // برگرداندن وب‌سایت فروشگاه
    }

    public void setWebsite(String website) {
        this.website = website; // تنظیم وب‌سایت فروشگاه
    }

    public String getSupportNumber() {
        return supportNumber; // برگرداندن شماره پشتیبانی فروشگاه
    }

    public void setSupportNumber(String supportNumber) {
        this.supportNumber = supportNumber; // تنظیم شماره پشتیبانی فروشگاه
    }

    public List<Seller> getSellers() {
        return sellers; // برگرداندن لیست فروشندگان
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers; // تنظیم لیست فروشندگان
    }

    public List<Product> getProducts() {
        return products; // برگرداندن لیست محصولات
    }

    public void setProducts(List<Product> products) {
        this.products = products; // تنظیم لیست محصولات
    }

    public List<Order> getOrders() {
        return orders; // برگرداندن لیست سفارشات
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders; // تنظیم لیست سفارشات
    }

    public double getTotalProfit() {
        return totalProfit; // برگرداندن سود کل فروشگاه
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit; // تنظیم سود کل فروشگاه
    }

    /**
     * افزودن سفارش به لیست سفارشات فروشگاه
     * @param order سفارش جدید
     */
    public void addOrder(Order order) {
        orders.add(order); // اضافه کردن سفارش جدید به لیست سفارشات
    }

    /**
     * دریافت تمامی سفارشات
     * @return لیست تمامی سفارشات
     */
    public List<Order> getAllOrders() {
        return orders; // برگرداندن لیست تمامی سفارشات
    }

    /**
     * افزودن سود به سود کل فروشگاه
     * @param profit میزان سودی که باید اضافه شود
     */
    public void addTotalProfit(double profit) {
        this.totalProfit += profit; // اضافه کردن سود به سود کل فروشگاه
    }

    public void addAccount(Account account) {
        Account.add(account); // اضافه کردن حساب به لیست حساب‌ها
    }

    public List<Account> getAccounts() {
        return Account;
    }
}