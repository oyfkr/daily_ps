package programmers_2;

public class expect_draw2 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        expect_draw2 s = new expect_draw2();
        System.out.println(s.solution(n,a,b));
    }
    public int solution(int n,int a,int b){
        int answer = 1;
        while(true){
            if((a%2==1) && ((a+1)==b)){
                break;
            }
            if(a % 2 == 1){
                a = (a+1)/2;
            }else{
                a = a/2;
            }
            if(b % 2 == 1){
                b = (b+1)/2;
            }else{
                b = b/2;
            }
            n /= 2;
            answer++;
        }
        return answer;
    }
}
