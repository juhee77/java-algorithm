package leetcode;

class NumberofStudentsUnabletoEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int sIndex = 0;
        boolean[] isAte = new boolean[students.length];
        int isAteCnt = 0;
        boolean isFinded = true;

        while (isFinded) {
            isFinded = false;
            for (int i = 0; i < students.length; i++) {
                if (!isAte[i] && students[i] == sandwiches[sIndex]) {
                    isAte[i] = true;
                    sIndex++;
                    isAteCnt++;
                    isFinded = true;
                    break;
                }
            }
        }
        return students.length - isAteCnt;
    }
}