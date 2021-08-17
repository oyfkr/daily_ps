import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ShuttleBus {
    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10","09:09","08:00"};
        ShuttleBus s = new ShuttleBus();
        System.out.println(s.solution(n,t,m,timetable));
    }

    public String solution(int n, int t, int m, String[] timetable){
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable){
            int hh = Integer.parseInt(time.split(":")[0]);
            int mm = Integer.parseInt(time.split(":")[1]);

            int fin = hh * 60 + mm;
            pq.add(fin);
        }

        int depart = 9*60;
        List[] list = new List[n];

        for(int i = 0; i<n;i++){
            list[i] = new ArrayList();
            while (!pq.isEmpty()){
                int tmp = pq.poll();
                if(tmp <= depart && list[i].size()<m){
                    list[i].add(tmp);
                    answer = tmp-1;
                }else{
                    pq.add(tmp);
                    break;
                }
            }
            depart += t;
        }

        if(list[n-1].size()<m){
            answer = depart-t;
        }

        String hh = String.format("%02d",answer/60);
        String mm = String.format("%02d",answer%60);

        return hh+":"+mm;
    }
}
