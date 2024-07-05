package users;

/**
 * کلاس Wallet که میزان موجودی کیف پول را نگه‌داری می‌کند
 * شامل متدهایی برای دسترسی، تغییر و مدیریت موجودی است
 */
public class wallet {
    private double balance;

    public wallet() {
        this.balance = 0.0; // مقدار اولیه موجودی را برابر با 0.0 تنظیم می‌کند
    }

    // Getters and Setters
    public double getBalance() {
        return balance;
    }

    // متدی برای تنظیم میزان موجودی کیف پول
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // متدی برای اضافه کردن مبلغی به موجودی کیف پول.
    public void addFunds(double amount) {
        this.balance += amount;
    }

    // متدی برای کسر مبلغی از موجودی کیف پول
    public boolean deductFunds(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * این متد برای ارسال درخواست افزودن وجه به مدیر استفاده می‌شود.
     * 
     * @param manager مدیری که درخواست باید به او ارسال شود
     * @param amount  مقدار مورد درخواست برای افزودن به موجودی
     */
    public void requestAddFundsToManager(String manager, double amount) {
        // اینجا باید کد برای ارسال درخواست به مدیر بنویسید
        System.out.println("Requesting to add $" + amount + " to manager " + manager);
    }
}
