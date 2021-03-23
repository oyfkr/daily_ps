package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class tomato {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n,m;
    static int[][] tomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tomato = new int[m][n];
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n;j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue_x = new LinkedList<Integer>();
        Queue<Integer> queue_y = new LinkedList<Integer>();

        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(tomato[i][j] == 1){
                    queue_x.add(i);
                    queue_y.add(j);
                }
            }
        }
        while(!queue_x.isEmpty()){
            int x = queue_x.poll();
            int y = queue_y.poll();

            for(int i = 0; i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny>=0 && nx<m && ny<n){
                    if(tomato[nx][ny]==0){
                        tomato[nx][ny] = tomato[x][y]+1;
                        queue_x.add(nx);
                        queue_y.add(ny);
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(tomato[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, tomato[i][j]);
            }
        }
        System.out.println(max-1);
    }
}
