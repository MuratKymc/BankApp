import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    static ArrayList<Bank> banks = new ArrayList<>();
    public static void main(String[] args) {

        ArrayList<Bank> banks = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("Hoþgeldiniz! Ana ekran gösteriliyor\n " +
                "***********************************" +" \n " +"q -Çýkýþ" +
                "\n 1 -Banka oluþturma"+"\n 2-Müþteri oluþturma"+"\n 3-Hesap oluþturma"+"\n 4-Banka müþterilerini görüntüle" +
                "\n 5- Müþterilerin hesaplarý"+"\n 6-Para Gönder"+"\n 7-Para çek"+"\n 8-Para getir"+"\n 9-Birikim Yap"+"\n 10-Kredi Çek");

        while(true){

            String a = input.nextLine();

            if (a.equals("q")){
                System.out.println("Programdan çýkýlýyor...");
                break;
            } else if (a.equals("1")) {
                System.out.println("Bankanýzý seçiniz:");
                String isim = input.nextLine();
                System.out.println("Faiz oranýný seçiniz:");
                double IRate = input.nextDouble();
                System.out.println("Birikim oranýný seçiniz:");
                double accRate = input.nextDouble();

                banks.add(new Bank(isim,IRate,accRate));

            } else if(a.equals("2")){
                System.out.println("Müþteri adýný giriniz: ");
                String isim= input.nextLine();
                System.out.println("Müþteri soyadýný giriniz: ");
                String soyisim= input.nextLine();
                System.out.println("Müþteri TC kimlik numarasýný giriniz: ");
                String tcID= input.nextLine();
                System.out.println("Müþteri bankasýný seçiniz: ");
                bankalar();
                int i = input.nextInt();

                Customer firstCust= new Customer("Murat","Kuyumcu", "37867898763", banks.get(i-1));





            }


            System.out.println("Hoþgeldiniz! Ana ekran gösteriliyor\n " +
                    "***********************************" +" \n " +"q -Çýkýþ" +
                    "\n 1 -Banka oluþturma"+"\n 2-Müþteri oluþturma"+"\n 3-Hesap oluþturma"+"\n 4-Banka müþterilerini görüntüle" +
                    "\n 5- Müþterilerin hesaplarý"+"\n 6-Para Gönder"+"\n 7-Para çek"+"\n 8-Para getir"+"\n 9-Birikim Yap"+"\n 10-Kredi Çek");
        }
    }


    public static void bankalar(){
        for (int i  = 0;i < banks.size(); i++){
            System.out.println((i+1) + " = " + banks.get(i).getBankName());
        }
    }





}
