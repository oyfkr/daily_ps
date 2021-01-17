package programmers_2;

public class Fibo {
    public static void main(String[] args) {
        int n = 5;
        Fibo s = new Fibo();
        System.out.println(s.solution(n));
    }
    public int solution(int n){
        int answer = 0;
        int one = 1, two = 1;
        if(n == 1 || n == 2) return 1;

        for(int i = 3; i <=n;i++){
            answer = one + two;
            answer = answer % 1234567;
            one = two;
            two = answer;

        }

        return answer;
    }
}
