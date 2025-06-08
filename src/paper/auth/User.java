package paper.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private String userId;
    private String username;
    private int passwordHash; // Simpan hash int, bukan string hash bcrypt
    private String email;
    private boolean isLoggedIn;

    // Simulasi database user
    private static final Map<String, User> usersDb = new HashMap<>();

    public User(String userId, String username, int passwordHash, String email) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.isLoggedIn = false;
        usersDb.put(username, this);
        System.out.println("[User] User '" + username + "' created (ID: " + userId + ").");
    }

    public static User register(String username, String plainPassword, String email) {
        if (usersDb.containsKey(username)) {
            System.out.println("[User] Registrasi gagal: Username '" + username + "' sudah ada.");
            return null;
        }
        if (plainPassword == null || plainPassword.isEmpty()) {
            System.out.println("[User] Registrasi gagal: Password tidak boleh kosong.");
            return null;
        }

        String newUserId = UUID.randomUUID().toString();
        int hashedPassword = hashPassword(plainPassword);
        System.out.println("[User] User '" + username + "' berhasil didaftarkan.");
        return new User(newUserId, username, hashedPassword, email);
    }

    public static User authenticate(String username, String plainPassword) {
        User user = usersDb.get(username);
        if (user == null) {
            System.out.println("[User] Otentikasi gagal: User '" + username + "' tidak ditemukan.");
            return null;
        }

        if (user.verifyPassword(plainPassword)) {
            user.setLoggedIn(true);
            System.out.println("[User] User '" + username + "' berhasil login.");
            return user;
        } else {
            System.out.println("[User] Otentikasi gagal: Password salah untuk user '" + username + "'.");
            return null;
        }
    }

    public boolean changePassword(String oldPlainPassword, String newPlainPassword) {
        if (!verifyPassword(oldPlainPassword)) {
            System.out.println("[User] Gagal mengubah password: Password lama salah.");
            return false;
        }
        if (newPlainPassword == null || newPlainPassword.isEmpty()) {
            System.out.println("[User] Gagal mengubah password: Password baru tidak boleh kosong.");
            return false;
        }
        this.passwordHash = hashPassword(newPlainPassword);
        System.out.println("[User] Password untuk user '" + this.username + "' berhasil diubah.");
        return true;
    }

    private static int hashPassword(String plainPassword) {
        return plainPassword.hashCode();
    }

    private boolean verifyPassword(String plainPassword) {
        return this.passwordHash == hashPassword(plainPassword);
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void logout() {
        this.isLoggedIn = false;
        System.out.println("[User] User '" + this.username + "' berhasil logout.");
    }

    // Static block untuk membuat akun default admin
    static {
        register("admin", "admin123", "admin@gmail.com");
    }
}