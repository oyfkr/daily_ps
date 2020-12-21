package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Failure_rate {
    public static void main(String args[]){
        int n = 5;
        int[] stages = {1,2,2,1,3};;
        System.out.println(Arrays.toString(solution(n,stages)));
    }
    public static int[] solution(int n, int[] stages){
        int[] answer = {};
        ArrayList<Double> array = new ArrayList<Double>();
        answer = new int[n];
        int cnt = 0;
        int tmp = 0;
        int now = stages.length;
        for(int i = 1; i<=n;i++){
            for(int j = 0; j< stages.length;j++){
                if(stages[j] == i) cnt++;
            }
            if(cnt == 0){
                array.add(-1.0);
            }else{
            array.add((double)cnt/now);
            tmp++;
            now = now - cnt;

            cnt = 0;
            }

        }

        System.out.println(array);
        for(int i = 0; i<n;i++){

            answer[i] = array.indexOf(Collections.max(array))+1;
            array.set(array.indexOf(Collections.max(array)),-2.0);
        }

        return answer;
    }
}
