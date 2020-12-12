package programmers;

public class find_password {
    public static void main(String args[]){
        String s = "a B z";
        int n = 1;
        System.out.println(solution(s,n));
    }
    public static String solution(String s, int n){
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(Character.isLowerCase(tmp)){
                tmp = (char)((tmp+ n%26 - 'a')%26+  'a');
            }else if(Character.isUpperCase(tmp)){
                tmp = (char)((tmp+ n%26 - 'A')% 26 +  'A');
            }
            answer += tmp;
        }
        return answer;
    }
}
