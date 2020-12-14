package programmers;

public class factor_find {
    public static void main(String args[]){
        int n = 0;
        System.out.println(solution(n));
    }
    public static int solution(int n){
        int answer = 0;
        int sum = 0;
        for(int i = 1; i<=n; i++){
            if(n%i == 0){
                sum += i;
            }
        }
        answer = sum;
        return answer;
    }
}
