package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class apart_num {
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};
    public static int[] aparts = new int[25*25];
    public static int n;
    public static int apartNum = 0;
    public static boolean[][] visit = new boolean[25][25];
    public static int[][] map = new int[25][25];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        
        map = new int[n][n];
        visit = new boolean[n][n];
        
        for(int i = 0; i<n;i++){
            String input = scan.next();
            for(int j = 0; j<n;j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    apartNum++;
                    dfs(i,j);
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(apartNum);
        for(int i = 0; i<aparts.length;i++){
            if(aparts[i] == 0){
            }else{
                System.out.println(aparts[i]);
            }
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        aparts[apartNum]++;

        for(int i = 0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny <n){
                if(map[nx][ny] == 1 && !visit[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}
