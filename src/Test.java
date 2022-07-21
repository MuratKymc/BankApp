public class Test {

    public static void main(String[] args) {
        Bank ziraat = new Bank("Ziraat Bankasý",2.85,0.18);

        Customer customer = new Customer("Hamza","Yýlmaz","23566778",ziraat);
        Customer customer2 = new Customer("Murat","Kuyumcu","12311",ziraat);


        Account ac = new Account("1234","TRY",10000,ziraat,customer);
        Account ac1 = new Account("123","USD",20000,ziraat,customer);
        Account ac2 = new Account("123","TRY",10000,ziraat,customer2);
        InteresAccount ac3 = new InteresAccount("123","TRY",20000,ziraat,customer2);
        InteresAccount ac4 = new InteresAccount("123","TRY",10000,ziraat,customer2);



        ziraat.writeAllAccounts();
        System.out.println("*****************************");
        ziraat.writeCustomers();
        System.out.println("********************************");
        customer.writeAccount();
        System.out.println("*********************************");
        customer2.writeAccount();
        System.out.println("******************************");
        ac3.borrowMoneyWithInterest(3000,10);

        System.out.println("*************************************");
        ziraat.writeAllAccounts();
        System.out.println("****************************");
        customer2.writeAccount();
        System.out.println("****************************");

        ac4.saveUpMoney(30);

    }





}
