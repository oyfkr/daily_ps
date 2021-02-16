package programmers_3;

import java.util.Arrays;
import java.util.Comparator;

public class control_camera {
    public static void main(String[] args) {
        int[][] route = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
        control_camera s = new control_camera();
        System.out.println(s.solution(route));
    }
    public int solution(int[][] route){
        int answer = 0;
        int start = 0;
        int end = 0;

        Arrays.sort(route, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        start = route[0][0];
        end = route[0][1];
        answer++;
        for(int i = 1; i< route.length;i++){
            if(start<= route[i][0] && end >= route[i][1]){
                start = route[i][0];
                end = route[i][1];
            }else if(end >= route[i][0] && end < route[i][1]){
                start = route[i][0];
            }else{
                start = route[i][0];
                end = route[i][1];
                answer++;
            }
        }

        return answer;
    }
}
