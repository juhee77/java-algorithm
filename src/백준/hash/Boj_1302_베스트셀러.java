package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj_1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> books = new HashMap<>();
        while (n-- > 0) {
            String bookName = br.readLine();
            Integer bookPieces = books.getOrDefault(bookName, 0) + 1;
            books.put(bookName, bookPieces);
        }

        int max = 0;
        String maxBookName = "!";
        for (String bookName : books.keySet()) {
            if (books.get(bookName) > max) {
                max = books.get(bookName);
                maxBookName = bookName;
            } else if (books.get(bookName) == max) {
                maxBookName = bookName.compareTo(maxBookName) < 0 ? bookName : maxBookName;
            }
        }
        System.out.println(maxBookName);
    }
}
