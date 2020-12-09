package programmers;

import java.util.ArrayList;
import java.util.List;

public class p_y_intostring {
    public static void main(String args[]){
        String s = "pPoooy";
        System.out.println(solution(s));
    }
    public static boolean solution(String s){
        boolean answer =true;
        int pcnt=0;
        int ycnt=0;
        String tmp = s.toLowerCase();

        for(int i = 0; i<tmp.length();i++){
            if(tmp.charAt(i) =='p'){
                pcnt++;
            }else if(tmp.charAt(i) == 'y'){
                ycnt++;
            };
        }
        if(pcnt == ycnt){
            answer = true;
        }else{answer = false;}
        return answer;
    }
}
