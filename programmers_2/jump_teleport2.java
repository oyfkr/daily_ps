package programmers_2;

public class jump_teleport2 {
    public static void main(String[] args) {
        jump_teleport2 s = new jump_teleport2();
        int n = 5000;
        System.out.println(s.solution(n));
    }
    public int solution(int n){
        int answer = 0;
        while(n != 0){
            if(n%2 == 0){
                n /= 2;
            }else{
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
}
