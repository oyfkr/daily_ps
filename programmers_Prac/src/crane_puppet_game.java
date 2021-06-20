import java.util.ArrayList;
import java.util.Arrays;

public class crane_puppet_game {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        crane_puppet_game s = new crane_puppet_game();
        System.out.println(s.solution(board,moves));
    }

    public int solution(int[][] board, int[] moves){
        int answer = 0;
        ArrayList<Integer> array = new ArrayList<>();
        for(int a : moves){
            for (int[] ints : board) {
                if (ints[a - 1] != 0) {
                    array.add(ints[a - 1]);
                    ints[a-1] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i<array.size()-1;i++){
            System.out.println(111);
            if(array.get(i) == array.get(i+1)){
                answer++;
                array.remove(i);
                array.remove(i);
                i = -1;
            }
        }
        return answer*2;
    }
}
