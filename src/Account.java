public class Account {

    private String accountID;
    private String accountType;
    private double balance;

    public Account(String accountID, String accountType, double balance) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                "}\n";
    }

    public boolean checkBalance(double amount){
        if (this.balance < amount ){
            System.out.println("Yeterli bakiye yok.");
            System.out.println("hhhh");
            return false;
        }else
            return true;

    }

    public void sendMoney(double amount, Account account){
        if (checkBalance(amount)){
            this.balance -= amount;
            account.setBalance(account.getBalance() + amount);
            System.out.println("��lem ba�ar�l�. Yeni bakiye : " + this.balance);
        }else
            System.out.println("��lem ba�ar�s�z.");
    }



    public boolean checkOut(double amount) {
        if (balance - amount < 0) {
            return false;
        } else
            return true;
    }

    public void withdrawMoney(double amount) {

        if (checkOut(amount)){
            System.out.println("��leminiz yapiliyor...");
            balance -= amount;
            System.out.println("��leminiz ba�ar�l�. Yeni bakiye : " + balance);
        }else{
            System.out.println("��leminiz yap�l�yor...");
            System.out.println("Bakiyeniz yeterli degil.");

        }

    }
    public void depositMoney(double amount) {
        System.out.println("��leminiz yapiliyor...");
        balance += amount;
        System.out.println("��leminiz ba�ar�l�. Yeni bakiye : " + balance);


    }




}
