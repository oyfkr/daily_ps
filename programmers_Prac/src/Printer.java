import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        Printer s = new Printer();
        System.out.println(s.solution(priorities,location));
    }

    public int solution(int[] priorities,int location){
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities){
            pq.offer(i);
        }
        while(!pq.isEmpty()){
            for(int i = 0; i< priorities.length;i++) {
                if (pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    if(location == i){
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
