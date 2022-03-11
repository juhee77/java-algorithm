import java.lang.reflect.Array;
import java.util.*;

public class test {
    public static void main(String args[]){
        int x=5,y=0,z=0;
        y=x++;
        z=--x;
        System.out.println(x+","+y+","+z);
        int k=0;
        for(;k<10;k++){

        }
        int j=10;
        for(;0<j;j--){

        }
        System.out.println(j);
        System.out.println(k);
        System.out.println(new Date().getTime());

        /*문자열 치황*/
        String num="123456789";
        System.out.println("*".repeat(num.length()-4)+num.substring(num.length()-4));

        /*배열 뒤집기*/
        long n= 12345;
        //String[] numArr= Long.toString(n).split("");
        String[] numArr= Long.toString(n).split("");
        Collections.reverse(Arrays.asList(numArr));
        //String re=Arrays.toString(numArr);
        int[] re= Arrays.stream(numArr).mapToInt(Integer::parseInt).toArray();

        int[] noApi = new int[numArr.length];
        for(int i=0;i<numArr.length;i++){
            noApi[i] = Integer.parseInt(numArr[numArr.length-i-1]);
            noApi[numArr.length-i-1]=Integer.parseInt(numArr[i]);
        }

        for(int i=0;i<numArr.length;i++){
            String temp=numArr[i];
            numArr[i] = numArr[numArr.length-i-1];
            numArr[numArr.length-i-1]=temp;
        }
        int arr[] = {1,2,3,4};
        int cnt=0;
        int hold=-1;
        String ans="";
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!= hold) {
                hold =arr [i];
            }
        }
        System.out.println();Arrays.stream(ans.split("")).toArray();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");


    }
}
