package shopping;

import java.util.HashMap;
import java.util.Map;
import products.Product;

public class ShoppingCart {
    private Map<Product, Integer> cartItems; // نقشه‌ای برای نگهداری محصولات و تعداد آن‌ها در سبد خرید

    // سازنده کلاس ShoppingCart که نقشه‌ای جدید برای سبد خرید ایجاد می‌کند
    public ShoppingCart() {
        cartItems = new HashMap<>();
    }

    // این متد تعداد مشخصی از یک محصول را به سبد خرید اضافه می‌کند.
    public void addProduct(Product product, int quantity) {
        /*
         این شرط بررسی می‌کند که آیا تعداد درخواست شده بیشتر از موجودی محصول است یا خیر.
         اگر تعداد درخواست شده بیشتر از موجودی باشد، این خط یک پیام خطا چاپ می‌کند.
         این خط در صورت نبودن موجودی کافی، از متد خارج می‌شود.
         */
        if (quantity > product.getStock()) {
            System.out.println("Not enough stock available."); // چاپ پیام خطا
            return; // خروج از متد
        }
        /*
         این خط بررسی می‌کند که آیا محصول قبلاً در سبد خرید وجود دارد یا خیر.
         اگر محصول در سبد خرید نباشد:
         این خط محصول را با تعداد مشخص شده به سبد خرید اضافه می‌کند.
         */
        if (cartItems.containsKey(product)) {
            cartItems.put(product, cartItems.get(product) + quantity); // اضافه کردن تعداد محصول به مقدار موجود
        } else {
            cartItems.put(product, quantity); // اضافه کردن محصول جدید به سبد خرید
        }
        // این خط موجودی محصول را به اندازه تعداد اضافه شده به سبد خرید کاهش می‌دهد.
        product.setStock(product.getStock() - quantity); // کاهش موجودی محصول
    }

    // این متد تعداد مشخصی از محصول را از سبد خرید حذف می‌کند
    public void removeProduct(Product product, int quantity) {
        /*     
        این خط بررسی می‌کند که آیا محصول در سبد خرید وجود ندارد یا خیر.
        اگر محصول در سبد خرید وجود نداشته باشد، این خط یک پیام خطا چاپ می‌کند.
        */
        if (!cartItems.containsKey(product)) {
            System.out.println("Product not in cart."); // چاپ پیام خطا
            return; 
        }
        /*
        این شرط تعداد فعلی محصول در سبد خرید را می‌گیرد.
        بررسی می‌کند که آیا تعداد برای حذف بیشتر یا برابر با تعداد فعلی است یا خیر.
        اگر تعداد برای حذف بیشتر یا برابر با تعداد فعلی باشد، این خط محصول را از سبد خرید حذف می‌کند.
        اگر تعداد برای حذف کمتر از تعداد فعلی باشد:
        تعداد محصول را در سبد خرید به‌روز می‌کند.
        موجودی محصول را به اندازه تعداد حذف شده از سبد خرید افزایش می‌دهد.
        */
        int currentQuantity = cartItems.get(product);
        if (quantity >= currentQuantity) {
            cartItems.remove(product); // حذف محصول از سبد خرید
        } else {
            cartItems.put(product, currentQuantity - quantity); // کاهش تعداد محصول در سبد خرید
        }

        product.setStock(product.getStock() + quantity); // افزایش موجودی محصول
    }

    // مجموع قیمت آیتم‌های موجود در سبد خرید را محاسبه می‌کند.
    public double getTotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            // قیمت محصول جاری را ضرب در تعداد آن کرده و به total اضافه می‌کند.
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total; // برگرداندن مجموع قیمت
    }

    // این متد سبد خرید را خالی می‌کند
    public void clear() {
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey(); // دریافت محصول
            int quantity = entry.getValue(); // دریافت تعداد محصول
            product.setStock(product.getStock() + quantity); // افزایش موجودی محصول
        }
        cartItems.clear(); // خالی کردن سبد خرید
    }

    // دریافت نقشه محصولات و تعداد آن‌ها در سبد خرید
    public Map<Product, Integer> getCartItems() {
        return cartItems; // برگرداندن نقشه محصولات و تعداد آن‌ها
    }
}
