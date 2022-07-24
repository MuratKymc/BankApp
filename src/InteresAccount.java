public class InteresAccount extends Account{

    private double intersetRate;
    private double accumulationRate;
    private double amountOfDebt;

    public InteresAccount(String accountID, String accountType, double balance, Bank bank, Customer customer) {
        super(accountID, accountType, balance, bank, customer);
        this.intersetRate = bank.getDailyInterestRate();
        this.accumulationRate = bank.getAccumulationRate();
    }

    public double getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(double intersetRate) {
        this.intersetRate = intersetRate;
    }

    public double getAccumulationRate() {
        return accumulationRate;
    }

    public void setAccumulationRate(double accumulationRate) {
        this.accumulationRate = accumulationRate;
    }

    public double getAmountOfDebt() {
        return amountOfDebt;
    }

    public void setAmountOfDebt(double amountOfDebt) {
        this.amountOfDebt = amountOfDebt;
    }

    @Override
    public Bank getBank() {
        return super.getBank();
    }

    @Override
    public void setBank(Bank bank) {
        super.setBank(bank);
    }

    @Override
    public String getAccountID() {
        return super.getAccountID();
    }

    @Override
    public void setAccountID(String accountID) {
        super.setAccountID(accountID);
    }

    @Override
    public String getAccountType() {
        return super.getAccountType();
    }

    @Override
    public void setAccountType(String accountType) {
        super.setAccountType(accountType);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean checkBalance(double amount) {
        return super.checkBalance(amount);
    }

    @Override
    public void sendMoney(double amount, Account account) {
        super.sendMoney(amount, account);
    }

    @Override
    public boolean checkOut(double amount) {
        return super.checkOut(amount);
    }



    @Override
    public void depositMoney(double amount) {
        super.depositMoney(amount);
    }

    @Override
    public void addAccountToBank() {
        super.addAccountToBank();
    }

    @Override
    public void addAccountToCustomer() {
        super.addAccountToCustomer();
    }

    public void borrowMoneyWithInterest(double money , int day){
        this.amountOfDebt = (money/100) * (getBank().getDailyInterestRate()) * day;
        setBalance(getBalance() + money);
        this.amountOfDebt += money;
        System.out.println("Krediniz hesab?n?za i?lenmi?tir.\n" +
                "Borcunuz = " + amountOfDebt+"" +
                "\nYeni bakiyeniz = " + getBalance());
    }

    public void showDept(){
        System.out.println("Borcunuz : " + amountOfDebt);

    }

    @Override
    public void saveUpMoney(double money, int day){
        double savedMoney = 0;
        savedMoney = getBalance() + ( money * (getBank().getAccumulationRate() / 100)* day );
        setBalance(savedMoney);
        System.out.println("Birikim yap?lm?? bakiyeniz : " + getBalance());

    }


}