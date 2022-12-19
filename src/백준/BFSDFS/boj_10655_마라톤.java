package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_10655_마라톤 {
    private static int size;
    private static final List<Point> allPoints = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            allPoints.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        //과거 방문점, 지금 방문할건지, 이전에 한번 건너간적이 있는지, 지금까지의 합
        dfs(0,1,false,0);

        System.out.println(min);
    }

    private static void dfs(int before, int nowVisit, boolean flag, int sum) {
        Point beforeP = allPoints.get(before);
        Point nowP = allPoints.get(nowVisit);
        if(nowVisit == size-1){
            System.out.println(sum);
            if(flag){
                min = Math.min(sum+beforeP.distance(nowP),min);
            }
            return;
        }

        if(flag){ // 이전에 한번 건너간적이 있음 (그냥 계산 하면된다)
            dfs(nowVisit,nowVisit+1, true,sum+nowP.distance(beforeP));
        }else{//이전에 한번 건너간적 없음 (이번에 건너 갈건지 아니면 계산하고 갈건지)
            //띄어 넘어감
            dfs(before,nowVisit+1,true,sum);
            //계산 한다.
            dfs(nowVisit,nowVisit+1,false,sum+nowP.distance(beforeP));

        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y);
        }
    }
}
