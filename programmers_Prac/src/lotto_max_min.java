import java.util.Arrays;

public class lotto_max_min {
    public static void main(String[] args) {
        lotto_max_min l = new lotto_max_min();
        int[] lottos = {44, 1, 0,0,31,25};
        int[] win_nums = {31,10,45,1,6,19};
        System.out.println(Arrays.toString(l.solution(lottos,win_nums)));
    }

    public int[] solution(int[] lottos,int[] win_nums) {
        int[] answer = {0,0};
        int zeroCnt = 0;

        Arrays.sort(lottos);
        for(int i : lottos){
            if(i != 0){
                break;
            }
            zeroCnt++;
        }

        Arrays.sort(win_nums);
        for(int i = 0; i<6;i++){
            for(int j = 0; j<6;j++){
                if(win_nums[i] == lottos[j]){
                    answer[0]++;
                    answer[1]++;
                }
            }
        }
        answer[0] += zeroCnt;

        for(int i = 0; i<2;i++){
            if(answer[i] == 6) answer[i] = 1;
            else if(answer[i] == 5) answer[i] = 2;
            else if(answer[i] == 4) answer[i] = 3;
            else if(answer[i] == 3) answer[i] = 4;
            else if(answer[i] == 2) answer[i] = 5;
            else answer[i] = 6;
        }
        return answer;
    }
}
