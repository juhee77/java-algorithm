package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_특정문자뒵집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String cpy = br.readLine();
        StringBuffer buf = new StringBuffer(cpy).reverse();
        String cpy2 = buf.toString();


        for(int i=0;i<cpy.length();i++){
            if(cpy.substring(i,i+1).matches("^[a-zA-Z]*$"))// 만약 알파벳
                for(int j=0;j<buf.length();j++){
                    if(cpy2.substring(j,j+1).matches("^[a-zA-Z]*$")){
                        sb.append(cpy2.substring(j,j+1));
                        cpy2 = cpy2.substring(j+1);
                        break;
                    }
                }
            else
                sb.append(cpy.substring(i,i+1));
        }
        System.out.println(sb);
    }
}
