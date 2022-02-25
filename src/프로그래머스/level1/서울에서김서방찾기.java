package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12919
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 서울에서김서방찾기 {
    public static String solution(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf("Kim");
        System.out.println(index);
        //리스트 상태라면
        List<String> list = new ArrayList<String>();
        list.add("kim");
        list.indexOf("kim"); //이렇게 검색가능 ("kim",3)으로 하면 3번째 뒤에것 부터 검색
        //String 배열이라면(정렬되어있어야 사용가능)
        Arrays.binarySearch(seoul,"Kim");
        //String 배열을 리스트 타입으로 변환하여 검색
        Arrays.asList(seoul).indexOf("kim");
        //boolean 타입으로 있는지 없는지 검사하는 방법
        seoul.toString().contains("kim");
        //일반 문자열 이라면
        String ex="kimorknd";
        ex.contains("kim");
        //matches를 활용하는 경우
        ex.matches(".*[a-zA-Z.*]"); //boolean 타입으로 영문자가 있는지검색
        ex.matches(".*특정문자열 검색.*");//특정 문자열 검색
        ex.matches(".*[0-9].*");//숫자 있는지 검색

        //binarSearch는 정렬되어있어야 사용가능
        return "김서방은 "+Arrays.binarySearch(seoul,"Kim")+"에 있다.";
    }
    public static void main(String args[]){
        String[] a={"Jane", "Kim"};
        System.out.println(solution(a));
    }
}

