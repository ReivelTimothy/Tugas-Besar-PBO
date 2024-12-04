package Models.classes;

import java.util.ArrayList;

public abstract class User {
    private int Id_User;
    private String name;
    private String password;
    private String NoTlp;
    private String email;
    private ArrayList<Transaction> listTiket = new ArrayList<>();
    // ada konfirmasi pemakaian tiket

    public User(int iD_karyawan, String name, String password, String noTlp, String email) {
        Id_User = iD_karyawan;
        this.name = name;
        this.password = password;
        NoTlp = noTlp;
        this.email = email;
    }

    public int getID_karyawan() {
        return Id_User;
    }

    public void setID_karyawan(int IdUser) {
        this.Id_User = IdUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoTlp() {
        return NoTlp;
    }

    public void setNoTlp(String noTlp) {
        NoTlp = noTlp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int id_User) {
        Id_User = id_User;
    }

    public ArrayList<Transaction> getListTiket() {
        return listTiket;
    }

    public void setListTiket(ArrayList<Transaction> listTiket) {
        this.listTiket = listTiket;
    }
    
}
