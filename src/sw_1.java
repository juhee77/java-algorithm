import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_1
{
    public static int[][] check(int arr[][],int cpyarr[][],int i,int j,int k,int land){
        Queue<Point> queue=new LinkedList<Point>();
        queue.add(new Point(i,j));
        int size = arr.length;

        while(true){

            if(queue.size()==0)break;

            Point po=queue.poll();
            int p=po.x,q=po.y;
            if(arr[p][q]>k)cpyarr[p][q]=land;
            else continue;

            //up down left right
            if(p-1>0 && cpyarr[p-1][q] ==0 &&arr[p-1][q]>k)queue.add(new Point(p-1,q));
            if(p+1<size && cpyarr[p+1][q] ==0  && arr[p+1][q]>k)queue.add(new Point(p+1,q));
            if(q+1<size && cpyarr[p][q+1] ==0  && arr[p][q+1]>k)queue.add(new Point(p,q+1));
            if(q-1>0 && cpyarr[p][q-1] ==0 && arr[p][q-1]>k)queue.add(new Point(p,q-1));
        }

        /*
        System.out.println();
        System.out.println(k+ " #### "+land);
        for(int a=1;a<size;a++){
            for(int b=1;b<size;b++){
                System.out.print(cpyarr[a][b]+" ");
            }
            System.out.println();
        }
*/

        return cpyarr;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sz=Integer.parseInt(br.readLine());
            int arr[][]=new int[sz+1][sz+1];
            int max=0;


            for(int i=1;i<sz+1;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=1;j<sz+1;j++){
                        if(j==0)arr[i][j]=101;
                        else{
                            arr[i][j]=Integer.parseInt(st.nextToken());
                            if(max<arr[i][j]) max=arr[i][j];
                        }
                    }
            }

            int landMax=1;
            //시작 1 끝은 어차피 0
            for(int i=1;i<max;i++){
                int tempLand=0;
                int cpyarr[][]=new int[sz+1][sz+1];
                for(int p=1;p<sz+1;p++){
                    for(int q=1;q<sz+1;q++){
                        if(arr[p][q]<=i)continue;
                        if(arr[p][q]>i && cpyarr[p][q]!=0) continue;
                        else check(arr,cpyarr,p,q,i,++tempLand);
                    }
                }
                landMax=Math.max(landMax,tempLand);
            }

            sb.append("#"+test_case+" "+landMax+'\n');
        }
        System.out.println(sb);
    }
}


/*

int tempLand_2=0;
                for(int p=1;p<sz+1;p++){
                    for(int q=sz;0<q;q--){
                        if(arr[p][q]<=i)continue;
                        if(arr[p][q+1]<=i && arr[p+1][q]<=i)tempLand_2++;
                    }
                }
                int landMin=Math.min(tempLand_1,tempLand_2);

                tempLand_1=0;
                for(int p=sz;0<p;p--){
                    for(int q=1;q<sz+1;q++){
                        if(arr[p][q]<=i)continue;
                        if(arr[p][q-1]<=i && arr[p+1][q]<=i)tempLand_1++;
                    }
                }
                landMin=Math.min(tempLand_1,landMin);

                tempLand_2=0;
                for(int p=sz;0<p;p--){
                    for(int q=sz;0<q;q--){
                        if(arr[p][q]<=i)continue;
                        if(arr[p][q+1]<=i && arr[p+1][q]<=i)tempLand_2++;
                    }
                }
 */

/*
                int landMin=tempLand;
                for(int p=1;p<sz+1;p++){
                    for(int q=1;q<sz+1;q++){
                        if(arr[p][q]<=i)continue;
                        if(arr[p][q-1]<=i && arr[p+1][q]<=i)tempLand++;
                    }
                }
                landMin=Math.min(landMin,tempLand);
                for(int p=1;p<sz+1;p++){
                    for(int q=1;q<sz+1;q++){
                        if(arr[p][q]<=i)continue;
                        if(arr[p][q+1]<=i && arr[p-1][q]<=i)tempLand++;
                    }
                }
                landMin=Math.min(landMin,tempLand);
                for(int p=1;p<sz+1;p++){
                    for(int q=1;q<sz+1;q++){
                        if(arr[p][q]<=i)continue;
                        if(arr[p][q+1]<=i && arr[p+1][q]<=i)tempLand++;
                    }
                }
                landMin=Math.min(landMin,tempLand);

 */