package programmers_2;

import java.util.Arrays;

public class matrix_multi {
    public static void main(String[] args) {
        matrix_multi s = new matrix_multi();
        int[][] arr1 = {{1,4},{3,2},{4,2}};
        int[][] arr2 = {{3,3},{3,3}};
        System.out.println(Arrays.deepToString(s.solution(arr1,arr2)));
    }
    public int[][] solution(int[][] arr1,int[][] arr2){
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i< arr1.length;i++){
            for(int j = 0; j<arr2[0].length;j++){
                for(int h = 0; h<arr1[0].length;h++){
                    answer[i][j] += arr1[i][h] * arr2[h][j];
                }
            }
        }

        return answer;
    }
}
