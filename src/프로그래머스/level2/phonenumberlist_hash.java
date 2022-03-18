package 프로그래머스.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/42577 -- 전화번호 목록

public class phonenumberlist_hash {
    public boolean solution(String[] phone_book) {
        /*
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()) return 1; //값을 바꿈
                else if ((o1.length()==o2.length())) return 0; // 값을 바꾸지 않음
                else return -1;
            }
        });
        */
        Arrays.sort(phone_book);

        //굳이 정렬 안하고 그냥 hashSet이용해서 다 넣어두고 서브스트링에서 있는지 확인하는 방법이 더 효율적일 수도
        // 내가 풀이한 방법은 19324,19와 같은경우 정렬이 안되어있어서 비교가 안되므로 정렬하려고 comparator을 사용
        // 그냥 hashset에 전부 넣어서 앞에서 부터 하나씩 비교하는 방법도 있음
        // 함수중에 startwith 이라는 함수도 있음
        // 아니 sort로 길이까지 비교가 된다 뭐한거지..
        HashMap<String,Integer> hash = new HashMap<>();
        for(String number : phone_book){
            if(hash.size()>=1)
                for(int i=1;i<number.length();i++){
                    if(hash.containsKey(number.substring(0,i))) return false;
                }
            hash.put(number,1);
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(new phonenumberlist_hash().solution(new String[] { "97674223", "1195524421","119"}));
    }
}

