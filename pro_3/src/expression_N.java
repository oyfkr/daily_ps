public class expression_N {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        expression_N s = new expression_N();
        System.out.println(s.solution(N,number));
    }

    static int answer = -1;
    public int solution(int N, int number){
        calc(N, number, 0, 0);
        return answer;
    }

    public void calc(int N, int Number, int cnt, int sum){
        int nn = N;

        if(cnt > 8 ) return;

        if(sum == Number){
            if(answer == -1 || answer > cnt){
                answer = cnt;
                return;
            }
        }
        for(int i = 1; i<9-cnt;i++){
            calc(N,Number,cnt+i,sum+nn);
            calc(N,Number,cnt+i,sum-nn);
            calc(N,Number,cnt+i,sum*nn);
            calc(N,Number,cnt+i,sum/nn);
            nn = N*10 +N;
        }
    }
}
