package programmers_2;

import java.util.Arrays;

public class TwoUnderDifBit {
    public static void main(String[] args) {
        long[] numbers = {2,7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    static Long temp;

    public static Long[] solution(long[] numbers){
        Long[] answer = new Long[numbers.length];

        for(int i = 0; i<numbers.length;i++){
            dfs(Long.toBinaryString(numbers[i]), numbers[i]+1);
            answer[i] = temp;
        }

        return answer;
    }

    public static void dfs(String num, Long tmp){
        String upTmp = Long.toBinaryString(tmp);
        while(true){
            if(upTmp.length() != num.length()){
                num = "0"+num;
            }else{
                break;
            }
        }
        int cnt = 0;
        for(int i = 0; i<num.length();i++){
            if(num.charAt(i) != upTmp.charAt(i)){
                cnt++;
            }
        }

        if(cnt<=2){
            temp = tmp;
            return;
        }

        dfs(num,tmp+1);
    }
}
