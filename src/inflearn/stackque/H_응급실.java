package inflearn.stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_응급실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        PriorityQueue<Patient> pq = new PriorityQueue<>();
        Queue<Patient> q = new LinkedList<>();

        int turn = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(new Patient(i, arr[i]));
            q.offer(new Patient(i, arr[i]));
        }

        while (true) {
            while (pq.peek().pain > q.peek().pain) {
                q.offer(q.poll());
            }
            turn++;
            if (q.peek().idx == m) break;
            q.poll();
            pq.poll();
        }
        return turn;
    }

    public static int solution2(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }
        while (!Q.isEmpty()) {
            Person tmp = Q.poll(); //만약 우선순위가 가장 높은게 맞다면 삭제된다.
            for (Person x : Q) {
                if (x.priority > tmp.priority) { //우선순위가 더 높은것이 있다면 멈추고 멈춘다.
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) return answer;
            }
        }
        return answer;
    }


    private static class Patient implements Comparable<Patient> {
        int idx;
        int pain;

        public Patient(int idx, int pain) {
            this.idx = idx;
            this.pain = pain;
        }

        @Override
        public int compareTo(Patient o) {
            return o.pain - this.pain;
        }
    }


    private static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}
