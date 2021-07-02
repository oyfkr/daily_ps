import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class develope_feature {
    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        develope_feature s = new develope_feature();
        System.out.println(Arrays.toString(s.solution(progresses, speeds)));
    }
    public int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i<speeds.length;i++){
            if((100-progresses[i]) % speeds[i] == 0){
                queue.add((100-progresses[i])/ speeds[i]);
            }else {
                queue.add((100-progresses[i])/speeds[i] + 1);
            }
        }
        int pre = queue.poll();
        int num = 1;


        while (!queue.isEmpty()){
            int now = queue.poll();
            if(now <= pre){
                num++;
            }else{
                arrayList.add(num);
                num = 1;
                pre = now;
            }
        }
        arrayList.add(num);
        int[] answer = new int[arrayList.size()];
        for(int i = 0; i<arrayList.size();i++){
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}
