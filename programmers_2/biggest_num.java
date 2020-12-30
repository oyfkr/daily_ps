package programmers_2;

import java.util.*;

public class biggest_num {
    public static void main(String args[]){
        biggest_num s =new biggest_num();
        int[] numbers = {6,10,2};
        System.out.println(s.solution(numbers));
    }
    public String solution(int[] numbers){
        String answer ="";
        String str[] = new String[numbers.length];
        for(int i = 0; i< str.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            // 첫번째로 넘어온 파라미터가 더크면 양수리턴
            // 양수가 리턴되면 자리 바꿈
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(str[0].startsWith("0")){
            answer+="0";
        }else{
            for(int i = 0; i<str.length;i++){
                answer += str[i];
            }
        }
        return answer;
    }
}
