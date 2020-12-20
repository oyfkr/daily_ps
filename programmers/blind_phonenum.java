package programmers;

import java.util.Arrays;

public class blind_phonenum {
    public static void main(String args[]){
        String phone_number = "01033334444";
        System.out.println(solution(phone_number));
    }
    public static String solution(String phone_number){
        String answer = "";
        int cnt = 0;
        for(int i = 0; i<phone_number.length();i++){
            if(phone_number.length()-cnt <=4){
                answer +=phone_number.charAt(i);
            }else{
                answer += "*";
                cnt++;
            }
        }
        return answer;
    }
}
