package programmers;
import java.util.Arrays;


public class base3_flip {
    public static void main(String args[]){
        int n = 45;

        System.out.println(solution(n));
    }
    public static int solution(int n){
        int answer = 0;
        String str = "";

        while(n > 0){
            str += n%3;
            n /= 3;
        }
        int j = 0;
        for(int i = str.length()-1; i>=0;i--){
            // -0 을 하는 이유 str.charAt(i)를 하면 아스키 코드가 나옴 거기에 0의 아스키 코드를 빼주는것
            answer += (str.charAt(i)-'0') * Math.pow(3,j);
            j++;
        }

        return answer;
    }
}
