package 프로그래머스.level3;

import java.util.Arrays;
import java.util.HashMap;

public class level2 {
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        int answer = 0;
        double maxanswer = 0;
        double[][] arr = new double[pages.length][5]; //기본점수, 외부링크수,링크점수, 매칭점수,기본점수/외부링크수(계산용)
        HashMap<String, Integer> urlhash = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            String s = pages[i];
            //모든 url 저장
            int metaidx = s.indexOf("content");
            int headidx = s.indexOf("</head>");
            String url = s.substring(metaidx + 9, headidx);
            int co = url.indexOf("\"/>");
            url = url.substring(0, co);
            urlhash.put(url, i);
        }
        //System.out.println(Arrays.toString(urlhash.keySet().toArray()));

        for (int i = 0; i < pages.length; i++) {
            String s = pages[i];

            int bodyp = s.indexOf("<body>") + 6;
            int bodypde = s.indexOf("</body>");
            String body = s.substring(bodyp, bodypde).toLowerCase();


            int msgcnt = 0;

            //외부링크
            int cnt = 0;
            while (body.contains("<a")) {
                int pointatag = body.indexOf("<a");
                int pointa = body.indexOf("https:");
                int enda = body.indexOf("\">");

                String msg = body.substring(0, pointatag);
                //System.out.println(msg);

                String[] msgs = msg.split(" ");
                for (String value : msgs) {
                    if (value.contains(word)) {
                        System.out.println(value.substring(value.indexOf(word) + word.length()));
                        boolean f = value.substring(value.indexOf(word) + word.length()).contains(word);
                        if (!f) msgcnt++;
                    }
                }

                String turl = body.substring(pointa, enda);
                cnt++;
                //System.out.println(turl);
                int aend = body.indexOf("a>");

                body = body.substring(aend + 2);
            }

            String[] msgs = body.trim().split(" ");
            System.out.println(Arrays.toString(msgs));
            for (String msg : msgs) {
                if (msg.contains(word)) {
                    System.out.println(msg.substring(msg.indexOf(word) + word.length()));
                    boolean f = msg.substring(msg.indexOf(word) + word.length()).contains(word);
                    if (!f) msgcnt++;
                }
            }

            //기본점수
            arr[i][0] = msgcnt;
            //링크점수
            arr[i][1] = cnt;
            //System.out.println(msgcnt);
            //기본점수
            arr[i][4] = arr[i][0] / arr[i][1];
        }

        for (int i = 0; i < pages.length; i++) {
            String s = pages[i];
            int bodyp = s.indexOf("<body>") + 6;
            int bodypde = s.indexOf("</body>");
            String body = s.substring(bodyp, bodypde);

            //외부링크
            int cnt = 0;
            while (body.contains("<a")) {
                int pointa = body.indexOf("https:");
                int enda = body.indexOf("\">");

                String turl = body.substring(pointa, enda);
                if (urlhash.containsKey(turl)) {
                    int k = urlhash.get(turl);
                    arr[k][2] += arr[i][4];
                }
                int aend = body.indexOf("a>");
                body = body.substring(aend + 3);
            }
        }

        for (int i = 0; i < pages.length; i++) {
            arr[i][3] = arr[i][0] + arr[i][2];
            //System.out.println(i+" "+arr[i][3]);
            if (maxanswer < arr[i][3]) {
                maxanswer = arr[i][3];
                answer = i;
            }
            //System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " " + arr[i][3] + " " + arr[i][4]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new level2().solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}
        ));
        System.out.println(new level2().solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}
        ));
    }
}
