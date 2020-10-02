import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class two_number_sum {
    public static void main(String args[]){
        int[] numbers = {5,0,2,7};
        System.out.println(Arrays.toString(solution(numbers)));
    }
    public static int[] solution(int[] numbers){
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<Integer>();
        answer = new int[temp.size()];
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j< numbers.length; j++){
                if(!temp.contains(numbers[i] + numbers[j])){
                    temp.add(numbers[i]+ numbers[j]);
                }
            }
        }
        answer = new int [temp.size()];
        for(int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
