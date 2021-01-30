package programmers_2;

public class n_demical_game {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;

        n_demical_game s = new n_demical_game();
        System.out.println(s.solution(n,t,m,p));
    }
    public String solution(int n, int t,int m,int p){
        String answer = "";
        String tmp = "0";
        int cnt = 0;

        while(tmp.length()<(t*m)){
            String numtmp = "";
            int num = cnt++;

            while(num != 0){
                if(num % n >= 10){
                    numtmp +=String.valueOf((char)(num%n+55));
                }else{
                    numtmp += String.valueOf(num % n);
                }
                num /= n;
            }
            tmp += new StringBuffer(numtmp).reverse().toString();
        }
        for(int i = 0; i<t;i++){
            answer += String.valueOf(tmp.charAt(m*i+p-1));
        }
        return answer;
    }
}
