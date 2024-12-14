package 백준.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_14426_접두사찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Trie trie = new Trie();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (n-- > 0) {
            trie.insert(br.readLine());
        }

        while (m-- > 0) {
            if (trie.startsWith(br.readLine()))
                cnt++;
        }
        System.out.println(cnt);
    }


    public static class Trie {
        // Trie 노드 클래스
        private static class TrieNode {
            HashMap<Character, TrieNode> children = new HashMap<>();
            boolean isEndOfWord = false; // 해당 노드가 단어의 끝인지 여부
        }

        private final TrieNode root;

        // 생성자
        public Trie() {
            root = new TrieNode();
        }

        // 단어 삽입
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current = current.children.computeIfAbsent(c, k -> new TrieNode());
            }
            current.isEndOfWord = true; // 단어의 끝 표시
        }

        // 단어 검색
        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current = current.children.get(c);
                if (current == null) {
                    return false; // 문자가 없으면 false
                }
            }
            return current.isEndOfWord; // 끝 노드 여부 반환(동일 단어가 있는지 반환)
        }

        // 접두사 검색
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                current = current.children.get(c);
                if (current == null) {
                    return false; // 접두사가 없으면 false
                }
            }
            return true; // 접두사로 끝나는 경로가 있으면 true
        }
    }

}
