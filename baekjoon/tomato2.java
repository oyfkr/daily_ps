package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tomato2 {
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        Queue<Point> queue = new LinkedList<>();

        int[][][] arr = new int[h][n][m];
        boolean[][][] check = new boolean[h][n][m];

        for(int k = 0; k<h;k++){
            for(int i=0;i<n;i++){
                for(int j = 0; j<m;j++){
                    arr[k][i][j] = sc.nextInt();
                    if(arr[k][i][j] == 1){
                        queue.add(new Point(k,i,j));
                        check[k][i][j] = true;
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            Point t = queue.poll();
            int x = t.x;
            int y = t.y;
            int z = t.z;

            for(int i = 0; i<6;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx<h && ny < n && nz < m){
                    if(arr[nx][ny][nz] == 0 && !check[nx][ny][nz]){
                        queue.add(new Point(nx,ny,nz));
                        arr[nx][ny][nz] = arr[x][y][z] + 1;
                    }
                }
            }
        }
        int max = 0;

        for(int k = 0; k<h;k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m;j++){
                    if(arr[k][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                    if(max < arr[k][i][j]){
                        max = arr[k][i][j];
                    }
                }
            }
        }
        System.out.println(max-1);

    }
}
class Point{
    int x,y,z;

    public Point(int x,int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
