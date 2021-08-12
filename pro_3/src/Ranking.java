public class Ranking {
    public static void main(String[] args) {
        int n = 5;
        int[][] result = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        Ranking r = new Ranking();
        System.out.println(r.solution(n,result));
    }

    public int solution(int n, int[][] results){
        int answer = 0;

        boolean[][] check = new boolean[n][n];

        for (int[] ints : results) {
            check[ints[0] - 1][ints[1] - 1] = true;
        }

        for(int i = 0; i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0; k<n;k++){
                    if(check[j][i] && check[i][k]){
                        check[j][k] = true;
                    }
                }
            }
        }

        for(int i = 0; i<n;i++){
            int result = 0;
            for(int j = 0; j<n;j++){
                if(check[i][j] || check[j][i]) result++;
            }
            if(result == n-1) answer++;
        }

        return answer;
    }
}
