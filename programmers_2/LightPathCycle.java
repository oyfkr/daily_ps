package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LightPathCycle {
    public static void main(String[] args) {
        LightPathCycle l = new LightPathCycle();
        //System.out.println(l.solution(new String[]{"SL","LR"}));
        System.out.println(Arrays.toString(l.solution(new String[]{"SL", "LR"})));
    }

    static int R,C;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static boolean[][][] check;

    public int[] solution(String[] grid){
        ArrayList<Integer> answer = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();

        check = new boolean[R][C][4];
        for(int i = 0; i<R;i++){
            for(int j = 0;j<C;j++){
                for(int d = 0;d<4;d++){
                    if(!check[i][j][d]){
                        answer.add(light(grid,i,j,d));
                    }
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    public int light(String[] grid, int r, int c, int d){
        int cnt = 0;

        while(true){
            if(check[r][c][d]) break;

            cnt++;
            check[r][c][d] = true;

            if(grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d-1;
            else if(grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d+1;

            r = (r + dr[d] +R) %R;
            c = (c + dc[d] + C) % C;
        }

        //System.out.println(cnt);
        return cnt;
    }
}
