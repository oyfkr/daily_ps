package programmers;

import java.util.Arrays;

public class find_day_2016 {
    public static void main(String args[]) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a,b));
    }
    public static String solution(int a, int b){
        String answer = "";
        int sum = 0;
        sum = (a-1) * 30 +b;
        if(a == 2){
            sum = sum +a/2;
        }else if(a>2 && a<=7){
            if(a%2==0){
                sum = sum + a/2 - 1;
            }else{
                sum = sum + a/2 - 1;
            }
        }else{
            if(a%2==0){
                sum = sum + a/2 -1;
            }else{
                sum = sum + a/2;
            }
        }
        int day = sum % 7;
        if(day == 0){
            answer = "THU";
        }else if(day == 1){
            answer = "FRI";
        }else if(day == 2){
            answer = "SAT";
        }else if(day == 3){
            answer = "SUN";
        }else if(day == 4){
            answer = "MON";
        }else if(day == 5){
            answer = "TUE";
        }else if(day == 6){
            answer = "WED";
        }
        return answer;
    }


}
