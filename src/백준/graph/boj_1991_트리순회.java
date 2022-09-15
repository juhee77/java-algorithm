package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1991_트리순회 {
    private static HashMap<Character,char[]> hash = new HashMap<>();
    private static String preorder(char start){
        char left = hash.get(start)[0];
        char right = hash.get(start)[1];
        if(left=='.' && right=='.') return start+"";
        else if (right=='.')return start+ preorder(left);
        else if (left=='.')return start + preorder(right);
        else return start + preorder(left)+preorder(right);
    }

    private static String inorder(char start){
        char left = hash.get(start)[0];
        char right = hash.get(start)[1];
        if(left=='.' && right=='.') return start+"";
        else if (right=='.')return inorder(left)+start ;
        else if (left=='.')return start+inorder(right);
        else return  inorder(left)+start + inorder(right);
    }

    private static String postorder(char start){
        char left = hash.get(start)[0];
        char right = hash.get(start)[1];
        if(left=='.' && right=='.') return start+"";
        else if (right=='.')return postorder(left)+start;
        else if (left=='.')return postorder(right)+start;
        else return postorder(left)+postorder(right)+start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        for(int i=0;i<line;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char now = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            hash.put(now,new char[]{left,right});
        }
        StringBuilder sb = new StringBuilder();

        //전위순회
        sb.append(preorder('A')+"\n");
        //중위순회
        sb.append(inorder('A')+"\n");
        //후위순회
        sb.append(postorder('A')+"\n");
        System.out.println(sb);
    }
}
