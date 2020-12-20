package programmers;

import java.util.Arrays;

public class x_n_number {
    public static void main(String args[]){
        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(solution(x,n)));
    }
    public static long[] solution(int x,int n){
        long[] answer = {};
        answer = new long[n];
        int j = 1;
        for(int i = 0; i < n; i++){
            answer[i] = x * j;
            j++;
        }
        return answer;
    }
}
