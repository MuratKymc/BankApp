public class Account {

    private String accountID;
    private String accountType;
    private double balance;
    private Bank bank;
    private Customer customer;

    public Account(String accountID, String accountType, double balance,Bank bank,Customer customer) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.balance = balance;
        this.bank = bank;
        this.customer = customer;
        addAccountToBank();
        addAccountToCustomer();
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
            return false;
        }else
            return true;

    }

    public void sendMoney(double amount, Account account){
        if (checkBalance(amount)){
            this.balance -= amount;
            account.setBalance(account.getBalance() + amount);
            System.out.println("Ýþlem baþarýlý. Yeni bakiye : " + this.balance);
        }else
            System.out.println("Ýþlem baþarýsýz.");
    }



    public boolean checkOut(double amount) {
        if (balance - amount < 0) {
            return false;
        } else
            return true;
    }

    public void withdrawMoney(double amount) {

        if (checkOut(amount)){
            System.out.println("Ýþleminiz yapiliyor...");
            balance -= amount;
            System.out.println("Ýþleminiz baþarýlý. Yeni bakiye : " + balance);
        }else{
            System.out.println("Ýþleminiz yapýlýyor...");
            System.out.println("Bakiyeniz yeterli degil.");

        }

    }
    public void depositMoney(double amount) {
        System.out.println("Ýþleminiz yapiliyor...");
        balance += amount;
        System.out.println("Ýþleminiz baþarýlý. Yeni bakiye : " + balance);


    }

    public void addAccountToBank(){
        this.bank.addAccounts(this);
    }

    public void addAccountToCustomer(){
        this.customer.addAccount(this);
    }




}
