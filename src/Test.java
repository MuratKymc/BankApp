import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static ArrayList<Bank> banks = new ArrayList<>();

    public static void main(String[] args) {
        Bank ziraat = new Bank("Ziraat Bankasý",2.85,0.18);
        Scanner input = new Scanner(System.in);
        welcome();
        while (true) {
            String a = input.nextLine();
            if (a.equals("q")) {
                System.out.println("Programdan çýkýlýyor...");
                break;
            } else if (a.equals("1")) {
                System.out.println("Bankanýzý seçiniz:");
                String isim = input.nextLine();
                System.out.println("Faiz oranýný seçiniz:");
                double IRate = input.nextDouble();
                System.out.println("Birikim oranýný seçiniz:");
                double accRate = input.nextDouble();
                banks.add(new Bank(isim, IRate, accRate));
                welcome();

            } else if (a.equals("2")) {
                System.out.println("Müþteri adýný giriniz: ");
                String isim = input.nextLine();
                System.out.println("Müþteri soyadýný giriniz: ");
                String soyisim = input.nextLine();
                System.out.println("Müþteri TC kimlik numarasýný giriniz: ");
                String tcID = input.nextLine();
                System.out.println("Müþteri bankasýný seçiniz: ");
                bankalar();
                int i = input.nextInt();
                System.out.println("Müþteri kaydýnýz " + i + ". bankaya eklendi!");
                banks.get(i - 1).addCustomer(new Customer(isim, soyisim, tcID, banks.get(i - 1)));
                welcome();
            } else if (a.equals("3")) {

                System.out.println(" Hesap numarasýný giriniz: ");
                String id = input.next();
                System.out.println(" Hesabýn tipini giriniz: ");
                String type = input.next();
                System.out.println("Müþteri bankasýný seçiniz: ");
                bankalar();
                int i = input.nextInt();
                banks.get(i - 1).writeCustomers();
                int j = input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).addAccount(new Account(id, type, 0, banks.get(i - 1), banks.get(i - 1).getCustomerList().get(j - 1)));
                welcome();
            } else if (a.equals("4")) {
                System.out.println("Hangi bankanýn müsterilerini görüntülemek istersiniz? ");
                bankalar();
                int choose=input.nextInt();
                banks.get(choose-1).writeCustomers();
                welcome();
            } else if (a.equals("5")) {
                System.out.println("Hangi banka müþterilerinin hesaplarýný görüntülemek istersiniz? ");
                bankalar();
                int i= input.nextInt();
                banks.get(i-1).writeCustomers();
                System.out.println("Hangi müþterinin hesaplarýný görüntelemek istersiniz?");
                int choose= input.nextInt();
                banks.get(i-1).getCustomerList().get(choose-1).writeAccount();
                welcome();
            } else if (a.equals("6")) {
                System.out.println("Para göndereceðiniz bankayý seçiniz");
                bankalar();
                int i = input.nextInt();
                System.out.println("Para göndermek istediðiniz müþteriyi seçiniz");
                banks.get(i-1).writeCustomers();
                int j = input.nextInt();
                System.out.println(banks.get(i - 1).getCustomerList().get(j - 1) +
                        " müþterisini seçtiniz. \n Göndermek istediðiniz tutarý giriniz: ");
                int tutar = input.nextInt();
                System.out.println("Para göndermek istediðiniz hesabý seçiniz");
                banks.get(i - 1).getCustomerList().get(j - 1).writeAccount();
                int choose= input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).getAccountList().get(choose-1).depositMoney(tutar);
                welcome();

            } else if (a.equals("7")) {
                System.out.println("Para çekeceðiniz bankayý seçiniz ");
                bankalar();
                int i = input.nextInt();
                System.out.println("Para çekmek istediðiniz müþteriyi seçiniz");
                banks.get(i - 1).writeCustomers();
                int j= input.nextInt();
                System.out.println(banks.get(i - 1).getCustomerList().get(j - 1) + " müþterisini seçtiniz. \n Çekmek istediðiniz tutarý giriniz: ");
                int withdraw= input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).writeAccount();
                System.out.println("Seçtiðiniz müþterinin hesaplarýný listeledik.Seçmek istediðiniz hesabýn sýra numarasýný giriniz:");
                int queue = input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).getAccountList().get(queue-1).withdrawMoney(withdraw);
                welcome();

            }
            else if (a.equals("8")){
                System.out.println("Birikim yapmayý hedeflediðiniz bankayý seçiniz lütfen: ");
                bankalar();
                int i= input.nextInt();
                System.out.println("Birikim yaptýrmak istediðiniz müþteriyi seçiniz: ");
                banks.get(i-1).writeCustomers();
                int j= input.nextInt();
                System.out.println(banks.get(i-1).getCustomerList().get(j-1)+
                        " müþterisinin tüm hesaplarýný görüntülemek için 4 e basýnýz.");
                int show= input.nextInt();
                banks.get(i-1).getCustomerList().get(j-1).writeAccount();
                System.out.println("Hangi hesabýnda birikim yapmak istersiniz? ");
                int choose= input.nextInt();
                banks.get(i-1).getCustomerList().get(j-1).getAccountList().get(choose-1);
                System.out.println("Birikim hesabýna yükleyeceðiniz tutarý belirleyin");
                int money= input.nextInt();
                System.out.println("Kaç gün birikim yapacaðýnýzý giriniz ");
                int day= input.nextInt();
                banks.get(i-1).getCustomerList().get(j-1).getAccountList().get(choose-1).saveUpMoney(money,day);
                welcome();

            }
            /*else if(a.equals("9")){
                System.out.println("Kredi çekmek istediðiniz bankayý seçiniz: ");
                bankalar();
                int bankChoose= input.nextInt();
                if (banks.get(bankChoose-1).getCustomerList().size() <=0)
                    System.out.println("Bankanýn müþterisi olup hesap açmalýsýnýz");
                    Customer fakeCustomer = new Customer();
                    banks.get(bankChoose - 1).addCustomer(fakeCustomer);
                    System.out.println("Bu bankadaki kredi çekim miktarýný öðrenmek için sanal bir vadeli hesap oluþturmalýsýnýz. \n" +
                            "Bunun için 3 e basýnýz.");

                    int createAcc = input.nextInt();
                    InteresAccount fakeAcc = (InteresAccount) new Account("123", "deposit", 0, banks.get(bankChoose - 1), fakeCustomer);
                System.out.println("Ana paranýzý giriniz: ");
                int mainMoney= input.nextInt();
                System.out.println("Kredi tutarýný giriniz:");
                int interest= input.nextInt();
                fakeAcc.borrowMoneyWithInterest(mainMoney,interest);
            }*/


        }
    }

    public static void welcome() {
        System.out.println("Hoþgeldiniz! Ana ekran gösteriliyor\n " +
                "***********************************" + " \n " + "q -Çýkýþ Yapma" +
                "\n 1 -Banka oluþturma" + "\n 2-Müþteri oluþturma" + "\n 3-Hesap oluþturma" + "\n 4-Banka müþterilerini görüntüle" +
                "\n 5- Müþterilerin hesaplarýný görüntüle" + "\n 6-Para Gönder" + "\n 7-Para Çek" + "\n 8-Birikim Yap" + "\n 9-Kredi Çek");
    }




    public static void bankalar() {
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + " = " + banks.get(i).getBankName());
        }
    }

}

