package paper.auth;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;

    public static final ArrayList<User> DATA_SAMPLE = new ArrayList<>();

    // Static block untuk data bawaan
    static {
        DATA_SAMPLE.add(new User("admin", "admin123", "admin@paper.com"));
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }

    // Register user
    public static User register(String username, String password, String email) {
        for (User u : DATA_SAMPLE) {
            if (u.getUsername().equalsIgnoreCase(username)) return null; // sudah ada
        }
        User user = new User(username, password, email);
        DATA_SAMPLE.add(user);
        return user;
    }

    // Authenticate user
    public static User authenticate(String username, String password) {
        for (User u : DATA_SAMPLE) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}