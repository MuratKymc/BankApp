import java.util.ArrayList;


public class Bank {

    private String bankName;

    private double dailyInterestRate;

    private double accumulationRate;
    private ArrayList<Customer> customerList = new ArrayList<>();

    private ArrayList<Account> accountList = new ArrayList<>();

    public Bank(String bankName, double dailyInterestRate,double accumulationRate) {
        this.bankName = bankName;
        this.dailyInterestRate = dailyInterestRate;
        this.accumulationRate = accumulationRate;
        System.out.println("Banka oluþtu");
    }

    public double getAccumulationRate() {
        return accumulationRate;
    }

    public void setAccumulationRate(double accumulationRate) {
        this.accumulationRate = accumulationRate;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public double getDailyInterestRate() {
        return dailyInterestRate;
    }

    public void setDailyInterestRate(double dailyInterestRate) {
        this.dailyInterestRate = dailyInterestRate;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public void addCustomer(Customer customer){
        customerList.add(customer);
        System.out.println("Müþteri eklendi.");
    }

    public void addAccounts(Account account){
        accountList.add(account);
    }


    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", customerList=" + customerList +
                "}\n";
    }


    public void writeCustomers(){
        System.out.println("\n******** " + this.bankName + " Müþteri Listesi ********");

        if (customerList.size() <= 0){
            System.out.println("Bankanýn hiç müþterisi yok");
        }else
        for (int i = 0 ; i< customerList.size(); i++){
            System.out.println(i+1 + " : " + getCustomerList().get(i).getName() + " " + getCustomerList().get(i).getLastName());
        }

    }

    public void writeAllAccounts(){
        System.out.println("\n******** " + this.bankName + " Tüm Hesaplarý ********");

        if (accountList.size() <= 0){
            System.out.println("Bankaya kayýtlý bir hesap bulunamadý.");
        }else
            for (int i = 0 ; i< accountList.size(); i++){
                System.out.println(i+1 + " -> " + " ID : " + getAccountList().get(i).getAccountID() + "\tType : "
                        + getAccountList().get(i).getAccountType()+ "\t Balance : " + getAccountList().get(i).getBalance() );
            }

    }

}
