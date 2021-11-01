package programmers_2;

import java.util.Arrays;

public class TwoUnderDifBit2 {
    public static void main(String[] args) {
        long[] numbers = {2,9};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static long[] solution(long[] numbers){
        long[] answer = new long[numbers.length];

        for(int i = 0; i<numbers.length;i++){
            if(numbers[i] % 2 == 0){ //짝수인 경우 +1만 해주면 됩니다.
                answer[i] = numbers[i]+1;
            }else{ // 홀수인 경우 1. 모든 값들이 1 2. 0포함 두 가지 경우로 나눠서 생각
                StringBuilder tmp = new StringBuilder();
                String binary = Long.toBinaryString(numbers[i]);

                // 0이 포함되지 않았을 때 , 두번째 자리에 0을 추가
                if(!binary.contains("0")){
                    tmp.append("10");
                    tmp.append(binary.substring(1).replace("0","1"));
                }else{ // 0이 포함됐을 때 마지막 0을 1로 바꿔주고 그 다음 1을 0으로 바꿔준다.
                    int lastIndex = binary.lastIndexOf("0");
                    int firstOneIndex = binary.indexOf("1",lastIndex);

                    // 마지막 0앞까지 자른 다음에 그 뒤에 1을 붙인다.
                    tmp.append(binary,0,lastIndex).append("1");

                    // 1뒤에 0을 붙인다. => 마지막 0은 1이되었고 1은 0이 된다.
                    tmp.append("0");

                    // 마지막 1이었던 자리 이후의 값들을 붙인다.
                    tmp.append(binary.substring(firstOneIndex+1));
                }
                answer[i] = Long.parseLong(tmp.toString(),2);
            }
        }
        return answer;
    }
}
