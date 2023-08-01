import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2863_이게분수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double c = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());

        double max = a / c + b / d;
        int maxRotation = 0;
        for (int i = 1; i <= 4; i++) {
            double temp = d;
            d = b;
            b = a;
            a = c;
            c = temp;

            double tempAns = a / c + b / d;
            if (max < tempAns) {
                maxRotation = i;
                max = tempAns;
            }
        }
        System.out.println(maxRotation);
    }
}
