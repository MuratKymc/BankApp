import java.nio.file.AccessMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static ArrayList<Bank> banks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        welcome();
        while (true) {
            String a = input.nextLine();

            if (a.equals("q")) {
                System.out.println("Programdan çıkılıyor...");
                break;
            } else if (a.equals("1")) {
                System.out.println("Bankan�z� se�iniz:");
                String isim = input.nextLine();
                System.out.println("Faiz oran�n� se�iniz:");
                double IRate = input.nextDouble();
                System.out.println("Birikim oran�n� se�iniz:");
                double accRate = input.nextDouble();
                banks.add(new Bank(isim, IRate, accRate));
                welcome();

            } else if (a.equals("2")) {
                System.out.println("M��teri ad�n� giriniz: ");
                String isim = input.nextLine();
                System.out.println("M��teri soyad�n� giriniz: ");
                String soyisim = input.nextLine();
                System.out.println("M��teri TC kimlik numaras�n� giriniz: ");
                String tcID = input.nextLine();
                System.out.println("M��teri bankas�n� se�iniz: ");
                bankalar();
                int i = input.nextInt();
                System.out.println("M��teri kayd�n�z " + i + ". bankaya eklendi!");
                banks.get(i - 1).addCustomer(new Customer(isim, soyisim, tcID, banks.get(i - 1)));
                welcome();
            } else if (a.equals("3")) {
                System.out.println(" Hesap numaras� giriniz: ");
                String id = input.next();
                System.out.println(" Hesab�n tipini giriniz: ");
                String type = input.next();
                System.out.println("M��teri bankas�n� se�iniz: ");
                bankalar();

                int i = input.nextInt();
                banks.get(i - 1).writeCustomers();
                int j = input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).addAccount(new Account(id, type, 0, banks.get(i - 1), banks.get(i - 1).getCustomerList().get(j - 1)));
                welcome();
            } else if (a.equals("4")) {
                System.out.println("Hangi bankanın müsterilerini görüntülemek istersiniz? ");
                bankalar();
                int choose=input.nextInt();
                banks.get(choose-1).writeCustomers();
                welcome();
            } else if (a.equals("5")) {
                System.out.println("Hangi banka müsterilerinin hesaplar�n� g�r�nt�lemek istersiniz? ");
                bankalar();
                int i= input.nextInt();
                banks.get(i-1).writeCustomers();
                System.out.println("Hangi müşterinin hesaplarını görüntülemek istersiniz?");
                int choose= input.nextInt();
                banks.get(i-1).getCustomerList().get(choose-1).writeAccount();
                System.out.println("Ana menüye dönmek isterseniz 'A' yazınız!");
                String menu=input.next();
                if(menu.equals("A")){
                    welcome();
                }
                else break;
            } else if (a.equals("6")) {
                System.out.println("Para göndereceğiniz bankayı seçiniz");
                bankalar();
                int i = input.nextInt();
                System.out.println("Para göndermek istediğiniz müşteriyi seçiniz");
                banks.get(i-1).writeCustomers();
                int j = input.nextInt();
                System.out.println(banks.get(i - 1).getCustomerList().get(j - 1) +
                        " müşterisini seçtiniz. \n Göndermek istediğiniz tutarı giriniz: ");
                int tutar = input.nextInt();
                System.out.println("Para göndermek istediğiniz hesabı seçiniz");
                banks.get(i - 1).getCustomerList().get(j - 1).writeAccount();
                int choose= input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).getAccountList().get(choose-1).depositMoney(tutar);
                welcome();

            } else if (a.equals("7")) {
                System.out.println("Para çekeceğiniz bankayı seçiniz ");
                bankalar();
                int i = input.nextInt();
                System.out.println("Para çekmek istediğiniz müşteriyi seçiniz");
                banks.get(i - 1).writeCustomers();
                int j= input.nextInt();
                System.out.println(banks.get(i - 1).getCustomerList().get(j - 1) + " müşterisini seçtiniz. \n Çekmek istediğiniz tutarı giriniz: ");
                int withdraw= input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).writeAccount();
                System.out.println("Seçtiğiniz müşterinin hesaplarını listeledik.Seçmek istediğiniz hesabın sıra numarasını giriniz:");
                int queue = input.nextInt();
                banks.get(i - 1).getCustomerList().get(j - 1).getAccountList().get(queue-1).withdrawMoney(withdraw);
                welcome();

            }
            else if (a.equals("8")){
                System.out.println("Birikim yapmayı hedeflediğiniz bankayı seçiniz: ");
                bankalar();
                int i= input.nextInt();
                System.out.println("Birikim yaptırmak istediğiniz müşteriyi seçiniz: ");
                banks.get(i-1).writeCustomers();
                int j= input.nextInt();
                System.out.println(banks.get(i-1).getCustomerList().get(j-1)+
                        " müşterisinin tüm hesaplarını görüntülemek için 4 e basınız.");
                int show= input.nextInt();
                banks.get(i-1).getCustomerList().get(j-1).writeAccount();
                System.out.println("Hangi hesabında birikim yapmak istersiniz? ");
                int choose= input.nextInt();
                banks.get(i-1).getCustomerList().get(j-1).getAccountList().get(choose-1);
                System.out.println("Birikim hesabına yükleyeceğiniz tutarı belirleyin");
                int money= input.nextInt();
                System.out.println("Kaç gün birikim yapacağınızı giriniz ");
                int day= input.nextInt();
                banks.get(i-1).getCustomerList().get(j-1).getAccountList().get(choose-1).saveUpMoney(money,day);
                welcome();

            }
            else if(a.equals("9")){
                System.out.println("Kredi çekmek istediğiniz bankayı seçiniz: ");
                bankalar();
                int bankChoose= input.nextInt();
                System.out.println("Bankanın müşterisi olup hesap açmalısınız");
                Customer fakeCustomer=new Customer();
                banks.get(bankChoose-1).addCustomer(fakeCustomer);
                System.out.println("Bu bankadaki kredi çekim miktarını öğrenmek için sanal bir vadeli hesap oluşturmalısınız. \n" +
                        "Bunun için 3 e basınız.");
                int createAcc= input.nextInt();
                InteresAccount fakeAcc= (InteresAccount) new Account("123","deposit",0,banks.get(bankChoose-1),fakeCustomer);
                System.out.println("Ana paranızı giriniz: ");
                int mainMoney= input.nextInt();
                System.out.println("Kredi tutarını giriniz:");
                int interest= input.nextInt();
                fakeAcc.borrowMoneyWithInterest(mainMoney,interest);


            }
        }
    }

    public static void welcome() {
        System.out.println("Ho�geldiniz! Ana ekran g�steriliyor\n " +
                "***********************************" + " \n " + "q -��k��" +
                "\n 1 -Banka olu�turma" + "\n 2-Müşteri oluşturma" + "\n 3-Hesap olu�turma" + "\n 4-Banka müşterilerini görüntüle" +
                "\n 5- Müşterilerin hesaplarını görüntüle" + "\n 6-Para Gönder" + "\n 7-Para çek" + "\n 8-Birikim Yap" + "\n 9-Kredi çek");
    }
    public static void bankalar() {
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + " = " + banks.get(i).getBankName());
        }
    }

}