import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    static ArrayList<Bank> banks = new ArrayList<>();
    public static void main(String[] args) {

        ArrayList<Bank> banks = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("Ho�geldiniz! Ana ekran g�steriliyor\n " +
                "***********************************" +" \n " +"q -��k��" +
                "\n 1 -Banka olu�turma"+"\n 2-M��teri olu�turma"+"\n 3-Hesap olu�turma"+"\n 4-Banka m��terilerini g�r�nt�le" +
                "\n 5- M��terilerin hesaplar�"+"\n 6-Para G�nder"+"\n 7-Para �ek"+"\n 8-Para getir"+"\n 9-Birikim Yap"+"\n 10-Kredi �ek");

        while(true){

            String a = input.nextLine();

            if (a.equals("q")){
                System.out.println("Programdan ��k�l�yor...");
                break;
            } else if (a.equals("1")) {
                System.out.println("Bankan�z� se�iniz:");
                String isim = input.nextLine();
                System.out.println("Faiz oran�n� se�iniz:");
                double IRate = input.nextDouble();
                System.out.println("Birikim oran�n� se�iniz:");
                double accRate = input.nextDouble();

                banks.add(new Bank(isim,IRate,accRate));

            } else if(a.equals("2")){
                System.out.println("M��teri ad�n� giriniz: ");
                String isim= input.nextLine();
                System.out.println("M��teri soyad�n� giriniz: ");
                String soyisim= input.nextLine();
                System.out.println("M��teri TC kimlik numaras�n� giriniz: ");
                String tcID= input.nextLine();
                System.out.println("M��teri bankas�n� se�iniz: ");
                bankalar();
                int i = input.nextInt();

                Customer firstCust= new Customer("Murat","Kuyumcu", "37867898763", banks.get(i-1));





            }


            System.out.println("Ho�geldiniz! Ana ekran g�steriliyor\n " +
                    "***********************************" +" \n " +"q -��k��" +
                    "\n 1 -Banka olu�turma"+"\n 2-M��teri olu�turma"+"\n 3-Hesap olu�turma"+"\n 4-Banka m��terilerini g�r�nt�le" +
                    "\n 5- M��terilerin hesaplar�"+"\n 6-Para G�nder"+"\n 7-Para �ek"+"\n 8-Para getir"+"\n 9-Birikim Yap"+"\n 10-Kredi �ek");
        }
    }


    public static void bankalar(){
        for (int i  = 0;i < banks.size(); i++){
            System.out.println((i+1) + " = " + banks.get(i).getBankName());
        }
    }





}
