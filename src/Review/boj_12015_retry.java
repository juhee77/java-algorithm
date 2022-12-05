package Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_12015_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sz = Integer.parseInt(br.readLine()) - 1;

        st = new StringTokenizer(br.readLine());
        //init
        List<Integer> maxLength = new ArrayList<>();
        maxLength.add(Integer.parseInt(st.nextToken()));
        int nowIdx = 0;
        while (sz-- > 0) {
            int now = Integer.parseInt(st.nextToken());
            if (maxLength.get(nowIdx) < now) {
                maxLength.add(now);
                nowIdx++;
            } else {
                //이분 탐색으로 해당 위치에 삽입
                int selectIdx = findIdx(now, maxLength);
                maxLength.set(selectIdx, now);
            }
            //System.out.println(maxLength);
        }
        System.out.println(maxLength.size());
        //System.out.println(maxLength);
    }

    private static int findIdx(int now, List<Integer> maxLength) {
        int start = 0, end = maxLength.size() - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (maxLength.get(mid) < now) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}

/*
6
10 20 10 30 20 50
 */
/*
10
10 50 30 70 20 50 60 80 70 25
 */