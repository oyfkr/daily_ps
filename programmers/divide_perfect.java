package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class divide_perfect {
    public static void main(String args[]){
        int arr[] = {3,2,6};
        int div = 10;
        System.out.println(Arrays.toString(solution(arr,div)));
    }
    public static int[] solution(int[] arr, int div){
        int[] answer = {};
        ArrayList<Integer> arrays = new ArrayList<>();
        for(int i = 0; i<arr.length;i++){
            if(arr[i] % div ==0){
                arrays.add(arr[i]);
            }
        }
        answer = new int[arrays.size()];
        Collections.sort(arrays);
        for(int i = 0; i <arrays.size(); i++){
            answer[i] = arrays.get(i);
        }
        if(arrays.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}
