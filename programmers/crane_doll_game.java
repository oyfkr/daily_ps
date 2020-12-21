package programmers;

import java.util.ArrayList;

public class crane_doll_game {
    public static void main(String args[]){
        int[][] board ={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] move = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,move));
    }
    public static int solution(int[][] board, int[] moves){
        int answer = 0;
        int tmp=0;
        ArrayList<Integer> array = new ArrayList();
        array.add(-1);
        for(int i = 0; i< moves.length;i++){
            for(int j = 0; j< board.length;j++){
                tmp = board[j][moves[i]-1];
                if(tmp == 0){
                    continue;
                }else{
                    if(array.get(array.size()-1)==tmp){
                        answer++;
                        array.remove(array.size()-1);
                        board[j][moves[i]-1] = 0;
                        break;
                    }else{
                        array.add(tmp);
                        board[j][moves[i]-1] = 0;
                        break;
                    }

                }
            }
        }
        return answer*2;
    }
}
