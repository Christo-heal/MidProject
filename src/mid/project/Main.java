package mid.project;
import mid.project.pengguna;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private ArrayList<pengguna> listPengguna;
    private Scanner scan;
    String usertemp;
    String passtemp;

    public Main() {
        listPengguna = new ArrayList<>();
        scan = new Scanner(System.in);

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
                    this.checkLoginUser();
                    scan.nextLine();
                    break;
                case 2:
                    this.registerUser();
                    break;
                case 3:
                    this.checkUser();
                    break;
                case 0:

                    break;

                default:
                    System.out.println("Error! Enter correct operator");
            }
        }
    }

    void loginUser(){
        Scanner login = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Username : ");
        usertemp = login.nextLine();  // Read user input
        System.out.println("Password : ");
        passtemp = login.nextLine();  // Read user input
    }

    void checkLoginUser(){
        for (pengguna tmp : listPengguna) {
            if (usertemp.equals(tmp.uname)) {
                if (passtemp.equals(tmp.password)) {
                    System.out.println("Berhasil login");
                    return ;
                }
            }
        }
        System.out.println(
                "Username atau password salah\n" +
                "Silahkan coba lagi");
    }

    void registerUser(){
        Scanner register = new Scanner(System.in);
        System.out.println("Username : ");
        String uname = register.nextLine();
        System.out.println("Nama Panjang : ");
        String namaPjg = register.nextLine();
        System.out.println("Email : ");
        String email = register.nextLine();
        System.out.println("Password : ");
        String password = register.nextLine();

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

    public static void main(String[] args) {
        new Main();
    }
}
