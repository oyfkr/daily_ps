package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;

public class function_develope {
    public static void main(String args[]){
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        System.out.println(Arrays.toString(solution(progresses,speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds){
        int[] answer = {};
        int n = 1;
        int index = 0;
        int max = 0;
        int cnt = 0;
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        for(int i = 0; i< progresses.length;i++){
            while(progresses[i] < 100){
                progresses[i] = progresses[i] + speeds[i] * n;
                cnt++;
            }
            array.add(cnt);
            cnt = 0;
        }
        System.out.println(array);
        max = array.get(0);
        for(int i = 0; i< array.size();i++){
            if(max < array.get(i)) {
                index = array.indexOf(array.get(i));
                max = array.get(i);
                array1.add(index);
                for(int j = 0; j< index; j++){
                    array.remove(0);
                }
                i=0;
                if(array.size() == 1){
                    array1.add(array.size());
                }
            }
        }
        answer = new int[array1.size()];
        for(int i = 0; i< array1.size(); i++){
            answer[i] = array1.get(i);
        }
        return answer;
    }
}
