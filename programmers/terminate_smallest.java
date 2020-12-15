package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class terminate_smallest {
    public static void main(String args[]){
        int arr[]= {4,3,2,1};
        System.out.println(Arrays.toString(solution(arr)));
    }
    public static int[] solution(int[] arr){
        int[] answer = {};
        if(arr.length == 1){
            answer = new int[1];
            answer[0]= -1;
            return answer;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for(int i = 0; i < arr.length;i++){
            tmp.add(arr[i]);
        }
        Arrays.sort(arr);
        for(int i = 0; i< tmp.size();i++){
            if(tmp.get(i) == arr[0]){
                tmp.remove(i);
            }
        }
        answer = new int[tmp.size()];
        for(int i = 0; i<tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}
