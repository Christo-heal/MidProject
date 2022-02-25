package mid.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnotherMain {

    private ArrayList<pengguna> listPengguna;
    private Scanner scan;

    String usertemp;
    String passtemp;
    String uname, namaPjg, email, password;
    int wallet;
    int logout;
    int sm, ja, hl;
    String jaUk;
    int countID, max;
    int total, totalHarga;
    public AnotherMain() {
        listPengguna = new ArrayList<>();
        scan = new Scanner(System.in);

        while (true) {
            while (true) {
                System.out.print(
                        "Selamat datang di Program\n" +
                                "Silahkan pilih salah satu\n" +
                                "1. Login\n" +
                                "2. Register\n" +
                                "0. Keluar\n");
                System.out.print(">> ");
                int pil1 = scan.nextInt();
                int loginCode = 0;
                
                switch (pil1) {
                    case 1:
                        logout = 0;
                        this.loginUser();
                        loginCode = this.checkLoginUser();
                        break;
                    case 2:
                        this.registerUser();
                        break;
                    case 3:
                        this.checkUser();
                        break;
                    case 0:
                        System.exit(1);
                    default:
                        System.out.println("Error! Enter correct operator");
                        break;
                }
                if (loginCode == 1) {
                    break;
                }
            }

            // program utama
            while(true) {
                Scanner menuutama = new Scanner(System.in);
                System.out.println("Selamat datang diprogram");
                System.out.println(
                        "1. Beli Produk\n" +
                        "2. History Pembelian\n" +
                        "3. Tambah Uang\n" +
                        "4. Cek Uang\n" +
                        "5. Logout\n" +
                        "6. Exit");
                System.out.printf(">> ");

                int pil2 = menuutama.nextInt();
                max = 0;
                switch (pil2) {
                    case 1: //Beli produk
                        while (true) {
                            int keluar = 0;
                            this.menuDalam();
                            System.out.printf(">>");
                            Scanner produk = new Scanner(System.in);
                            int indx = produk.nextInt();
                            switch(indx){
                                case 1: //Pilih produk
                                    this.menuProduk();
                                    System.out.print(">>");
                                    int idx = produk.nextInt();
                                    switch(idx){
                                        case 1:
                                            System.out.println("Mau berapa?");
                                            System.out.print(">>");
                                            sm = produk.nextInt();
                                            break;

                                        case 2:
                                            ja =+ 1;
                                            System.out.println("Ukuran?");
                                            System.out.println(
                                                    "1. S\n"+
                                                    "2. M\n"+
                                                    "3. L\n"+
                                                    "4. XL"
                                            );
                                            System.out.printf(">> ");
                                            int jaU = produk.nextInt();

                                            if (jaU == 1){
                                                jaUk = "S";
                                            }
                                            else if (jaU == 2){
                                                jaUk = "M";
                                            }
                                            else if (jaU == 3){
                                                jaUk = "L";
                                            }
                                            else if (jaU == 4){
                                                jaUk = "XL";
                                            }
                                            else {
                                                System.out.println("Error! Enter correct operator");
                                            }
                                            break;

                                        case 3:
                                            hl =+ 1;
                                            break;

                                        case 0:
                                            keluar = 1;
                                            break;

                                    }
                                    if (keluar == 1){
                                        break;
                                    }
                                    break;

                                case 2: //Checkout
                                    countID++;
                                    max++;
                                    total = sm + ja + hl;
                                    totalHarga = sm*8800 + ja*187500 + hl*780000;

                                    this.strukBelanja();

                                    System.out.println("Bayar?? (tekan enter untuk melanjutkan)");
                                    scan.nextLine();

                                    if (totalHarga > wallet){
                                        System.out.println("Uang tidak mencukupi");
                                    }
                                    else{
                                        wallet -= totalHarga;
                                        sm=0;
                                        ja=0;
                                        hl=0;
                                        jaUk = null;
                                        System.out.println("Sudah dibayarkan");
                                    }
                                    break;

                                case 3: //Kembali
                                    keluar = 2;
                                    break;
                            }
                            if (keluar == 2){
                                break;
                            }
                        }
                        break;

                    case 2:
                        for(countID = 1;countID<=max+1;countID++){
                            this.strukBelanja();
                            System.out.println("\n"+"---------------------------------------------"+"\n");
                        }
                        break;

                    case 3:
                        Scanner money = new Scanner(System.in);
                        System.out.println("Uang saat ini adalah : " + wallet + "\n");
                        System.out.println("Masukan uang yang ingin ditambahkan\n");
                        System.out.printf(">> ");

                        int uangMasuk = money.nextInt();
                        wallet += uangMasuk;

                        System.out.println("Uang saat ini adalah : " + wallet + "\n");
                        break;

                    case 4:
                        System.out.println("Uang saat ini adalah : " + wallet);
                        break;

                    case 5:
                        logout = 1;
                        break;

                    case 6:
                        System.out.println("Program akan ditutup\n");
                        scan.nextLine();
                        System.exit(1);
                        break;

                    default:
                        System.out.println("Error! Enter correct operator");
                }
                if(logout == 1){
                    break;
                }
            }
        }
    }

        void menuProduk(){
            System.out.println(
                    "List produk\n"+
                    "1. Susu milo - Rp. 8800\n" +
                    "2. Jaket anime - Rp. 187500\n" +
                    "3. Headset Logitech G231 Prodigy - Rp. 780000\n"+
                    "0. Keluar"
            );
        }

        void menuDalam(){
            System.out.println(
                    "1. Pilih produk\n" +
                    "2. Checkout\n" +
                    "3. Kembali"
            );
        }

        void loginUser(){
            Scanner login = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Username : ");
            usertemp = login.nextLine();  // Read user input
            System.out.println("Password : ");
            passtemp = login.nextLine();  // Read user input
        }

        int checkLoginUser(){
            for (pengguna tmp : listPengguna) {
                if (usertemp.equals(tmp.uname)) {
                    if (passtemp.equals(tmp.password)) {
                        System.out.println("Berhasil login");
                        return 1;
                    }
                }
            }
            System.out.println(
                    "Username atau password salah\n" +
                            "Silahkan coba lagi");
            scan.nextLine();
            return 0;
        }

        void registerUser(){
            Scanner register = new Scanner(System.in);
            System.out.println("Username : ");
            uname = register.nextLine();
            System.out.println("Nama Panjang : ");
            namaPjg = register.nextLine();
            System.out.println("Email : ");
            email = register.nextLine();
            System.out.println("Password : ");
            password = register.nextLine();

            pengguna pgn;
            int wallet = 1000;
            pgn = new pengguna(uname, namaPjg, email, password, wallet);
            listPengguna.add(pgn);
            System.out.println("Anda sudah terdaftar!");
            scan.nextLine();
        }

        void checkUser(){
            if(listPengguna.isEmpty()){
                System.out.println("Data mahasiswa kosong");
            } else{
                int count = 0;
                for (pengguna tmp : listPengguna) {
                    count++;
                    System.out.println(count + "." + tmp.getUname() +"-" + tmp.getNamaPjg() +"-" + tmp.getEmail() +"-" + tmp.getPassword()+"-"+ tmp.getWallet());
                }
            }
            scan.nextLine();

        }

        void strukBelanja(){
            System.out.println(
                    "---------------------------------------------\n"+
                            "Padie shop\n"+
                            "---------------------------------------------\n"+
                            "id#"+countID+"\n\n"+
                            "1. Susu milo [F] - Rp 8800  " +sm +"x\n"+
                            "   - Expire date: 12 Des 2022\n"+
                            "2. Jaket anime [C] - Rp 187500  " +ja +"x\n"+
                            "   - Size:" + jaUk+"\n"+
                            "3. Headset Logitech [T] - Rp 780000\n"+
                            "   - Version: G231 Prodigy  "+ hl +"x\n"+
                            "---------------------------------------------\n"+
                            "Quantity  : "+ total +"\n"+
                            "Total price : Rp " + totalHarga +"\n"+
                            "---------------------------------------------\n"
            );
        }

        public static void main(String[] args) {
            new AnotherMain();
        }
}

