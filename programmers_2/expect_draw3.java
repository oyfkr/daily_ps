package programmers_2;

public class expect_draw3 {
    public static void main(String[] args) {
        expect_draw3 s = new expect_draw3();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(s.solution(n,a,b));
    }
    public int solution(int n, int a, int b){
        int answer = 0;
        while(a != b){
            a = a % 2 == 1 ? (a = (a+1)/2) : (a = a/2);
            b = b % 2 == 1 ? (b = (b+1)/2) : (b = b/2);
            answer++;
        }
        return answer;
    }
}
