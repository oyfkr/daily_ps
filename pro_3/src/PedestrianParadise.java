public class PedestrianParadise {
    public static void main(String[] args) {
        int m = 3;
        int n = 6;
        int[][] cityMap = {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};
        PedestrianParadise p = new PedestrianParadise();
        System.out.println(p.solution(m,n,cityMap));
    }
    int MOD = 20170805;
    int[][][] dp;
    public int solution(int m,int n,int[][] cityMap){
        int answer = 0;

        dp = new int[m][n][2];

        if(cityMap[0][0] == 1) return 0;
        //내려오는 거
        dp[0][0][0] = 1;
        //왼쪽에서 오는 거
        dp[0][0][1] = 1;

        for(int i = 1; i<m;i++){
            // 내려오는 과정에서 1이 아니면 다 똑같은 값을 넣는다 1로
            if(cityMap[i][0] != 1) dp[i][0][0] = dp[i-1][0][0];
        }

        for(int i = 1; i<n;i++){
            // 오른쪽으로 가면서 1이 아니면 같은 값을 넣는다
            if(cityMap[0][i] != 1) dp[0][i][1] = dp[0][i-1][1];
        }

        for(int i = 1; i<m;i++){
            for(int j = 1; j<n;j++){
                //위에서 내려올때 1이 아니고
                if(cityMap[i-1][j] != 1){
                    //2일때 그 값을 그대로 더해줌
                    if(cityMap[i-1][j] == 2){
                        dp[i][j][0] = dp[i-1][j][0];
                    }
                    // 2가 아니면
                    else{
                        //0일때 이므로 위의 점에서 아래로 오른쪽으로 모두 갈수 있기 때문에 왼쪽에서 오는 값과 내려오는 모근 값을 더해준다.
                        dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1])%MOD;
                    }

                }
                if(cityMap[i][j-1] != 1){
                    if(cityMap[i][j-1] == 2){
                        dp[i][j][1] = dp[i][j-1][1];
                    }else{
                        dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1])%MOD;
                    }
                }
            }
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1])%MOD;
    }

}
