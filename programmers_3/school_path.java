package programmers_3;

public class school_path {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles={{2,2}};
        school_path s = new school_path();
        System.out.println(s.solution(m,n,puddles));
    }
    public int solution(int m, int n, int[][] puddles){
        int[][] path = new int[m][n];
        for(int[] puddle : puddles){
            path[puddle[0]-1][puddle[1]-1] = -1;
        }
        path[0][0] = 1;

        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(path[i][j] == -1){
                    path[i][j]=0;
                    continue;
                }
                if(i != 0){
                    path[i][j]+= path[i-1][j] %1000000007;
                }
                if(j != 0){
                    path[i][j]+= path[i][j-1] %1000000007;
                }
            }
        }
        return path[m-1][n-1] %1000000007;
    }
}
