package orders;

import java.util.Map;
import products.Product;
import users.Customer;

public class Order {
    private Customer customer; // مشتری
    private Map<Product, Integer> orderItems; // نقشه‌ای از محصولات و تعداد آن‌ها در سفارش
    private double totalAmount; // مجموع قیمت کل سفارش
    private boolean isApproved; // وضعیت تأیید سفارش

    // سازنده کلاس Order که مقادیر اولیه را تنظیم می‌کند
    public Order(Customer customer, Map<Product, Integer> orderItems, double totalAmount) {
        this.customer = customer; // مقداردهی متغیر مشتری
        this.orderItems = orderItems; // مقداردهی نقشه محصولات و تعداد آن‌ها
        this.totalAmount = totalAmount; // مقداردهی مجموع قیمت کل سفارش
        this.isApproved = false; // مقداردهی اولیه وضعیت تایید سفارش به حالت false
    }

    // متد getCustomer برای دریافت مشتری
    public Customer getCustomer() {
        return customer; 
    }

    // متد getOrderItems برای دریافت نقشه محصولات و تعداد آن‌ها
    public Map<Product, Integer> getOrderItems() {
        return orderItems; 
    }

    // متد getTotalAmount برای دریافت مجموع قیمت کل سفارش
    public double getTotalAmount() {
        return totalAmount; 
    }

    // متد isApproved برای بررسی وضعیت تایید سفارش
    public boolean isApproved() {
        return isApproved; 
    }

    // متد approve برای تایید سفارش
    public void approve() {
        this.isApproved = true; // تغییر وضعیت تایید سفارش به true
    }
}
