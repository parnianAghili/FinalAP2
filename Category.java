package products;

import java.util.ArrayList;
import java.util.List;

/**
 * این یک کلاس است که نام محصولات را می‌گیرد و یک لیست از آن‌ها با اسم مشخص
 * ایجاد می‌کند.
 */
public abstract class Category {
    private String name; // نام دسته بندی
    private List<Product> products; // لیست محصولات

    // سازنده کلاس Category که نام دسته بندی را تنظیم کرده و لیست محصولات را ایجاد
    // می‌کند
    public Category(String name) {
        this.name = name; // تنظیم نام دسته بندی
        this.products = new ArrayList<>(); // ایجاد یک لیست خالی از محصولات
    }

    /**
     * اضافه کردن محصول به دسته بندی
     * 
     * @param product محصولی که باید اضافه شود
     */
    public void addProduct(Product product) {
        products.add(product); // اضافه کردن محصول به لیست محصولات
    }

    /**
     * حذف محصول از دسته بندی
     * 
     * @param product محصولی که باید حذف شود
     */
    public void removeProduct(Product product) {
        products.remove(product); // حذف محصول از لیست محصولات
    }

    /**
     * دریافت لیست محصولات
     * 
     * @return لیست محصولات
     */
    public List<Product> getProducts() {
        return products; // برگرداندن لیست محصولات
    }

    /**
     * دریافت نام دسته بندی
     * 
     * @return نام دسته بندی
     */
    public String getName() {
        return name; // برگرداندن نام دسته بندی
    }

    /**
     * تنظیم نام دسته بندی
     * 
     * @param name نام جدید دسته بندی
     */
    public void setName(String name) {
        this.name = name; // تنظیم نام دسته بندی
    }

    /**
     * تنظیم لیست محصولات
     * 
     * @param products لیست جدید محصولات
     */
    public void setProducts(List<Product> products) {
        this.products = products; // تنظیم لیست جدید محصولات
    }
}

class DessertCategory extends Category {
    public DessertCategory() {
        super("Dessert");
    }
}

class BeveragesCategory extends Category {
    public BeveragesCategory() {
        super("Beverages");
    }
}

class FoodCategory extends Category {
    public FoodCategory() {
        super("Food");
    }
}
