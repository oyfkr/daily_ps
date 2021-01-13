package programmers_2;

public class Represen_num {
    public static void main(String[] args) {
        Represen_num s = new Represen_num();
        int n = 15;
        System.out.println(s.solution(n));
    }
    public int solution(int n){
        int answer = 0;
        int sum = 0;
        for(int i = 1; i<=n; i++){
            int j = i;
            sum += i;
            while(true){
                j++;
                sum+=j;
                if(sum == n){
                    answer++;
                }else if(sum>n){
                    break;
                }
            }
            sum = 0;
        }
        answer++;
        return answer;
    }
}
