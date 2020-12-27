package programmers_2;

import java.util.LinkedList;
import java.util.Queue;

public class bridge_truck {
    public static void main(String args[]){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length,weight,truck_weights));
    }
    public static int solution(int bridge_length,int weight,int[] truck_weights){
        int answer = 0;
        int[] time = new int[truck_weights.length];
        int cnt = 0;
        Queue<Integer> bridge = new LinkedList<Integer>();
        while(true){
            if(!bridge.isEmpty() && time[bridge.peek()] == answer){
                weight +=truck_weights[bridge.poll()];
            }

            if(cnt < truck_weights.length && truck_weights[cnt] < weight){
                bridge.add(cnt);
                time[cnt] = answer + bridge_length;
                weight -= truck_weights[cnt];
                cnt++;
            }

            answer++;
            if (bridge.isEmpty()){
                break;
            }
        }

        return answer;
    }
}
