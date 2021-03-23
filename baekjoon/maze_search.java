package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class maze_search {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] maze;
    static boolean[][] check;
    static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        check = new boolean[n][m];

        for(int i = 0;i<n;i++){
            String tmp = sc.next();
            for(int j = 0;j<m;j++){
                maze[i][j] = tmp.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(maze[n-1][m-1]);
    }

    private static void bfs() {
        Queue<Integer> queue_x = new LinkedList<Integer>();
        Queue<Integer> queue_y = new LinkedList<Integer>();

        queue_x.offer(0);
        queue_y.offer(0);

        check[0][0] = true;

        while(!queue_x.isEmpty()){
            int x = queue_x.poll();
            int y = queue_y.poll();

            for(int i = 0; i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >=0 && ny >=0 && nx<n && ny < m){
                    if(maze[nx][ny] == 1 && !check[nx][ny]){
                        queue_x.offer(nx);
                        queue_y.offer(ny);

                        check[nx][ny] = true;

                        maze[nx][ny] = maze[x][y] + 1;
                    }
                }
            }
        }
    }
}
