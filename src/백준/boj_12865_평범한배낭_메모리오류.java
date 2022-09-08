package 백준;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12865_평범한배낭_메모리오류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int line = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,goal)); // x: 현재가중치, y: 남은 무게
        for(int ele=0;ele<line;ele++ ){
            st= new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int intialQueSize = queue.size();
            for(int i=0;i<intialQueSize;i++){
                Point temp = queue.poll();
                if(temp.y<weight) queue.add(temp); //더이상 무게를 실을수 없으면 그냥 지나감
                else {
                    queue.add(temp); //이 물건을 싣거나 안싣거나
                    queue.add(new Point(value+temp.x,temp.y-weight));
                }
            }
        }
        int max =0;
        while(!queue.isEmpty()){
            max = Math.max(queue.poll().x,max);
        }
        System.out.println(max);
    }
}
