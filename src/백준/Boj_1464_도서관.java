package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1464_도서관 {
    private static int m;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        plus.add(0);
        minus.add(0);

        st = new StringTokenizer(br.readLine());
        int bookCnt = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bookCnt; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (book > 0) plus.add(book);
            else if (book < 0) minus.add(-book);
        }
        plus.sort(Collections.reverseOrder());
        minus.sort(Collections.reverseOrder());

        if (plus.get(0) < minus.get(0)) {
            //음수로 끝남
            find(plus, true);
            find(minus, false); //0으로 돌아오지 않아도 된다.
        } else {
            //양수로 끝남
            find(minus, true);
            find(plus, false); //0으로 돌아오지 않아도 된다.
        }
        System.out.println(cnt);
    }

    private static void find(List<Integer> books, boolean isFinZero) {
        if (books.isEmpty()) return;

        int hold = m;

        //0으로 돌아와야 하는 경우만
        if (isFinZero) cnt += books.get(0) * 2;
        else cnt += books.get(0);

        while (hold < books.size()) {
            cnt += (books.get(Math.min(hold, books.size() - 1))) * 2;
            hold += m;
        }
    }
}
