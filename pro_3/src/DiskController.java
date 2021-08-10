import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

    public static void main(String[] args) {
        DiskController d = new DiskController();
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(d.solution(jobs));
    }

    public int solution(int[][] jobs){
        int answer = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));

        int cnt = 0;
        int now = 0;
        int i = 0;
        while(cnt < jobs.length){
            while(i< jobs.length && jobs[i][0]<=now){
                queue.add(jobs[i++]);
            }

            if(queue.isEmpty()){
                now = jobs[i][0];
            }else{
                int[] tmp = queue.poll();
                answer += tmp[1] + now - tmp[0];
                now += tmp[1];
                cnt++;
            }
        }
        System.out.println(answer);

        return answer/ jobs.length;
    }
}
