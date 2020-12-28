package programmers_2;

import java.util.Arrays;

public class triangular_snail {
    public static void main(String args[]){
        int n = 5;
        System.out.println(Arrays.toString(solution(n)));
    }
    public static int[] solution(int n){
        int[] answer = new int[n*(n+1)/2];
        int[][] matrix = new int [n][n];

        int x = -1, y = 0;
        int num = 1;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                //세로로 가기
                if(i%3 == 0){
                    x++;
                //가로로 가기
                }else if(i % 3 == 1){
                    y++;
                //대각선으로 가기
                }else if(i % 3 == 2){
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        int k = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(matrix[i][j] == 0){
                    break;
                }
                answer[k++] = matrix[i][j];
            }
        }
        return answer;
    }
}
