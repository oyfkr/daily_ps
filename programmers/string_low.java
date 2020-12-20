package programmers;

import java.util.Arrays;
import java.util.Collections;

public class string_low {
    public static void main(String args[]){
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }
    public static String solution(String s){
        String answer ="";
        Integer[] arr = new Integer[s.length()];
        for(int i = 0; i<s.length();i++){
            arr[i] = (int)s.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        //System.out.println(arr[1]);
        for(int i = 0; i< arr.length;i++){
            answer +=Character.toString(arr[i]);
        }
        return answer;
    }
}
