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

    //more efficient
    public int countStudents2(int[] students, int[] sandwiches) {
        int zeroCnt = 0;
        int oneCnt;

        for (int student : students) {
            if (student == 0) {
                zeroCnt++;
            }
        }
        oneCnt = students.length - zeroCnt;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                zeroCnt--;
                if (zeroCnt < 0)
                    return sandwiches.length - i;
            } else {
                oneCnt--;
                if (oneCnt < 0)
                    return sandwiches.length - i;
            }
        }
        return 0;
    }
}