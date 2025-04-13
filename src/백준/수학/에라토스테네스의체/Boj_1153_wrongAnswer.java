package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_1153_wrongAnswer {
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        findPrimes(N);

        if (N % 2 == 0) {
            //짝수
            if (findDfs(N - 4, 2, new ArrayList<>(List.of(2, 2)))) {
                return;
            }
        } else if (N != 1) {
            //홀수 (하나는 짝수여야 한다 - 2가 포함)
            if (findDfs(N - 5, 2, new ArrayList<>(List.of(2, 3)))) {
                return;
            }
        }

        System.out.println("-1");
    }

    private static boolean findDfs(int n, int depth, List<Integer> path) {
        if (path.size() > 4)
            return false;

        if (depth == 0) {
            if (path.size() == 4 && n == 0) {
                for (Integer number : path) {
                    System.out.print(number + " ");
                }
                return true;
            }
            return false;
        }

        for (int i = upperBound(n); 0 <= i; i--) {
            path.add(primes.get(i));
            //찾음
            if (findDfs(n - primes.get(i), depth - 1, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }
        return false;
    }

    private static int upperBound(int n) {
        int start = 0;
        int end = primes.size() - 1;
        int upperBound = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (primes.get(mid) <= n) {
                start = mid + 1;
                upperBound = mid;
            } else {
                end = mid - 1;
            }
        }
        return upperBound;
    }

    private static void findPrimes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 1; i <= n; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    /**
     *
     *  public static void main(String[] args) throws IOException {
     *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     *         StringBuilder sb = new StringBuilder();
     *         StringTokenizer st;
     *
     *         int N = Integer.parseInt(br.readLine());
     *         findPrimes(N);
     *
     *         if (N % 2 == 0) {
     *             //짝수
     *             if (findDfs(N - 8, 0, new ArrayList<>(List.of(2, 2, 2, 2)))) {
     *                 return;
     *             } else if (findDfs(N - 2, 3, new ArrayList<>(List.of(2)))) {
     *                 return;
     *             } else if (findDfs(N, 4, new ArrayList<>())) {
     *                 return;
     *             }
     *         } else if (N != 1) {
     *             //홀수 (하나는 짝수여야 한다 - 2가 포함)
     *             if (findDfs(N - 6, 1, new ArrayList<>(List.of(2, 2, 2)))) {
     *                 return;
     *             } else if (findDfs(N - 2, 3, new ArrayList<>(List.of(2)))) {
     *                 return;
     *             }
     *         }
     *
     *         System.out.println("-1");
     *     }
     *
     *     private static boolean findDfs(int n, int depth, List<Integer> path) {
     * //        System.out.println(path);
     *         if (path.size() > 4)
     *             return false;
     *
     *         if (depth == 0) {
     *             if (path.size() == 4 && n == 0) {
     * //                System.out.println("HERE");
     *                 for (Integer number : path) {
     *                     System.out.print(number + " ");
     *                 }
     *                 return true;
     *             }
     *             return false;
     *         }
     *
     *         for (int i = upperBound(n); 0 <= i; i--) {
     *             path.add(primes.get(i));
     *             //찾음
     *             if (findDfs(n - primes.get(i), depth - 1, path)) {
     *                 return true;
     *             }
     *             path.remove(path.size() - 1);
     *         }
     *         return false;
     *     }
     *
     *     private static int upperBound(int n) {
     *         int start = 0;
     *         int end = primes.size() - 1;
     *         int upperBound = 0;
     *
     *         while (start <= end) {
     *             int mid = start + (end - start) / 2;
     *             if (primes.get(mid) <= n) {
     *                 start = mid + 1;
     *                 upperBound = mid;
     *             } else {
     *                 end = mid - 1;
     *             }
     *         }
     * //        System.out.println("UPPERBOUND "+n + " " + primes.get(upperBound));
     *         return upperBound;
     *     }
     *
     *     private static void findPrimes(int n) {
     *         boolean[] isNotPrime = new boolean[n + 1];
     *         isNotPrime[0] = isNotPrime[1] = true;
     *         for (int i = 1; i <= n; i++) {
     *             if (!isNotPrime[i]) {
     *                 primes.add(i);
     *                 for (int j = i; j <= n; j += i) {
     *                     isNotPrime[j] = true;
     *                 }
     *             }
     *         }
     * //        System.out.println(primes);
     *
     *     }
     */
}
