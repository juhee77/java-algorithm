package 백준.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_16934_게임닉네임 {
    private static Trie trie = new Trie();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            String now = br.readLine();
            if (!findAndInsert(now)) {
                if (!trie.search(now)) {
                    sb.append(now);
                    trie.insert(now);

                } else {
                    int hold = 2;
                    Trie.TrieNode trieNode = trie.searchTrie(now);
                    while (true) {
                        String word = String.valueOf(hold);
                        if (!trie.search(trieNode, word)) {
                            trie.insert(trieNode, word);
                            sb.append(now + hold);
                            break;
                        }
                        hold++;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean findAndInsert(String now) {
        for (int i = 1; i < now.length(); i++) {
            String temp = now.substring(0, i);
            if (!trie.startsWith(temp)) {
                trie.insert(now);
                sb.append(temp);
                return true;
            }
        }
        return false;
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

        public void insert(TrieNode trieNode, String word) {
            TrieNode current = trieNode;
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

        public boolean search(TrieNode trieNode, String word) {
            TrieNode current = trieNode;
            for (char c : word.toCharArray()) {
                current = current.children.get(c);
                if (current == null) {
                    return false; // 문자가 없으면 false
                }
            }
            return current.isEndOfWord; // 끝 노드 여부 반환(동일 단어가 있는지 반환)
        }


        public TrieNode searchTrie(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current = current.children.get(c);
                if (current == null) {
                    return null; // 문자가 없으면 false
                }
            }
            return current;// 끝 노드 여부 반환(동일 단어가 있는지 반환)
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
