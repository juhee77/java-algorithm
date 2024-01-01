package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strArr = br.readLine().toCharArray();
        Stack<Character> rightS = new Stack<>();
        Stack<Character> leftS = new Stack<>();

        for(int i=0;i<strArr.length;i++) rightS.add(strArr[i]);

        int line = Integer.parseInt(br.readLine());

        for(int i=0;i<line;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd){
                case 'B':
                    if(!rightS.isEmpty())rightS.pop();
                    break;

                case 'L':
                    if(!rightS.isEmpty()) leftS.add(rightS.pop());
                    break;

                case 'P':
                    char add = st.nextToken().charAt(0);
                    rightS.add(add);
                    break;

                case 'D':
                    if(!leftS.isEmpty())
                        rightS.add(leftS.pop());
                    break;

                default:
                    break;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<rightS.size();i++){
            sb.append(rightS.get(i));
        }
        while(!leftS.isEmpty()) sb.append(leftS.pop());

        System.out.println( sb );


    }
}
