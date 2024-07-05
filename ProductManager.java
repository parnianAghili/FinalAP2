package products;

import java.util.ArrayList;
import java.util.List;

/**
 * این کلاس برای مدیریت محصولات استفاده می‌شود
 */
public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    /**
     * اضافه کردن محصول جدید
     * @param product محصول جدید
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * نمایش همه محصولات
     */
    public void showAllProducts() {
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + " - Price: " + product.getPrice() + " - Quantity: " + product.getStock());
        }
    }

    /**
     * جستجوی محصول بر اساس نام
     * @param productName نام محصول
     * @return محصول پیدا شده یا null
     */
    public Product searchProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(Product product) {
       
    }
}
