package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class make_bridge2 {
    static class dot{
        int x;
        int y;
        public dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class edge implements Comparable<edge>{
        int s,e,v;
        public edge(int s,int e,int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
        @Override
        public int compareTo(edge o) {
            return o.v>=this.v?-1:1;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n,m;
    static int[][] map;
    static boolean[][] visit;
    static int cnt = 0;
    static int[] parents;
    static int bridge_cnt = 0;
    static PriorityQueue<edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i<n;i++){
            str = br.readLine().split(" ");
            for(int j = 0; j<m;j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if (map[i][j] == 1 && !visit[i][j]){
                    cnt++;
                    bfs(new dot(i,j));
                }
            }
        }

        visit = new boolean[n][m];

        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(map[i][j] != 0){
                    makeBridge(new dot(i,j),map[i][j]);
                }
            }
        }
        parents = new int[cnt+1];

        for(int i = 0; i<parents.length;i++){
            parents[i] = i;
        }

        int size = pq.size();
        int result = 0;
        for(int i = 0; i<size;i++){
            edge tmp = pq.poll();

            int a = find(tmp.s);
            int b = find(tmp.e);

            if(a == b) continue;

            union(tmp.s,tmp.e);
            result += tmp.v;
            bridge_cnt++;
        }
        if(result == 0 || bridge_cnt !=cnt-1){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    private static void makeBridge(dot dot, int num) {
        int nx = dot.x;
        int ny = dot.y;
        int length = 0;

        for(int i = 0; i<4;i++){
            while(true){
                nx = nx + dx[i];
                ny = ny + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(map[nx][ny] == num){
                        length = 0;
                        nx = dot.x;
                        ny = dot.y;
                        break;
                    }else if(map[nx][ny] == 0){
                        length++;
                    }else{
                        if(length>1){
                            pq.add(new edge(num,map[nx][ny], length));
                        }
                        length = 0;
                        nx = dot.x;
                        ny = dot.y;
                        break;
                    }
                }else{
                    length = 0;
                    nx = dot.x;
                    ny = dot.y;
                    break;
                }
            }
        }
    }

    private static void bfs(dot d) {
        Queue<dot> q = new LinkedList<>();
        visit[d.x][d.y] = true;
        map[d.x][d.y] = cnt;
        q.add(d);

        while(!q.isEmpty()){
            dot t = q.poll();
            int x = t.x;
            int y = t.y;

            for(int i = 0; i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny] == 1 && !visit[nx][ny]){
                    q.add(new dot(nx,ny));
                    map[nx][ny] = cnt;
                    visit[nx][ny] = true;
                }
            }
        }
    }
    static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot){
            parents[aRoot] = b;
        }
    }
}
