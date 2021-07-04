import java.util.Arrays;

public class friends_4block {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE","AAADE","AAABF","CCBBF"};
        friends_4block s = new friends_4block();
        System.out.println(s.solution(m,n,board));
    }
    public int solution(int m, int n, String[] board){
        int answer = 0;

        char[][] map = new char[m][n];

        for(int i = 0; i<m;i++){
            map[i] = board[i].toCharArray();
        }

        while(true){
            System.out.println(Arrays.deepToString(map));

            int cnt = checkBlock(m,n,map);
            if(cnt == 0) break;
            answer += cnt;

            dropBlock(m,n,map);
        }


        return answer;
    }

    public int checkBlock(int m, int n, char[][] map){
        int cnt = 0;
        boolean check[][] = new boolean[m][n];
        for(int i = 0; i<m-1;i++){
            for(int j = 0; j<n-1;j++){
                if(map[i][j] == '.') continue;
                checkFour(i,j,map,check);
            }
        }

        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(check[i][j]){
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }
        return cnt;
    }

    public void checkFour(int m,int n,char[][] map, boolean[][] check){
        char block = map[m][n];
        for(int i = m;i<m+2;i++){
            for(int j = n;j<n+2;j++){
                if(map[i][j] != block) return;
            }
        }

        for(int i = m;i<m+2;i++){
            for(int j = n;j<n+2;j++){
                check[i][j] = true;
            }
        }
    }

    public void dropBlock(int m,int n, char[][] map){
        for(int i = 0;i<n;i++){
            for(int j = m-1;j>=0;j--){
                if(map[j][i] == '.'){
                    for(int k = j-1;k>=0;k--){
                        if(map[k][i] != '.'){
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
