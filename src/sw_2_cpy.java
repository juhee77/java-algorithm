import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Student2 {
    public Student2(int id, int grade, char[] gender, int score) {
        this.id = id;
        this.grade = grade;
        this.gender = gender;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }


    public char[] getGender() {
        return gender;
    }

    public int getScore() {
        return score;
    }


    private int id;
    private int grade;
    private char[] gender;
    private int score;
}

class UserSolution2 {
    HashMap<Integer,Student> allStudent = new HashMap<Integer,Student>();
    HashSet<Integer> Student1_F = new HashSet<Integer>();
    HashSet<Integer> Student2_F = new HashSet<Integer>();
    HashSet<Integer> Student3_F = new HashSet<Integer>();

    HashSet<Integer> Student1_M = new HashSet<Integer>();
    HashSet<Integer> Student2_M = new HashSet<Integer>();
    HashSet<Integer> Student3_M = new HashSet<Integer>();

    public void init() {
        allStudent.clear();
        Student1_F.clear();
        Student2_F.clear();
        Student3_F.clear();
        Student1_M.clear();
        Student2_M.clear();
        Student3_M.clear();
        return;
    }



    public int addStudent(HashSet<Integer> hashSet){
        if(hashSet.isEmpty())return 0;
        else{
            int maxScore=0;
            int maxId =0;
            Iterator<Integer> iterator = hashSet.iterator();
            while(iterator.hasNext()){
                Student st = allStudent.get(iterator.next());

                if(st.getScore()>maxScore){
                    maxScore=st.getScore();
                    maxId=st.getId();
                }
                else if(st.getScore()==maxScore && st.getId()>maxId){
                    maxScore=st.getScore();
                    maxId=st.getId();
                }
            }
            //System.out.println(minId);
            return maxId;
        }
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        Student student = new Student(mId,mGrade,mGender,mScore);
        allStudent.put(mId,student);
        int id =0;
        String gender = String.valueOf(student.getGender());
        //System.out.println(gender);
        switch(mGrade){

            case 1:
                if(gender.equals("male\u0000\u0000\u0000")){
                    Student1_M.add(mId);
                    id = addStudent(Student1_M);
                }
                else {
                    Student1_F.add(mId);
                    id = addStudent(Student1_F);
                }
                break;
            case 2:
                if(gender.equals("male\u0000\u0000\u0000")) {
                    Student2_M.add(mId);
                    id = addStudent(Student2_M);
                }
                else {
                    Student2_F.add(mId);
                    id = addStudent(Student2_F);
                }
                break;
            case 3:
                if(gender.equals("male\u0000\u0000\u0000")) {
                    Student3_M.add(mId);
                    id = addStudent(Student3_M);
                }
                else {
                    Student3_F.add(mId);
                    id = addStudent(Student3_F);
                }
                break;

            default:
                break;
        }
        //System.out.println(scoreMaxId);
        return id;
    }

    public int findStudent(HashSet<Integer> hashSet){
        if(hashSet.isEmpty())return 0;
        else{
            int minScore=1000000000;
            int minId =1000000000;
            Iterator<Integer> iterator = hashSet.iterator();
            while(iterator.hasNext()){
                Student st = allStudent.get(iterator.next());
                if(st.getScore()<minScore){
                    minScore=st.getScore();
                    minId=st.getId();
                }
                else if(st.getScore()==minScore && st.getId()<minId){
                    minScore=st.getScore();
                    minId=st.getId();
                }
            }
            //System.out.println(minId);
            return minId;
        }
    }

    public int remove(int mId) {

        if(!allStudent.containsKey(mId))
            return 0;
        else{
            Student st = allStudent.get(mId);
            allStudent.remove(mId);
            int grade = st.getGrade();
            char [] cgender = st.getGender();
            String gender=String.valueOf(cgender);
            int id=0;
            switch(grade){

                case 1:
                    if(gender.equals("male\u0000\u0000\u0000")){
                        Student1_M.remove(mId);
                        id = findStudent(Student1_M);
                    }
                    else {
                        Student1_F.remove(mId);
                        id = findStudent(Student1_F);
                    }
                    break;
                case 2:
                    if(gender.equals("male\u0000\u0000\u0000")) {
                        Student2_M.remove(mId);
                        id = findStudent(Student2_M);
                    }
                    else {
                        Student2_F.remove(mId);
                        id = findStudent(Student2_F);
                    }
                    break;
                case 3:
                    if(gender.equals("male\u0000\u0000\u0000")) {
                        Student3_M.remove(mId);
                        id = findStudent(Student3_M);
                    }
                    else {
                        Student3_F.remove(mId);
                        id = findStudent(Student3_F);
                    }
                    break;

                default:
                    break;
            }
            return id;
        }
    }

    /*
        public int findStudentbyScore(HashSet<Integer> hashSet,int minScore,int minId,int mScore){
            if(hashSet.isEmpty())return minId;
            else{
                Iterator<Integer> iterator = hashSet.iterator();
                while(iterator.hasNext()){
                    Student st = allStudent.get(iterator.next());

                    if(mScore>st.getScore())  continue; //점수가 낮음경우

                    if(st.getScore()<minScore){
                        minScore=st.getScore();
                        minId=st.getId();
                    }
                    else if(st.getScore()==minScore && st.getId()<minId){
                        minScore=st.getScore();
                        minId=st.getId();
                    }
                }
              //System.out.println(minId);
                return minId;
            }

        }

    /*
        public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
            int minScore=1000000000;
            int minId=100000000;
            for(int i=0;i<mGradeCnt;i++){
                for(int j=0;j<mGenderCnt;j++){
                    int grade = mGrade[i];
                    String gender = String.valueOf(mGender[j]);
                    switch(grade){
                        case 1:
                            if(gender.equals("male\u0000\u0000\u0000")){
                                minId = findStudentbyScore(Student1_M,minScore,minId,mScore);
                            }
                            else {
                                minId = findStudentbyScore(Student1_F,minScore,minId,mScore);
                            }
                            break;
                        case 2:
                            if(gender.equals("male\u0000\u0000\u0000")) {
                                minId = findStudentbyScore(Student2_M,minScore,minId,mScore);
                            }
                            else {
                                minId = findStudentbyScore(Student2_F,minScore,minId,mScore);
                            }
                            break;
                        case 3:
                            if(gender.equals("male\u0000\u0000\u0000")) {
                                minId = findStudentbyScore(Student3_M,minScore,minId,mScore);
                            }
                            else {
                                minId = findStudentbyScore(Student3_F,minScore,minId,mScore);
                            }
                            break;

                        default:
                            break;

                    }
                    if(minId!=100000000 && minId!=0) minScore=allStudent.get(minId).getScore();
                }
            }
            if(minId==100000000) return 0;
            else return minId;
        }
     */
    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        int minScore=1000000000;
        int minId=100000000;
        HashSet<Integer> total = new HashSet<Integer>();
        for(int i=0;i<mGradeCnt;i++){
            for(int j=0;j<mGenderCnt;j++){
                int grade = mGrade[i];
                String gender = String.valueOf(mGender[j]);
                switch(grade){
                    case 1:
                        if(gender.equals("male\u0000\u0000\u0000")){
                            total.addAll(Student1_M);
                        }
                        else {
                            total.addAll(Student1_F);
                        }
                        break;
                    case 2:
                        if(gender.equals("male\u0000\u0000\u0000")) {
                            total.addAll(Student2_M);
                        }
                        else {
                            total.addAll(Student2_F);
                        }
                        break;
                    case 3:
                        if(gender.equals("male\u0000\u0000\u0000")) {
                            total.addAll(Student3_M);
                        }
                        else {
                            total.addAll(Student3_F);
                        }
                        break;

                    default:
                        break;

                }

            }
        }
        if(total.isEmpty()) return 0;
        else{
            Iterator<Integer> iterator = total.iterator();
            while(iterator.hasNext()){
                Student st = allStudent.get(iterator.next());

                if(mScore>st.getScore())  continue; //점수가 낮음경우

                if(st.getScore()<minScore){
                    minScore=st.getScore();
                    minId=st.getId();
                }
                else if(st.getScore()==minScore && st.getId()<minId){
                    minScore=st.getScore();
                    minId=st.getId();
                }
            }
            //System.out.println(minId);
        }
        if(minId==100000000) return 0;
        else return minId;
    }
}
