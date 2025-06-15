package paper.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AppUtils {
    // Generate kode transaksi/order unik
    public static String generateKode(String prefix) {
        return prefix + System.currentTimeMillis();
    }

    // Format tanggal ke string (dd-MM-yyyy)
    public static String formatTanggal(Date date) {
        if (date == null) return "-";
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    // Generate random alphanumeric ID, length 6
    public static String generateRandomId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // Validasi input tidak kosong
    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
