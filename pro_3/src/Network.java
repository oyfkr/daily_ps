public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        Network s = new Network();
        System.out.println(s.solution(n,computers));
    }

    public int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] check = new boolean[n];
        for(int i = 0; i<n;i++){
            if(!check[i]){
                check = dfs(i,computers,check);
                answer++;
            }
        }
        return answer;
    }

    public boolean[] dfs(int n, int[][] computers,boolean[] check){
        check[n] = true;
        for(int i = n; i< computers.length;i++){
            if(!check[i] && i != n && computers[n][i]== 1){
                check = dfs(i,computers,check);
            }
        }


        return check;
    }
}
