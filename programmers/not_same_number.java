import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class not_same_number {
   public static void main(String args[]){
       int[] arr = {4,4,4,3,3};
       System.out.println(Arrays.toString(solution(arr)));
   }

   public static int[] solution(int []arr){
       int[] answer = {};
       ArrayList<Integer> temp = new ArrayList<Integer>();
       for(int i = 0; i < arr.length-1; i++){
          if(arr[i] == arr[i+1]){
              if(i == 0){
                  temp.add(arr[i]);
              }
          }else{
              if(i==0){
                  temp.add(arr[i]);
                  temp.add(arr[i+1]);
              }else{
                  temp.add(arr[i+1]);
              }
          }
       }
       answer = new int[temp.size()];
       for(int i = 0; i < temp.size(); i++){
           answer[i] = temp.get(i);
       }


       return answer;
   }

}
