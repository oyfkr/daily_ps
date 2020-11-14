package programmers;

import java.util.Arrays;

public class k_number {
    public static void main(String args[]){
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands ={{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(solution(array,commands)));
    }
    public static int[] solution(int[] array, int[][] commands){

        int answer[] = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int fir = commands[i][0] - 1;
            int sec = commands[i][1] - 1;
            int target = commands[i][2] -1;
            int len = sec - fir + 1;
            int new_array[] = new int[len];
            int h = 0;

            for (int j = fir; j <= sec; j++) {
                new_array[h++] = array[j];
            }
            Arrays.sort(new_array);
            answer[i] = new_array[target];
        }
        return answer;
    }
}
