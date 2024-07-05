package users;

// این کلاس یک کلاس انتزاعی به نام Account است که ویژگی‌های یک حساب کاربری را مدل می‌کند.

public abstract class Account {
    private String username; // نام کاربری حساب
    private String password; // رمز عبور حساب
    private String email; // ایمیل حساب
    private double walletBalance; // موجودی کیف پول

    // متد سازنده برای ایجاد یک نمونه از کلاس Account با مقادیر داده شده
    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.walletBalance = 0.0; // اولین موقعیت موجودی کیف پول را صفر تنظیم می‌کند
    }

    // متد getter برای دریافت نام کاربری
    public String getUsername() {
        return username;
    }

    // متد getter برای دریافت رمز عبور
    public String getPassword() {
        return password;
    }

    // متد getter برای دریافت ایمیل
    public String getEmail() {
        return email;
    }

    // متد getter برای دریافت موجودی کیف پول
    public double getWalletBalance() {
        return walletBalance;
    }

    // متد برای افزایش موجودی کیف پول
    public void addToWallet(double amount) {
        walletBalance += amount;
    }

    // متد برای کاهش موجودی کیف پول
    public void deductFromWallet(double amount) {
        walletBalance -= amount;
    }

    // متد toString برای نمایش اطلاعات پایه حساب به صورت رشته‌ای
    @Override
    public String toString() {
        return "Username: " + username + ", Email: " + email;
    }
}
