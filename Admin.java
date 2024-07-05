package users;

/*
 * کلاس Admin از کلاس Account ارث‌بری می‌کند.
 */
public class Admin extends Account {
    
    // کانستراکتور کلاس Admin که مقادیر ورودی را به کانستراکتور کلاس والد (Account) ارسال می‌کند.
    public Admin(String username, String password, String email) {
        super(username, password, email);
    }

    // متد برای نمایش اطلاعات حساب کاربری ادمین به صورت رشته
    @Override
    public String toString() {
        return "Admin: " + super.toString(); // استفاده از متد toString کلاس والد (Account)
    }
}
