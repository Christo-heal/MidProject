package mid.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private ArrayList<pengguna> listPengguna;
    private Scanner scan;
    pengguna pgn;

    void loadData(){
        File dataFile = new File("pengguna.txt");

        if(!dataFile.exists()){
            return;
        }
        try (Scanner fileRead = new Scanner(dataFile)){
            while(fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                String[] arr = line.split(";");
                pengguna pgn = new pengguna(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]));
                listPengguna.add(pgn);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String usertemp;
    String passtemp;
    String uname,namaPjg,email,password;
    int wallet;


    public Main() {
        listPengguna = new ArrayList<>();
        scan = new Scanner(System.in);

        this.loadData();

        while (true) {
            System.out.print(
                    "Selamat datang di Program\n" +
                            "Silahkan pilih salah satu\n" +
                            "1. Login\n" +
                            "2. Register\n" +
                            "0. Keluar\n");
            System.out.print(">> ");
            int pil1 = scan.nextInt();

            switch (pil1) {
                case 1:
                    this.loginUser();
                    break;
                case 2:
                    this.registerUser();
                    File fileKu = new File("pengguna.txt");
                    try (FileWriter fw = new FileWriter(fileKu,true)){
                        wallet = 1000;
                        fw.write(uname+";"+namaPjg+";"+email+";"+password+";"+ wallet+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
            if(this.checkLoginUser() == 1){
                break;
            }
        }

        // program utama
        Scanner menuutama = new Scanner(System.in);
        System.out.println("Selamat datang diprogram");
        System.out.println(
                "1. Beli Produk\n"+
                "2. History Pembelian\n"+
                "3. Tambah Uang\n"+
                "4. Cek Uang\n"+
                "5. Logout\n"+
                "6. Exit\n");
        System.out.printf(">> ");
        int pil2 = menuutama.nextInt();
        switch (pil2) {
            case 1:

                break;

            case 2:

                break;

            case 3:
                Scanner money = new Scanner(System.in);
                System.out.println("Uang saat ini adalah : " + wallet + "\n");
                System.out.println("Masukan uang yang ingin ditambahkan\n");
                System.out.printf(">> ");
                int uangMasuk = money.nextInt();
                wallet += uangMasuk;

                this.saveData();

                System.out.println("Uang saat ini adalah : " + wallet + "\n");
                break;

            case 4:
                System.out.println("Uang saat ini adalah : " + wallet);
                break;

            case 5:

                break;

            case 6:

                break;

            default:
                System.out.println("Error! Enter correct operator");
        }

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
                    uname = tmp.uname;
                    password = tmp.password;
                    namaPjg = tmp.namaPjg;
                    email = tmp.email;
                    wallet = tmp.wallet;
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

    void saveData(){
        File dataFile = new File("pengguna.txt");
        try (FileWriter fileWrite = new FileWriter(dataFile);){
            for (pengguna pgn : listPengguna){
                fileWrite.write(pgn.getUname()+";"+pgn.getNamaPjg()+";"+pgn.getEmail()+";"+pgn.getPassword()+";"+pgn.getWallet()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
