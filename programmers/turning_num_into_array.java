package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class turning_num_into_array {
    public static void main(String args[]){
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }
    public static int[] solution(long n){
        int[] answer = {};
        int length = (int)(Math.log10(n)+1);
        answer = new int[length];
        int i = 0;
        while(n>0){
            answer[i] = (int)(n % 10);
            n /=10;
            i++;
        }
        return answer;
    }
}
