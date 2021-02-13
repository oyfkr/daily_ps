package programmers_2;

public class network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        network s = new network();
        System.out.println(s.solution(n,computers));
    }
    public int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] con = new boolean[n];
        for(int i = 0; i<n;i++){
            if(!con[i]){
                answer++;
                con = dfs(i,computers,con);
            }
        }
        return answer;
    }
    public boolean[] dfs(int i, int[][] computers,boolean[] check){
        check[i] = true;
        for(int j = 0; j< computers.length;j++){
            if(!check[j] && i != j && computers[i][j] == 1){
                check = dfs(j,computers,check);
            }
        }
        return check;
    }
}

