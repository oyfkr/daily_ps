package programmers;

public class primeNumber {
    public static void main(String args[]){
        int  n = 10;
        System.out.println(solution(n));
    }
    public static int solution(int n){
        int answer = 0;
        for(int i = 2; i <= n; i++){
            boolean flag = true;
            for(int j = 2; j*j<=i; j++){
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }
}
