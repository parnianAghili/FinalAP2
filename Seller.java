package users;

import products.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * این کلاس برای نگهداری و مدیریت اطلاعات فروشنده‌ها طراحی شده است.
 */
public class Seller extends Account {
    private List<Product> listedProducts; // لیست محصولات فروشنده
    private String company; // نام شرکت فروشنده
    private double balance; // موجودی فروشنده
    private boolean hasLicense; // مجوز فروش
    private double wallet; // کیف پول

    /**
     * کانستراکتور کلاس Seller برای ایجاد یک نمونه از فروشنده با اطلاعات اولیه مشخص
     * شده.
     * 
     * @param username نام کاربری
     * @param password رمز عبور
     * @param email    ایمیل
     * @param company  نام شرکت
     */
    public Seller(String username, String password, String email, String company) {
        super(username, password, email);
        this.company = company;
        this.listedProducts = new ArrayList<>();
        this.balance = 0.0;
        this.hasLicense = false; // مجوز فروش اولیه false
        this.wallet = 0.0; // مقدار اولیه کیف پول 0.0
    }

    // Getters and setters
    public List<Product> getListedProducts() {
        return listedProducts;
    }

    public void setListedProducts(List<Product> listedProducts) {
        this.listedProducts = listedProducts;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean hasLicense() {
        return hasLicense;
    }

    public void setHasLicense(boolean hasLicense) {
        this.hasLicense = hasLicense;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    /**
     * این متد یک محصول را به لیست محصولات فروشنده اضافه می‌کند.
     * 
     * @param product محصولی که اضافه می‌شود
     */
    public void addProduct(Product product) {
        listedProducts.add(product);
    }

    /**
     * این متد موجودی حساب فروشنده را افزایش می‌دهد.
     * 
     * @param amount مقداری که به موجودی اضافه می‌شود
     */
    public void addToBalance(double amount) {
        this.balance += amount;
    }

    /**
     * این متد موجودی حساب فروشنده را کاهش می‌دهد.
     * 
     * @param amount مقداری که از موجودی کم می‌شود
     */
    public void subtractFromBalance(double amount) {
        this.balance -= amount;
    }

    /**
     * این متد لیست محصولات فروشنده را نمایش می‌دهد.
     */
    public void showProducts() {
        if (listedProducts.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Products from " + company + ":");
            for (Product product : listedProducts) {
                System.out.println(product);
            }
        }
    }
}
