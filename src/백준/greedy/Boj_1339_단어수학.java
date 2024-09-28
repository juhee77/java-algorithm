package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1339_단어수학 {

    private static final int MAX_WORD_LENGTH = 8;
    private static final int ALPHABET_COUNT = 26;

    public static class WordChar implements Comparable<WordChar> {
        int number;
        long usedCnt;

        public WordChar(int number, long usedCnt) {
            this.number = number;
            this.usedCnt = usedCnt;
        }

        @Override
        public int compareTo(WordChar other) {
            return (other.usedCnt < usedCnt) ? -1 : ((other.usedCnt == usedCnt) ? 0 : 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] words = new char[n][MAX_WORD_LENGTH];
        int[][] save = new int[MAX_WORD_LENGTH][ALPHABET_COUNT];
        long[] digitSumByCharacter = new long[ALPHABET_COUNT];
        int[] numberSet = new int[ALPHABET_COUNT];

        for (int i1 = 0; i1 < n; i1++) {
            words[i1] = br.readLine().toCharArray();
            for (int j = 0; j < words[i1].length; j++) {
                int temp = MAX_WORD_LENGTH - words[i1].length + j;
                save[temp][words[i1][j] - 'A']++;
                digitSumByCharacter[words[i1][j] - 'A'] += (long) (Math.pow(10, words[i1].length - j));
            }
        }

        PriorityQueue<WordChar> sortedWordChars = new PriorityQueue<>();
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (digitSumByCharacter[i] > 0)
                sortedWordChars.add(new WordChar(i, digitSumByCharacter[i]));
        }

        int now = 9;
        while (!sortedWordChars.isEmpty()) {
            WordChar poll = sortedWordChars.poll();
            numberSet[poll.number] = now--;
        }

        long sum = calculateFinalSum(save, numberSet);
        System.out.println(sum);
    }

    private static long calculateFinalSum(int[][] save, int[] numberSet) {
        long sum = 0;
        for (int i = 0; i < MAX_WORD_LENGTH; i++) {
            sum *= 10;
            for (int j = 0; j < ALPHABET_COUNT; j++) {
                sum += save[i][j] * numberSet[j];
            }
        }
        return sum;
    }
}
