package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class String_array_myself {
    public static void main(String args[]){
        String[] strings={"sun","bed","car"};
        int n = 1;
        System.out.println(Arrays.toString(solution(strings,n)));
    }
    public static String[] solution(String[] strings, int n){
        String[] answer = {};
        answer = new String[strings.length];
        for(int i = 0; i< strings.length; i++){
            //charAt을 이용하여 단어의 맨 앞에 필요로 하는 문자 배치
            strings[i] = strings[i].charAt(n) + strings[i];
        }
        //오름차순으로 정리
        Arrays.sort(strings);

        for(int i = 0; i < strings.length; i++){
            //substring을 이용하여 앞에 문자를 지운 단어를 answer에 대입
            answer[i] = strings[i].substring(1);
        }
        return answer;
    }
}
