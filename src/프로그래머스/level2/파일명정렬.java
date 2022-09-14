package 프로그래머스.level2;

// 입력 순서대로 정렬 해야하는 부분이 추가되어 정렬된 버젼(이게 맞는 버전)

import java.util.ArrayList;
import java.util.Arrays;

class file implements Comparable<file> {
    String head;
    String number;
    String tail;
    int index;

    public file(String head, String number, String tail, int index) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.index = index;
    }

    @Override
    public int compareTo(file o) {
        //파일명 같으면 숫자 수
        if(this.head.toLowerCase().trim().equals(o.head.toLowerCase().trim())){
            if (Long.parseLong(this.number) == Long.parseLong(o.number)) return this.index-o.index;
            return (int) (Long.parseLong(this.number) -Long.parseLong(o.number));
        }
        else
            return this.head.toLowerCase().trim().compareTo(o.head.toLowerCase().trim());

    }

    @Override
    public String toString() {
        return head + number +  tail;
    }

}
public class 파일명정렬 {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<file> arr = new ArrayList<>();

        for(String f : files){
            int tempH=0,tempT=0;
            for(int i=0;i<f.length();i++){
                char c = f.charAt(i);
                if('0'<= c && c<= '9'){
                    if(tempH==0) tempH=tempT=i;
                    else if( tempT==i-1 && tempT-tempH<4) tempT = i;
                }
            }
            String head = f.substring(0,tempH);
            String number= f.substring(tempH,tempT+1);
            String tail = (tempT+1==f.length())?"":f.substring(tempT+1);
            arr.add(new file(head,number,tail,arr.size()+1));
        }
        arr.sort(file::compareTo);
        for(int i=0;i<files.length;i++){
            answer[i] = arr.get(i).toString();
            System.out.println(answer[i]+ arr.get(i).index);
        }

        return answer;
    }

    public static void main(String args[]) {
        String[] a = {"img12.png", "MUZI01.zip","muzi1.png","i101", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(new 파일명정렬().solution(a)));
        String[] b = {"i1 ", "i2id","i22222","I02333"};
        System.out.println(Arrays.toString(new 파일명정렬().solution(b)));
        String[] c = {"O00321123", "img202.png123","O32111123O"};
        System.out.println(Arrays.toString(new 파일명정렬().solution(c)));
    }
}
