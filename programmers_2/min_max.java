package programmers_2;

import java.util.Arrays;

public class min_max {
    public static void main(String[] args) {
        min_max a = new min_max();
        String s = "-10 -2 -3 -4";
        System.out.println(a.solution(s));
    }

    public String solution(String s){
        String answer = "";
        String[] tmp = s.split(" ");
        int[] intarr = new int[tmp.length];
        for(int i = 0; i<tmp.length;i++){
                intarr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(intarr);
        answer = intarr[0] + " " + intarr[intarr.length-1];
        return answer;
    }
}
