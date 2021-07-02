import java.util.Arrays;

public class kakao_coloringbook2 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        kakao_coloringbook2 s = new kakao_coloringbook2();
        System.out.println(Arrays.toString(s.solution(m,n,picture)));
    }

    static int area;
    static boolean visit[][];
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    public int[] solution(int m, int n, int[][] picture){
        visit = new boolean[m][n];
        int cnt = 0;
        int cntofarea = 0;

        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(!visit[i][j] && picture[i][j] !=0){
                    cnt++;
                    area = 0;
                    dfs(i,j,picture);
                }
                cntofarea = Math.max(area,cntofarea);
            }
        }
        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = cntofarea;
        return answer;
    }
    public void dfs(int x, int y, int[][] picture){
        area++;
        visit[x][y] = true;
        for(int i = 0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny <0 || nx >= picture.length || ny>= picture[0].length) continue;

            if(picture[x][y] == picture[nx][ny] && !visit[nx][ny]){
                dfs(nx,ny,picture);
            }
        }
    }
}
