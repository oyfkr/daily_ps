import java.util.PriorityQueue;

public class more_spicy {
    public static void main(String[] args) {
        more_spicy s = new more_spicy();
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(s.solution(scoville,k));
    }

    public int solution(int[] scoville,int k){
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.offer(i);
        }

        while(pq.peek()<k){
            if(pq.size()==0) return -1;
            int first = pq.poll();
            int second = pq.poll();

            int sco = first + second *2;

            pq.offer(sco);
            answer++;
        }
        return answer;
    }
}
