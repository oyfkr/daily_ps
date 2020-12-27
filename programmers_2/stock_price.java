package programmers_2;

import java.util.Arrays;

public class stock_price {
    public static void main(String args[]){
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution(prices)));
    }
    public static int[] solution(int[] prices){
        int[] answer = {};
        answer = new int[prices.length];
        int cnt = 0;
        for(int i = 0; i< prices.length; i++){
            for(int j = i+1; j< prices.length; j++){
                if(prices[i] > prices[j]){
                    cnt++;
                    break;
                }else{
                    cnt++;
                }
            }
            answer[i] = cnt;
            cnt = 0;
        }
        return answer;
    }
}
