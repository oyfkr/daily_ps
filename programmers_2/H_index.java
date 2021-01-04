package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;

public class H_index {
    public static void main(String args[]){
        int[] citations = {3,0,6,1,5};
        H_index s = new H_index();
        System.out.println(s.solution(citations));
    }
    public int solution(int[] citations){
        int answer = 0;
        Arrays.sort(citations);
        ArrayList<Integer> array = new ArrayList<>();
        int max = citations[citations.length-1];
        for(int i = 0; i<=max; i++){
            int cnt = 0;
            for(int j = 0; j< citations.length; j++){
                if(citations[j] >= i){
                    cnt++;
                }
            }
            if(cnt >= i){
                array.add(i);
            }
        }
        System.out.println(array);
        answer = array.get(array.size()-1);
        return answer;
    }
}
