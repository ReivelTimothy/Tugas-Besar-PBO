package Controller;

public class LoginSingleton {
    private static LoginSingleton instance;
    private int userID;
    private int roleID;// 0=customer, 1=seller, 2=admin, 3=antonJonatan

    public static LoginSingleton getInstance() {
        if (instance == null) {
            synchronized (LoginSingleton.class) {
                if (instance == null) {
                    instance = new LoginSingleton();
                }
            }
        }
        return instance;
    }

    public void setUser(int id, int role) {
        this.userID = id;
        this.roleID = role;
    }

    public int getID() {
        return userID;
    }

    public int getRole() {
        return roleID;
    }
}