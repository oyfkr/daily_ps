import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bridge_on_truck {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        bridge_on_truck b = new bridge_on_truck();
        System.out.println(b.solution(bridge_length,weight,truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        int weightMax = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(i);
                    answer++;
                    weightMax += i;
                    break;
                }else if(q.size() == bridge_length){
                    weightMax -=  q.poll();
                }else{
                    if(weightMax + i > weight){
                        q.add(0);
                        answer++;
                    }else{
                        q.add(i);
                        answer++;
                        weightMax += i;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
