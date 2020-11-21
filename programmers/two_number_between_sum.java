package programmers;

public class two_number_between_sum {
    public static void main(String args[]){
        int a = 5;
        int b = 3;
        System.out.println(solution(a,b));
    }
    public static int solution(int a, int b){
        int answer= 0;
        int tmp;
        if(a>b){
            tmp = a;
            a = b;
            b = tmp;
        }
        for(int i = a; i<=b;i++){
            answer = answer + i;
        }
        return answer;
    }
}
