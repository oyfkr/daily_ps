package programmers_2;

public class Npresentation {
    public static void main(String[] args) {
        Npresentation s = new Npresentation();
        int N = 5;
        int number = 12;
        System.out.println(s.solution(N,number));
    }
    static int answer = -1;
    public int solution(int N, int number){
        cal(N,number,0,0);
        return answer;
    }
    public void cal(int n, int number,int count,int acc){
        int nn = n;

        if(count>8){
            return;
        }
        if(acc == number){
            if(answer == -1 || answer > count){
                answer = count;
            }
            return;
        }
        for(int i = 1; i<9-count;i++){
            cal(n,number,count+i,acc+nn);
            cal(n,number,count+i,acc-nn);
            cal(n,number,count+i,acc*nn);
            cal(n,number,count+i,acc/nn);
            nn = nn*10 +n;
        }
    }
}
