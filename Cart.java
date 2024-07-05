package users;

import java.util.HashMap;
import java.util.Map;
import products.Product;

/**
 * کلاس Cart برای نگهداری و مدیریت سبد خرید کاربر طراحی شده است.
 */
public class Cart {
    private Map<Product, Integer> cartItems; // مپی از محصولات و تعداد آن‌ها در سبد خرید

    /**
     * کانستراکتور کلاس Cart که یک مپ جدید برای محصولات و تعدادشان در سبد خرید ایجاد می‌کند.
     */
    public Cart() {
        cartItems = new HashMap<>();
    }

    /**
     * متد برای اضافه کردن محصول به سبد خرید با تعداد مشخص.
     * اگر تعداد منفی یا صفر باشد، یک استثناء IllegalArgumentException پرتاب می‌کند.
     * @param product محصولی که باید به سبد خرید اضافه شود
     * @param quantity تعداد محصول
     */
    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (cartItems.containsKey(product)) {
            cartItems.put(product, cartItems.get(product) + quantity);
        } else {
            cartItems.put(product, quantity);
        }
    }

    /**
     * متد برای حذف محصول از سبد خرید با تعداد مشخص.
     * اگر محصول در سبد خرید وجود نداشته باشد، هیچ اقدامی انجام نمی‌شود.
     * @param product محصولی که باید از سبد خرید حذف شود
     * @param quantity تعداد محصول برای حذف
     */
    public void removeProduct(Product product, int quantity) {
        if (cartItems.containsKey(product)) {
            int currentQuantity = cartItems.get(product);
            if (quantity >= currentQuantity) {
                cartItems.remove(product);
            } else {
                cartItems.put(product, currentQuantity - quantity);
            }
        }
    }

    /**
     * متد برای خالی کردن سبد خرید، تمام محصولات از سبد حذف می‌شوند.
     */
    public void clear() {
        cartItems.clear();
    }

    /**
     * متد برای دریافت محصولات و تعداد آن‌ها در سبد خرید.
     * @return مپی از محصولات و تعدادشان در سبد خرید
     */
    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    /**
     * متد برای محاسبه مجموع قیمت تمامی آیتم‌های موجود در سبد خرید.
     * @return مجموع قیمت آیتم‌های موجود در سبد خرید
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }
}
