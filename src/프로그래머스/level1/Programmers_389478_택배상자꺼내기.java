package 프로그래머스.level1;

class Programmers_389478_택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int lastRow = (n - 1) / w; //  마지막 위치
        int lastIndex = (lastRow % 2 == 0) ? (n - 1) % w : (w - (n % w)) % w; // 마지막 인덱스

        int numRow = (num - 1) / w;
        int numIndex = (numRow % 2 == 0) ? (num - 1) % w : (w - (num % w)) % w;  // 현재 인덱스
        System.out.println("lastIndex:" + lastIndex + " numIndex:" + numIndex);

        int answer = lastRow - numRow;
        System.out.println(lastRow + " " + numRow + " " + answer);
        if (lastRow % 2 == 0) {
            //~lastIndex전까지 비워져있음
            if (lastIndex >= numIndex) answer++;
        } else {
            if (lastIndex <= numIndex) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스.level1.Programmers_389478_택배상자꺼내기 programmers389478_택배상자꺼내기 = new Programmers_389478_택배상자꺼내기();
        System.out.println(programmers389478_택배상자꺼내기.solution(13,12,7));
    }
}