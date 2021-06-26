import java.util.Arrays;

public class rotate_matrix_border {
    public static void main(String[] args) {
        rotate_matrix_border s = new rotate_matrix_border();
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(s.solution(rows,columns,queries)));
    }

    static int[][] map;
    static int min = 0;
    public int[] solution(int rows, int columns, int[][] queries){
        int[] answer = new int[queries.length];
        int cnt = 1;

        // map에 숫자 넣기
        map = new int[rows+1][columns+1];
        for(int i = 1;i<=rows;i++){
            for(int j = 1;j<=columns;j++){
                map[i][j] = cnt;
                cnt++;
            }
        }

        for(int i = 0 ; i< queries.length;i++){
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public int rotate(int[] query) {
        //시작점
        int nx = query[0];
        int ny = query[1];

        int now = map[nx][ny];

        min = now;

        // 가로와 세로길이
        int xMove = query[2] - query[0];
        int yMove = query[3] - query[1];

        //오른쪽
        for(int i = 0;i<yMove;i++){
            ny += 1;
            now = move(nx,ny,now);
        }

        //아래
        for(int i = 0; i<xMove;i++){
            nx += 1;
            now = move(nx,ny,now);
        }
        // 왼쪽
        for(int i = 0; i<yMove;i++){
            ny -= 1;
            now = move(nx,ny,now);
        }
        //위
        for(int i = 0; i<xMove;i++){
            nx -= 1;
            now = move(nx,ny,now);
        }

        return min;
    }

    public int move(int x,int y, int before){
        int tmp = map[x][y];
        min = Math.min(min,before);
        map[x][y] = before;
        return tmp;
    }
}
