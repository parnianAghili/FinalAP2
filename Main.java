package Main;

import users.*;
import products.*;
import shop.Shop;
import java.util.List;
import java.util.Scanner;
import shopping.ShoppingCart;
import orders.*;

public class Main {

    private static Shop shop = new Shop("My Shop", "www.myshop.com", "123-456-7890"); // ایجاد یک فروشگاه جدید
    private static UserManager userManager = new UserManager(); // مدیر کاربران
    private static ProductManager productManager = new ProductManager(); // مدیر محصولات

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); // خواندن انتخاب کاربر
            scanner.nextLine(); // مصرف کردن کاراکتر newline

            switch (choice) {
                case 1:
                    registerUser(scanner); // ثبت نام کاربر
                    break;
                case 2:
                    loginUser(scanner); // ورود به سیستم
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again."); // پیام خطا برای انتخاب نامعتبر
            }
        }
        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.println("Select account type: ");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("3. Seller");
        int accountType = scanner.nextInt();
        scanner.nextLine(); // مصرف کردن کاراکتر newline

        Account account = null;

        switch (accountType) {
            case 1:
                System.out.print("Enter username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Enter password: ");
                String adminPassword = scanner.nextLine();
                System.out.print("Enter email: ");
                String adminEmail = scanner.nextLine();
                account = new Admin(adminUsername, adminPassword, adminEmail);
                break;
            case 2:
                System.out.print("Enter username: ");
                String customerUsername = scanner.nextLine();
                System.out.print("Enter password: ");
                String customerPassword = scanner.nextLine();
                System.out.print("Enter email: ");
                String customerEmail = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                account = new Customer(customerUsername, customerPassword, customerEmail, phoneNumber, address);
                break;
            case 3:
                System.out.print("Enter username: ");
                String sellerUsername = scanner.nextLine();
                System.out.print("Enter password: ");
                String sellerPassword = scanner.nextLine();
                System.out.print("Enter email: ");
                String sellerEmail = scanner.nextLine();
                System.out.print("Enter company name: ");
                String company = scanner.nextLine();
                account = new Seller(sellerUsername, sellerPassword, sellerEmail, company);
                break;
            default:
                System.out.println("Invalid account type! Please try again!");
                return; // اگر نقش معتبر نبود، عملیات ثبت نام را متوقف کنید
        }

        boolean success = userManager.registerUser(account);
        if (success) {
            shop.addAccount(account); // فرض بر این است که متدی برای اضافه کردن حساب‌ها در کلاس Shop دارید
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private static void loginUser(Scanner scanner) { // گرفتن اطلاعات کاربر برای ورود به سیستم
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Account user = userManager.login(username, password); // تلاش برای ورود به سیستم با استفاده از مدیر کاربران

        if (user != null) {
            System.out.println("Login successful.");
            if (user instanceof Admin) {
                adminMenu((Admin) user, scanner); // نمایش منوی مدیر
            } else if (user instanceof Customer) {
                customerMenu((Customer) user, scanner); // نمایش منوی مشتری
            } else if (user instanceof Seller) {
                sellerMenu((Seller) user, scanner); // نمایش منوی فروشنده
            }
        } else {
            System.out.println("Login failed. Please check your username and password."); // پیام خطا برای ورود نامعتبر
        }
    }

    private static void adminMenu(Admin admin, Scanner scanner) {
        boolean exit = false;

        while (!exit) { // نمایش منوی مدیر
            System.out.println("1. View all users");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // مصرف کردن کاراکتر newline

            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void viewAllUsers() {
        List<Account> users = userManager.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (Account user : users) {
                System.out.println(user);
            }
        }
    }

    private static void customerMenu(Customer customer, Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("1. View products");
            System.out.println("2. Add product to cart");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // مصرف کردن کاراکتر newline

            switch (choice) {
                case 1:
                    productManager.showAllProducts();
                    break;
                case 2:
                    addProductToCart(customer, scanner);
                    break;
                case 3:
                    customer.viewCart();
                    break;
                case 4:
                    customer.checkout();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addProductToCart(Customer customer, Scanner scanner) { // متد برای اضافه کردن محصول به سبد خرید
        System.out.print("Enter product name: "); // از کاربر نام محصول را دریافت می‌کند
        String productName = scanner.nextLine();
        Product product = productManager.searchProduct(productName); // جستجوی محصول با استفاده از نام آن
        if (product != null) { // اگر محصول پیدا شد، آن را به سبد خرید مشتری اضافه می‌کند
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // مصرف کردن کاراکتر newline
            customer.addToCart(product, quantity); // درخواست تعداد محصول

            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // مصرف کردن کاراکتر newline
        System.out.print("Enter product stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // مصرف کردن کاراکتر newline
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        Product product = new Product(name, price, stock, description, category); // ایجاد یک شیء محصول جدید با استفاده
                                                                                  // از اطلاعات دریافت شده
        productManager.addProduct(product); // اضافه کردن محصول به مدیر محصولات
        System.out.println("Product added successfully.");
    }

    private static void removeProduct(Scanner scanner) { // متد برای حذف محصول
        System.out.print("Enter product name: "); // از کاربر نام محصول را دریافت می‌کند
        String name = scanner.nextLine();

        Product product = productManager.searchProduct(name); // جستجوی محصول با استفاده از نام آن
        if (product == null) { // اگر محصول پیدا نشد، پیغام خطا نمایش داده می‌شود
            System.out.println("Product not found.");
            return;
        }

        productManager.removeProduct(product); // حذف محصول از مدیر محصولات
        System.out.println("Product removed successfully.");
    }

    private static void sellerMenu(Seller seller, Scanner scanner) {
        boolean exit = false; // پرچم برای خروج از منو

        while (!exit) {
            System.out.println("1. View products");
            System.out.println("2. Add product");
            System.out.println("3. Remove product");
            System.out.println("4. View wallet balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // مصرف کردن کاراکتر newline

            switch (choice) {
                case 1:
                    seller.showProducts(); // نمایش محصولات فروشنده
                    break;
                case 2:
                    // اضافه کردن محصول جدید
                    addProduct(scanner);
                    break;
                case 3:
                    // حذف محصول
                    removeProduct(scanner);
                    break;
                case 4:
                    // نمایش موجودی کیف پول
                    System.out.println("Wallet balance: " + seller.getBalance());
                    break;
                case 5:
                    // خروج از منو
                    exit = true;
                    break;
                default:
                    // پیغام خطا برای انتخاب نامعتبر
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}