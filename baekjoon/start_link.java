package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class start_link {
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i = 1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for(int j = 1; j<n+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        com(1,0);
        System.out.println(min);
    }
    public static void com(int start, int depth){
        if(depth == n/2){
            min = Math.min(min,cal());
            return;
        }
        for(int i = start;i<n+1;i++){
            if(!visit[i]){
                visit[i] = true;
                com(i+1,depth+1);
                visit[i] = false;
            }
        }
    }

    private static int cal() {
        int start = 0;
        int link = 0;

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<n+1; j++){
                if(visit[i] && visit[j]){
                    start += map[i][j];
                }
                if(!visit[i] && !visit[j]){
                    link += map[i][j];
                }
            }
        }
        return Math.abs(start-link);
    }
}
