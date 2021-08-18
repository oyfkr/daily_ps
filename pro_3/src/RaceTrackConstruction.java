import java.util.LinkedList;
import java.util.Queue;

public class RaceTrackConstruction {
    public static void main(String[] args) {
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        RaceTrackConstruction s = new RaceTrackConstruction();
        System.out.println(s.solution(board));
    }

    class Road{
        int x,y,dir,cost;

        public Road(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cost = Integer.MAX_VALUE;
    static boolean[][] visit;
    static int n;
    static int[][] map;

    public int solution(int[][] board){
        map = board;
        n = board.length;
        visit = new boolean[n][n];

        bfs(0,0,-1,0);

        return cost;
    }

    public void bfs(int x, int y, int dir, int price){
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(x,y,dir,price));
        visit[x][y] = true;

        while (!q.isEmpty()){
            Road r = q.remove();
            int px = r.x;
            int py = r.y;
            int pDir = r.dir;
            int pPrice = r.cost;

            if(px == n-1 && py == n-1){
                cost = Math.min(cost,pPrice);
            }
            for(int i = 0; i<4;i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                int nDir = i;
                int nPrice = pPrice;

                if(nx<0 || ny< 0 || nx>=n||ny>=n || map[nx][ny] == 1){
                    continue;
                }

                if(pDir == -1){
                    nPrice += 100;
                }else if(nDir == pDir){
                    nPrice += 100;
                }else{
                    nPrice += 600;
                }

                if(!visit[nx][ny] || map[nx][ny] >= nPrice){
                    visit[nx][ny] = true;
                    map[nx][ny] = nPrice;
                    q.add(new Road(nx,ny,nDir,nPrice));
                }
            }
        }
    }
}
