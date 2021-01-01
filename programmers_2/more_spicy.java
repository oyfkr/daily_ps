package programmers_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class more_spicy {
    public static void main(String args[]){
        int[] scovile = {1,2,3,9,10,12};
        int k = 7;
        more_spicy s = new more_spicy();
        System.out.println(s.solution(scovile,k));
    }
    public int solution(int[] scoville, int k){
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int a : scoville){
            queue.offer(a);
        }
        while(queue.peek() <= k){
            if(queue.size() == 1){
                return -1;
            }
            int a = queue.poll();
            int b = queue.poll();

            int result = a + b *2;
            queue.offer(result);
            answer++;
        }
        return answer;
    }
}
