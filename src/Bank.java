import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Customer> customerList = new ArrayList<>();

    public Bank(String bankName) {
        this.bankName = bankName;
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
}
