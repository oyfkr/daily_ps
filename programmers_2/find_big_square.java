package programmers_2;

import java.util.Map;

public class find_big_square {
    public static void main(String[] args) {
        int arr[][] = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0},{0,0,1,1},{1,1,1,1}};
        find_big_square s = new find_big_square();
        System.out.println(s.solution(arr));
    }
    public int solution(int[][] board){
        int answer = 0;
        int x = board.length;
        int y = board[0].length;
        int max = 0;
        if(x <= 1 || y <= 1){return 1;}
        for(int i = 1; i<x;i++){
            for(int j = 1; j<y; j++){
                if(board[i][j] == 1){
                    int left = board[i][j-1];
                    int top = board[i-1][j];
                    int lefttop = board[i-1][j-1];
                    int min = Math.min(left,top);
                    min = Math.min(min,lefttop);
                    board[i][j] = min+1;
                    max = Math.max(min+1,max);
                }
            }
        }
        answer = (int)Math.pow(max,2);
        return answer;
    }
}
