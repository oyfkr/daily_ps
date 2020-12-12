package programmers;

public class make_subak {
    public static void main(String args[]){
        int n = 4;
        System.out.println(solution(n));
    }
    public static String solution(int n){
        String answer = "";
        for(int i = 0; i < n/2; i++){
            answer += "수박";
        }
        if(n % 2 == 1){
            answer += "수";
        }
        return answer;
    }
}
