package inflearn.twopointerSlindingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
import java.util.*;
class Main {
	public int solution(int n, int k, int[] arr){
		int answer=0, cnt=0, lt=0;
		for(int rt=0; rt<n; rt++){
			if(arr[rt]==0) cnt++;
			while(cnt>k){
				if(arr[lt]==0) cnt--;
				lt++;
			}
			answer=Math.max(answer, rt-lt+1);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, k, arr));
	}
}

 */
public class F_최대길이연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
        System.out.println(solution2(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int left = 1, right = 1, nowK = 0;
        int maxLen = 0;
        int nowLen = 0;
        while (right <= n) {
            if (arr[right] == 1) {
                nowLen++;
            } else {
                if (nowK < k) {
                    nowK++;
                    nowLen++;
                } else {
                    //어차피 lt는 0임 (최악의 경우이기 때문)
                    int index = searchZeroIdx(left, right, arr);
                    nowLen -= Math.max(0, index - left);
                    left = index + 1;
                }
            }
            right++;
            maxLen = Math.max(nowLen, maxLen);
        }
        return maxLen;
    }

    private static int solution2(int n, int k, int[] arr) {
        int left = 1, right = 1, nowK = 0;
        int maxLen = 0;
        while (right <= n) {
            if (arr[right] == 0) {
                nowK++;
                while (nowK > k) {
                    if (arr[left] == 0) nowK--;
                    left++;
                }
            }

            right++;
            maxLen = Math.max(right - left, maxLen);
        }
        return maxLen;
    }

    private static int searchZeroIdx(int left, int right, int[] arr) {
        for (int i = left; i < right; i++) {
            if (arr[i] == 0)
                return i;
        }
        return -1;
    }
}
