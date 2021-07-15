import java.util.Locale;
import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {
        System.out.println("헬로");
        Scanner kb = new Scanner((System.in));
        String str = kb.next();
        System.out.println("str = " + str);
        str = str.toUpperCase();
        char t = kb.next().charAt(0);
        t = Character.toUpperCase(t);
    }
}
