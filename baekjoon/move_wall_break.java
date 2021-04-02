package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class move_wall_break {
    static class Point{
        int x,y,distance;
        int drill;

        public Point(int x, int y, int distance,int drill){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.drill = drill;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int g,s;
    static int[][] map;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        map = new int[g][s];
        visit = new int[g][s];

        for(int i = 0; i<g;i++){
            String tmp = br.readLine();
            for(int j = 0; j<s;j++){
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        int ans = bfs(0,0);
        bw.write(ans+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y,1,0));
        visit[y][x] = 0;

        while(!q.isEmpty()){
            Point point = q.poll();

            if(point.y == g-1 && point.x == s-1){
                return point.distance;
            }
            for(int i = 0; i<4;i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx>=0 && ny>=0 && nx<s && ny<g){
                    if(visit[ny][nx] > point.drill){// 만약에 부시고 간 길이 먼저 탐색을 했더라도 안 부신 길이 오게되면 안 부신 길로 바뀌게 된다
                        if(map[ny][nx] == 0){
                            q.add(new Point(nx,ny, point.distance+1, point.drill));
                            visit[ny][nx] = point.drill;
                        }else{
                            if(point.drill == 0){
                                q.add(new Point(nx,ny, point.distance+1, point.drill+1));
                                visit[ny][nx] = point.drill + 1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
