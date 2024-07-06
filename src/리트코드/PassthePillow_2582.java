package 리트코드;

class PassthePillow_2582 {
    public int passThePillow(int n, int time) {
        int hold = time%(2*n-2);

        if(n<=hold){
            return n-(hold%(n-1));
        }else{
            return hold+1;
        }
    }
}