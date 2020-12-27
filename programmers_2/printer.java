package programmers_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class printer {
    public static void main(String args[]){
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }
    public static int solution(int[] priorities, int location){
        int answer = 0;
        //우선순위 큐를 내림차순으로 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //offer을 이용해 우선순위 큐에 원소를 대입
        for(int priority : priorities){
            pq.offer(priority);
        }
        System.out.println(pq);
        //원소가 없을때까지 반복
        while(!pq.isEmpty()){
            //주어진 배열의 원소만큼 반복
            for(int i = 0; i< priorities.length;i++){
                //우선순위 큐에 맨 위에 있는 값이랑 주어진 배열의 i번째와 같은지 확인
                //같으면 큐에서 제거 후 answer증가
                //location과의 위치와 i가 같으면 그 값을 리턴
                //1,1,9,1,1,1
                if(pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    if(location == i){
                        pq.clear();
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
