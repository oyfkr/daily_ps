package programmers_2;

import java.util.Arrays;

public class repeat_binary {
    public static void main(String[] args) {
        String s = "1111111";
        repeat_binary a = new repeat_binary();
        System.out.println(Arrays.toString(a.solution(s)));
    }
    public int[] solution(String s){
        int []answer = new int[2];

        while(!s.equals("1")){
            answer[0]++;
            String tmp = s.replace("0","");
            int zeroCnt = s.length()-tmp.length();
            answer[1] += zeroCnt;
            s = Integer.toBinaryString(tmp.length());
        }
        return answer;
    }
}
