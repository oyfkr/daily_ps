package programmers_2;

public class next_big_number {
    public static void main(String[] args) {
        int n = 78;
        next_big_number s = new next_big_number();
        System.out.println(s.solution(n));
    }
    public int solution(int n){
        int bitcnt = Integer.bitCount(n);
        for(int i = n+1;;i++){
            int newbitcnt = Integer.bitCount(i);
            if(newbitcnt == bitcnt){
                return i;
            }
        }
    }
}
