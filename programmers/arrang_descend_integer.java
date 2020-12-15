package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class arrang_descend_integer {
    public static void main(String args[]){
        long n = 118372;
        System.out.println(solution(n));
    }
    public static long solution(long n){
        long answer = 0;
        int length = (int)(Math.log10(n)+1);
        Integer []array = new Integer[length];
        int i = 0;
        while(n>0){
            array[i] = (int)(n%10);
            n /= 10;
            i++;
        }
        Arrays.sort(array, Collections.reverseOrder());

        for(int j = 0; j < array.length; j++){
            answer += array[j] * Math.pow(10, array.length-j-1);
        }
        return answer;
    }
}
