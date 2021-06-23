import java.util.ArrayList;
import java.util.Arrays;

public class gym_suit {
    public static void main(String[] args) {
        gym_suit s = new gym_suit();
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        System.out.println(s.solution(n,lost,reserve));
    }

    public int solution(int n, int[] lost, int[] reserve){
        int answer = n;
        int[] all = new int[n];

        for(int a : lost){
            all[a-1]--;
        }

        for(int a : reserve){
            all[a-1]++;
        }

        for(int i = 0; i<all.length;i++){
            if(all[i] <0){
                if(i != all.length-1 && all[i+1] > 0){
                    all[i]++;
                    all[i+1]--;
                }else if(i != 0 && all[i-1]>0){
                    all[i]++;
                    all[i-1]--;
                }
            }
        }

        for(int i = 0; i< all.length;i++){
            if(all[i] <0){
                answer--;
            }
        }

        return answer;
    }
}
