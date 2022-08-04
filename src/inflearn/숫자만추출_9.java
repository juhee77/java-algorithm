package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만추출_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cpy = br.readLine().toLowerCase().replaceAll("[^0-9]","");
        //String cpy2 = new StringBuffer(cpy).reverse().toString().toLowerCase().replaceAll("[^0-9]","");

        //System.out.println(cpy+  "   "+cpy2);
        //한글 숫자 영문 띄어쓰기 빼고(모든 특수문자 제거) String match = "[^\uAC00-\uD7A30-9a-zA-Z]";
        System.out.println(Integer.parseInt(cpy));
    }
}
