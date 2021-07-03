import java.util.LinkedList;
import java.util.Queue;

public class shortest_gamemap2 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        shortest_gamemap2 s = new shortest_gamemap2();
        System.out.println(s.solution(maps));
    }

    int[] dx = {-1,0,0,1};
    int[] dy = {0,1,-1,0};
    boolean[][] visit;
    int n,m;

    public int solution(int[][] maps){
        n = maps.length;
        m = maps[0].length;

        visit = new boolean[n][m];
        return bfs(0,0,maps);
    }

    public int bfs(int x,int y, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,1));
        visit[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.x == n-1 && node.y == m-1) return node.cost;
            for(int i = 0; i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(maps[nx][ny]==1 &&!visit[nx][ny]){
                        visit[nx][ny] = true;
                        q.offer(new Node(nx,ny, node.cost+1));
                    }
                }
            }
        }
        return -1;
    }

    public class Node{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
