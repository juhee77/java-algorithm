package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12901
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class usingDate {
    public String solution(int a, int b) throws ParseException {
        //return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);

        String answer = "2016-"+a/10+""+a%10+"-"+b/10+""+b%10;
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date date= dateFormat.parse(answer);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayN= cal.get(Calendar.DAY_OF_WEEK);

        switch (dayN){
            case 1:
                return "SUN";
            case 2:
                return "MON";
            case 3:
                return "TUE";
            case 4:
                return "WED";
            case 5:
                return "THU";
            case 6:
                return "FRI";
            default:
                return "SAT";
        }

    }
    public static void main(String args[]) throws ParseException {
        usingDate ex= new usingDate();
        System.out.println(ex.solution(5,24));
    }
}
