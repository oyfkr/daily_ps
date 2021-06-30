public class n_number_game {
    public static void main(String[] args) {
        n_number_game s = new n_number_game();
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(s.solution(n,t,m,p));
    }

    public String solution(int n, int t, int m, int p){
        int cnt = 0;
        String tmp = "0";
        String answer ="";
        while(tmp.length()<t*m){
            int num = cnt++;
            String numtmp = "";
            while(num != 0){
                if(num%n >= 10) numtmp += String.valueOf((char)(num%n+55));
                else numtmp += String.valueOf(num%n);
                num = num/n;
            }
            tmp += new StringBuffer(numtmp).reverse().toString();
        }

        for(int i = 0; i<t;i++){
            answer += String.valueOf(tmp.charAt(m * i + p - 1));
        }
        return answer;
    }
}

