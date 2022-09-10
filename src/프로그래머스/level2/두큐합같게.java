package 프로그래머스.level2;

public class 두큐합같게 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        int allLength= queue1.length+queue2.length;
        int allArr[] = new int[allLength];
        long total = 0;

        for(int i=0;i<allLength;i++){
            if(i<queue1.length) allArr[i] = queue1[i];
            else allArr[i] = queue2[i-queue1.length];
            total += allArr[i];
        }

        long temp=0;
        int p=0,q=0;
        while(p<allLength){
            if(temp==total/2) {
                int tempAnswer=Integer.MAX_VALUE;
                //걸쳐 있는경우(오늘쪽걸 모두 제거하는것과 왼쪽걸 모두 제거하는것 비교)
                if(q<=queue1.length && queue1.length<=p)
                    tempAnswer = q+p-queue1.length;
                //왼쪽에 있는경우
                else if(q<queue1.length && p<queue1.length)
                    tempAnswer = p+queue2.length+q;
                //오른쪽에 있는경우
                else if(q>queue1.length && p>queue1.length)
                    tempAnswer = (p-queue2.length)+q;

                answer = Math.min(answer,tempAnswer);
            }
            temp += allArr[p++];

            if(temp > total/2){
                while(temp>total/2)
                    temp-=allArr[q++];
            }

        }
        return (answer==Integer.MAX_VALUE)?-1:answer;
    }
    public static void main(String args[]){

        System.out.println(new 두큐합같게().solution(new int[]{3,2,7,2},new int[]{4,6,5,1}));
        System.out.println(new 두큐합같게().solution(new int[]{1,2,1,2},new int[]{1,10,1,2}));
        System.out.println(new 두큐합같게().solution(new int[]{1,2,10,2},new int[]{1,1,1,2}));
        System.out.println(new 두큐합같게().solution(new int[]{1,1},new int[]{1,5}));
        System.out.println(new 두큐합같게().solution(new int[]{2,14,2},new int[]{2,5,5,2}));


    }
}
