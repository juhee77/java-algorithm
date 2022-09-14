package 프로그래머스.level2;
//틀린 버전 ( 입력 순서대로 정렬이 되지 않는다)  compare 시 return 0이 많으면런타임 에러가 발생함
import java.util.ArrayList;
import java.util.Arrays;


public class 파일명정렬2 {
    class file implements Comparable<file> {
        String head;
        String number;
        String tail;

        public file(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(file o) {
            //파일명 같으면 숫자 수
            if(this.head.toLowerCase().equals(o.head.toLowerCase())){
                if (Long.parseLong(this.number) == Long.parseLong(o.number)) return 1;
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
            arr.add(new file(head,number,tail));
        }
        arr.sort(file::compareTo);
        for(int i=0;i<files.length;i++){
            answer[i] = arr.get(i).toString();
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
