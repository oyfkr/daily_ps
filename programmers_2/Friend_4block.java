package programmers_2;

public class Friend_4block {
    public static void main(String[] args) {
        Friend_4block s = new Friend_4block();
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"};
        System.out.println(s.solution(m,n,board));
    }

    static char[][] boardN = null;
    static boolean[][] che = null;
    static boolean finalFlag = true;

    public int solution(int m, int n, String[] board){
        int answer = 0;

        boardN = new char[m][n];
        che = new boolean[m][n];

        for(int i = 0; i<m;i++){
            boardN[i] = board[i].toCharArray();
        }

        while(finalFlag){
            finalFlag = false;
            check(m,n);
            answer += proBlo(m,n);
            rearrange(m,n);
        }
        return answer;
    }
    public void check(int m, int n){
        // 어차피 한 점에서 오른쪽, 오른쪽 밑에, 아래 만 체크해보면 됨
        int[] dx = {0,1,1};
        int[] dy = {1,0,1};

        //새로 만든 이차원 배열에 ' '인지 아닌지로 체크
        for(int i = 0; i<m-1;i++){
            for(int j = 0; j<n-1; j++){
                if(boardN[i][j] == ' '){
                    continue;
                }
                boolean flag = false;
                for(int k = 0;k<3;k++){
                    int x = i+dy[k];
                    int y = j+dx[k];
                    if(x>=0 && y>=0 && x<m && y<n){
                        // 오른쪽, 오른쪽 밑, 아래를 체크했을 때 하나라도 틀리면 flag = true
                        if(boardN[i][j] != boardN[x][y]){
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag){
                    finalFlag = true;
                    che[i][j] = true;
                    for(int k = 0; k<3;k++){
                        int mx = i+dx[k];
                        int my = j+dy[k];
                        che[mx][my] = true;
                    }
                }
            }
        }
    }

    public int proBlo(int m , int n){

        int count = 0;
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(che[i][j]){
                    boardN[i][j] = ' ';
                    count +=1;
                }
            }
        }
        return count;
    }
    public void rearrange(int m, int n){
        String tmp = "";
        for(int j = 0; j<n;j++){
            tmp = "";
            for(int i = 0; i<m;i++){
                tmp += boardN[i][j];
            }
            tmp = tmp.replace(" ","");

            for(int i = 0; i<tmp.length(); i++){
                boardN[m-1-i][j] = tmp.charAt(tmp.length()-1-i);
                che[m-1-i][j] = false;
            }

            if(m > tmp.length()){
                int ins = m - tmp.length();
                for(int i = ins-1; i>=0;i--){
                    boardN[i][j] = ' ';
                    che[i][j] = false;
                }
            }
        }
    }
}
