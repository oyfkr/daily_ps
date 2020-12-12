package programmers;

public class change_stirng_int {
    public static void main(String args[]){
        String s = "-1234";
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int answer = 0;

        if(s.charAt(0) == '-'){
            answer = -1;
            answer *= Integer.parseInt(s.substring(1,s.length()));
        } else{
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}
