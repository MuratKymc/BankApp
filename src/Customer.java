import java.util.ArrayList;

public class Customer {

    private String name;
    private String lastName;
    private String TC;
    private Bank bank;
    private ArrayList<Account> accountList = new ArrayList<>();

    public Customer(String name, String lastName, String TC, Bank bank) {
        this.name = name;
        this.lastName = lastName;
        this.TC = TC;
        this.bank = bank;
    }

    public Customer() {

    }

    public Bank getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", TC='" + TC + '\'' +
                ", accountList=" + accountList +
                "}\n";
    }
    public void addAccount(Account account){
        accountList.add(account);
        System.out.println("Hesap ba�ar�yla eklendi.");
    }

    public void addCustomerToBank(){
        this.bank.addCustomer(this);

    }
    public void writeAccount(){
        System.out.println("\n******** " + this.name + " " + this.lastName + " Hesaplar ********");

        if (accountList.toArray().length <= 0){
            System.out.println("M�sterinin hi� hesab� yok. Hesap a�mak i�in 3 e bas�n�z.");

        }else
            System.out.println("Hangi hesab�nda birikim yapmak istersiniz? ");
            for (int i = 0 ; i< accountList.toArray().length; i++){
                System.out.println(i+1 + " -> " + " ID : " + getAccountList().get(i).getAccountID() + "\tType : "
                        + getAccountList().get(i).getAccountType()+ "\t Balance : " + getAccountList().get(i).getBalance() );
            }


    }
}