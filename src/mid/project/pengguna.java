package mid.project;

public class pengguna {
    private String uname;
    private String namaPjg;
    private String email;
    private String password;
    private int wallet;

    public pengguna(String uname, String namaPjg, String email, String password, int wallet) {
        this.uname = uname;
        this.namaPjg = namaPjg;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
    }

    public pengguna(String uname, String namaPjg, String email, String password) {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getNamaPjg() {
        return namaPjg;
    }

    public void setNamaPjg(String namaPjg) {
        this.namaPjg = namaPjg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}
