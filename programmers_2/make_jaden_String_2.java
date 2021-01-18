package programmers_2;


public class make_jaden_String_2 {
    public static void main(String[] args) {
        String s = "for the last week";
        make_jaden_String_2 a = new make_jaden_String_2();
        System.out.println(a.solution(s));
    }
    public String solution(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (answer.length() == 0) {
                if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                    answer += (char) (s.charAt(i) - 32);
                } else {
                    answer += s.charAt(i);
                }
            } else if (answer.charAt(answer.length()-1) == ' ' && 'a' <= s.charAt(i) && s.charAt(i) <= 122) {
                answer += (char)(s.charAt(i)-32);
            } else if (answer.charAt(answer.length()-1) != ' ' && 'A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                answer += (char) (s.charAt(i) + 32);
            } else {
                answer+= s.charAt(i);
            }
        }
        return answer;
    }
}
