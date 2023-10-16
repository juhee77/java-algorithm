package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1431_시리얼번호 {
    private static class Isbn implements Comparable<Isbn> {
        private String isbn;

        @Override
        public int compareTo(Isbn o) {
            if (isbn.length() == o.isbn.length()) {
                int sum = this.getSum();
                int otherSum = o.getSum();

                if (sum == otherSum) {
                    return isbn.compareTo(o.isbn);
                }
                return sum - otherSum;
            }
            return isbn.length() - o.isbn.length();
        }

        private int getSum() {
            int thisSum = 0;
            for (char c : isbn.toCharArray()) {
                if (Character.isDigit(c)) {
                    thisSum += c - '0';
                }
            }
            return thisSum;
        }

        public Isbn(String isbn) {
            this.isbn = isbn;
        }

        public String getIsbn() {
            return isbn;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        List<Isbn> list = new ArrayList<>();
        while (tc-- > 0) {
            list.add(new Isbn(br.readLine()));
        }

        Collections.sort(list);
        for (Isbn isbn : list) {
            sb.append(isbn.getIsbn()).append("\n");
        }

        System.out.println(sb);
    }

}
