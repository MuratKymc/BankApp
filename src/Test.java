public class Test {

    public static void main(String[] args) {
        Bank ziraat = new Bank("Ziraat Bankasý ve Kalkýnma");

        Account ac1 = new Account("123","USD",23333);
        Customer customer = new Customer("Hamza","Yýlmaz","23566778");
        Customer cust2 = new Customer("Murat","Kuyumcu","12311");
        Account ac2 = new Account("123","TRY",10000);
        Account ac = new Account("1234","TRY",10000);


        customer.addAccount(ac1);
        customer.addAccount(ac);


        ziraat.addCustomer(customer);
        ziraat.addCustomer(cust2);

        System.out.println(ac2.getBalance());
        System.out.println(ac.getBalance());

        ac2.sendMoney(2000,ac);

        System.out.println(ac2.getBalance());
        System.out.println(ac.getBalance());

            ziraat.writeCustomers();
            customer.writeAccount();
            cust2.writeAccount();

    }

}
