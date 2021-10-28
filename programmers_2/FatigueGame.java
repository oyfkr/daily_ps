package programmers_2;

public class FatigueGame {

    public static void main(String[] args) {
        FatigueGame f = new FatigueGame();
        int[][] dungeons = {{50,40},{30,10},{80,20}};
        System.out.println(f.solution(80, dungeons));
    }

    static boolean[] check;
    static int answer=0;

    public int solution(int k , int[][] dungeons){

        check = new boolean[dungeons.length];
        dfs(k,dungeons,0);

        return answer;
    }

    public static void dfs(int k, int[][] dungeons, int cnt){

        for(int i = 0; i<dungeons.length;i++){
            if(!check[i] && dungeons[i][0] <= k){
                check[i] = true;
                dfs(k-dungeons[i][1],dungeons,cnt+1);
                check[i] = false;
            }
        }
        answer = Math.max(cnt,answer);
    }
}
