package 프로그래머스.level1;

public class Programmers_132267_콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int temp = n;
        while (a <= temp) {
            int hold = (temp / a) * b;
            answer += hold;
            temp = hold + temp % a;
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_132267_콜라문제 solution = new Programmers_132267_콜라문제();
        System.out.println(solution.solution(2,1,20));
    }
}
