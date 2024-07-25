package leetcode;

class ZigzagConversion_6 {
    //이거 사실 모듈러로 해서 풀 수도 있음
    public String convert(String s, int numRows) {
        char[][] arr = new char[numRows][s.length()];
        
        int index = 0;
        int col = 0;
        while (index < s.length()) {
            //일단 세로로 한줄 
            for (int i = 0; i < numRows && index<s.length(); i++) {
                arr[i][col] = s.charAt(index++);
            }
            col++;

            for (int i = numRows - 2; 0<i && index < s.length(); i--) {
                arr[i][col++] = s.charAt(index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows ;i++) {
            //System.out.println(Arrays.toString(arr[i]));
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]!= 0) sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }
}