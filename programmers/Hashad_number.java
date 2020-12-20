package programmers;

public class Hashad_number {
    public static void main(String args[]){
        int x = 13;
        System.out.println(solution(x));
    }
    public static boolean solution(int x){
        boolean answer = true;
        int sum = 0;
        int tmp = x;
        while(x > 0){
            sum += x%10;
            x /= 10;
        }
        if(tmp % sum !=0){
            answer = false;
        }
        return answer;
    }
}
