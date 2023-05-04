package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_20920_영단어암기는괴로워 {
    private static class Word implements Comparable<Word> {
        String word;
        int cnt;


        @Override
        public int compareTo(Word o) {
            if (o.cnt == this.cnt) {
                if (o.word.length() == this.word.length()) {
                    return this.word.compareTo(o.word);
                }
                return o.word.length() - this.word.length();
            }
            return o.cnt - this.cnt;
        }

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int wordLength = Integer.parseInt(st.nextToken());

        HashMap<String, Word> hashMap = new HashMap<>();
        while (cnt-- > 0) {
            String s = br.readLine();
            if (s.length() >= wordLength) {
                Word nowWord = hashMap.getOrDefault(s, new Word(s, 0));
                nowWord.cnt++;
                hashMap.put(s, nowWord);
            }
        }

        ArrayList<Word> list = new ArrayList<>(hashMap.values());
        Collections.sort(list);
        for (Word word : list) {
            sb.append(word.word).append("\n");
        }
        System.out.println(sb);

    }
}
