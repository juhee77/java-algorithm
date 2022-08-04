package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class 회문문자열_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cpy = br.readLine().toLowerCase();
        String cpy2 = new StringBuffer(cpy).reverse().toString().toLowerCase(Locale.ROOT);

        System.out.println((cpy.equals(cpy2)?"YES":"NO"));
    }
}
