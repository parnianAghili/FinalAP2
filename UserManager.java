package users;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<Account> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public boolean registerUser(Account account) {
        // بررسی وجود کاربر با همان نام کاربری
        for (Account user : users) {
            if (user.getUsername().equals(account.getUsername())) {
                return false; // اگر کاربر با همان نام کاربری وجود داشته باشد، ثبت‌نام انجام نمی‌شود
            }
        }
        users.add(account); // اضافه کردن کاربر به لیست کاربران
        return true; // ثبت‌نام با موفقیت انجام شد
    }

    public Account login(String username, String password) {
        // بررسی صحت نام کاربری و رمز عبور
        for (Account user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // اگر نام کاربری و رمز عبور درست باشد، کاربر بازگردانده می‌شود
            }
        }
        return null; // اگر نام کاربری یا رمز عبور اشتباه باشد، null بازگردانده می‌شود
    }

    public List<Account> getAllUsers() {
        return users; // بازگرداندن لیست همه کاربران
    }
}
