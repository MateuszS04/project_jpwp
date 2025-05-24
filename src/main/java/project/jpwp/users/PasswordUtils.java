package project.jpwp.users;
import java.security.MessageDigest;

public class PasswordUtils {
    public static String hashPassword(String password) {
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte[] hashbytes=md.digest(password.getBytes());
            StringBuilder sb=new StringBuilder();
            for(byte b:hashbytes){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Błąd haszowania hasła",e);
        }
    }
}
